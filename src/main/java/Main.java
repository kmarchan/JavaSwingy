import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.StateManager;
import Exception.InputException;

public class Main {

	public static void main(String[] args) throws InputException {
		ApplicationController.createWindow();
		EventDataController.readStdinAsync();
		StateManager.status = 0;
		StateManager.stateManager();
	}
}
