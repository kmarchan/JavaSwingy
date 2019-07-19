package View;

import Controller.CreateInstructionController;
import Controller.EventDataController;

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
    private JTextPane heroStats;
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
                    EventDataController.addInstructions("start");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateInstructionController.addCreateInstructions("menu");
            }
        });
        heroTypeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (heroTypeSelector.getSelectedIndex() != 0) {
                    heroStats.setText(heroType[heroTypeSelector.getSelectedIndex()]);
                    heroTypeSelectorLabel.setForeground(Color.BLACK);
                    EventDataController.createHeroPreview(heroType[heroTypeSelector.getSelectedIndex()], heroNameInput.getText().isEmpty() ? "The Unnamed One" : heroNameInput.getText());
                    showStats(EventDataController.getHero(), heroStats);
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
                if (heroTypeSelector.getSelectedIndex() != 0) {
                    heroStats.setText(heroType[heroTypeSelector.getSelectedIndex()]);
                    EventDataController.createHeroPreview(heroType[heroTypeSelector.getSelectedIndex()], heroNameInput.getText().isEmpty() ? "The Unnamed One" : heroNameInput.getText());
                    showStats(EventDataController.getHero(), heroStats);}
            }
        });
    }

    static public void displayNewGame(){
        frame.setContentPane(new NewGame().newGame);
        frame.pack();
    }
}
