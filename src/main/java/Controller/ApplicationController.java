package Controller;

import Storage.HeroStorage;
import View.BaseWindow;
import View.MainMenu;

public class ApplicationController {
	public static final int MENU_LOOP = 0;
	public static final int GAME_LOOP = 1;
	public static final int FIGHT_LOOP = 2;
	public static final int ART_LOOP = 3;
	public static final int END_LOOP = 4;
	public static int status = 0;

	static public void createWindow(){
		BaseWindow.createBaseWindow();
		MainMenu.displayMainMenu();
		EventDataController.setIsRunning(true);
	}

	static public void closeApplication(){
		BaseWindow.destroyWindow();
		HeroStorage.saveGame();
		System.exit(0);
	}
}
