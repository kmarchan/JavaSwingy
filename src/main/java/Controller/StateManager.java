package Controller;

import Exception.InputException;
import static Controller.ApplicationController.*;

public class StateManager {
	public static int status;

	public static void stateManager() throws InputException {
		while(true) {
			if (status == GAME_LOOP) {
				GameInstructionController.gameInstructionParse();
			} else if (status == MENU_LOOP) {
				MenuInstructionController.instructionParse();
			} else if (status == LOAD_LOOP) {
				LoadInstructionController.loadInstructionParse();
			} else if (status == CREATE_LOOP) {
				CreateInstructionController.createInstructionParse();
			} else if (status == FIGHT_LOOP) {
				FightInstructionController.fightInstructionParse();
			} else 	if (status == ART_LOOP) {
				ArtifactPickupInstructionController.ArtifactInstructionParse();
			} else if (status == END_LOOP) {
				GameOverInstructionController.GameOverInstructionParse();
			}
		}
	}
}
