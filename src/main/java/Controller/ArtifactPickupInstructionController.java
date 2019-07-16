package Controller;

import View.ArtifactPickupView;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ArtifactPickupInstructionController {
	private static List<String> responseInstructions;
	private static boolean isProcessed;
	@Getter	@Setter private static boolean artifactView = false;

	enum response {
		y,
		n,
	}

	public static void ArtifactInstructionParse() {
		int instructionIndex = 0;
		try {
			responseInstructions = EventDataController.getInstructions();
			while (artifactView) {
				for (int i = 0; i < responseInstructions.size(); i++) {
					instructionIndex = i;
					/* IMPORTANT: remove instruction after use. */
					if (responseInstructions.get(i) != null) {
						isProcessed = true;
						switch (ArtifactPickupInstructionController.response.valueOf(responseInstructions.get(i).toLowerCase())) {
							case y: {
								System.out.println("yes");;
								break;
							}
							case n:
								System.out.println("no");
								break;
							default: {
								System.out.println("Invalid instruction:" + responseInstructions.get(i));
							}
						}
						ArtifactPickupView.displayArtifactPickupView();
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
		isProcessed = false;
		responseInstructions.add(input);
	}

	public static void removeResponseInstructions(String input) {
		if (isProcessed) {
			responseInstructions.remove(input);
			isProcessed = false;
		} else {
			ArtifactInstructionParse();
			if (responseInstructions.size() != 0) {
				removeResponseInstructions(input);
			}
		}
	}
}
