package Model.Artifacts;

public class Armour extends Artifact {
	enum armour {
		loincloth,
		oldsack,
		melonskinsrmour,
		leatherarmour,
		woodenarmour,
		chainmail,
		steelarmour,
		dragonscalearmour,
	}

	public Armour(int abilityBuff) {
		super(abilityBuff);
	}
}
