package View;

import javax.swing.*;
import Exception.InputException;

public class GameView extends BaseWindow {
	private JPanel gameView;
	private JTextPane gameMap;
	private JButton rightButton;
	private JButton backwardButton;
	private JButton leftButton;
	private JButton forwardButton;

	static public void displayLoadHero() throws InputException {
		frame.setContentPane(new GameView().gameView);
		frame.pack();
	}
}
