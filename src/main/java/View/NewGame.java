package View;

import Controller.EventData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends BaseWindow{
    private JButton createHero;
    private JComboBox heroTypeSelector;
    private JTextField heroNameInput;
    private JPanel newGame;
    private JButton cancel;
    private JTextArea heroStats;
    private String[] heroType = {"select type", "Black Mage", "Elf", "Knight", "Orc"};

    public NewGame() {

        System.out.println(heroType[heroTypeSelector.getSelectedIndex()]);
        createHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!heroNameInput.getText().isEmpty()) {
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
                    heroStats.append(heroType[heroTypeSelector.getSelectedIndex()]);
                }
                else {
                    heroStats.append("Please select a Hero Type");
                }
            }
        });
    }
    static public void displayNewGame(){
        frame.setContentPane(new NewGame().newGame);
        frame.pack();
    }
}
