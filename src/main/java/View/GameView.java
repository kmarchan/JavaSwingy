package View;

import Controller.EventDataController;
import Controller.GameController;
import Controller.GameInstructionController;
import Exception.InputException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends BaseWindow {
	private JPanel gameView;
	private JTextPane gameMap;
	private JButton eastButton;
	private JButton southButton;
	private JButton westButton;
	private JButton northButton;
    private JTextPane heroStats;
    private JTextPane foeStats;
    private JButton saveAndExitButton;

	public GameView() {

        showStats(EventDataController.getHero(), heroStats);

        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("north");
				gameMap.setText(GameController.printMap());
            }
        });
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				GameInstructionController.addInstructions("east");
            }
        });
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("south");
            }
        });
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("west");
            }
        });
        saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gameMap.setText(GameController.printMap());
    }

	static public void displayGameView() throws InputException {
		frame.setContentPane(new GameView().gameView);
		frame.pack();
	}
}
