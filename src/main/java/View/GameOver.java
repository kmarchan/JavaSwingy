package View;

import Controller.EventDataController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends BaseWindow{
	private JPanel gameOver;
	private JButton exitButton;

	public GameOver() {
		System.out.println("\nYou Have Died!\n[exit] is your only option.");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				EventDataController.addInstructions("exit");
			}
		});
	}
	static public void displayGameOver(){
		frame.setContentPane(new GameOver().gameOver);
		frame.pack();
	}
}
