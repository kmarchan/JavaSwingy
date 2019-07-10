package Controller;

import Model.GameModel;
import Exception.InputException;
import View.GameView;


public class GameController {


	public static void startGame() throws InputException {

		GameModel.createMap(EventDataController.getHero());
		GameView.displayGameView();
	}

	public static String printMap() {
		String mapString = new String();
		for (int i = 0; i < GameModel.getMapSize(); i++){
			for (int x = 0; x < GameModel.getMapSize(); x++){
				mapString += GameModel.getMap()[i][x] = 0;
				mapString += " ";
			}
			mapString += "\n";
		};
		return mapString;
	}
}
