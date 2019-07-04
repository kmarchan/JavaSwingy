package View;

import Controller.EventData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controls extends BaseWindow{
    private JTextPane heroStats;
    private JPanel controls;
    private JButton backButton;

    public Controls() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventData.addInstructions("menu");
            }
        });
    }
    static public void displayControls(){
        frame.setContentPane(new Controls().controls);
        frame.pack();
    }
}
