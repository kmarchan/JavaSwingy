package Views;

import GameLogic.EventData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends BaseWindow{
	private JButton button1;
	private JPanel panel1;
	private JButton printButton;
	private JButton validButton;
	private JButton exitButton;


	public MainMenu() {
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EventData.addInstructions("this was a button click");
			}
		});
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventData.addInstructions("print");
			}
		});
		validButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EventData.addInstructions("test");
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EventData.addInstructions("exit");
			}
		});
	}

	static public void displayMainMenu(){


		frame.setContentPane(new MainMenu().panel1);
		frame.pack();
	}

}
