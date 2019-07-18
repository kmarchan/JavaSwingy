package Model.Artifacts;

import java.util.Random;

public class Helm extends Artifact{

	private static String[] helm  = new String[]{ "an Old Boot", " a Toupe", "a Bucket", "a Judicial Wig", "a Top hat", "a Scrum cap", "a Helmet", "a Dragon Bone Helmet" };

	public Helm(int abilityBuff) {
		super(helm[new Random().nextInt(7)], abilityBuff);
	}

	public Helm() {
		super(helm[0], 0);
	}

	public Helm(String helm, int abilityBuff) {
		super(helm, abilityBuff);
	}
}
