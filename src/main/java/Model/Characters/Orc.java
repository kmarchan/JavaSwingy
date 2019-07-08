package Model.Characters;

public class Orc extends Hero{
    public Orc(String name) {
        this.name = name;
    }

    public Orc(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.level = level;
        this.maxHitPnts = damage;
        this.maxDefencePnts = defence;
    }
}
