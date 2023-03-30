package Procuremen;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Main {
	
	private static void createAndshowGUI() {
		JFrame frame = new JFrame(" Order ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Menu(frame), BorderLayout.NORTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndshowGUI();
			}
		});
	}

}
