package Model.Characters;

import Model.Artifacts.Artifact;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import static Model.Artifacts.Artifact.*;
import static Model.Artifacts.Artifact.HELM;

@Setter
@Getter
@NotNull
public class Character {
    protected String name;
    protected String type;
	protected int level;
	protected int attackPnts;
	protected int defencePnts;
	protected int hitPnts;
	protected int experiencePnts;
	protected int baseHitPnts;
	protected int baseAttackPnts;
	protected int baseDefencePnts;
	protected int baseExperiencePnts;
	protected Artifact[] equipped = new Artifact[3];

	public Character() {
		this.name = "undefined";
		this.level = 0;
		this.attackPnts = 0;
		this.defencePnts = 0;
		this.hitPnts = 0;
		this.experiencePnts = 0;
		this.equipped = null;
	}

	public Character(String name, int level, int experiencePnts, int baseHitPnts, int baseAttackPnts, int baseDefencePnts, Artifact[] equipped) {
		this.name = cleanNameInput(name);
		this.level = level;
		this.baseAttackPnts = baseAttackPnts;
		attackPnts = baseAttackPnts;
		if (equipped[WEAPON] != null)
			attackPnts += equipped[WEAPON].getBuff();

		this.baseDefencePnts = baseDefencePnts;
		defencePnts = baseDefencePnts;
		if (equipped[ARMOUR] != null)
			defencePnts += equipped[ARMOUR].getBuff();

		this.baseHitPnts = baseHitPnts;
		hitPnts = baseHitPnts;
		if (equipped[HELM] != null)
			hitPnts += equipped[HELM].getBuff();

//		this.experiencePnts -= baseExperiencePnts;
		// Todo -- make sure you didnt brake anything commenting out above line
		this.experiencePnts = experiencePnts;
		baseExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
		this.equipped = equipped;
	}

	public void attack(){}

	public void defend(){}

	public void takeDamage(){}

	public void gainHitPnts(){}

	public static int calculateExperiencePnts(int level) {
		return level * 1000 + (int)Math.pow(level - 1, 2) * 450;
	}

	private String cleanNameInput(String input) {
		return input.replaceAll(",", "");
	}
}
