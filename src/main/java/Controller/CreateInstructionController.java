package Controller;

import View.BaseWindow;
import View.NewGame;

import java.util.List;

import static Controller.ApplicationController.CREATE_LOOP;
import static Controller.ApplicationController.MENU_LOOP;

public class CreateInstructionController {
    private static List<String> createInstructions;

    enum instruction{
        menu,
        gui,
        blackmage,
        orc,
        elf,
        knight,
    }

    public static void createInstructionParse() {
        int instructionIndex = 0;
        try {
            NewGame.displayNewGame();
            createInstructions = EventDataController.getInstructions();
            while (ApplicationController.status == CREATE_LOOP) {
                for (int i = 0; i < createInstructions.size(); i++) {
                    instructionIndex = i;
                    if (createInstructions.get(i) != null) {
                        switch (instruction.valueOf(createInstructions.get(i).toLowerCase())) {
                            case menu:
                                ApplicationController.status = MENU_LOOP;
                                break;
                            case blackmage:
                                break;
                            case orc:
                                break;
                            case elf:
                                break;
                            case knight:
                                break;
                            case gui:
                                BaseWindow.showBaseWindow();
                                break;
                            default: {
                                System.out.println("Invalid Create Instruction:" + createInstructions.get(i));
                            }
                        }
                        removeCreateInstructions(createInstructions.get(i));
                    }
                }
                createInstructions = EventDataController.getInstructions();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Create instruction:" + createInstructions.get(instructionIndex));
            removeCreateInstructions(createInstructions.get(instructionIndex));
            createInstructionParse();
        }
    }

    public static void addCreateInstructions(String input) {
        createInstructions.add(input);
    }

    public static void removeCreateInstructions(String input) {
        createInstructions.remove(input);
    }
}
