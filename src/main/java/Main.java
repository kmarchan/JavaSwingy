import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.GameInstructionController;
import Controller.MenuInstructionController;
import Exception.InputException;

public class Main {

		public static void main(String[] args) throws InputException {
			System.out.println("Starting");
			ApplicationController.createWindow();
            EventDataController.readStdinAsync();
            MenuInstructionController.instructionParse();
			GameInstructionController.setIsGameRunning(true);
			GameInstructionController.gameInstructionParse();
			System.out.println("End of main");
		}
}
