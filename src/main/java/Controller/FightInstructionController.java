package Controller;

import View.ArtifactPickupView;
import View.FightView;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FightInstructionController {

		private static List<String> fightInstructions;
		private static boolean isProcessed;
		@Getter
		@Setter
		private static boolean isFightRunning = false;

		enum Instructions {
			fight,
			run,
		}

		public static void fightInstructionParse() {
			int instructionIndex = 0;
			try {
				fightInstructions = EventDataController.getInstructions();
				while (isFightRunning) {
					for (int i = 0; i < fightInstructions.size(); i++) {
						instructionIndex = i;
						/* IMPORTANT: remove instruction after use. */
						if (fightInstructions.get(i) != null) {
							isProcessed = true;
							switch (FightInstructionController.Instructions.valueOf(fightInstructions.get(i).toLowerCase())) {
								case fight: {
									System.out.println("fight");
									GameController.attack(EventDataController.getHero(), EventDataController.getFoe());
									GameController.attack(EventDataController.getFoe(), EventDataController.getHero());
									break;
								}
								case run:
									System.out.println("run");
									GameController.run();
									break;
								default: {
									System.out.println("Invalid instruction:" + fightInstructions.get(i));
								}
							}
							FightView.displayFightView();
							removeFightInstructions(fightInstructions.get(i));
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

	private static void checkForDeath() {
		if (EventDataController.getHero().getHitPnts() == 0)
		{
			setFightRunning(false);
			System.out.println("Game Over");
		}
		if (EventDataController.getFoe().getHitPnts() <= 0)
		{
			setFightRunning(false);
			ArtifactPickupInstructionController.setArtifactView(true);
			ArtifactPickupInstructionController.ArtifactInstructionParse();
			ArtifactPickupView.displayArtifactPickupView();
		}
	}

	public static void addInstructions(String input) {
			isProcessed = false;
			fightInstructions.add(input);
		}

		public static void removeFightInstructions(String input) {
			if (isProcessed) {
				fightInstructions.remove(input);
				isProcessed = false;
			} else {
				fightInstructionParse();
				if (fightInstructions.size() != 0) {
					removeFightInstructions(input);
				}
			}
		}
	}
