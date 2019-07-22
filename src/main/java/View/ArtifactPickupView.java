package View;

import Controller.ArtifactPickupInstructionController;
import Controller.EventDataController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArtifactPickupView extends BaseWindow{
	private JLabel artifactMessage;
	private JButton yesButton;
	private JButton noButton;
	private JPanel artifactView;
	private JTextPane heroStats;

	private ArtifactPickupView() {
		artifactMessage.setText(EventDataController.getFoe().getName() +
				" was killed and has dropped " +
				ArtifactPickupInstructionController.getDrop().getName() +
				" (" + ArtifactPickupInstructionController.getDrop().getClass().getSimpleName() +
				" buff = " + ArtifactPickupInstructionController.getDrop().getBuff() + ")"
		);
		showStats(EventDataController.getHero(), heroStats);
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("n");
			}
		});
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventDataController.addInstructions("y");
			}
		});
	}

	static public void displayArtifactPickupView() {
		frame.setContentPane(new ArtifactPickupView().artifactView);
		frame.pack();
	}
}
