package Utils;

import Exception.InputException;
import Model.Characters.*;

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

    public static Hero recreateHero(String type, String name, int experience, int level, int currentHealth, int currentDefence, String weapon, int wBuff, String armour, int aBuff, String helm, int hBuff) throws InputException {
        switch (type) {
            case "Orc" :
                return new Orc(name, experience, level, currentHealth, currentDefence, weapon, wBuff, armour, aBuff, helm, hBuff);
            case "Black Mage":
                return new BlackMage(name, experience, level, currentHealth, currentDefence, weapon, wBuff, armour, aBuff, helm, hBuff);
            case "Knight":
                return new Knight(name, experience, level, currentHealth, currentDefence, weapon, wBuff, armour, aBuff, helm, hBuff);
            case "Elf":
                return new Elf(name, experience, level, currentHealth, currentDefence, weapon, wBuff, armour, aBuff, helm, hBuff);
            default:
                throw new InputException("Invalid hero type");
        }
    }

    public static Foe createFoe(int heroLevel) {
        return new Foe(heroLevel);
    }
}
