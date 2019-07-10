package Model.Characters;

import Model.Artifacts.Artifact;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight extends Hero {

    private static int defence = 20;
    private static int hitPoints = 36;
    private static int attack = 15;

    public Knight(String name) {
        super(name, 1, 0, hitPoints, attack, defence, new Artifact[3]);
        this.name = name;
        this.type = "Knight";
        this.level = 1;
        this.baseDefencePnts = level * defence;
        this.baseHitPnts = level * hitPoints;
        this.baseAttackPnts = level * attack;
    }

    // TODO -- Artifact array needs to be done. String conversion to Artifact
    public Knight(String name, int experience, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        super(name, level, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence, new Artifact[3]);
		this.experiencePnts = experience;
		this.type = "Knight";
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
    }
}
