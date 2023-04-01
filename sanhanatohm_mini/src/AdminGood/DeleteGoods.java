package AdminGood;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DeleteGoods extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;
	
	int idLv1, idLv2, idLv3;

	DefaultTableModel tableModel;

	JLabel nameTxt;
	JLabel priceTxt;
	JLabel stockTxt;

	private static final String deleteString = "Delete";
	private static final String refreshString = "Refresh";

	private JTable table;
	String id1;
	String name1;
	String price1;
	String stock1;

	public DeleteGoods(JFrame frame) {

		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel addgoodlabel = new JLabel("Delete Goods");
		JLabel nameLabel = new JLabel("Name");
		JLabel priceLabel = new JLabel("Price");
		JLabel stockLabel = new JLabel("Stock");

		// create buttons
		JButton addBtn = new JButton(deleteString);
		JButton refreshBtn = new JButton(refreshString);

		// create texts
		nameTxt = new JLabel();
		priceTxt = new JLabel();
		stockTxt = new JLabel();

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
		addgoodlabel.setBounds(434, 4, 81, 14);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(316, 39, 100, 30);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(316, 94, 100, 30);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(316, 149, 100, 30);

		// set sizes and positions for labels
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(396, 39, 300, 30);
		size = priceTxt.getPreferredSize();
		priceTxt.setBounds(396, 94, 100, 30);
		size = stockTxt.getPreferredSize();
		stockTxt.setBounds(396, 149, 100, 30);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(383, 189, 72, 23);
		size = refreshBtn.getPreferredSize();
		refreshBtn.setBounds(476, 189, 88, 23);

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

			if(command.equals(deleteString)) {
				System.out.println("actionCommand:" + deleteString);
				try {
					
					String name = nameTxt.getText();
					int price = Integer.parseInt(priceTxt.getText());
					int stock = Integer.parseInt(stockTxt.getText());
					upgoods EDIT = new upgoods(id1, name, price, stock);
					System.out.println("Admingoods2:" + deleteString.toString());
					DAO.deleteGoods(EDIT);
					tableModel.setRowCount(0);
			           DAO.showDataTable(tableModel);
			           table.setModel(tableModel);
			           
			           nameTxt.setText(null);
			           priceTxt.setText(null);
			           stockTxt.setText(null);

			           System.out.println("--------------Start------------------");
						System.out.println("ConsoleLog Lavel11: " + name);
						System.out.println("ConsoleLog Lavel22: " + price);
						System.out.println("ConsoleLog Lavel33: " + stock);
						System.out.println("---------------END-----------------");

				}catch (Exception ex) {
	                System.err.println("Error! Invalid data.");
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