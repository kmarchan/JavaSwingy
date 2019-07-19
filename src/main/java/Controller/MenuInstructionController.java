package Controller;

import Storage.HeroStorage;
import View.*;
import Exception.InputException;
import java.util.List;

import static Controller.ApplicationController.*;
// TODO remove comments
public class MenuInstructionController {
	private static List<String> instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
		controls,
		gui,
	}

	public static void instructionParse() {
		int instructionIndex = 0;
		try {
			MainMenu.displayMainMenu();
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
								ApplicationController.status = CREATE_LOOP;
								break;
							case loadgame:
								ApplicationController.status = LOAD_LOOP;
								HeroStorage.getSavedHeroes();
								break;

							default: {
								System.out.println("Invalid Menu Instruction:" + instructions.get(i));
							}
						}
						EventDataController.removeInstructions(instructions.get(i));
					}
				}
				instructions = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e){
			System.out.println("Invalid Menu instruction:"+instructions.get(instructionIndex));
			EventDataController.removeInstructions(instructions.get(instructionIndex));
			instructionParse();
		}
		catch (InputException e) {
			e.printStackTrace();
		}
	}
}
