package View;

import Model.Characters.Hero;

import javax.swing.*;

public class StartGame extends javax.swing.JFrame implements WindowManager {

	private javax.swing.JButton button;
	private JButton button1;
	private JButton newGameButton;
	private JTextPane jKKZTextPane;

	public StartGame() {
		button1.addActionListener((evt) -> {jButtonActionPerformed(evt);});
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) { showSelectedHero(); }

	public void showSelectedHero() {
		SelectHero selectHeroPane = new SelectHero();
		setContentPane(selectHeroPane);
		pack();
	}

	public void showNewHero() {
		NewHero newHeroPanel = new NewHero();
		setContentPane(newHeroPanel);
		pack();
	}

	public void showSelectedMission(Hero hero) {
		PlayMission playMissionPanel = new PlayMission(this, hero);
		setContentPane(playMissionPanel);
		pack();
	}

}
