package Utils;

import Model.Artifacts.Armour;
import Model.Artifacts.Artifact;
import Model.Artifacts.Helm;
import Model.Artifacts.Weapon;

import java.util.Random;

public class ArtifactFactory {

	public static Artifact createArtifact(int foeLevel) {
		int rn = new Random().nextInt();
		switch (rn %  3) {
			case 0:
				return new Weapon(foeLevel * 10 );
			case 1:
				return new Armour(foeLevel * 10);
			default:
				return new Helm(foeLevel * 10);
		}
	}
}
