package Model.Characters;

import Model.Artifacts.Artifact;

import java.util.Random;

public class Foe extends Character {
	private static int hitPoints = 8;
	private static int attack = 7;
	private static int defence = 8;
	private static int foeLevel;
	private static String [] foeName = { "Billy the Bad", "Stan of Sternness", "Frightening Freddie", "Malicious Mike", "Salivating Steve", "Tyrone the Tyrant", "Melvin the Moody", "Antagonizing Antony"};

	public Foe(int level) {
		super(foeName[new Random().nextInt(7)], generateFoeLevel(level), 0, foeLevel *hitPoints, foeLevel * attack, foeLevel * defence, new Artifact[3]);
		this.type = "Monster";
	}

	private static int generateFoeLevel(int level) {
		int rn = new Random().nextInt(3);
		int[] levelRange = {level <= 1 ? 1 : level -1, level, level +1};
		foeLevel = levelRange[rn];
		return foeLevel;
	}
}
