package View;

import javax.swing.*;

import Controller.EventData;
import Exception.InputException;
import Model.Characters.Hero;

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

        showStats(EventData.getHero(), heroStats);

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
    }
    static public void displayGameView() throws InputException {
		frame.setContentPane(new GameView().gameView);
		frame.pack();
	}
}
