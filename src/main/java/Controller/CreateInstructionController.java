package Controller;

import Storage.HeroStorage;
import View.BaseWindow;
import View.NewGame;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static Controller.ApplicationController.CREATE_LOOP;
import static Controller.ApplicationController.GAME_LOOP;
import static Controller.ApplicationController.MENU_LOOP;

public class CreateInstructionController {
    private static List<String> createInstructions;
    @Getter @Setter
	private static int type = 0;
	@Getter @Setter
    private static String name;

    enum instruction{
        menu,
        start,
        gui,
    }

    static void createInstructionParse() {
        int instructionIndex = 0;
		if (name == null && type ==  0)System.out.println("\nPlease select a hero type by index and enter name:" +
				"\nHero Types: " +
				"\n[1] Black Mage, " +
				"\n[2] Elf," +
				"\n[3] Knight," +
				"\n[4] Orc");
        if (name != null && type != 0)
		{
			EventDataController.createHeroPreview(NewGame.heroType[type], name);
			System.out.println(HeroStorage.loadToString(EventDataController.getHero()));
			System.out.println("[start] to begin game or change name / type");
		}
        try {
            NewGame.displayNewGame();
            createInstructions = EventDataController.getInstructions();
            while (ApplicationController.status == CREATE_LOOP) {
                for (int i = 0; i < createInstructions.size(); i++) {
                    instructionIndex = i;
                    if (createInstructions.get(i) != null) {
                        switch (instruction.valueOf(createInstructions.get(i).toLowerCase())) {
                            case menu:
                            	setName(null);
                            	setType(0);
                                ApplicationController.status = MENU_LOOP;
                                break;
                            case gui:
                                BaseWindow.showBaseWindow();
                                break;
                            case start:
                            	if (name == null) {	System.out.println("Please input name"); }
								else if (type == 0) {
									System.out.println("Please select type index:" +
											"\nHero Types: " +
											"\n[1] Black Mage, " +
											"\n[2] Elf," +
											"\n[3] Knight," +
											"\n[4] Orc");
								}
								else if (name != null)
								{
									System.out.println(HeroStorage.loadToString(EventDataController.getHero()));
									ApplicationController.status = GAME_LOOP;
									GameController.startGame();
								}
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
			try {
				int in = Integer.parseInt(createInstructions.get(instructionIndex));
				if (in > 0 && in <= 4) {
					setType(in);
				} else {
					System.out.println("index " + in + " invalid: enter a number from 1 to 4");
				}
			} catch (NumberFormatException ex) {
				setName(createInstructions.get(instructionIndex));
			}
            removeCreateInstructions(createInstructions.get(instructionIndex));
        }
    }

    public static void addCreateInstructions(String input) {
        createInstructions.add(input);
    }

    private static void removeCreateInstructions(String input) {
        createInstructions.remove(input);
    }
}
