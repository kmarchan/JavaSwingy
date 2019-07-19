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

	public static void ArtifactInstructionParse() {
		int instructionIndex = 0;
		try {
			drop = ArtifactFactory.createArtifact(EventDataController.getFoe().getLevel());
			ArtifactPickupView.displayArtifactPickupView();
			responseInstructions = EventDataController.getInstructions();
			while (ApplicationController.status == ART_LOOP) {
				for (int i = 0; i < responseInstructions.size(); i++) {
					instructionIndex = i;
					if (responseInstructions.get(i) != null) {
						switch (ArtifactPickupInstructionController.response.valueOf(responseInstructions.get(i).toLowerCase())) {
							case y:
								EventDataController.getHero().equipArtifact(EventDataController.getHero(), drop);
								setArtifactView(false);
								ApplicationController.status = GAME_LOOP;
								break;
							case n:
								setArtifactView(false);
								ApplicationController.status = GAME_LOOP;
								break;

							default: {
								System.out.println("Invalid Artifact Instruction:" + responseInstructions.get(i));
							}
						}
						removeResponseInstructions(responseInstructions.get(i));
					}
				}
				responseInstructions = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + responseInstructions.get(instructionIndex));
			removeResponseInstructions(responseInstructions.get(instructionIndex));
			ArtifactInstructionParse();
		}
	}

	public static void addResponseInstructions(String input) {
		responseInstructions.add(input);
	}

	public static void removeResponseInstructions(String input) {
		responseInstructions.remove(input);
	}

}
