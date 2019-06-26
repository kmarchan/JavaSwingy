package View;

import javax.swing.*;
import java.awt.*;


public class NewHero extends javax.swing.JPanel{
	private WindowManager windowManager;
	private CharacterController characterController = new CharacterController();

	public NewHero(WindowManager windowManager) {
		this.windowManager = windowManager;
		initComponents();
	}

	private void initComponents() {
		jTextField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		errorMessage = new javax.swing.JLabel();
		errorMessage.setForeground(Color.RED);
		jComboBox = new javax.swing.JComboBox<>();
		jButton1 = new javax.swing.JButton();
	}
}
