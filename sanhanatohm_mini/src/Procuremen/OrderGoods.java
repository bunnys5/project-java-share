package Procuremen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class OrderGoods extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField idTxt;
	JTextField supplierTxt;
	JTextField goodTxt;
	JTextField quantityTxt;
	JTextField OrderDateTxt;

	private static final String orderString = "Order";
	private static final String cancelString = "cancel";
	private JTable table;

	public OrderGoods(JFrame frame) {
//		super(frame, true);
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				ShowData();
//			}
//		});

		// Create pane as container
//		Container pane = getContentPane();
		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel orderlabel = new JLabel("Add Order");
		JLabel SupplierLabel = new JLabel("Supplier");
		JLabel idLabel = new JLabel("IdGoods");
		JLabel GoodsLabel = new JLabel("Goods");
		JLabel QuantityLabel = new JLabel("Quantity");
		JLabel OrderDateLabel = new JLabel("OrderDate");

		// create buttons
		JButton orderBtn = new JButton(orderString);
		orderBtn.setBackground(new Color(0, 255, 64));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 64));

		// create texts
		supplierTxt = new JTextField(20);
		idTxt = new JTextField(10);
		goodTxt = new JTextField(15);
		quantityTxt = new JTextField(10);
		OrderDateTxt = new JTextField(10);

		// create control buttons.
		orderBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(orderlabel);
		pane.add(idLabel);
		pane.add(SupplierLabel);
		pane.add(GoodsLabel);
		pane.add(QuantityLabel);
		pane.add(OrderDateLabel);

		// add text fields
		pane.add(idTxt);
		pane.add(supplierTxt);
		pane.add(goodTxt);
		pane.add(quantityTxt);
		pane.add(OrderDateTxt);

		// add control buttons
		pane.add(orderBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = orderlabel.getPreferredSize();
		orderlabel.setBounds((width - size.width) / 2, 5, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(70, 30, size.width, size.height);
		size = SupplierLabel.getPreferredSize();
		SupplierLabel.setBounds(70, 60, size.width, size.height);
		size = GoodsLabel.getPreferredSize();
		GoodsLabel.setBounds(70, 90, size.width, size.height);
		size = QuantityLabel.getPreferredSize();
		QuantityLabel.setBounds(70, 120, size.width, size.height);
		size = OrderDateLabel.getPreferredSize();
		OrderDateLabel.setBounds(70, 150, size.width, size.height);

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(140, 30, 120, 20);
		size = supplierTxt.getPreferredSize();
		supplierTxt.setBounds(140, 60, 120, 20);
		size = goodTxt.getPreferredSize();
		goodTxt.setBounds(140, 90, 120, 20);
		size = quantityTxt.getPreferredSize();
		quantityTxt.setBounds(140, 120, 120, 20);
		size = OrderDateTxt.getPreferredSize();
		OrderDateTxt.setBounds(140, 150, 120, 20);

		// set sizes and positions for controls buttons
		size = orderBtn.getPreferredSize();
		orderBtn.setBounds(139, 190, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(210, 190, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 380, 271);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
//		pack();
//		setLocationRelativeTo(null);
		setVisible(true);

		System.out.println("AddformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String actionCommand = evt.getActionCommand();
		
		if (actionCommand.equals(orderString)) {
			System.out.println("actionCommand:" + orderString);
			try {
				// retrieve values from text fields.
				String idgoods = idTxt.getText();
				String supplier = supplierTxt.getText();
				String good = goodTxt.getText();
				int quantity = Integer.parseInt(quantityTxt.getText());
				String OrderDate = OrderDateTxt.getText();
				Order order1 = new Order(supplier, idgoods, good, quantity, OrderDate);
				System.out.println("order:" + order1.toString());
				addorder(order1);
				
				// reset text fields
				idTxt.setText(null);
				supplierTxt.setText(null);
				goodTxt.setText(null);
				quantityTxt.setText(null);
				OrderDateTxt.setText(null);
				

			}catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
		}else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
		ShowData();
	}

	private void addorder(Order order1) {
		System.out.println("OrderDB.order()");
		try {

			String insertSql = "INSERT INTO ORDERED VALUES" + "( NULL , '" + order1.supplier + "', '" + order1.idgoods + "', '"
					+ order1.good + "', " + order1.quantity + ", '" + order1.OrderDate + "' , '" + 0 + "')";
			System.out.println("selectSql:" + insertSql);

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Order add successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid id.");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	private void ShowData() {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("SUPPLIER");
		model.addColumn("IDGOODS");
		model.addColumn("GOOD");
		model.addColumn("QUANTITY");
		model.addColumn("ORDERDATE");



		try {
			String query = "SELECT * FROM ORDERED";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("id"), rs.getString("supplier"), rs.getString("idgoods"), rs.getString("good"),
						rs.getString("quantity"), rs.getString("OrderDate") });
			}
			rs.close();
			st.close();
			con.close();

			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(90);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);


		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
}
