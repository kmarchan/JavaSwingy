import Controller.ApplicationControls;
import Controller.EventData;
import Controller.EventParsing;
import Storage.HeroStorage;
import Exception.InputException;

public class Main{

		public static void main(String[] args) throws InputException {
			System.out.println("Starting");
			ApplicationControls.createWindow();
            EventData.readStdinAsync();
            EventParsing.instructionParse();
			System.out.println("End of main");
		}
}
