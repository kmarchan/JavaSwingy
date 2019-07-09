package Model.Characters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight extends Hero {

    private int defence = 20;
    private int hitPoints = 36;
    private int attack = 15;

    public Knight(String name) {
        this.name = name;
        this.type = "Knight";
        this.level = 1;
        this.baseDefencePnts = level * defence;
        this.baseHitPnts = level * hitPoints;
        this.baseAttackPnts = level * attack;
    }

    public Knight(String name, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        this.name = name;
        this.type = "Knight";
        this.level = level;
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
        this.baseHitPnts = level * hitPoints;
        this.baseDefencePnts = level * defence;
        this.baseAttackPnts = level * attack;
    }
}
