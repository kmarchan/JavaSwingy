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

import static Model.Artifacts.Artifact.*;

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
            int wBuff;
            String armour;
            int aBuff;
            String helm;
            int hBuff;
            while (sc.hasNext()) {
                sc.useDelimiter(", ");
                name = sc.next();
				experience = sc.nextInt();
                type = sc.next();
                level = sc.nextInt();
                currentHealth = sc.nextInt();
                currentDefence = sc.nextInt();
                weapon = sc.next();
                wBuff = sc.nextInt();
                armour = sc.next();
                aBuff = sc.nextInt();
                helm = sc.next();
                hBuff = sc.nextInt();
                sc.reset();
                savedHeroes.add(CharacterFactory.recreateHero(type, name, experience, level, currentHealth, currentDefence, weapon, wBuff, armour, aBuff, helm, hBuff));
            }
        }
    }
		// TODO use for terminal hero loader
    	public static String loadToString(Hero hero) {
			String ret;
			ret = 	"name: " + hero.getName() +
					" experience: " + hero.getExperiencePnts() +
					" type: " + hero.getType() +
					" level: " + hero.getLevel() +
					" currentHealth: " + hero.getHitPnts() +
					" currentDefence: " + hero.getDefencePnts() +
					" weapon: " + hero.getEquipped()[WEAPON] +
					" armour: " + hero.getEquipped()[ARMOUR] +
					" helm: " + hero.getEquipped()[HELM];
		return ret;
    }

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
