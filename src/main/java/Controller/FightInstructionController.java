package Controller;

import Model.Characters.Hero;
import Model.GameModel;
import View.FightView;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Controller.ApplicationController.*;

public class FightInstructionController {

	private static List<String> fightInstructions;
	@Getter @Setter private static List<String> fightCommentary;

	enum Instructions {
		fight,
		run,
	}

	static void fightInstructionParse() {
		int instructionIndex = 0;
		System.out.println("You have encountered: " + EventDataController.getFoe().getName() + "\nWill you: [fight] or [run?] \n");
		setFightCommentary(new ArrayList<>());
		try {
			FightView.displayFightView();
			fightInstructions = EventDataController.getInstructions();
			while (StateManager.status == FIGHT_LOOP) {
				for (int i = 0; i < fightInstructions.size(); i++) {
					instructionIndex = i;
					if (fightInstructions.get(i) != null) {
						switch (FightInstructionController.Instructions.valueOf(fightInstructions.get(i).toLowerCase())) {
							case fight: {
								GameController.attack(EventDataController.getHero(), EventDataController.getFoe());
								if (!checkForDeath()) {
									GameController.attack(EventDataController.getFoe(), EventDataController.getHero());
								}
								break;
							}
							case run:
								GameController.run();
								break;
							default: {
								System.out.println("Invalid Fight Instruction:" + fightInstructions.get(i));
							}
						}
						FightView.displayFightView();
						if (fightCommentary.size() > 0)
						{
							System.out.println("Fight Log:");
							for(int e = fightCommentary.size() - 2; e < fightCommentary.size(); e++) {
								System.out.println(fightCommentary.get(e));
							}
						}
						if (fightInstructions.size() != 0) {
							EventDataController.removeInstructions(fightInstructions.get(i));
						}
					}
				}
				fightInstructions = EventDataController.getInstructions();
				checkForDeath();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + fightInstructions.get(instructionIndex) + "\nYour options are [fight/run]");
			EventDataController.removeInstructions(fightInstructions.get(instructionIndex));
			fightInstructionParse();
		}
	}

	private static boolean checkForDeath() {
		if (EventDataController.getFoe().getHitPnts() <= 0)
		{
			fightWon();
			searchForDrop();
			return true;
		}
		else if (EventDataController.getHero().getHitPnts() <= 0)
		{
			StateManager.status = END_LOOP;
		}
		return false;
	}

	private static void searchForDrop() {
		if (new Random().nextInt() % 2 == 0) {
			ArtifactPickupInstructionController.setArtifactView(true);
			StateManager.status = ART_LOOP;
		}
		else StateManager.status = GAME_LOOP;
	}

	private static void fightWon() {
		GameModel.removeFoe(EventDataController.getHero());
		Hero.gainExperience(EventDataController.getHero(), EventDataController.getFoe().getLevel() * 20);
	}
}
