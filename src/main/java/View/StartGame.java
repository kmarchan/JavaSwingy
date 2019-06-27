package View;

import Model.Characters.Hero;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartGame extends javax.swing.JFrame implements WindowManager {

	private javax.swing.JButton button;

	public StartGame() { initComponents();}

	private void initComponents() {
		button = new javax.swing.JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		button.setText("Select Hero");
//		button.addActionListener({jButtonActionPerformed(evt)});
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
