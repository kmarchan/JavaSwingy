package Model.Characters;

import Model.Artifacts.Artifact;

public class Orc extends Hero{

    private static int defence = 20;
    private static int hitPoints = 36;
    private static int attack = 15;

    public Orc(String name) {
        super(name, 1, 0, hitPoints, attack, defence, new Artifact[3]);
        this.type = "Orc";
    }

    // TODO -- Artifact array needs to be done. String conversion to Artifact
    public Orc(String name, int experience, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        super(name, level, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence, new Artifact[3]);
		this.experiencePnts = experience;
		this.type = "Orc";
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
    }
}
