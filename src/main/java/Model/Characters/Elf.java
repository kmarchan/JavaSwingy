package Model.Characters;

public class Elf extends Hero {
    public Elf(String name) {
        this.name = name;
    }

    public Elf(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.level = level;
        this.maxHitPnts = damage;
        this.maxDefencePnts = defence;
    }
}
