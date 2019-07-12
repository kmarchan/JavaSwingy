package View;

import Controller.EventDataController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightView extends BaseWindow {
	private JPanel fightView;
	private JTextPane foeStats;
	private JTextPane fightBox;
	private JTextPane heroStats;
	private JButton fightButton;
	private JButton runButton;

	public FightView() {
		showStats(EventDataController.getHero(), heroStats);


		fightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	static public void displayFightView() {
		frame.setContentPane(new FightView().fightView);
		frame.pack();
	}
}
