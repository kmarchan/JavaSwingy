package Controller;

import View.BaseWindow;
import java.util.List;

public class EventParsing {
	private static List<String> instructions;

	enum Instruction {
		print,
		exit,
		test,
		gui
	}

	public static void instructionParse() {
			int instructionIndex = 0;
			public void run() {
				try {
					instructions = EventData.getOutput();
					while(EventData.getIsRunning()) {
						instructions = EventData.getOutput();
						for (int i=0; i < instructions.size(); i++) {
							instructionIndex = i;
							/* IMPORTANT: remove instruction after use. */

							switch (Instruction.valueOf(instructions.get(i).toLowerCase())) {

								case print: {
									System.out.println(EventData.getOutput());
									break;
								}
								case exit: {
									EventData.setIsRunning(false);
									System.out.println("killing program");
									Controller.ApplicationControls.closeApplication();
									break;
								}
								case gui:
									BaseWindow.showBaseWindow();
									break;

								default: {
									System.out.println("Invalid instruction:" + instructions.get(i));
								}
							}
							EventData.removeInstructions(instructions.get(i));
						}
					}
				} catch (IllegalArgumentException e){
					System.out.println("Invalid instruction:"+instructions.get(instructionIndex));
					EventData.removeInstructions(instructions.get(instructionIndex));
					instructionParseAsync();
				}
			}
		}).start();

	}
}
