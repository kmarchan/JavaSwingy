import Controller.*;
import Exception.InputException;

public class Main {

		public static void main(String[] args) throws InputException {
			System.out.println("Starting");
			ApplicationController.createWindow();
            EventDataController.readStdinAsync();
//            MenuInstructionController.instructionParse();
			GameInstructionController.setIsGameRunning(true);
			StateManager.stateManager();
//			GameInstructionController.gameInstructionParse();
			System.out.println("End of main");
		}
}
