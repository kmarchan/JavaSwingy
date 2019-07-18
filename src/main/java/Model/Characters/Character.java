package Model.Characters;

import Model.Artifacts.Armour;
import Model.Artifacts.Artifact;
import Model.Artifacts.Helm;
import Model.Artifacts.Weapon;
import lombok.Getter;
import lombok.Setter;

import static Model.Artifacts.Artifact.*;

@Setter @Getter public class Character {
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
	protected int row;
	protected int column;
	protected int[] previousPosition;
	protected Artifact[] equipped = new Artifact[3];

	public Character() {
		this.name = "undefined";
		this.level = 1;
		this.attackPnts = 0;
		this.defencePnts = 0;
		this.hitPnts = 0;
		this.experiencePnts = 0;
		this.column = 0;
		this.row = 0;
		this.previousPosition = new int[]{0, 0};
	}

	public Character(String name, int level, int experiencePnts, int baseHitPnts, int baseAttackPnts, int baseDefencePnts, Artifact[] equipped) {
		int center = ((level-1)*5+10-(level%2)) / 2;
		this.name = cleanNameInput(name);
		this.level = level;

		this.baseAttackPnts = baseAttackPnts;
		attackPnts = baseAttackPnts;
		if (equipped[WEAPON] != null) {
			attackPnts += equipped[WEAPON].getBuff();
			this.baseAttackPnts = baseAttackPnts; }

		this.baseDefencePnts = baseDefencePnts;
		defencePnts = baseDefencePnts;
		if (equipped[ARMOUR] != null) {
			defencePnts += equipped[ARMOUR].getBuff();
			this.baseDefencePnts = baseDefencePnts;}

		this.baseHitPnts = baseHitPnts;
		hitPnts = baseHitPnts;
		if (equipped[HELM] != null) {
			hitPnts += equipped[HELM].getBuff();
			this.baseHitPnts = baseHitPnts;}

		this.experiencePnts = experiencePnts;
		baseExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
		this.equipped = equipped;

		this.column = center;
		this.row = center;
		this.previousPosition = new int[]{center, center};
	}

	protected void generateArtifacts(Character character) {
		character.equipped[WEAPON] = new Weapon();
		character.equipped[HELM] = new Helm();
		character.equipped[ARMOUR] = new Armour();
	}

	public void takeDamage(Character victim, int damage){
		if (damage >= 0) {
			if (victim.hitPnts > damage) {
				victim.hitPnts -= damage;
			} else {
				victim.hitPnts = 0;
			}
		}
	}

	public static int calculateExperiencePnts(int level) {
		return level * 1000 + (int)Math.pow(level - 1, 2) * 450;
	}

	private String cleanNameInput(String input) {
		return input.replaceAll(",", "");
	}
}
