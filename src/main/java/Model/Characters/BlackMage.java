package Model.Characters;

public class BlackMage extends Hero{

    private int defence = 20;
    private int hitPoints = 36;
    private int attack = 15;

    public BlackMage(String name) {
        this.name = name;
        this.type = "Black Mage";
        this.level = 1;
        this.baseHitPnts = level * hitPoints;
        this.baseDefencePnts = level * defence;
        this.baseAttackPnts = level * attack;
    }

    public BlackMage(String name, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        this.name = name;
        this.type = "Black Mage";
        this.level = level;
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
        this.baseHitPnts = level * hitPoints;
        this.baseDefencePnts = level * defence;
        this.baseAttackPnts = level * attack;
    }
}
