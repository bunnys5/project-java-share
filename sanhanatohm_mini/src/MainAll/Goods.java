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

import AdminGood.Addgood;
import AdminGood.Deletegood;
import AdminGood.Editgood;

import java.awt.Font;
import java.awt.Color;

public class Goods extends JDialog implements ActionListener {

	private static final String mainString = "Goods Menu";
	private static final String addString = "Add";
	private static final String editString = "Edit";
	private static final String deleteString = "Delete";
	private static final String exitString = "Exit";

	
	Addgood addgoods;
	Editgood editgoods;
	Deletegood deletegoods;
	
	public Goods(JFrame frame) {
		
		super(frame, true);
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);

		
		addgoods = new Addgood(frame);
		editgoods = new Editgood(frame);
		deletegoods = new Deletegood(frame);
		
		int panelWidth = 400;
		int panelHeight = 300;
		
		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		
		JButton addBtn = new JButton(addString);
		addBtn.setBackground(new Color(0, 128, 255));
		JButton editBtn = new JButton(editString);
		editBtn.setBackground(new Color(0, 128, 255));
		JButton deleteBtn = new JButton(deleteString);
		deleteBtn.setBackground(new Color(0, 128, 255));
		JButton exitBtn = new JButton(exitString);
		exitBtn.setBackground(new Color(0, 128, 255));
		
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		pane.add(mainLabel);
		pane.add(addBtn);
		pane.add(editBtn);
		pane.add(deleteBtn);
		pane.add(exitBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(153, 33, 87, 21);
		size = addBtn.getPreferredSize();
		addBtn.setBounds(161, 83, 79, 23);
		size = editBtn.getPreferredSize();
		editBtn.setBounds(161, 123, 79, 23);
		size = deleteBtn.getPreferredSize();
		deleteBtn.setBounds(161, 160, 79, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(161, 194, 79, 23);
		pane.setPreferredSize(new Dimension(400, 250));
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
			addgoods.setVisible(true);
		}else if(actionCommand.equals(editString)) {
			System.out.println("equals " + editString);
			editgoods.setVisible(true);
		}else if(actionCommand.equals(deleteString)) {
			System.out.println("equals " + deleteString);
			deletegoods.setVisible(true);
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			setVisible(false);
		}
	}
}
