package AdminGood;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel implements ActionListener{
	
	private static final String mainString = "Main Menu";
	private static final String addString = "Add";
	private static final String editString = "Edit";
	private static final String deleteString = "Delete";
	private static final String exitString = "Exit";
	
	private static final int frameWidth = 400;
	private static final int frameHeight = 200;
	
	Addgood addgoods;
	Editgood editgoods;
	Deletegood deletegoods;
	
	public Menu(JFrame frame) {
		
		super();
		
		addgoods = new Addgood(frame);
		editgoods = new Editgood(frame);
		deletegoods = new Deletegood(frame);
		
		int panelWidth = 400;
		int panelHeight = 300;
		
		setLayout(null);
		
		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton addBtn = new JButton(addString);
		JButton editBtn = new JButton(editString);
		JButton deleteBtn = new JButton(deleteString);
		JButton exitBtn = new JButton(exitString);
		
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		add(mainLabel);
		add(addBtn);
		add(editBtn);
		add(deleteBtn);
		add(exitBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(90, 11, 70, 14);
		size = addBtn.getPreferredSize();
		addBtn.setBounds(100, 58, 60, 23);
		size = editBtn.getPreferredSize();
		editBtn.setBounds(100, 92, 60, 23);
		size = deleteBtn.getPreferredSize();
		deleteBtn.setBounds(98, 126, 64, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(100, 160, 60, 23);
		
		this.setPreferredSize(new Dimension(260, 200));
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
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
			System.exit(0);
		}
	}
}
