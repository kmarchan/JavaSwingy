package Controller;

import static Controller.ApplicationController.*;

public class StateManager {

	public static void stateManager(){

		while(true) {
			if (ApplicationController.status == MENU_LOOP) {
				MenuInstructionController.instructionParse();
			} else if (ApplicationController.status == GAME_LOOP) {
				GameInstructionController.gameInstructionParse();
			} else if (ApplicationController.status == FIGHT_LOOP) {
				FightInstructionController.fightInstructionParse();
			} else 	if (ApplicationController.status == ART_LOOP) {
				ArtifactPickupInstructionController.ArtifactInstructionParse();
			}
		}
	}
}
