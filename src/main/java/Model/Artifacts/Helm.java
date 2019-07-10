package Model.Artifacts;

public class Helm extends Artifact{

	enum helm {
		oldboot,
		toupe,
		bucket,
		judicialwig,
		tophat,
		scrumcap,
		helmet,
		drangonbonehelmet,
	}

	public Helm(int abilityBuff) {
		super(abilityBuff);
	}
}
