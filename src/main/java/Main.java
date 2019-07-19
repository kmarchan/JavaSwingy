import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.GameInstructionController;
import Controller.StateManager;

public class Main {

	public static void main(String[] args) {
		ApplicationController.createWindow();
		EventDataController.readStdinAsync();
		GameInstructionController.setIsGameRunning(true);
		StateManager.stateManager();
	}
}
