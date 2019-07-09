package Model.Characters;

import Model.Artifacts.Artifact;
import Model.Artifacts.Item;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
	protected int maxHitPnts;
	protected int maxAttackPnts;
	protected int maxDefencePnts;
	protected int maxExperiencePnts;
	protected List<Item> backpack = new ArrayList<Item>();
	protected Artifact[] equipped = new Artifact[3];

	public Character() {
		this.name = "undefined";
		this.level = 0;
		this.attackPnts = 0;
		this.defencePnts = 0;
		this.hitPnts = 0;
		this.experiencePnts = 0;
		this.backpack = null;
		this.equipped = null;
	}

	public Character(String name, int level, int experiencePnts, int maxHitPnts, int maxAttackPnts, int maxDefencePnts, List<Item> backpack, Artifact[] equipped) {
		this.name = name;
		this.level = level;

		this.maxAttackPnts = maxAttackPnts;
		attackPnts = maxAttackPnts;
		if (equipped[WEAPON] != null)
			attackPnts += equipped[WEAPON].getBuff();

		this.maxDefencePnts = maxDefencePnts;
		defencePnts = maxDefencePnts;
		if (equipped[ARMOUR] != null)
			defencePnts += equipped[ARMOUR].getBuff();

		this.maxHitPnts = maxHitPnts;
		hitPnts = maxHitPnts;
		if (equipped[HELM] != null)
			hitPnts += equipped[HELM].getBuff();

		this.experiencePnts -= maxExperiencePnts;
		maxExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
		this.backpack = backpack;
		this.equipped = equipped;
	}

	public void attack(){}

	public void defend(){}

	public void takeDamage(){}

	public void gainHitPnts(){}


}
