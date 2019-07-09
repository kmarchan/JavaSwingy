package Controller;

import Storage.HeroStorage;
import View.*;
import Exception.InputException;
import java.util.List;

public class EventParsing {
	private static List<String> instructions;

	enum Instruction {
		loadgame,
		exit,
		newgame,
        start,
		controls,
		menu,
		gui
	}

	public static void instructionParse() {
			int instructionIndex = 0;
				try {
					instructions = EventData.getOutput();

					while(EventData.getIsRunning()) {
						for (int i=0; i < instructions.size(); i++) {
							instructionIndex = i;
							/* IMPORTANT: remove instruction after use. */
							if (instructions.get(i) != null) {
								EventData.setIsProcessed(true);
								switch (Instruction.valueOf(instructions.get(i).toLowerCase())) {
									case exit: {
										EventData.setIsRunning(false);
										System.out.println("killing program");
										Controller.ApplicationControls.closeApplication();
										break;
									}
									case gui:
										BaseWindow.showBaseWindow();
										break;
									case newgame:
										NewGame.displayNewGame();
										break;
									case controls:
										Controls.displayControls();
										break;
									case loadgame:
                                       	HeroStorage.getSavedHeroes();
                                        LoadHero.displayLoadHero();
										break;
									case menu:
										MainMenu.displayMainMenu();
										break;
                                    case start:
                                        GameView.displayGameView();
                                        break;
									default: {
										System.out.println("Invalid instruction:" + instructions.get(i));
									}
								}
							}
							EventData.removeInstructions(instructions.get(i));
						}
						instructions = EventData.getOutput();
					}
				} catch (IllegalArgumentException e){
					System.out.println("Invalid instruction:"+instructions.get(instructionIndex));
					EventData.removeInstructions(instructions.get(instructionIndex));
					instructionParse();
				} catch (InputException e) {
                    e.printStackTrace();
                }
    }
}
