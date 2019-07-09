package Model.Characters;

public class Elf extends Hero {

    private int defence = 20;
    private int hitPoints = 36;
    private int attack = 15;

    public Elf(String name) {
        this.name = name;
        this.type = "Elf";
        this.level = 1;
        this.baseHitPnts = level * hitPoints;
        this.baseDefencePnts = level * defence;
        this.baseAttackPnts = level * attack;
    }

    public Elf(String name, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        this.name = name;
        this.type = "Elf";
        this.level = level;
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
        this.baseHitPnts = level * hitPoints;
        this.baseDefencePnts = level * defence;
        this.baseAttackPnts = level * attack;
    }
}
