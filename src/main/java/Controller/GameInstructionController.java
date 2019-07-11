package Controller;

import Exception.InputException;
import Model.GameModel;
import View.BaseWindow;

import java.util.List;

import static View.GameView.displayGameView;

public class GameInstructionController {
	private static List<String> gameInstructions;
	private static boolean isProcessed;
	private static boolean isGameRunning;

	enum Instruction {
		north,
		east,
		west,
		south,
		exit,
		gui,
	}

	public static void setIsGameRunning(boolean isGameRunning) {
		GameInstructionController.isGameRunning = isGameRunning;
	}
	public static void gameInstructionParse() {
		int instructionIndex = 0;
		try {
			gameInstructions = EventDataController.getOutput();

			while (isGameRunning == true) {
				for (int i = 0; i < gameInstructions.size(); i++) {
					instructionIndex = i;
					/* IMPORTANT: remove instruction after use. */
					if (gameInstructions.get(i) != null) {
						isProcessed = true;
						switch (Instruction.valueOf(gameInstructions.get(i).toLowerCase())) {
							case exit: {
								EventDataController.setIsRunning(false);
								System.out.println("killing program");
								ApplicationController.closeApplication();
								break;
							}
							case gui:
								BaseWindow.showBaseWindow();
								break;
							case south:
								GameModel.moveSouth(EventDataController.getHero());
								displayGameView();
								break;
							case north:
								GameModel.moveNorth(EventDataController.getHero());
								displayGameView();
								break;
							case west:
								GameModel.moveWest(EventDataController.getHero());
								displayGameView();
								break;
							case east:
								displayGameView();
								GameModel.moveEast(EventDataController.getHero());
								break;
							default: {
								System.out.println("Invalid instruction:" + gameInstructions.get(i));
							}
						}
						displayGameView();
						removeGameInstructions(gameInstructions.get(i));
					}
				}
				gameInstructions = EventDataController.getOutput();
			}
		} catch (IllegalArgumentException | InputException e) {
			System.out.println("Invalid instruction:" + gameInstructions.get(instructionIndex));
			removeGameInstructions(gameInstructions.get(instructionIndex));
			gameInstructionParse();
		}
	}

	public static void addInstructions(String input) {
		isProcessed = false;
		gameInstructions.add(input);
	}

	public static void removeGameInstructions(String input) {
		if (isProcessed) {
			gameInstructions.remove(input);
			isProcessed = false;
		} else {
			gameInstructionParse();
			if (gameInstructions.size() != 0) {
				removeGameInstructions(input);
			}
		}
	}
}
