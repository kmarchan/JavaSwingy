package Model.Characters;

public class BlackMage extends Hero{
    public BlackMage(String name) {
        this.name = name;
        this.type = "Black Mage";
        this.level = 1;
        this.baseDefencePnts = 10;
        this.baseHitPnts = 100;
        this.baseAttackPnts = 20;
    }

    public BlackMage(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.type = "Black Mage";
        this.level = level;
        this.baseHitPnts = damage;
        this.baseAttackPnts = defence;
    }
}
