package GameLogic;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventData {

	private static List<String> instructions = new ArrayList<String>();
	private static Boolean isRunning;


	public static List<String> getOutput() {
		return instructions;
	}

	public static Boolean getIsRunning() {
		return isRunning;
	}

	public static void setIsRunning(Boolean isRunning) {
		EventData.isRunning = isRunning;
	}

	public static void readStdinAsync(){

		new Thread(new Runnable() {
			Scanner input = new Scanner(System.in);

			public void run() {
					while (isRunning && input.hasNext()) {
						addInstructions(input.nextLine());
					}
					System.out.println("ended stdin");
					Thread.interrupted();
			}
		}).start();
	}

	public static void addInstructions(String input) {
		instructions.add(input);
	}

	public static void removeInstructions(String input) {
		instructions.remove(input);
	}

}
