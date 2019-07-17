import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.GameInstructionController;
import Controller.StateManager;

public class Main {

		public static void main(String[] args) {
			System.out.println("Starting");
			ApplicationController.createWindow();
            EventDataController.readStdinAsync();
			GameInstructionController.setIsGameRunning(true);
			StateManager.stateManager();
			System.out.println("End of main");
		}
}
