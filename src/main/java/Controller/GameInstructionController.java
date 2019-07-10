package Controller;

import Model.GameModel;
import View.BaseWindow;

import java.util.List;

public class GameInstructionController {
	private static List<String> gameInstructions;

	enum Instruction {
		north,
		east,
		west,
		south,
		exit,
		gui,
	}
	public static void gameInstructionParse() {
		int instructionIndex = 0;
		try {
			gameInstructions = EventDataController.getOutput();

			while(EventDataController.getIsRunning()) {
				for (int i=0; i < gameInstructions.size(); i++) {
					instructionIndex = i;
					/* IMPORTANT: remove instruction after use. */
					if (gameInstructions.get(i) != null) {
						EventDataController.setIsProcessed(true);
						switch (Instruction.valueOf(gameInstructions.get(i).toLowerCase())) {
							case exit: {
								EventDataController.setIsRunning(false);
								System.out.println("killing program");
								ApplicationController.closeApplication();
								break;
							}
							case gui:
								BaseWindow.showBaseWindow();
								break;
							case south:
								break;
							case north:
								GameModel.moveNorth(EventDataController.getHero());
								break;
							case west:
								break;
							case east:
								break;
							default: {
								System.out.println("Invalid instruction:" + gameInstructions.get(i));
							}
						}
					}
					EventDataController.removeInstructions(gameInstructions.get(i));
				}
				gameInstructions = EventDataController.getOutput();
			}
		} catch (IllegalArgumentException e){
			System.out.println("Invalid instruction:"+gameInstructions.get(instructionIndex));
			EventDataController.removeInstructions(gameInstructions.get(instructionIndex));
			gameInstructionParse();
		}
	}
	public static void addInstructions(String input) {
		gameInstructions.add(input);
	}}
