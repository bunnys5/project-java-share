package AdminGood;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		// Create pane as container
		//Container pane = getContentPane();
		// set layout manager to manual
		JPanel pane = this;
		this.setLayout(null);
	    setLayout(null);
	    JLabel label = new JLabel("1:");
	    label.setBounds(0, 0, 0, 0);
	    pane.add(label);
	    lv1ComboBox = new JComboBox<CatagoryItem>();
	    lv1ComboBox.setBounds(308, 46, 100, 30);
	    pane.add(lv1ComboBox);
	    DAO.ComboBoxVL1(lv1ComboBox, 0);
	    lv1ComboBox.addActionListener(this);
	    
	    lv2ComboBox = new JComboBox<CatagoryItem>();
	    JLabel label_1 = new JLabel("2:");
	    label_1.setBounds(0, 0, 0, 0);
	    pane.add(label_1);
	    lv2ComboBox.setBounds(308, 101, 100, 30);
	    pane.add(lv2ComboBox);
	    lv2ComboBox.addActionListener(this);
	   
	    
	    lv3ComboBox = new JComboBox<CatagoryItem>();
	    lv3ComboBox.setBounds(308, 156, 100, 30);
	    pane.add(lv3ComboBox);
	    lv3ComboBox.addActionListener(this);
	    
	    nameLabel = new JLabel("Name");
	    nameLabel.setBounds(458, 46, 100, 30);
	    pane.add(nameLabel);
	    
	    priceLabel = new JLabel("Price");
	    priceLabel.setBounds(458, 101, 100, 30);
	    pane.add(priceLabel);
	    
	    stockLabel = new JLabel("Stocks");
	    stockLabel.setBounds(458, 156, 100, 30);
	    pane.add(stockLabel);
	    
	    nameTxt = new JTextField();
	    nameTxt.setBounds(503, 46, 282, 30);
	    pane.add(nameTxt);
	    
	    priceTxt = new JTextField();
	    priceTxt.setBounds(503, 101, 100, 30);
	    pane.add(priceTxt);
	    
	    stockTxt = new JTextField();
	    stockTxt.setBounds(503, 156, 100, 30);
	    pane.add(stockTxt);
	    

	 

		// create labels
		JLabel addgoodlabel = new JLabel("Add Goods");


		// create buttons
		JButton addBtn = new JButton(addString);
		addBtn.setBackground(new Color(0, 255, 128));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 128));

		// create texts

		
		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		this.add(addgoodlabel);
		
		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addgoodlabel.getPreferredSize();
		addgoodlabel.setBounds(422, 13, 77, 14);
		

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(503, 197, 63, 23);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(600, 197, 77, 23);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 248, 827, 327);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("refresh");
		btnNewButton.setBackground(new Color(0, 255, 128));
		
		
		String[] columnNames = {"ID", "LV3","LV2","LV1", "NAME", "PRICE", "STOCKS"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
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

		setVisible(true);

		System.out.println("AddformDialog() done!");

	}
	
	public static void infoMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
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
				
				if((nameTxt.getText().isEmpty()) || priceTxt.getText().isEmpty() || stockTxt.getText().isEmpty()) {
					infoMessage("Please complete the information.", "Check your fucking field!");
				} else {
				
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
			}
		

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	

	}
