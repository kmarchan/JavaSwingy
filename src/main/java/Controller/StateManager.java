package Controller;

import lombok.Getter;
import lombok.Setter;

import static Controller.ApplicationController.*;

public class StateManager {
	public static int status;

	@Setter	@Getter private static boolean game = true;

	public static void stateManager(){
		while(game) {
			System.out.println(status);
			if (status == GAME_LOOP) {
				System.out.println(status);

				GameInstructionController.gameInstructionParse();
			} else if (status == MENU_LOOP) {
				System.out.println(status);
				MenuInstructionController.instructionParse();

			} else if (status == LOAD_LOOP) {
				System.out.println(status);

				LoadInstructionController.loadInstructionParse();

			} else if (status == CREATE_LOOP) {
				System.out.println(status);

				CreateInstructionController.createInstructionParse();
			}else if (status == FIGHT_LOOP) {
				System.out.println(status);

				FightInstructionController.fightInstructionParse();
			} else 	if (status == ART_LOOP) {
				System.out.println(status);

				ArtifactPickupInstructionController.ArtifactInstructionParse();
			} else if (status == END_LOOP) {
				System.out.println(status);

				GameOverInstructionController.GameOverInstructionParse();
			}

		}
		System.out.println("end of parsing");
	}
}
