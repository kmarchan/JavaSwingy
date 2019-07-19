package Controller;

import View.BaseWindow;
import View.LoadHero;

import java.util.List;

import static Controller.ApplicationController.LOAD_LOOP;
import static Controller.ApplicationController.MENU_LOOP;

public class LoadInstructionController {
    private static List<String> loadInstructions;

    enum instruction{
        menu,
        gui,
    }

    public static void loadInstructionParse() {
        int instructionIndex = 0;
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
            System.out.println("Invalid Load Instruction:" + loadInstructions.get(instructionIndex));
            removeLoadInstructions(loadInstructions.get(instructionIndex));
            loadInstructionParse();
        }
    }
    public static void addLoadInstructions(String input) {
        loadInstructions.add(input);
    }

    public static void removeLoadInstructions(String input) {
        loadInstructions.remove(input);
    }
}
