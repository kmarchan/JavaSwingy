package Model.Characters;

public class Elf extends Hero {
    public Elf(String name) {
        this.name = name;
        this.type = "Elf";
        this.level = 1;
        this.baseDefencePnts = 10;
        this.baseHitPnts = 90;
        this.baseAttackPnts = 30;
    }

    public Elf(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.level = level;
        this.baseHitPnts = damage;
        this.baseDefencePnts = defence;
    }
}
