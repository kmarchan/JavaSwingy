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
//                System.out.println("name: " + name);
				experience = sc.nextInt();
//				System.out.println("experience: " + experience);
                type = sc.next();
//				System.out.println("type: " + type);
                level = sc.nextInt();
//                System.out.println("level: " + level);
                currentHealth = sc.nextInt();
//                System.out.println("currentHealth: " + currentHealth);
                currentDefence = sc.nextInt();
//                System.out.println("currentDefence: " + currentDefence);
                weapon = sc.next();
//                System.out.println("weapon: " + weapon);
                armour = sc.next();
//                System.out.println("armour: " + armour);
                helm = sc.next();
//                System.out.println("helm: " + helm);
                sc.reset();
                savedHeroes.add(CharacterFactory.recreateHero(type, name, experience, level, currentHealth, currentDefence, weapon, armour, helm));
            }
        }
    }
    public static void saveGame(){
        Hero hero = EventDataController.getHero();
        try {
            FileWriter fr = new FileWriter("heroes.txt", true);
            fr.write(hero.saveString() +"\n");
            fr.close();
        } catch (IOException e){
            System.out.println("Cannot save game.");
        }
    }
}
