package MainAll;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import AdminGood.Addgood;
import AdminGood.DeleteGoods;
import AdminGood.Deletegood;
import AdminGood.Editgood;
import Customer.AddCustomer;
import Customer.DeleteCustomer;
import Customer.EditCustomer;
import Procuremen.CheckGoods;
import Procuremen.OrderGoods;
import SupplierAdmin.AddSupplier;
import SupplierAdmin.DeleteSupplier;
import SupplierAdmin.EditSupplier;

public class MyMenu extends JPanel implements ActionListener {

	private static final String mainString = "Main Menu";
	private static final String GoodsString = "Goods";
	private static final String SupplierString = "Supplier";
	private static final String ProcurementString = "Procurement";
	private static final String CustomerString = "Customer";
	private static final String exitString = "Exit";
	private JPanel currentPanel;

	private static final int frameWidth = 400;
	private static final int frameHeight = 300;
	
	private JPanel mainPanel;
	private Goods goods;
	private Supplier supplier;
	private Procurement procurement;
	private Customer customer;
	private CardLayout cardLayout;
	
	private JFrame frame;
	
	
	
public MyMenu(JFrame frame) {
			
		super();
		this.frame = frame;

		goods = new Goods(frame);
		supplier = new Supplier(frame);
		procurement = new Procurement(frame);
		customer = new Customer(frame);
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mainMenu = new JMenu(mainString);
		mainMenu.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		

		JMenuItem exitMenuItem = new JMenuItem(exitString);
		exitMenuItem.setBackground(new Color(0, 255, 64));
		

		exitMenuItem.addActionListener(this);
		
		mainMenu.add(this.createMenu("Good"));
		mainMenu.add(this.createMenu("Supplier"));
		mainMenu.add(this.createMenu("Customer"));
		mainMenu.add(this.createMenu2("Procurement"));
		mainMenu.addSeparator();
		mainMenu.add(exitMenuItem);
		
		menuBar.add(mainMenu);

		
		frame.setJMenuBar(menuBar);
		
		
		this.setPreferredSize(new Dimension(400, 700));
	}

	public JMenu createMenu2(String menuName2) {
		JMenu procurementItem = new JMenu(menuName2);
		procurementItem.setBackground(new Color(0, 255, 64));
		
		JMenuItem pro1 = new JMenuItem("order");
		pro1.addActionListener(this);
		JMenuItem pro2 = new JMenuItem("check order");
		pro2.addActionListener(this);
		
		procurementItem.add(pro1);
		procurementItem.add(pro2);
		
		procurementItem.addActionListener(this);
		return procurementItem;
		
		
	}


	public JMenu createMenu(String menuName) {
		JMenu goodsMenuItem = new JMenu(menuName);
		goodsMenuItem.setBackground(new Color(0, 255, 64));
		
		JMenuItem goods1 = new JMenuItem("add " + menuName);
		goods1.addActionListener(this);
		JMenuItem goods2 = new JMenuItem("edit " + menuName);
		goods2.addActionListener(this);
		JMenuItem goods3 = new JMenuItem("delete " + menuName);
		goods3.addActionListener(this);
		
		goodsMenuItem.add(goods1);
		goodsMenuItem.add(goods2);
		goodsMenuItem.add(goods3);
		
		goodsMenuItem.addActionListener(this);
		return goodsMenuItem;
	}



	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand().toLowerCase();
		System.out.println("ActionCommand:" + actionCommand);
		
		this.frame.getContentPane().removeAll();
		
		if(actionCommand.equals("add good")) {
			System.out.println("equals " + GoodsString);
			this.frame.getContentPane().add(new Addgood(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("edit good")) {
			System.out.println("Edit");
			System.out.println("equals " + "edit goods");
			this.frame.getContentPane().add(new Editgood(frame), BorderLayout.CENTER);
			
		}
		else if(actionCommand.equals("delete good")) {
			System.out.println("Delete");
			System.out.println("equals " + "delete goods");
			this.frame.getContentPane().add(new DeleteGoods(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("add supplier")) {
			System.out.println("equals " + "add supplier");
			this.frame.getContentPane().add(new AddSupplier(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("edit supplier")) {
			System.out.println("equals " + "edit supplier");
			this.frame.getContentPane().add(new EditSupplier(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("delete supplier")) {
			System.out.println("equals " + "delete supplier");
			this.frame.getContentPane().add(new DeleteSupplier(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("order")) {
			System.out.println("equals " + "Procuremen Order");
			this.frame.getContentPane().add(new OrderGoods(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("check order")) {
			System.out.println("equals " + "Procuremen Check Order");
			this.frame.getContentPane().add(new CheckGoods(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("add customer")) {
			System.out.println("equals " + "Procuremen Check Order");
			this.frame.getContentPane().add(new AddCustomer(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("edit customer")) {
			System.out.println("equals " + "Procuremen Check Order");
			this.frame.getContentPane().add(new EditCustomer(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals("delete customer")) {
			System.out.println("equals " + "Procuremen Check Order");
			this.frame.getContentPane().add(new DeleteCustomer(frame), BorderLayout.CENTER);
		}
		else if(actionCommand.equals(ProcurementString)) {
			System.out.println("equals " + ProcurementString);
			procurement.setVisible(true);
		}else if(actionCommand.equals(CustomerString)) {
			System.out.println("equals " + CustomerString);
			customer.setVisible(true);	
		}else if(actionCommand.equals("Order")) {
			System.out.println("equals " + ProcurementString);
			this.frame.getContentPane().add(new OrderGoods(frame), BorderLayout.CENTER);	
		}else if(actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			System.exit(0);
		}
		this.frame.pack();
	}
}
