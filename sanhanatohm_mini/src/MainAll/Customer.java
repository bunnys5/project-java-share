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

import Customer.AddCustomer;
import Customer.DeleteCustomer;
import Customer.EditCustomer;

import java.awt.Font;
import java.awt.Color;

public class Customer extends JDialog implements ActionListener {

	private static final String mainString = "Customer Menu";
	private static final String addString = "Add";
	private static final String editString = "Edit";
	private static final String deleteString = "Delete";
	private static final String exitString = "Exit";
	
	private static final int panelWidth = 400;
	private static final int panelHeight = 300;
	
	AddCustomer addCustomer;
	EditCustomer editCustomer;
	DeleteCustomer deleteCustomer;
	
	public Customer(JFrame frame) {
		
		super(frame, true);
		setBackground(new Color(128, 255, 128));
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);
		
		addCustomer = new AddCustomer(frame);
		editCustomer = new EditCustomer(frame);
		deleteCustomer = new DeleteCustomer(frame);
		
		int panelWidth = 400;
		int panelHeight = 300;
		
		getContentPane().setLayout(null);
		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setBackground(new Color(128, 0, 64));
		mainLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		
		JButton addBtn = new JButton(addString);
		addBtn.setBackground(new Color(0, 255, 64));
		JButton editBtn = new JButton(editString);
		editBtn.setBackground(new Color(0, 255, 64));
		JButton deleteBtn = new JButton(deleteString);
		deleteBtn.setBackground(new Color(0, 255, 64));
		JButton exitBtn = new JButton(exitString);
		exitBtn.setBackground(new Color(0, 255, 64));
		
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		getContentPane().add(mainLabel);
		getContentPane().add(addBtn);
		getContentPane().add(editBtn);
		getContentPane().add(deleteBtn);
		getContentPane().add(exitBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(143, 33, 118, 21);
		size = addBtn.getPreferredSize();
		addBtn.setBounds(161, 83, 79, 23);
		size = editBtn.getPreferredSize();
		editBtn.setBounds(161, 123, 79, 23);
		size = deleteBtn.getPreferredSize();
		deleteBtn.setBounds(161, 160, 79, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(161, 194, 79, 23);
		
		pane.setPreferredSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		pack();
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if(actionCommand.equals(addString)) {
			System.out.println("equals " + addString);
			addCustomer.setVisible(true);
		}else if(actionCommand.equals(editString)) {
			System.out.println("equals " + editString);
			editCustomer.setVisible(true);
		}else if(actionCommand.equals(deleteString)) {
			System.out.println("equals " + deleteString);
			deleteCustomer.setVisible(true);
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			setVisible(false);
		}
	}
}
