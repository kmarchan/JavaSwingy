package View;

import Controller.EventDataController;
import Controller.FightInstructionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightView extends BaseWindow {
	private JPanel fightView;
	private JTextPane foeStats;
	private JTextPane fightBox;
	private JTextPane heroStats;
	private JButton runButton;
	private JButton fightButton;

	public FightView() {
		showStats(EventDataController.getHero(), heroStats);
		showFoeStats(EventDataController.getFoe(), foeStats);

		runButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FightInstructionController.addInstructions("fight");
			}

		});
		runButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				FightInstructionController.addInstructions("run");
			}
		});
	}

	static public void displayFightView() {
		frame.setContentPane(new FightView().fightView);
		frame.pack();
	}
}
