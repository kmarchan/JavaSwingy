package Controller;

import Model.Characters.Foe;
import Model.Characters.Hero;
import Utils.CharacterFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public class EventDataController {

    @Getter @Setter private static Hero hero;
    @Getter @Setter private static Foe foe;
	@Getter	@Setter	private static String map;
	@Getter private static String instruction = "";

	public static void readStdinAsync(){
		new Thread(new Runnable() {
			Scanner input = new Scanner(System.in);

			public void run() {
				System.out.println("kadsjhfkdjsa");
					while (input.hasNext()) {
						addInstructions(input.nextLine());
					}
					System.out.println("ended stdin");
					Thread.interrupted();
			}
		}).start();
	}

	public static void addInstructions(String input) {
		instruction = input;
		System.out.println("[INSTRUCTION IN: " + instruction + "]");
	}

	static void removeInstructions(String input) {
		instruction = "";
		System.out.println("input " + input + " removed");
	}

    public static void createHeroPreview(String type, String name)
	{
        setHero(CharacterFactory.createHero(name, type));
    }
}
