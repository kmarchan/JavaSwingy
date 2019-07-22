import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.StateManager;

public class Main {

	public static void main(String[] args) {
		ApplicationController.createWindow();
//		EventDataController.setIsRunning(true);
		EventDataController.readStdinAsync();
		StateManager.status = 0;
		StateManager.stateManager();
	}
}
