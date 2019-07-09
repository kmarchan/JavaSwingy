package Model.Characters;

public class Orc extends Hero{
    public Orc(String name) {
        this.name = name;
        this.type = "Orc";
        this.level = 1;
        this.baseDefencePnts = 10;
        this.baseHitPnts = 100;
        this.baseAttackPnts = 10;
    }

    public Orc(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.type = "Orc";
        this.level = level;
        this.baseHitPnts = damage;
        this.baseDefencePnts = defence;
    }
}
