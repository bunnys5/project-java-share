package SupplierAdmin;

import javax.swing.JFrame;

public class Main {
	
	private static void createAndshowGUI() {
		JFrame frame = new JFrame("Admin Supplier");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new Menu(frame));
		
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
