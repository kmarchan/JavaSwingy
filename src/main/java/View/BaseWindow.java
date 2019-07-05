package View;

import javax.swing.*;
import java.awt.*;

public class BaseWindow extends JFrame{
	static public JFrame frame ;

	static public void createBaseWindow(){
		frame = new JFrame("Swingy");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height  / 4;
        int width = screenSize.width  / 4;

        frame.setPreferredSize(new Dimension(width, height));
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
