package Controller;

import Storage.HeroStorage;
import View.*;
import Exception.InputException;
import java.util.List;

public class InstructionController {
	private static List<String> instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
        start,
		controls,
		menu,
		gui
	}

	public static void instructionParse() {
		int instructionIndex = 0;
		try {
			instructions = EventDataController.getOutput();

			while(EventDataController.getIsRunning()) {
				for (int i=0; i < instructions.size(); i++) {
					instructionIndex = i;
					/* IMPORTANT: remove instruction after use. */
					if (instructions.get(i) != null) {
						EventDataController.setIsProcessed(true);
						switch (Instruction.valueOf(instructions.get(i).toLowerCase())) {
							case exit: {
								EventDataController.setIsRunning(false);
								System.out.println("killing program");
								ApplicationController.closeApplication();
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
								HeroStorage.getSavedHeroes();
								LoadHero.displayLoadHero();
								break;
							case menu:
								MainMenu.displayMainMenu();
								break;
							case start:
								GameController.startGame();
								break;
							default: {
								System.out.println("Invalid instruction:" + instructions.get(i));
							}
						}
					}
					EventDataController.removeInstructions(instructions.get(i));
				}
				instructions = EventDataController.getOutput();
			}
		} catch (IllegalArgumentException e){
			System.out.println("Invalid instruction:"+instructions.get(instructionIndex));
			EventDataController.removeInstructions(instructions.get(instructionIndex));
			instructionParse();
		}
		catch (InputException e) {
			e.printStackTrace();
		}
	}
}
