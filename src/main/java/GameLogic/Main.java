package GameLogic;

public class Main {

		public static void main(String[] args) {
			System.out.println("Starting");

			ApplicationControls.createWindow();

			EventParsing.instructionParseAsync();

			EventData.readStdinAsync();

			System.out.println("End of main");

		}
}
