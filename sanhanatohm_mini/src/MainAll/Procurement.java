package MainAll;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Procuremen.CheckGoods;
import Procuremen.OrderGoods;

import java.awt.Font;
import java.awt.Color;

public class Procurement extends JDialog implements ActionListener {

	private static final String mainString = "Procurement Menu";
	private static final String OrderString = "Order";
	private static final String CheckString = "Check Order";
	private static final String exitString = "Exit";
	
	private static final int frameWidth = 400;
	private static final int frameHeight = 300;
	
	OrderGoods ordergoods;
	CheckGoods chackgoods;

	
	public Procurement(JFrame frame) {
		
		super(frame, true);
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);
		
		ordergoods = new OrderGoods(frame);
		chackgoods = new CheckGoods(frame);

		
		int panelWidth = 400;
		int panelHeight = 300;
		
		getContentPane().setLayout(null);
		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		
		JButton orderBtn = new JButton(OrderString);
		orderBtn.setBackground(new Color(0, 255, 64));
		JButton chackBtn = new JButton(CheckString);
		chackBtn.setBackground(new Color(0, 255, 64));
		JButton exitBtn = new JButton(exitString);
		exitBtn.setBackground(new Color(0, 255, 64));
		
		orderBtn.addActionListener(this);
		chackBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		getContentPane().add(mainLabel);
		getContentPane().add(orderBtn);
		getContentPane().add(chackBtn);
		getContentPane().add(exitBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(123, 39, 148, 21);
		size = orderBtn.getPreferredSize();
		orderBtn.setBounds(138, 83, 108, 23);
		size = chackBtn.getPreferredSize();
		chackBtn.setBounds(138, 117, 108, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(153, 151, 79, 23);
		
		pane.setPreferredSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		pack();
		setLocationRelativeTo(null);
		setVisible(false);
	}


	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if(actionCommand.equals(OrderString)) {
			System.out.println("equals " + OrderString);
			ordergoods.setVisible(true);
		}else if(actionCommand.equals(CheckString)) {
			System.out.println("equals " + CheckString);
			chackgoods.setVisible(true);
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			setVisible(false);
		}
	}
}
