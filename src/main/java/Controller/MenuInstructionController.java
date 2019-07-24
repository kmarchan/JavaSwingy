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

	static void instructionParse() {
		System.out.println( "\nMain Menu\nYour options are [exit, newgame, loadgame and gui]");
		try {
			MainMenu.displayMainMenu();
			instructions = EventDataController.getInstruction();
			while(StateManager.status == MENU_LOOP) {
				Thread.sleep( SLEEP_TIME);

				if (!instructions.equals("")) {
						System.out.println(instructions);

						switch (Instruction.valueOf(instructions.toLowerCase())) {
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
								System.out.println("Invalid Menu Instruction: " + instructions);
							}
						}
						EventDataController.removeInstructions();
					}
					instructions = EventDataController.getInstruction();
			}
		} catch (IllegalArgumentException | InputException | InterruptedException e){
			if (!instructions.equals("h") && !instructions.equals("help")) {
				System.out.println("Invalid Menu Instruction: " + instructions);
			}
			EventDataController.removeInstructions();
			instructionParse();
		}
	}
}
