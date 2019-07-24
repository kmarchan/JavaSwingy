import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.StateManager;
import Exception.InputException;
import View.BaseWindow;

public class Main {

	public static void main(String[] args) throws InputException {
		ApplicationController.createWindow();
		EventDataController.readStdinAsync();
		if (args.length >= 1 && args[0].contains("console"))
		{
			BaseWindow.hideBaseWindow();
		}
		StateManager.status = 0;
		StateManager.stateManager();
	}
}
