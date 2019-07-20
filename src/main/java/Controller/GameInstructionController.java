package Controller;

import Model.GameModel;
import View.BaseWindow;

import java.util.List;

import static Controller.ApplicationController.GAME_LOOP;
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

	static void gameInstructionParse() {
		int instructionIndex = 0;
		try {
			gameInstructions = EventDataController.getInstructions();
			displayGameView();
			while (isGameRunning && ApplicationController.status == GAME_LOOP) {
				for (int i = 0; i < gameInstructions.size(); i++) {
					instructionIndex = i;
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
								break;
							case north:
								GameModel.moveNorth(EventDataController.getHero());
								break;
							case west:
								GameModel.moveWest(EventDataController.getHero());
								break;
							case east:
								GameModel.moveEast(EventDataController.getHero());
								break;
							default: {
								System.out.println("Invalid Game Instruction:" + gameInstructions.get(i));
							}
						}
						removeGameInstructions(gameInstructions.get(i));
						displayGameView();
					}
				}
				gameInstructions = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + gameInstructions.get(instructionIndex)+ "\nYour options are [north, south, east, west and exit]");
			removeGameInstructions(gameInstructions.get(instructionIndex));
			gameInstructionParse();
		}
	}

	public static void addInstructions(String input) {
		isProcessed = false;
		gameInstructions.add(input);
	}

	private static void removeGameInstructions(String input) {
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
