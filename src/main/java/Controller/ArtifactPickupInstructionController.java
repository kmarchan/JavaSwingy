package Controller;

import Model.Artifacts.Artifact;
import Utils.ArtifactFactory;
import View.ArtifactPickupView;
import lombok.Getter;

import static Controller.ApplicationController.*;

public class ArtifactPickupInstructionController {
	private static String responseInstructions;
	@Getter private static Artifact drop;

	enum response {
		y,
		n,
	}

	static void ArtifactInstructionParse() {
		try {
			drop = ArtifactFactory.createArtifact(EventDataController.getFoe().getLevel());
			ArtifactPickupView.displayArtifactPickupView();
			responseInstructions = EventDataController.getInstruction();
			System.out.println(EventDataController.getFoe().getName() +
					" was killed and has dropped " +
					ArtifactPickupInstructionController.getDrop().getName() +
					" (" + ArtifactPickupInstructionController.getDrop().getClass().getSimpleName() +
					" buff = " + ArtifactPickupInstructionController.getDrop().getBuff() + ")\nWould you like to equip it? [y/n] ");
			while (StateManager.status == ART_LOOP) {
				Thread.sleep( SLEEP_TIME);
					if (!responseInstructions.equals("")) {
						switch (ArtifactPickupInstructionController.response.valueOf(responseInstructions.toLowerCase())) {
							case y:
								EventDataController.getHero().equipArtifact(EventDataController.getHero(), drop);
								StateManager.status = GAME_LOOP;
								break;
							case n:
								StateManager.status = GAME_LOOP;
								break;

							default: {
								System.out.println("Invalid Artifact Instruction:" + responseInstructions);
							}
						}
						EventDataController.removeInstructions();
					}
					responseInstructions = EventDataController.getInstruction();
				}
		} catch (IllegalArgumentException | InterruptedException e) {
			if (!responseInstructions.equals("h") && !responseInstructions.equals("help")) {
				System.out.println("Invalid instruction:" + responseInstructions);
			}
			System.out.println("\nYour options are [y/n]");
			EventDataController.removeInstructions();
			ArtifactInstructionParse();
		}
	}
}
