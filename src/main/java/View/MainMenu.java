package View;

import Controller.EventDataController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends BaseWindow{
	private JButton newGameButton;
	private JPanel panel1;
	private JButton controlsButton;
	private JButton loadGameButton;
	private JButton exitButton;


	public MainMenu() {
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EventDataController.addInstructions("newgame");
			}
		});
		controlsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("controls");
			}
		});
		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EventDataController.addInstructions("loadgame");
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EventDataController.addInstructions("exit");
			}
		});
	}

	static public void displayMainMenu(){
		frame.setContentPane(new MainMenu().panel1);
		frame.pack();
	}
}