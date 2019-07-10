package Model;

import Controller.EventDataController;
import Model.Characters.Hero;
import lombok.Getter;
import lombok.Setter;


public class GameModel {
	@Getter @Setter	private static int mapSize;
	@Getter @Setter	private static int[][] map;

	public static void createMap(Hero hero) {
		setMapSize((hero.getLevel()-1)*5+10-(hero.getLevel()%2));
		setMap(new int[mapSize][mapSize]);
		for (int i = 0; i < mapSize; i++){
			for (int x = 0; x < mapSize; x++){
				map[i][x] = 0;
			}
		}
		updateHeroPlacement(EventDataController.getHero());
	}

	public static void updateHeroPlacement(Hero hero) {
		map[hero.getRow()][hero.getColumn()] = 8;
	}

	public static void moveNorth(Hero hero) {
		hero.setPreviousPosition(hero.getRow(), hero.getColumn());
		hero.setRow(hero.getRow()-1);
		updateHeroPlacement(hero);
	}
}
