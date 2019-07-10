package Model.Artifacts;

public class Weapon extends Artifact {

	enum weapon {
		twig,
		pebble,
		stone,
		stoneonastick,
		makeshiftaxe,
		butterknife,
		spear,
		bastardsword,
		longsword,
		bragonbonestaff,
	}

	public Weapon(int abilityBuff) {
		super(abilityBuff);
	}
}
