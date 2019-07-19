package Controller;

import View.GameOver;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static Controller.ApplicationController.END_LOOP;

public class GameOverInstructionController {
	@Getter
	@Setter
	private static List<String> Instruction;
	enum instruction {
		exit,
	}

	public static void GameOverInstructionParse() {
		int instructionIndex = 0;
		try {
			GameOver.displayGameOver();
			Instruction = EventDataController.getInstructions();
			while (ApplicationController.status == END_LOOP) {
				for (int i = 0; i < Instruction.size(); i++) {
					instructionIndex = i;
					if (Instruction.get(i) != null) {
						switch (instruction.valueOf(Instruction.get(i).toLowerCase())) {
							case exit:
								StateManager.setGame(false);
								System.exit(0);
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
			System.out.println("Invalid Over Instruction:" + Instruction.get(instructionIndex));
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

