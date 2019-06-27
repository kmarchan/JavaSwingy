package View;

import Controller.CharacterController;
import Model.Characters.Hero;

import javax.swing.*;
import java.awt.*;

public class PlayMission extends javax.swing.JPanel{
	private WindowManager windowManager;
	private CharacterController characterController = new CharacterController();

	public PlayMission(WindowManager windowManager, Hero hero) {
		this.windowManager = windowManager;
		initComponents();

	}

	private void initComponents() {
		JTextField textField = new javax.swing.JTextField();
		JLabel errorLabel = new javax.swing.JLabel();
		errorLabel.setForeground(Color.RED);
		JComboBox comboBox = new javax.swing.JComboBox<>();
		JButton button = new javax.swing.JButton();
	}
}
