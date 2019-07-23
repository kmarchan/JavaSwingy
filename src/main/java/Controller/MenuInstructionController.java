package Controller;

import Exception.InputException;
import Storage.HeroStorage;
import View.BaseWindow;
import View.MainMenu;

import static Controller.ApplicationController.*;

class MenuInstructionController {
	private static String instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
		gui,
	}

	static void instructionParse() throws InputException {
		System.out.println( "\nMain Menu\nYour options are [exit, newgame, loadgame and gui]");
		try {
			System.out.println("Dispklay maidn menu");
			MainMenu.displayMainMenu();
			System.out.println(StateManager.status);
			instructions = EventDataController.getInstruction();
			System.out.println(EventDataController.getInstruction());
			while(StateManager.status == MENU_LOOP) {
					if (EventDataController.getInstruction() != "") {
						switch (Instruction.valueOf(EventDataController.getInstruction().toLowerCase())) {
							case exit: {
								ApplicationController.closeApplication();
								break;
							}
							case gui:
								BaseWindow.showBaseWindow();
								break;
							case newgame:
								StateManager.status = CREATE_LOOP;
								break;
							case loadgame:
								StateManager.status = LOAD_LOOP;
								HeroStorage.getSavedHeroes();
								break;
							default: {
								System.out.println("Invalid Menu Instruction: " + EventDataController.getInstruction());
							}
						}
						EventDataController.removeInstructions(EventDataController.getInstruction());
					}
				instructions = EventDataController.getInstruction();
			}
		} catch (IllegalArgumentException | InputException e){
			System.out.println("Invalid Menu Instruction: " + EventDataController.getInstruction());
			EventDataController.removeInstructions(EventDataController.getInstruction());
			instructionParse();
		}
	}
}
