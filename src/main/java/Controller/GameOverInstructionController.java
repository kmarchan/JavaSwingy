package Controller;

import View.GameOver;
import lombok.Getter;
import lombok.Setter;

import static Controller.ApplicationController.END_LOOP;

public class GameOverInstructionController {
	@Getter
	@Setter
	private static String Instruction;
	enum instruction {
		exit,
	}

	static void GameOverInstructionParse() {
		try {
			GameOver.displayGameOver();
			Instruction = EventDataController.getInstruction();
			while (StateManager.status == END_LOOP) {
					if (Instruction != null) {
						switch (instruction.valueOf(Instruction.toLowerCase())) {
							case exit:
								System.exit(0);
								break;
							default: {
								System.out.println("Invalid instruction:" + Instruction);
							}
						}
						EventDataController.removeInstructions(Instruction);
					}
				}
				Instruction = EventDataController.getInstruction();
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Over Instruction:" + Instruction + "\n[exit] is your only option");
			EventDataController.removeInstructions(Instruction);
			GameOverInstructionParse();
		}
	}
}

