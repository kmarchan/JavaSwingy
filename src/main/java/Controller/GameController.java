package Controller;

import Model.Characters.Character;
import Model.GameModel;
import Utils.CharacterFactory;
import View.GameView;

import java.util.Random;

import static Controller.ApplicationController.FIGHT_LOOP;


public class GameController {


	public static void startGame() {
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
					mapString += " # ";
					FightInstructionController.setFightRunning(true);
					EventDataController.setFoe(CharacterFactory.createFoe(EventDataController.getHero().getLevel()));
					ApplicationController.status = FIGHT_LOOP;
//					FightView.displayFightView();
//					FightInstructionController.fightInstructionParse();
				}
			}
			mapString += "\n";
		}
		return mapString;
	}
	public static String setFightText(){ ;
	String fightCom = new String();
	for (int i = 0; i < GameModel.getFightCommentary().size(); i++ ){
			fightCom += "\n" + GameModel.getFightCommentary().get(i);
		}
		return fightCom;
	}

	public static void attack(Character attacker, Character victim){
		victim.takeDamage(victim, attacker.getAttackPnts() - victim.getDefencePnts());
		victim.setDefencePnts((victim.getDefencePnts() <= attacker.getAttackPnts()) ? 0 : (victim.getDefencePnts() - attacker.getAttackPnts()));
		GameModel.addFightCommentary(attacker.getName() + " attacks " + victim.getName() + " and did " + attacker.getAttackPnts() + " damage!");
	}

	public static void run(){
		int rn = new Random().nextInt(100);
		if (rn % 2 == 0) {
			GameModel.runAway(EventDataController.getHero());
			FightInstructionController.setFightRunning(false);
		}
		else {
			GameModel.addFightCommentary(EventDataController.getHero().getName() + " failed to run away");
			attack(EventDataController.getFoe(), EventDataController.getHero());
		};
	}
}
