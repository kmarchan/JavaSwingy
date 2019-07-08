package View;

import Controller.EventData;
import Storage.HeroStorage;
import Exception.InputException;
import lombok.var;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadHero extends BaseWindow{
    private JTextPane heroStats;
    private JComboBox selectHero;
    private JButton selectHeroButton;
    private JButton cancelButton;
    private JPanel loadHeroPane;

    public LoadHero() throws InputException {

        selectHeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventData.addInstructions("menu");

            }
        });
    }

    static public void displayLoadHero() throws InputException {
        frame.setContentPane(new LoadHero().loadHeroPane);
        frame.pack();
    }
}
