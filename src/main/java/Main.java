import Controller.ApplicationControls;
import Controller.EventData;
import Controller.EventParsing;

public class Main{

		public static void main(String[] args) {
			System.out.println("Starting");
			ApplicationControls.createWindow();
            EventData.readStdinAsync();
            EventParsing.instructionParse();
			System.out.println("End of main");
		}
}
