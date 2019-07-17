package Controller;

import Model.Characters.Hero;
import Model.GameModel;
import View.FightView;
import View.GameOver;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static Controller.ApplicationController.ART_LOOP;
import static Controller.ApplicationController.FIGHT_LOOP;

public class FightInstructionController {

		private static List<String> fightInstructions;
		private static boolean isFightProcessed;
		@Getter	@Setter	private static boolean isFightRunning = false;
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
						/* IMPORTANT: remove instruction after use. */
						if (fightInstructions.get(i) != null) {
							isFightProcessed = true;
							switch (FightInstructionController.Instructions.valueOf(fightInstructions.get(i).toLowerCase())) {
								case fight: {
									GameController.attack(EventDataController.getHero(), EventDataController.getFoe());
									if (!checkForDeath()); {

										GameController.attack(EventDataController.getFoe(), EventDataController.getHero());}
								break;
								}
								case run:
									GameController.run();
									break;
								default: {
									System.out.println("Invalid instruction:" + fightInstructions.get(i));
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
		if (EventDataController.getHero().getHitPnts() == 0)
		{
			setFightRunning(false);
			StateManager.setGame(false);
			GameOver.displayGameOver();
			return true;
		}
		else if (EventDataController.getFoe().getHitPnts() <= 0)
		{
			fightWon();
			searchForDrop();
			return true;
		}
		return false;
	}

	private static void searchForDrop() {
		ArtifactPickupInstructionController.setArtifactView(true);
		ApplicationController.status = ART_LOOP;
	}

	private static void fightWon() {
		GameModel.removeFoe(EventDataController.getHero());

		Hero.gainExperience(EventDataController.getHero(), EventDataController.getFoe().getLevel() * 20);
		setFightRunning(false);
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
