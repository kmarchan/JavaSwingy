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

	public ArtifactPickupView() {
		// TODO item info
		artifactMessage.setText(EventDataController.getFoe().getName() + " was killed and has dropped " + ArtifactPickupInstructionController.getDrop().getName() + " (buff = " + ArtifactPickupInstructionController.getDrop().getBuff() + ")");
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArtifactPickupInstructionController.addResponseInstructions("n");
			}
		});
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArtifactPickupInstructionController.addResponseInstructions("y");
			}
		});
	}

	static public void displayArtifactPickupView() {
		frame.setContentPane(new ArtifactPickupView().artifactView);
		frame.pack();
	}
}
