package Controller;

import View.*;

import java.util.List;

public class EventParsing {
	private static List<String> instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
		controls,
		menu,
		gui
	}

	public static void instructionParse() {
			int instructionIndex = 0;
		System.out.println("here");
				try {
					instructions = EventData.getOutput();

					while(EventData.getIsRunning()) {
						for (int i=0; i < instructions.size(); i++) {
							instructionIndex = i;
							/* IMPORTANT: remove instruction after use. */
							if (instructions.get(i) != null) {
								System.out.println("case"+Instruction.valueOf(instructions.get(i).toLowerCase()));
								switch (Instruction.valueOf(instructions.get(i).toLowerCase())) {
									case exit: {
										EventData.setIsRunning(false);
										System.out.println("killing program");
										Controller.ApplicationControls.closeApplication();
										break;
									}
									case gui:
										BaseWindow.showBaseWindow();
										break;
									case newgame:
										NewGame.displayNewGame();
										break;
									case controls:
										Controls.displayControls();
										break;
									case loadgame:
										LoadHero.displayLoadHero();
										break;
									case menu:
										MainMenu.displayMainMenu();
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
