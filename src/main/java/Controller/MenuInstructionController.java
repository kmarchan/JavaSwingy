package Controller;

import Storage.HeroStorage;
import View.*;
import Exception.InputException;
import java.util.List;

import static Controller.ApplicationController.GAME_LOOP;
import static Controller.ApplicationController.MENU_LOOP;

public class MenuInstructionController {
	private static List<String> instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
        start,
		controls,
		menu,
		gui,
	}

	public static void instructionParse() {
		int instructionIndex = 0;
		try {
			instructions = EventDataController.getInstructions();

			while(EventDataController.getIsRunning() && ApplicationController.status == MENU_LOOP) {
				for (int i=0; i < instructions.size(); i++) {
					instructionIndex = i;
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
								ApplicationController.status = GAME_LOOP;
								GameController.startGame();
								EventDataController.setIsRunning(false);
								break;
							default: {
								System.out.println("Invalid instruction:" + instructions.get(i));
							}
						}
					}
					EventDataController.removeInstructions(instructions.get(i));
				}
				instructions = EventDataController.getInstructions();
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
