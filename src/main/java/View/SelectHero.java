package View;

import Controller.CharacterController;
import Model.Characters.Hero;

import javax.swing.*;

public class SelectHero extends javax.swing.JFrame {
	private WindowManager windowManager;
	private CharacterController characterController = new CharacterController();

	private JPanel panel1;
	private JList HeroList;
	private JTextPane heroStatsTextPane;

	public void setData(Hero data) {
	}

	public void getData(Hero data) {
	}

	public boolean isModified(Hero data) {
		return false;
	}
}
