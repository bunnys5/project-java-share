package AdminGood;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Editgood extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;
	
	int idLv1, idLv2, idLv3;

	DefaultTableModel tableModel;

	JTextField nameTxt;
	JTextField priceTxt;
	JTextField stockTxt;
	
	private static final String editString = "Edit";
	private static final String refreshString = "refresh";
	
	private JTable table;
	String id1;
	String name1;
	String price1;
	String stock1;

	public Editgood(JFrame frame) {

		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel addgoodlabel = new JLabel("Edit Goods");
		JLabel nameLabel = new JLabel("Name");
		JLabel priceLabel = new JLabel("Price");
		JLabel stockLabel = new JLabel("Stock");

		// create buttons
		JButton addBtn = new JButton(editString);
		JButton refreshBtn = new JButton(refreshString);

		// create texts
		nameTxt = new JTextField(20);
		priceTxt = new JTextField(10);
		stockTxt = new JTextField(10);

		// create control buttons.
		addBtn.addActionListener(this);
		refreshBtn.addActionListener(this);
		setLayout(null);

		// add labels
		pane.add(addgoodlabel);
		pane.add(nameLabel);
		pane.add(priceLabel);
		pane.add(stockLabel);

		// add text fields
		pane.add(nameTxt);
		pane.add(priceTxt);
		pane.add(stockTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(refreshBtn);

		// set sizes and positions for labels
		Dimension size = addgoodlabel.getPreferredSize();
		addgoodlabel.setBounds(402, 11, 79, 14);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(328, 46, 100, 30);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(328, 101, 100, 30);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(328, 156, 100, 30);

		// set sizes and positions for labels
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(393, 46, 334, 30);
		size = priceTxt.getPreferredSize();
		priceTxt.setBounds(393, 101, 100, 30);
		size = stockTxt.getPreferredSize();
		stockTxt.setBounds(393, 156, 100, 30);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(351, 196, 67, 23);
		size = refreshBtn.getPreferredSize();
		refreshBtn.setBounds(438, 196, 79, 23);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 248, 827, 327);
		this.add(scrollPane);
		
		String[] columnNames = {"ID", "LV3","LV2","LV1", "NAME", "PRICE","STOCK"};
		tableModel = new DefaultTableModel(columnNames, 0);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0 ) {
					id1 = tableModel.getValueAt(row, 0).toString();
					name1 = tableModel.getValueAt(row, 4).toString();
					price1 = tableModel.getValueAt(row, 5).toString();
					stock1 = tableModel.getValueAt(row, 6).toString();
					nameTxt.setText(name1);
					priceTxt.setText(price1);
					stockTxt.setText(stock1);
					
					System.out.println("--------------Start------------------");
					System.out.println("ConsoleLog Lavel11: " + id1);
					System.out.println("ConsoleLog Lavel11: " + name1);
					System.out.println("ConsoleLog Lavel22: " + price1);
					System.out.println("ConsoleLog Lavel33: " + stock1);
					System.out.println("---------------END-----------------");
				}
				
			}
			
		});
		
		DAO.showDataTable(tableModel);
		table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(533);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(55);

		scrollPane.setViewportView(table);
		
		setVisible(true);

		System.out.println("AddformDialog() done!");

		
	}

	@Override
	// TODO Auto-generated method stub
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		Object source = e.getSource();

		try {
			

			if(command.equals(editString)) {
				System.out.println("actionCommand:" + editString);
				if((nameTxt.getText().isEmpty()) || priceTxt.getText().isEmpty() || stockTxt.getText().isEmpty()) {
					Addgood.infoMessage("Please complete the information.", "Alert");
				} else {
				try {
					
					String name = nameTxt.getText();
					int price = Integer.parseInt(priceTxt.getText());
					int stock = Integer.parseInt(stockTxt.getText());
					upgoods EDIT = new upgoods(id1, name, price, stock);
					System.out.println("Admingoods2:" + editString.toString());
					DAO.editgoods(EDIT);
					tableModel.setRowCount(0);
			           DAO.showDataTable(tableModel);
			           table.setModel(tableModel);
			         						
						
				}catch (Exception ex) {
	                System.err.println("Error! Invalid data.");
	            }
				}
			}else if(command.equals(refreshString)) {
				tableModel.setRowCount(0);
		           DAO.showDataTable(tableModel);
		           table.setModel(tableModel);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}


}
