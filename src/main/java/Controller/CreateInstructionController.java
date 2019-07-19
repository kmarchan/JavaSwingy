package Controller;

import View.NewGame;

import java.util.List;

import static Controller.ApplicationController.CREATE_LOOP;
import static Controller.ApplicationController.MENU_LOOP;

public class CreateInstructionController {
    private static List<String> createInstructions;

    enum instruction{
        cancel,
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
                            case cancel:
                                ApplicationController.status = MENU_LOOP;
                                break;
                            default: {
                                System.out.println("Invalid instruction:" + createInstructions.get(i));
                            }
                        }
                        removeCreateInstructions(createInstructions.get(i));
                    }
                }
                createInstructions = EventDataController.getInstructions();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid instruction:" + createInstructions.get(instructionIndex));
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
