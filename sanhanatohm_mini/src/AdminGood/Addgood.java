package AdminGood;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Addgood extends JPanel implements ActionListener {
	
	int idLv1;

	int idLv2;

	int idLv3;
	DefaultTableModel tableModel;
	
	JComboBox<CatagoryItem> lv1ComboBox, lv2ComboBox, lv3ComboBox;
	CatagoryItem selectedCode;

	private static final int width = 400;
	private static final int height = 200;
	

	JTextField nameTxt;
	JTextField priceTxt;
	JTextField stockTxt;
	
	JLabel nameLabel;
	JLabel priceLabel;
	JLabel stockLabel;
	

	private static final String addString = "Add";
	private static final String cancelString = "cancel";
	private JTable table;
	

	public Addgood(JFrame jframe) {
		
//		super(frame, true);
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				ShowData();
//			}
//		});
	    setLayout(new GridLayout(4, 2));
		
		// Create pane as container
		//Container pane = getContentPane();
		// set layout manager to manual
		JPanel pane = this;
		this.setLayout(null);
	    pane.add(new JLabel("1:"));
	    lv1ComboBox = new JComboBox<CatagoryItem>();
	    lv1ComboBox.setBounds(30, 40, 100, 30);
	    pane.add(lv1ComboBox);
	    DAO.ComboBoxVL1(lv1ComboBox, 0);
	    lv1ComboBox.addActionListener(this);
	    
	    lv2ComboBox = new JComboBox<CatagoryItem>();
	    pane.add(new JLabel("2:"));
	    lv2ComboBox.setBounds(30, 95, 100, 30);
	    pane.add(lv2ComboBox);
	    lv2ComboBox.addActionListener(this);
	   
	    
	    lv3ComboBox = new JComboBox<CatagoryItem>();
	    lv3ComboBox.setBounds(30, 150, 100, 30);
	    pane.add(lv3ComboBox);
	    lv3ComboBox.addActionListener(this);
	    
	    nameLabel = new JLabel("Name");
	    nameLabel.setBounds(180, 40, 100, 30);
	    pane.add(nameLabel);
	    
	    priceLabel = new JLabel("Price");
	    priceLabel.setBounds(180, 95, 100, 30);
	    pane.add(priceLabel);
	    
	    stockLabel = new JLabel("Stocks");
	    stockLabel.setBounds(180, 150, 100, 30);
	    pane.add(stockLabel);
	    
	    nameTxt = new JTextField();
	    nameTxt.setBounds(225, 40, 100, 30);
	    pane.add(nameTxt);
	    
	    priceTxt = new JTextField();
	    priceTxt.setBounds(225, 95, 100, 30);
	    pane.add(priceTxt);
	    
	    stockTxt = new JTextField();
	    stockTxt.setBounds(225, 150, 100, 30);
	    pane.add(stockTxt);
	    

	 

		// create labels
		JLabel addgoodlabel = new JLabel("Add Goods");
//		JLabel idgoodsLabel = new JLabel("ID");
//		JLabel nameLabel = new JLabel("Name");
//		JLabel DescriptionLabel = new JLabel("Description");
//		JLabel priceLabel = new JLabel("Price");
//		JLabel stockLabel = new JLabel("Stock");

		// create buttons
		JButton addBtn = new JButton(addString);
		addBtn.setBackground(new Color(0, 255, 128));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 128));

		// create texts
//		idgoodsTxt = new JTextField(10);
//		nameTxt = new JTextField(20);
//		DescriptionTxt = new JTextField(15);
//		priceTxt = new JTextField(10);
//		stockTxt = new JTextField(10);

		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		this.add(addgoodlabel);
//		pane.add(idgoodsLabel);
//		pane.add(nameLabel);
//		pane.add(DescriptionLabel);
//		pane.add(priceLabel);
//		pane.add(stockLabel);

		// add text fields
//		pane.add(idgoodsTxt);
//		pane.add(nameTxt);
//		pane.add(DescriptionTxt);
//		pane.add(priceTxt);
//		pane.add(stockTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addgoodlabel.getPreferredSize();
		addgoodlabel.setBounds((width - size.width) / 2, 5, size.width, size.height);
//		size = idgoodsLabel.getPreferredSize();
//		idgoodsLabel.setBounds(70, 32, 14, 16);
//		size = nameLabel.getPreferredSize();
//		nameLabel.setBounds(70, 60, size.width, size.height);
//		size = DescriptionLabel.getPreferredSize();
//		DescriptionLabel.setBounds(70, 90, size.width, size.height);
//		size = priceLabel.getPreferredSize();
//		priceLabel.setBounds(70, 120, size.width, size.height);
//		size = stockLabel.getPreferredSize();
//		stockLabel.setBounds(70, 150, size.width, size.height);

		// set sizes and positions for labels
//		size = idgoodsTxt.getPreferredSize();
//		idgoodsTxt.setBounds(140, 30, 120, 20);
//		size = nameTxt.getPreferredSize();
//		nameTxt.setBounds(140, 60, 120, 20);
//		size = DescriptionTxt.getPreferredSize();
//		DescriptionTxt.setBounds(140, 90, 120, 20);
//		size = priceTxt.getPreferredSize();
//		priceTxt.setBounds(140, 120, 120, 20);
//		size = stockTxt.getPreferredSize();
//		stockTxt.setBounds(140, 150, 120, 20);
		

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(92, 190, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(174, 190, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 235, 380, 241);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("refresh");
		btnNewButton.setBackground(new Color(0, 255, 128));
		
//		btnNewButton.setBackground(new Color(0, 255, 128));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ShowData();
//			}
//		});
	    
//	    DefaultTableModel model = new DefaultTableModel();
//		model.addColumn("ID");
//		model.addColumn("LV3");
//		model.addColumn("LV2");
//		model.addColumn("LV1");
//		model.addColumn("NAME");
//		model.addColumn("PRICE");
//		model.addColumn("STOCKS");
		

		
		String[] columnNames = {"ID", "LV3","LV2","LV1", "NAME", "PRICE", "STOCKS"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
        DAO.showDataTable(tableModel);
        table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);

		setVisible(true);

		System.out.println("AddformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

//		String actionCommand = evt.getActionCommand();
		// user presses "Add"
//		if (actionCommand.equals(addString)) {
//			System.out.println("actionCommand:" + addString);
//			try {
				// retrieve values from text fields.
//				String idgoods = idgoodsTxt.getText();
//				String name = nameTxt.getText();
//				String Description = DescriptionTxt.getText();
//				int price = Integer.parseInt(priceTxt.getText());
//				int stock = Integer.parseInt(stockTxt.getText());
//				Admingoods Pgoods = new Admingoods( name, price, stock);
//				System.out.println("goods:" + Pgoods.toString());
//				addGood(Pgoods);

				// reset text fields
//				idgoodsTxt.setText(null);
//				nameTxt.setText(null);
//				DescriptionTxt.setText(null);
//				priceTxt.setText(null);
//				stockTxt.setText(null);

//			} catch (Exception ex) {
//				System.err.println("Error! Invalid data.");
//			}
			// user presses "Cancel"
//		} else if (actionCommand.equals(cancelString)) {
//			System.out.println("actionCommand:" + cancelString);
//			setVisible(false);
//		}
//		ShowData();
		String actionCommand = e.getActionCommand();
		
//	}
		try {			
			
			if (e.getSource() == lv1ComboBox) {
					System.out.println("lv1combo");
					selectedCode = (CatagoryItem) lv1ComboBox.getSelectedItem();
					idLv1 = selectedCode.getId();
					System.err.println(idLv1);
					lv2ComboBox.removeAllItems();
					DAO.ComboBoxVL2(lv2ComboBox, idLv1);


			} else if (e.getSource() == lv2ComboBox) {


					selectedCode = (CatagoryItem) lv2ComboBox.getSelectedItem();
					idLv2 = selectedCode.getId();
					System.err.println(idLv2);
					lv3ComboBox.removeAllItems();
					DAO.ComboBoxVL3(lv3ComboBox, idLv2);


			} else if (e.getSource() == lv3ComboBox) {
				try {
				selectedCode = (CatagoryItem) lv3ComboBox.getSelectedItem();
				idLv3 = selectedCode.getId();
				System.err.println(idLv3);
				} catch (Exception ex) {

				}
			}else if(actionCommand.equals(addString)) {
				try {
					String name = nameTxt.getText();
					int unit_price = Integer.parseInt(priceTxt.getText());
					int stocks = Integer.parseInt(stockTxt.getText());
					Goods CatagoryOj = new Goods(0 , idLv3, idLv2, idLv3, name, unit_price, stocks);
					DAO.addGoods(CatagoryOj);
					DAO.showDataTable(tableModel);
				    table.setModel(tableModel);
					
				} catch(Exception ex) {
					
				}
			}
			
			System.out.println("--------------Start------------------");
		    System.out.println("ConsoleLog Lavel1: "+idLv1);
		    System.out.println("ConsoleLog Lavel2: "+idLv2);
		    System.out.println("ConsoleLog Lavel3: "+idLv3);
		    System.out.println("---------------END-----------------");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	

	}
