package View;

import Model.Characters.Hero;

import javax.swing.*;

public class StartGame extends javax.swing.JFrame implements WindowManager {

	private javax.swing.JButton jButton1;

	public StartGame() { initComponents();}

	private void initComponents() {
		JButton jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jButton1.setTest("Select Hero");
		jButton1.addActionListener({jButtonActionPerformed(evt)});
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) { showSelectedHero(); }

	public void showSelectedHero() {
		SelectHero selectHeroPane = new SelectHero(this);
		setContentPane(selectHeroPane);
		pack();

	}

	@Override
	public void showNewHero() {
		NewHero newHeroPanel = new NewHero(this);

		setContentPane(newHeroPanel);
		pack();
	}

	@Override
	public void showSelecMission(Hero hero) {
		PlayMission playMissionPanel = new PlayMission(this, hero);
		setContentPane(playMissionPanel);
		pack();
	}

}
