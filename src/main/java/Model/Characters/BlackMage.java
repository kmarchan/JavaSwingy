package Model.Characters;

import Model.Artifacts.Artifact;
import lombok.Getter;

public class BlackMage extends Hero{

	@Getter	private static int defence = 20;
	@Getter private static int hitPoints = 36;
	@Getter private static int attack = 15;

    public BlackMage(String name) {
        super(name, 1, 0, hitPoints, attack, defence, new Artifact[3]);
        this.type = "Black Mage";
    }

    // TODO -- Artifact array needs to be done. String conversion to Artifact
    public BlackMage(String name, int experience, int level, int currentHealth, int currentDefence, String weapon, String armour, String helm) {
        super(name, level, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence, new Artifact[3]);
		this.experiencePnts = experience;
		this.type = "Black Mage";
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
    }
}
