package Controller;

import Model.Characters.Hero;
import Utils.CharacterFactory;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventDataController {

    @Getter
    @Setter
    private static Hero hero;
	private static List<String> instructions = new ArrayList<String>();
	private static Boolean isRunning;
    @Setter
    private static Boolean isProcessed;
    @Getter
	@Setter
	private static String map;

	public static List<String> getOutput() {
		return instructions;
	}

	public static Boolean getIsRunning() {
		return isRunning;
	}

	public static void setIsRunning(Boolean isRunning) {
		EventDataController.isRunning = isRunning;
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
		if (isProcessed) {
			instructions.remove(input);
			isProcessed = false;
		}
		else {
			MenuInstructionController.instructionParse();
			removeInstructions(input);
		}
	}

    public static void createHeroPreview(String type, String name) {
        setHero(CharacterFactory.createHero(name, type));
    }
}
