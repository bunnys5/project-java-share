package Procuremen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Menu extends JPanel implements ActionListener {

	private static final String mainString = "Main Menu";
	private static final String orderString = "Order Goods";
	private static final String chackString = "Chack Goods";
	private static final String exitString = "Exit";

	private static final int frameWidth = 400;
	private static final int frameHeight = 200;

	OrderGoods ordergoods;
	CheckGoods chackgoods;

	public Menu(JFrame frame) {
		super();

		ordergoods = new OrderGoods(frame);
		chackgoods = new CheckGoods(frame);

		int panelWidth = 400;
		int panelHeight = 300;

		setLayout(null);

		JLabel mainLabel = new JLabel(mainString);
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton orderBtn = new JButton(orderString);
		orderBtn.setBackground(new Color(0, 255, 64));
		JButton chackBtn = new JButton(chackString);
		chackBtn.setBackground(new Color(0, 255, 64));
		JButton exitBtn = new JButton(exitString);
		exitBtn.setBackground(new Color(0, 255, 64));

		orderBtn.addActionListener(this);
		chackBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		add(mainLabel);
		add(orderBtn);
		add(chackBtn);
		add(exitBtn);

		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds(90, 11, 70, 14);
		size = orderBtn.getPreferredSize();
		orderBtn.setBounds(80, 58, 100, 23);
		size = chackBtn.getPreferredSize();
		chackBtn.setBounds(80, 92, 100, 23);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(98, 126, 64, 23);

		this.setPreferredSize(new Dimension(260, 200));

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if (actionCommand.equals(orderString)) {
			System.out.println("equals " + orderString);
			ordergoods.setVisible(true);
		}else if(actionCommand.equals(chackString)) {
			System.out.println("equals " + chackString);
			chackgoods.setVisible(true);
		} else if (actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			System.exit(0);
		}

	}
}