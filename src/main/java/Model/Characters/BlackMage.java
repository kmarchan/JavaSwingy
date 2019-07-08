package Model.Characters;

public class BlackMage extends Hero{
    public BlackMage(String name) {
        this.name = name;
    }

    public BlackMage(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.level = level;
        this.maxHitPnts = damage;
        this.maxAttackPnts = defence;
    }
}
