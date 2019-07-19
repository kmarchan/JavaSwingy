package View;

import Controller.EventDataController;
import Controller.LoadInstructionController;
import Model.Characters.Hero;
import Storage.HeroStorage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadHero extends BaseWindow{
    private JTextPane heroStats;
    private JComboBox<String> selectHero;
    private JButton selectHeroButton;
    private JButton cancelButton;
    private JPanel loadHeroPane;
    private Hero hero;

    private LoadHero() {

        selectHero.addItem("Please select a save");
        for (int i = 0; i < HeroStorage.savedHeroes.size(); i++) {
            selectHero.addItem(i + ". " + HeroStorage.savedHeroes.get(i).getName());
        }
        selectHeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				if (selectHero.getSelectedIndex() != 0) {
                EventDataController.setHero(hero);
                EventDataController.addInstructions("start");}
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadInstructionController.addLoadInstructions("menu");
            }
        });
        selectHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (selectHero.getSelectedIndex() != 0) {
                    int id = selectHero.getSelectedIndex() - 1;
                    hero = HeroStorage.savedHeroes.get(id);
                    showStats(hero, heroStats);
                }
            }
        });
    }

    static public void displayLoadHero() {
        frame.setContentPane(new LoadHero().loadHeroPane);
        frame.pack();
    }
}
