package Controller;

import View.ArtifactPickupView;

import java.util.List;

import static Controller.ApplicationController.*;

public class GameOverInstructionController {
	private static List<String> Instruction;
	enum instruction {
		exit,
	}

	public static void GameOverInstructionParse() {
		int instructionIndex = 0;
		try {
			ArtifactPickupView.displayArtifactPickupView();
			Instruction = EventDataController.getInstructions();
			while (ApplicationController.status == ART_LOOP) {
				for (int i = 0; i < Instruction.size(); i++) {
					instructionIndex = i;
					if (Instruction.get(i) != null) {
						switch (instruction.valueOf(Instruction.get(i).toLowerCase())) {
							case exit:
								ApplicationController.status = END_LOOP;
								break;
							default: {
								System.out.println("Invalid instruction:" + Instruction.get(i));
							}
						}
						removeEndInstructions(Instruction.get(i));
					}
				}
				Instruction = EventDataController.getInstructions();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + Instruction.get(instructionIndex));
			removeEndInstructions(Instruction.get(instructionIndex));
			GameOverInstructionParse();
		}
	}

	public static void addEndInstructions(String input) {
		Instruction.add(input);
	}

	public static void removeEndInstructions(String input) {
		Instruction.remove(input);
	}
}

