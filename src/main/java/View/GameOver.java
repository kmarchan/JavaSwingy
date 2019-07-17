package View;

import javax.swing.*;

public class GameOver extends BaseWindow{
	private JPanel gameOver;

	public GameOver() {
	}
	static public void displayGameOver(){
		frame.setContentPane(new GameOver().gameOver);
		frame.pack();
	}

}
