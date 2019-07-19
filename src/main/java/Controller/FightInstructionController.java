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
	private static boolean isFightProcessed;
	@Getter @Setter private static List<String> fightCommentary;

	enum Instructions {
		fight,
		run,
	}

	public static void fightInstructionParse() {
		int instructionIndex = 0;
		setFightCommentary(new ArrayList<>());
		try {
			FightView.displayFightView();
			fightInstructions = EventDataController.getInstructions();
			while (ApplicationController.status == FIGHT_LOOP) {
				for (int i = 0; i < fightInstructions.size(); i++) {
					instructionIndex = i;
					if (fightInstructions.get(i) != null) {
						isFightProcessed = true;
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
						if (fightInstructions.size() != 0) {
							removeFightInstructions(fightInstructions.get(i));
						}
					}
				}
				fightInstructions = EventDataController.getInstructions();
				checkForDeath();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid instruction:" + fightInstructions.get(instructionIndex));
			removeFightInstructions(fightInstructions.get(instructionIndex));
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
			ApplicationController.status = END_LOOP;
		}
		return false;
	}

	private static void searchForDrop() {
		if (new Random().nextInt() % 2 == 0) {
			ArtifactPickupInstructionController.setArtifactView(true);
			ApplicationController.status = ART_LOOP;
		}
		else ApplicationController.status = GAME_LOOP;
	}

	private static void fightWon() {
		GameModel.removeFoe(EventDataController.getHero());
		Hero.gainExperience(EventDataController.getHero(), EventDataController.getFoe().getLevel() * 20);
	}

	public static void addInstructions(String input) {
			isFightProcessed = false;
			fightInstructions.add(input);
	}

	public static void removeFightInstructions(String input) {
		if (isFightProcessed) {
			fightInstructions.remove(input);
			isFightProcessed = false;
		} else {
			fightInstructionParse();
			if (fightInstructions.size() != 0) {
				removeFightInstructions(input);
			}
		}
	}
}
