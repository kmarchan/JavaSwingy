package View;

import Controller.EventDataController;
import Controller.GameController;
import Exception.InputException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends BaseWindow {
	private JPanel gameView;
	private JTextPane gameMap;
	private JButton rightButton;
	private JButton backwardButton;
	private JButton leftButton;
	private JButton forwardButton;
    private JTextPane heroStats;
    private JTextPane foeStats;
    private JButton saveAndExitButton;

	public GameView() {

        showStats(EventDataController.getHero(), heroStats);

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
