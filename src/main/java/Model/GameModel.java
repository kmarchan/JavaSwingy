package Model;

import Controller.EventDataController;
import Controller.GameController;
import Model.Characters.Hero;
import lombok.Getter;
import lombok.Setter;


public class GameModel {
	@Getter @Setter	private static int mapSize;
	@Getter @Setter	private static int[][] map;

	public static void createMap(Hero hero) {
		setMapSize((hero.getLevel()-1)*5+10-(hero.getLevel()%2));
		resetHeroPlacement(hero);
		setMap(new int[mapSize][mapSize]);
		for (int i = 0; i < mapSize; i++){
			for (int x = 0; x < mapSize; x++){
				map[i][x] = 0;
			}
		}
		updateHeroPlacement(EventDataController.getHero());
	}

	public static void updateHeroPlacement(Hero hero) {
		map[hero.getPreviousPosition()[0]][hero.getPreviousPosition()[1]] = 0;
		map[hero.getRow()][hero.getColumn()] = 8;
	}

	public static void resetHeroPlacement(Hero hero) {
		int center = mapSize / 2;
		hero.setRow(center);
		hero.setColumn(center);
		hero.setPreviousPosition(center, center);
	}

	public static void moveNorth(Hero hero) {
		hero.setPreviousPosition(hero.getRow(), hero.getColumn());
		if (hero.getRow() > 0) {
			hero.setRow(hero.getRow() - 1);
		}
		else
		{
			mapEdgeReached(hero);
		}
		updateHeroPlacement(hero);
		System.out.println(GameController.printMap());
	}

	public static void moveSouth(Hero hero) {
		hero.setPreviousPosition(hero.getRow(), hero.getColumn());
		if (hero.getRow() + 1< mapSize) {
			hero.setRow(hero.getRow() + 1);
		}
		else
		{
			mapEdgeReached(hero);
		}
		updateHeroPlacement(hero);
		System.out.println(GameController.printMap());
	}
	public static void moveEast(Hero hero) {
		hero.setPreviousPosition(hero.getRow(), hero.getColumn());
		if (hero.getColumn() + 1 < mapSize) {
			hero.setColumn(hero.getColumn() + 1);
		}
		else
		{
			mapEdgeReached(hero);
		}
		updateHeroPlacement(hero);
		System.out.println(GameController.printMap());
	}
	public static void moveWest(Hero hero) {
		hero.setPreviousPosition(hero.getRow(), hero.getColumn());
		if (hero.getColumn() > 0) {
			hero.setColumn(hero.getColumn() - 1);
		}
		else
		{
			mapEdgeReached(hero);
		}
		updateHeroPlacement(hero);
		System.out.println(GameController.printMap());
	}
	private static void mapEdgeReached(Hero hero){
		Hero.gainExperience(hero, hero.getLevel() * 15);
		createMap(hero);
	}
}
