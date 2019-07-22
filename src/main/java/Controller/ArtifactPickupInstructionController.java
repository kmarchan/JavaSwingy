package Controller;

import Model.Artifacts.Artifact;
import Utils.ArtifactFactory;
import View.ArtifactPickupView;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static Controller.ApplicationController.ART_LOOP;
import static Controller.ApplicationController.GAME_LOOP;

public class ArtifactPickupInstructionController {
	private static List<String> responseInstructions;
	@Getter	@Setter private static boolean artifactView = false;
	@Getter private static Artifact drop;

	enum response {
		y,
		n,
	}

	static void ArtifactInstructionParse() {
		int instructionIndex = 0;
		try {

			drop = ArtifactFactory.createArtifact(EventDataController.getFoe().getLevel());
			ArtifactPickupView.displayArtifactPickupView();
			responseInstructions = EventDataController.getInstructions();
			System.out.println(EventDataController.getFoe().getName() +
					" was killed and has dropped " +
					ArtifactPickupInstructionController.getDrop().getName() +
					" (" + ArtifactPickupInstructionController.getDrop().getClass().getSimpleName() +
					" buff = " + ArtifactPickupInstructionController.getDrop().getBuff() + ")\nWould you like to equip it? [y/n] ");
			while (StateManager.status == ART_LOOP) {
				for (int i = 0; i < responseInstructions.size(); i++) {
					instructionIndex = i;
					if (responseInstructions.get(i) != null) {
						switch (ArtifactPickupInstructionController.response.valueOf(responseInstructions.get(i).toLowerCase())) {
							case y:
								EventDataController.getHero().equipArtifact(EventDataController.getHero(), drop);
								setArtifactView(false);
								StateManager.status = GAME_LOOP;
								break;
							case n:
								setArtifactView(false);
								StateManager.status = GAME_LOOP;
								break;

							default: {
								System.out.println("Invalid Artifact Instruction:" + responseInstructions.get(i));
							}
						}
						EventDataController.removeInstructions(responseInstructions.get(i));
					}
				}
				responseInstructions = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + responseInstructions.get(instructionIndex) + "\nYour options are [y/n]");
			EventDataController.removeInstructions(responseInstructions.get(instructionIndex));
			ArtifactInstructionParse();
		}
	}
}
