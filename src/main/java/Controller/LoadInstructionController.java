package Controller;

import Storage.HeroStorage;
import View.BaseWindow;
import View.LoadHero;

import java.util.List;

import static Controller.ApplicationController.GAME_LOOP;
import static Controller.ApplicationController.LOAD_LOOP;
import static Controller.ApplicationController.MENU_LOOP;

public class LoadInstructionController {
    private static List<String> loadInstructions;

    enum instruction{
        menu,
        gui,
    }

    static void loadInstructionParse() {
        int instructionIndex = 0;
        System.out.println("\nTo select your previous save please enter the index of the correct hero listed below:");
        for (int h = 0; h < HeroStorage.savedHeroes.size(); h ++) {
            System.out.println(h + ": " + HeroStorage.loadToString(HeroStorage.savedHeroes.get(h)));
        }
        try {
            LoadHero.displayLoadHero();
            loadInstructions = EventDataController.getInstructions();
            while (ApplicationController.status == LOAD_LOOP) {
                for (int i = 0; i < loadInstructions.size(); i++) {
                    instructionIndex = i;
                    if (loadInstructions.get(i) != null) {
                        switch (instruction.valueOf(loadInstructions.get(i).toLowerCase())) {
                            case menu:
                                ApplicationController.status = MENU_LOOP;
                                break;
                            case gui:
                                BaseWindow.showBaseWindow();
                                break;
                            default: {
                                System.out.println("Invalid Load instruction:" + loadInstructions.get(i));
                            }
                        }
                        removeLoadInstructions(loadInstructions.get(i));
                    }
                }
                loadInstructions = EventDataController.getInstructions();
            }
        } catch (IllegalArgumentException e) {

            try {
                int in = Integer.parseInt(loadInstructions.get(instructionIndex));
                if (in >= 0 && in < HeroStorage.savedHeroes.size()) {
                    EventDataController.setHero(HeroStorage.savedHeroes.get(in));
                    ApplicationController.status = GAME_LOOP;
                    System.out.println("\nGame Started");
                    GameController.startGame();
                } else {
                    System.out.println("index " + in + " invalid: enter a number from 0 to " + HeroStorage.savedHeroes.size());
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please select hero by index");
            }
        }
        removeLoadInstructions(loadInstructions.get(instructionIndex));
    }

    public static void addLoadInstructions(String input) {
        loadInstructions.add(input);
    }

    private static void removeLoadInstructions(String input) {
        loadInstructions.remove(input);
    }
}
