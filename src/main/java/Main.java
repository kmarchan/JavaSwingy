import Controller.ApplicationController;
import Controller.EventDataController;
import Controller.InstructionController;
import Exception.InputException;

public class Main{

		public static void main(String[] args) throws InputException {
			System.out.println("Starting");
			ApplicationController.createWindow();
            EventDataController.readStdinAsync();
            InstructionController.instructionParse();
			System.out.println("End of main");
		}
}
