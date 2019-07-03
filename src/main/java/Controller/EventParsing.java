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
		System.out.println("here");
				try {
					instructions = EventData.getOutput();
					if (instructions.size() > 0)
					{
						System.out.println("big");
					}
					while(EventData.getIsRunning()) {
						for (int i=0; i < instructions.size(); i++) {
							instructionIndex = i;
							/* IMPORTANT: remove instruction after use. */
							if (instructions.get(i) != null) {

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
							}
							EventData.removeInstructions(instructions.get(i));
						}
						instructions = EventData.getOutput();
					}
				} catch (IllegalArgumentException e){
					System.out.println("Invalid instruction:"+instructions.get(instructionIndex));
					EventData.removeInstructions(instructions.get(instructionIndex));
					instructionParse();
				}
			}
		}
