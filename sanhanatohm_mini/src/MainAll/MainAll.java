package MainAll;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import AdminGood.Addgood;

public class MainAll {
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Mini supplier");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(400,600));
		
		
        frame.setLayout(new BorderLayout());
        
        
		frame.getContentPane().add(new MyMenu(frame), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
