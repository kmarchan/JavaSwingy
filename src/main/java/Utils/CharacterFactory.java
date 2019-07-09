package Utils;

import Model.Characters.*;
import Exception.InputException;

public class CharacterFactory {

    public static Hero createHero(String name, String type) {
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

    public static Hero recreateHero(String type, String name, int level, int damage, int defence, String weapon, String armour, String helm) throws InputException{
        switch (type) {
            case "Orc" :
                return new Orc(name, level, damage, defence, weapon, armour, helm);
            case "Black Mage":
                return new BlackMage(name, level, damage, defence, weapon, armour, helm);
            case "Knight":
                return new Knight(name, level, damage, defence, weapon, armour, helm);
            case "Elf":
                return new Elf(name, level, damage, defence, weapon, armour, helm);
            default:
                throw new InputException("Invalid hero type");
        }
    }
}
