package Utils;

import Model.Characters.*;

public class CharacterFactory {

    public static Hero createHero(String name, String type) {
        System.out.println("new hero :" + name + type);
        switch (type) {
            case "Orc" :
                return new Orc(name);
            case "Black Mage":
                return new BlackMage(name);
            case "Knight":
                return new Knight(name);
            case "Elf":
                return new Elf(name);
            default:
                return null;
        }
    }
}
