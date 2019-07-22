package Controller;

import Model.GameModel;
import View.BaseWindow;

import java.util.List;

import static Controller.ApplicationController.GAME_LOOP;
import static View.GameView.displayGameView;

public class GameInstructionController {
	private static List<String> gameInstructions;

	enum Instruction {
		north,
		east,
		west,
		south,
		exit,
		gui,
	}

	static void gameInstructionParse() {
		int instructionIndex = 0;
		try {
			gameInstructions = EventDataController.getInstructions();
			displayGameView();
			while (ApplicationController.status == GAME_LOOP) {
				for (int i = 0; i < gameInstructions.size(); i++) {
					instructionIndex = i;
					if (gameInstructions.get(i) != null) {
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
						EventDataController.removeInstructions(gameInstructions.get(i));
					}
				}
				gameInstructions = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + gameInstructions.get(instructionIndex)+ "\nYour options are [north, south, east, west and exit]");
			EventDataController.removeInstructions(gameInstructions.get(instructionIndex));
			gameInstructionParse();
		} finally {
			EventDataController.removeInstructions(gameInstructions.get(instructionIndex));
			gameInstructions = EventDataController.getInstructions();
		}
	}
}
