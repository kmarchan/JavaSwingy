package Model.Artifacts;

import java.util.Random;

public class Armour extends Artifact {
	private static String[] armour = new String[]{"a Loincloth", "an Old Sack", "Melon Skin Armour", "Leather Armour", "Wooden Armour", "Chain Mail", "Steel Armour", "Dragon Scale Armour"};

	public Armour(int abilityBuff) {
		super(armour[new Random().nextInt(7)], abilityBuff);
	}

}
