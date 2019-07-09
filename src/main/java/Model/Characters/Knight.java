package Model.Characters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight extends Hero {

    public Knight(String name) {
        this.name = name;
    }

    public Knight(String name, int level, int damage, int defence, String weapon, String armour, String helm) {
        this.name = name;
        this.level = level;
        this.maxHitPnts = damage;
        this.maxDefencePnts = defence;
    }
}
