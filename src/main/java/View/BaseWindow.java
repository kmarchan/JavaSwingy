package View;

import Model.Characters.Foe;
import Model.Characters.Hero;

import javax.swing.*;
import java.awt.*;

import static Model.Artifacts.Artifact.*;

public class BaseWindow extends JFrame{
	static JFrame frame ;

	static public void hideBaseWindow() {
		frame.setVisible(false);
	}

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

	void showStats(Hero hero, JTextPane heroStats) {
		heroStats.setText(
			"Name:		" + hero.getName() + "\n" +
			"Level:		" + hero.getLevel() + "\n" +
			"Experience Points:	" + hero.getExperiencePnts() + "/" + hero.getBaseExperiencePnts() + "\n" +
			"Type:		" + hero.getType() + "\n" +
			"Damage:		" + hero.getAttackPnts() + "\n" +
			"Hit Points:		" + hero.getHitPnts() + "/" + (hero.getBaseHitPnts()+ hero.getEquipped()[HELM].getBuff()) + "\n" +
			"Defence Points:	" + hero.getDefencePnts() + "/" + (hero.getBaseDefencePnts() + hero.getEquipped()[ARMOUR].getBuff()) + "\n" +
			"Weapon:		" + hero.getEquipped()[WEAPON].getName() +
			"\nBuff:		" + hero.getEquipped()[WEAPON].getBuff() +
			"\nArmour:		" + hero.getEquipped()[ARMOUR].getName() +
			"\nBuff:		" + hero.getEquipped()[ARMOUR].getBuff() +
			"\nHelm:		" + hero.getEquipped()[HELM].getName() +
			"\nBuff:		" + hero.getEquipped()[HELM].getBuff()
		);
	}

	void showFoeStats(Foe foe, JTextPane heroStats) {
		heroStats.setText(
			"Name:		" + foe.getName() + "\n" +
			"Level:		" + foe.getLevel() + "\n" +
			"Type:		" + foe.getType() + "\n" +
			"Damage:		" + foe.getAttackPnts() + "\n" +
			"Hit Points:		" + foe.getHitPnts() + "/" + foe.getBaseHitPnts() + "\n" +
			"Defence Points:	" + foe.getDefencePnts() + "/" + foe.getBaseDefencePnts() + "\n");
	}
}
