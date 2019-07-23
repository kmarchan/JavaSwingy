package Controller;

import Storage.HeroStorage;
import View.BaseWindow;
import View.LoadHero;

import static Controller.ApplicationController.*;

class LoadInstructionController {
    private static String loadInstructions;

    enum instruction{
        menu,
        gui,
    }

    static void loadInstructionParse() {
		System.out.println("\nTo select your previous save please enter the index of the correct hero listed below:");
        for (int h = 0; h < HeroStorage.savedHeroes.size(); h ++) {
            System.out.println(h + ": " + HeroStorage.loadToString(HeroStorage.savedHeroes.get(h)));
        }
        try {
            LoadHero.displayLoadHero();
            loadInstructions = EventDataController.getInstruction();
            while (StateManager.status == LOAD_LOOP) {
                    if (loadInstructions != "") {
                        switch (instruction.valueOf(loadInstructions.toLowerCase())) {
                            case menu:
                                StateManager.status = MENU_LOOP;
                                break;
                            case gui:
                                BaseWindow.showBaseWindow();
                                break;
                            default: {
                                System.out.println("Invalid Load instruction:" + loadInstructions);
                            }
                        }
                        EventDataController.removeInstructions();
                    }
                    loadInstructions = EventDataController.getInstruction();
                }
        } catch (IllegalArgumentException e) {
            try {
                int in = Integer.parseInt(loadInstructions);
                if (in >= 0 && in < HeroStorage.savedHeroes.size()) {
                    EventDataController.setHero(HeroStorage.savedHeroes.get(in));
                    StateManager.status = GAME_LOOP;
                    System.out.println("\nGame Started");
                    GameController.startGame();
                } else {
                    System.out.println("index " + in + " invalid: enter a number from 0 to " + HeroStorage.savedHeroes.size());
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please select hero by index");
            }

        } finally {
            if (loadInstructions != "") {
                EventDataController.removeInstructions();
            }
			loadInstructions = EventDataController.getInstruction();
		}
    }
}
