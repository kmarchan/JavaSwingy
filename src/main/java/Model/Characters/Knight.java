package Model.Characters;

import Model.Artifacts.Armour;
import Model.Artifacts.Artifact;
import Model.Artifacts.Helm;
import Model.Artifacts.Weapon;
import lombok.Getter;

import static Model.Artifacts.Artifact.ARMOUR;
import static Model.Artifacts.Artifact.HELM;
import static Model.Artifacts.Artifact.WEAPON;

public class Knight extends Hero {

	@Getter private static int defence = 20;
	@Getter private static int hitPoints = 36;
	@Getter private static int attack = 15;

    public Knight(String name) {
        super(name, 1, 0, hitPoints, attack, defence, new Artifact[3]);
		this.generateArtifacts(this);
		this.type = "Knight";
    }

    // TODO -- Artifact array needs to be done. String conversion to Artifact
    public Knight(String name, int experience, int level, int currentHealth, int currentDefence, String weapon, int wbuff, String armour, int aBuff, String helm, int hBuff) {
        super(name, level, Character.calculateExperiencePnts(level), level * hitPoints, level * attack, level * defence, new Artifact[3]);
		this.experiencePnts = experience;
		this.type = "Knight";
        this.hitPnts = currentHealth;
        this.defencePnts = currentDefence;
		this.equipped[WEAPON] = new Weapon(weapon, wbuff);
		this.equipped[HELM] = new Helm(helm, hBuff);
		this.equipped[ARMOUR] = new Armour(armour, aBuff);}
}
