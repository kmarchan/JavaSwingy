package Controller;

import View.BaseWindow;
import View.MainMenu;
import View.StartGame;

public class ApplicationControls {

	static public void createWindow(){
		BaseWindow.createBaseWindow();
		MainMenu.displayMainMenu();
		EventData.setIsRunning(true);
	}

	static public void closeApplication(){
		BaseWindow.destoryWindow();
		System.exit(0);
	}
}
