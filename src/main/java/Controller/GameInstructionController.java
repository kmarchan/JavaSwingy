package Controller;

import Model.GameModel;
import View.BaseWindow;

import static Controller.ApplicationController.GAME_LOOP;
import static Controller.ApplicationController.SLEEP_TIME;
import static View.GameView.displayGameView;

public class GameInstructionController {
	private static String gameInstructions;

	enum Instruction {
		north,
		east,
		west,
		south,
		exit,
		gui,
	}


	static void gameInstructionParse() {
		try {
			gameInstructions = EventDataController.getInstruction();
			displayGameView();
			while ( StateManager.status == GAME_LOOP) {
				Thread.sleep( SLEEP_TIME);
					if (gameInstructions != "") {
						switch (Instruction.valueOf(gameInstructions.toLowerCase())) {
							case exit: {
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
								System.out.println("Invalid Game Instruction:" + gameInstructions);
							}
						}
						EventDataController.removeInstructions();
						displayGameView();
					}
					gameInstructions = EventDataController.getInstruction();
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			System.out.println("Invalid instruction:" + gameInstructions+ "\nYour options are [north, south, east, west and exit]");
			EventDataController.removeInstructions();
			gameInstructionParse();
		}
	}
}
