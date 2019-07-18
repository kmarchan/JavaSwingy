package View;

import Controller.GameOverInstructionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends BaseWindow{
	private JPanel gameOver;
	private JButton exitButton;

	public GameOver() {
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				GameOverInstructionController.addEndInstructions("exit");
			}
		});
	}
	static public void displayGameOver(){
		frame.setContentPane(new GameOver().gameOver);
		frame.pack();
	}

}
