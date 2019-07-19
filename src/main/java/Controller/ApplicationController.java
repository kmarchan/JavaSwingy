package Controller;

import Storage.HeroStorage;
import View.BaseWindow;
import View.MainMenu;

public class ApplicationController {
	static final int MENU_LOOP = 0;
	static final int GAME_LOOP = 1;
	static final int FIGHT_LOOP = 2;
	static final int ART_LOOP = 3;
	static final int END_LOOP = 4;
	static final int LOAD_LOOP = 5;
	static final int CREATE_LOOP = 6;
	public static int status = 0;

	static public void createWindow(){
		BaseWindow.createBaseWindow();
		MainMenu.displayMainMenu();
		EventDataController.setIsRunning(true);
	}

	static void closeApplication(){
		BaseWindow.destroyWindow();
		HeroStorage.saveGame();
		System.exit(0);
	}
}
