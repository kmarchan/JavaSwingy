package Storage;

import Controller.EventDataController;
import Exception.InputException;
import Model.Characters.Hero;
import Utils.CharacterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeroStorage {

    public static List<Hero> savedHeroes = new ArrayList<>();

    public static void getSavedHeroes() throws InputException {
        if (savedHeroes.size() == 0) {
            File file = new File("heroes.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            String name;
            int experience;
            String type;
            int level;
            int currentHealth;
            int currentDefence;
            String weapon;
            String armour;
            String helm;
            while (sc.hasNext()) {
                // TODO -- remove sout
                sc.useDelimiter(", ");
                name = sc.next();
				experience = sc.nextInt();
                type = sc.next();
                level = sc.nextInt();
                currentHealth = sc.nextInt();
                currentDefence = sc.nextInt();
                weapon = sc.next();
                armour = sc.next();
                helm = sc.next();
                sc.reset();
                savedHeroes.add(CharacterFactory.recreateHero(type, name, experience, level, currentHealth, currentDefence, weapon, armour, helm));
            }
        }
    }

    // TODO use or remove
//    public static String loadToString() {
//		System.out.println("name: " + name);
//		System.out.println("experience: " + hero.experience);
//		System.out.println("type: " + type);
//		System.out.println("level: " + level);
//		System.out.println("currentHealth: " + currentHealth);
//		System.out.println("currentDefence: " + currentDefence);
//		System.out.println("weapon: " + weapon);
//		System.out.println("armour: " + armour);
//		System.out.println("helm: " + helm);
//	}

    public static void saveGame(){
        Hero hero = EventDataController.getHero();
        if (EventDataController.getHero() != null) {
			try {
				FileWriter fr = new FileWriter("heroes.txt", true);
				fr.write(hero.saveString());
				fr.close();
			} catch (IOException e) {
				System.out.println("Cannot save game.");
			}
		}
    }
}
