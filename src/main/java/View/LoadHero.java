package View;

import Controller.EventData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadHero extends BaseWindow{
    private JLabel loadHero;
    private JTextPane heroStats;
    private JComboBox selectHero;
    private JButton selectHeroButton;
    private JButton cancelButton;
    private JLabel heroStatsLabel;
    private JLabel selectHeroLabel;
    private JPanel loadHeroPane;

    public LoadHero() {

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

    static public void displayLoadHero(){
        frame.setContentPane(new LoadHero().loadHeroPane);
        frame.pack();
    }
}
