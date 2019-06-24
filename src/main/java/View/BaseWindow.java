package View;

import javax.swing.*;

public class BaseWindow {
	static public JFrame frame ;

	static public void createBaseWindow(){
		frame = new JFrame("Swingy");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);

		}

	static public void destoryWindow(){
		frame.dispose();
		frame.setVisible(false);
	}

	static public void showBaseWindow(){
		frame.setVisible(true);
	}
}
