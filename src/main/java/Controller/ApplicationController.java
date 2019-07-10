package Controller;

import View.BaseWindow;
import View.MainMenu;

public class ApplicationController {

	static public void createWindow(){
		BaseWindow.createBaseWindow();
		MainMenu.displayMainMenu();
		EventDataController.setIsRunning(true);
	}

	static public void closeApplication(){
		BaseWindow.destoryWindow();
		System.exit(0);
	}
}
