package View;

import Model.Characters.Hero;

import javax.swing.*;
import java.awt.*;

public interface WindowManager {

	void showSelectedHero();
	void showNewHero();
	void showSelectedMission(Hero hero);


}
