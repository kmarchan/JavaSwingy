package Controller;

import Exception.InputException;
import Model.GameModel;
import Utils.CharacterFactory;
import View.FightView;
import View.GameView;


public class GameController {


	public static void startGame() throws InputException {
		GameModel.createMap(EventDataController.getHero());
		GameModel.updateHeroPlacement(EventDataController.getHero());
		GameView.displayGameView();
	}

	public static String generateRound() {
		String mapString = "";
		for (int i = 0; i < GameModel.getMapSize(); i++){
			for (int x = 0; x < GameModel.getMapSize(); x++){
				if (GameModel.getMap()[i][x] == 1) {
					mapString += "@ ";
				}
				else if (GameModel.getMap()[i][x] == 8) {
					mapString += " # ";
				}
				else if (GameModel.getMap()[i][x] == 0) {
					mapString += " _ ";
				}
				else {
					FightInstructionController.setFightRunning(true);
					EventDataController.setFoe(CharacterFactory.createFoe(EventDataController.getHero().getLevel()));
					FightView.displayFightView();
					FightInstructionController.fightInstructionParse();
				}
			}
			mapString += "\n";
		}
		return mapString;
	}
}
