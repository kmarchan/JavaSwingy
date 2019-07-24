package Controller;

import View.GameOver;
import lombok.Getter;
import lombok.Setter;

import static Controller.ApplicationController.END_LOOP;
import static Controller.ApplicationController.SLEEP_TIME;

class GameOverInstructionController {
	@Getter
	@Setter
	private static String Instruction;
	enum instruction {
		exit,
	}

	static void GameOverInstructionParse() {
		System.out.println("You have died!\n[exit] is your only option");
		try {
			GameOver.displayGameOver();
			Instruction = EventDataController.getInstruction();
			while (StateManager.status == END_LOOP) {
				Thread.sleep( SLEEP_TIME);
					if (!Instruction.equals("")) {
						switch (instruction.valueOf(Instruction.toLowerCase())) {
							case exit:
								System.exit(0);
								break;
							default: {
								System.out.println("Invalid instruction:" + Instruction);
							}
						}
						EventDataController.removeInstructions();
					}
					Instruction = EventDataController.getInstruction();
				}
		} catch (IllegalArgumentException | InterruptedException e) {
			System.out.println("Invalid Over Instruction:" + Instruction + "\n[exit] is your only option");
			EventDataController.removeInstructions();
			GameOverInstructionParse();
		}
	}
}

