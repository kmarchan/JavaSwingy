package View;

import Controller.EventDataController;
import Controller.FightInstructionController;
import Controller.GameController;

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
		fightBox.setText("		You have encountered\n		" + EventDataController.getFoe().getName() + "\n		Will you fight or run? \n" + GameController.setFightText());
		fightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { FightInstructionController.addInstructions("fight");
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
