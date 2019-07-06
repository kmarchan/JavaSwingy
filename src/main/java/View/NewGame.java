package View;

import Controller.EventData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewGame extends BaseWindow{
    private JButton createHero;
    private JComboBox heroTypeSelector;
    private JTextField heroNameInput;
    private JPanel newGame;
    private JButton cancel;
    private JEditorPane heroStats;
    private JLabel heroNameLabel;
    private JLabel heroTypeSelectorLabel;
    private String[] heroType = {"select type", "Black Mage", "Elf", "Knight", "Orc"};

    public NewGame() {

        System.out.println(heroType[heroTypeSelector.getSelectedIndex()]);
        createHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (heroNameInput.getText().isEmpty()) {
                    heroNameLabel.setForeground(Color.RED);
                }
                if (heroTypeSelector.getSelectedIndex() == 0) {
                    heroTypeSelectorLabel.setForeground(Color.RED);
                }
                if ((!heroNameInput.getText().isEmpty()) && heroTypeSelector.getSelectedIndex() != 0) {
                    Utils.CharacterFactory.createHero(heroNameInput.getText(), heroType[heroTypeSelector.getSelectedIndex()]);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventData.addInstructions("menu");
            }
        });
        heroTypeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (heroTypeSelector.getSelectedIndex() != 0) {
                    heroStats.setText(heroType[heroTypeSelector.getSelectedIndex()]);
                    heroTypeSelectorLabel.setForeground(Color.BLACK);
                }
                else {
                    heroStats.setText("Please select a Hero Type");
                }
            }
        });
        heroNameInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                heroNameLabel.setForeground(Color.BLACK);
            }
        });
    }
    static public void displayNewGame(){
        frame.setContentPane(new NewGame().newGame);
        frame.pack();
    }
}
