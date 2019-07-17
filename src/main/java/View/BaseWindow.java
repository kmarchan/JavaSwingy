package View;

import Model.Characters.Foe;
import Model.Characters.Hero;

import javax.swing.*;
import java.awt.*;

public class BaseWindow extends JFrame{
	static public JFrame frame ;

	static public void createBaseWindow(){
		frame = new JFrame("Swingy");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height  / 2;
		int width = screenSize.width  / 2;

		frame.setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		}

	static public void destroyWindow(){
		frame.dispose();
		frame.setVisible(false);
	}

	static public void showBaseWindow(){
		frame.setVisible(true);
	}

	public void showStats(Hero hero, JTextPane heroStats) {
		heroStats.setText(
			"Name:		" + hero.getName() + "\n" +
			"Level:		" + hero.getLevel() + "\n" +
			"Experience Points:	" + hero.getExperiencePnts() + "/" + hero.getBaseExperiencePnts() + "\n" +
			"Type:		" + hero.getType() + "\n" +
		// TODO	change to damage with weapon adjustment getAttackPoints()
			"Damage:		" + hero.getAttackPnts() + "\n" +
			"Hit Points:		" + hero.getHitPnts() + "/" + hero.getBaseHitPnts() + "\n" +
			"Defence Points:	" + hero.getDefencePnts() + "/" + hero.getBaseDefencePnts() + "\n");
	}

	public void showFoeStats(Foe foe, JTextPane heroStats) {
		heroStats.setText(
			"Name:		" + foe.getName() + "\n" +
			"Level:		" + foe.getLevel() + "\n" +
			"Type:		" + foe.getType() + "\n" +
			"Damage:		" + foe.getAttackPnts() + "\n" +
			"Hit Points:		" + foe.getHitPnts() + "/" + foe.getBaseHitPnts() + "\n" +
			"Defence Points:	" + foe.getDefencePnts() + "/" + foe.getBaseDefencePnts() + "\n");
	}
}
