package Model.Characters;

import Model.Artifacts.Artifact;
import Model.Artifacts.Item;

import javax.xml.stream.events.Characters;

public class Orc extends Hero{

    private int defence = 20;
    private int hitPoints = 36;
    private int attack = 15;

    public Orc(String name) {
        this.type = "Orc";
        Artifact[] equipped = new Artifact[3];
        Characters.Character(name, 1, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence, equipped);
    }

    public Orc(String name, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        this.type = "Orc";
        this.level = level;
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
        Characters.Character(name, 1, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence);
    }
}
