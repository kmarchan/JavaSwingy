package Model.Characters;

import Model.Artifacts.Artifact;

public class Elf extends Hero {

    private static int defence = 20;
    private static int hitPoints = 36;
    private static int attack = 15;

    public Elf(String name) {
        super(name, 1, Character.calculateExperiencePnts(1), hitPoints, attack, defence, new Artifact[3]);
        this.type = "Elf";
    }

    // TODO -- Artifact array needs to be done. String conversion to Artifact
    public Elf(String name, int experience, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        super(name, level, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence, new Artifact[3]);
        this.type = "Elf";
        this.experiencePnts = experience;
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
    }
}
