package View;

import Controller.EventDataController;
import Controller.GameController;

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
        foeStats.setText("No foe in sight yet");
		gameMap.setText(GameController.generateRound());

		northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("north");
			}
        });
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("east");
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

		saveAndExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				EventDataController.addInstructions("exit");
			}
		});
	}


	static public void displayGameView() {
		frame.setContentPane(new GameView().gameView);
		frame.pack();
	}
}
