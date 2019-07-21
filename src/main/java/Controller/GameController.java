package Controller;

import Model.Characters.Character;
import Model.GameModel;
import Utils.CharacterFactory;
import View.GameView;

import java.util.Random;

import static Controller.ApplicationController.FIGHT_LOOP;
import static Controller.ApplicationController.GAME_LOOP;


public class GameController {

	static void startGame() {
		GameModel.createMap(EventDataController.getHero());
		GameModel.updateHeroPlacement(EventDataController.getHero());
		GameView.displayGameView();
	}

	public static String generateRound() {
		StringBuilder mapString = new StringBuilder();
		for (int i = 0; i < GameModel.getMapSize(); i++) {
			for (int x = 0; x < GameModel.getMapSize(); x++) {
				if (GameModel.getMap()[i][x] == 1) {
					mapString.append("@ ");
				}
				else if (GameModel.getMap()[i][x] == 8) {
					mapString.append(" # ");
				}
				else if (GameModel.getMap()[i][x] == 0) {
					mapString.append(" _ ");
				}
				else {
					mapString.append(" # ");
					EventDataController.setFoe(CharacterFactory.createFoe(EventDataController.getHero().getLevel()));
					ApplicationController.status = FIGHT_LOOP;
				}
			}
			mapString.append("\n");
		}
		System.out.println(mapString.toString());
		return mapString.toString();
	}
	public static String setFightText() {
	StringBuilder fightCom = new StringBuilder();
	for (int i = 0; i < FightInstructionController.getFightCommentary().size(); i++ ){
			fightCom.append("\n").append(FightInstructionController.getFightCommentary().get(i));
		}
		return fightCom.toString();
	}

	static void attack(Character attacker, Character victim){
		victim.takeDamage(victim, attacker.getAttackPnts() - victim.getDefencePnts());
		victim.setDefencePnts((victim.getDefencePnts() <= attacker.getAttackPnts()) ? 0 : (victim.getDefencePnts() - attacker.getAttackPnts()));
		GameModel.addFightCommentary(attacker.getName() + " attacks " + victim.getName() + " and did " + attacker.getAttackPnts() + " damage!");
	}

	static void run(){
		int rn = new Random().nextInt(100);
		if (rn % 2 == 0) {
			GameModel.runAway(EventDataController.getHero());
			ApplicationController.status = GAME_LOOP;
		}
		else {
			GameModel.addFightCommentary(EventDataController.getHero().getName() + " failed to run away");
			attack(EventDataController.getFoe(), EventDataController.getHero());
		}
	}
}
