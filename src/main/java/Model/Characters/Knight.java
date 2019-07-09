package Model.Characters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight extends Hero {

    public Knight(String name) {
        this.name = name;
        this.type = "Knight";
        this.level = 1;
        this.baseDefencePnts = 20;
        this.baseHitPnts = 80;
        this.baseAttackPnts = 20;
    }

    public Knight(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.type = "Knight";
        this.level = level;
        this.baseHitPnts = damage;
        this.baseDefencePnts = defence;
    }
}
