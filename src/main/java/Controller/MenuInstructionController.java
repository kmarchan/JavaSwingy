package Controller;

import Storage.HeroStorage;
import View.*;
import Exception.InputException;
import java.util.List;

import static Controller.ApplicationController.*;

class MenuInstructionController {
	private static List<String> instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
		gui,
	}

	static void instructionParse() {
		int instructionIndex = 0;
		System.out.println( "\nMain Menu\nYour options are [exit, newgame, loadgame and gui]");
		try {
			MainMenu.displayMainMenu();
			instructions = EventDataController.getInstructions();
			while(ApplicationController.status == MENU_LOOP) {
				for (int i=0; i < instructions.size(); i++) {
					instructionIndex = i;
					if (instructions.get(i) != null) {
						EventDataController.setIsProcessed(true);
						switch (Instruction.valueOf(instructions.get(i).toLowerCase())) {
							case exit: {
								EventDataController.setIsRunning(false);
								ApplicationController.closeApplication();
								break;
							}
							case gui:
								BaseWindow.showBaseWindow();
								break;
							case newgame:
								ApplicationController.status = CREATE_LOOP;
								break;
							case loadgame:
								ApplicationController.status = LOAD_LOOP;
								HeroStorage.getSavedHeroes();
								break;
							default: {
								System.out.println("Invalid Menu Instruction: " + instructions.get(i));
							}
						}
						EventDataController.removeInstructions(instructions.get(i));
					}
				}
				instructions = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e){
			System.out.println("Invalid Menu Instruction: " + instructions.get(instructionIndex));
			EventDataController.removeInstructions(instructions.get(instructionIndex));
			instructionParse();
		}
		catch (InputException e) {
			e.printStackTrace();
		} finally {
			instructions = EventDataController.getInstructions();
		}
	}
}
