package Model;

import Model.Characters.Hero;
import Utils.CharacterFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.InputException;

public class HeroStorage {


    public static List<Hero> savedHeroes = new ArrayList<>();

    public static void getSavedHeroes() throws InputException {
        File file = new File("heroes.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        String name;
        String type;
        int level;
        int damage;
        int defence;
        String weapon;
        String armour;
        String helm;
        while (sc.hasNext()) {
            // TODO -- remove sout
            sc.useDelimiter(", ");
            name = sc.next();
            System.out.println("name: " + name);
            type = sc.next();
            System.out.println("type: " + type);
            level = sc.nextInt();
            System.out.println("level: " + level);
            damage = sc.nextInt();
            System.out.println("damage: " + damage);
            defence = sc.nextInt();
            System.out.println("defence: " + defence);
            weapon = sc.next();
            System.out.println("weapon: "+ weapon);
            armour = sc.next();
            System.out.println("armour: " + armour);
            helm = sc.next();
            System.out.println("helm: " + helm);
            sc.reset();
            savedHeroes.add(CharacterFactory.recreateHero(type, name, level, damage, defence, weapon, armour, helm));
        }
        System.out.println(savedHeroes);
    }
}
