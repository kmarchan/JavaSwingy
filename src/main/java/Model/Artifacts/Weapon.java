package Model.Artifacts;

import java.util.Random;

public class Weapon extends Artifact {

	private static String[] weapon  = new String[]{ "a Twig", "a Pebble", "a Stone", "a Stone on a Stick", "a Makeshift Axe", "a Butter Knife", "a Spear", "a Bastard Sword", "a Longsword", "a Dragon Bone Staff" };

	public Weapon(int abilityBuff) {
		super(weapon[new Random().nextInt(9)], abilityBuff);
	}

	public Weapon() {
		super(weapon[0], 0);
	}

	public Weapon(String weapon, int abilityBuff) {
		super(weapon, abilityBuff);
	}
}
