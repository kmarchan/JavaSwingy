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

	private static String fightInstructions;
	@Getter @Setter private static List<String> fightCommentary;

	enum Instructions {
		fight,
		run,
	}

	static void fightInstructionParse() {
		System.out.println("You have encountered: " + EventDataController.getFoe().getName() + "\nWill you: [fight] or [run?] \n");
		setFightCommentary(new ArrayList<>());
		try {
			FightView.displayFightView();
			fightInstructions = EventDataController.getInstruction();
			while (StateManager.status == FIGHT_LOOP) {
				Thread.sleep( SLEEP_TIME);
					if (!fightInstructions.equals("")) {
						switch (Instructions.valueOf(fightInstructions.toLowerCase())) {
							case fight: {
								GameController.attack(EventDataController.getHero(), EventDataController.getFoe());
								if (!checkForDeath()) {
									GameController.attack(EventDataController.getFoe(), EventDataController.getHero());
								}
								EventDataController.removeInstructions();
								break;
							}
							case run:
								GameController.run();
								EventDataController.removeInstructions();
								break;
							default:
								System.out.println("Invalid Fight Instruction:" + fightInstructions);
								EventDataController.removeInstructions();
								break;
						}
						FightView.displayFightView();
					}
				fightInstructions = EventDataController.getInstruction();
				checkForDeath();
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			if (!fightInstructions.equals("h") && !fightInstructions.equals("help")) {
				System.out.println("Invalid instruction:" + fightInstructions);
			}
			EventDataController.removeInstructions();
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
			StateManager.status = ART_LOOP;
		}
		else StateManager.status = GAME_LOOP;
	}

	private static void fightWon() {
		Hero.gainExperience(EventDataController.getHero(), EventDataController.getFoe().getLevel() * 20);
		GameModel.removeFoe(EventDataController.getHero());
	}
}
