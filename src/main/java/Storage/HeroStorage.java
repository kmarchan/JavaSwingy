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

    	public static String loadToString(Hero hero) {
			String ret;
			ret = 	"Name: " + hero.getName() +
					", Experience: " + hero.getExperiencePnts() +
					", Type: " + hero.getType() +
					", Level: " + hero.getLevel() +
					", Current Health: " + hero.getHitPnts() +
					", Current Defence: " + hero.getDefencePnts() +
					", Weapon: " + hero.getEquipped()[WEAPON].getName() +
					", Armour: " + hero.getEquipped()[ARMOUR].getName() +
					", Helm: " + hero.getEquipped()[HELM].getName();
		return ret;
    }

    public static void saveGame(){
        Hero hero = EventDataController.getHero();
        if (EventDataController.getHero() != null) {
			try {
				FileWriter fr = new FileWriter("heroes.txt", true);
				fr.write( checkFileEmpty() ? hero.saveStringFirst() : hero.saveString());
				fr.close();
			} catch (IOException e) {
				System.out.println("Cannot save game.");
			}
		}
    }

    public static boolean checkFileEmpty() {
    	File loadFile = new File("heroes.txt");
    	if (loadFile.length() == 0)
    		return true;
    	else
    		return false;
	}
}
