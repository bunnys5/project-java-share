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

public class CheckGoods extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField nameTxt;
	JTextField ReceiveDateTxt;

	private static final String acceptString = "accept";
	private static final String cancelString = "cancel";
	private JTable table;

	public CheckGoods(JFrame frame) {
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
		JLabel chacklabel = new JLabel("Chack Order");
		JLabel nameLabel = new JLabel("ID");
		JLabel ReceiveDateLabel = new JLabel("ReceiveDate");

		// create buttons
		JButton acceptBtn = new JButton(acceptString);
		acceptBtn.setBackground(new Color(0, 255, 64));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 64));

		// create texts
		nameTxt = new JTextField(10);
		ReceiveDateTxt = new JTextField(10);

		// create control buttons.
		acceptBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(chacklabel);
		pane.add(nameLabel);
		pane.add(ReceiveDateLabel);

		// add text fields
		pane.add(nameTxt);
		pane.add(ReceiveDateTxt);

		// add control buttons
		pane.add(acceptBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = chacklabel.getPreferredSize();
		chacklabel.setBounds(225, 5, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(90, 30, size.width, size.height);
		size = ReceiveDateLabel.getPreferredSize();
		ReceiveDateLabel.setBounds(90, 60, size.width, size.height);

		// set sizes and positions for labels
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(195, 30, 120, 20);
		size = ReceiveDateTxt.getPreferredSize();
		ReceiveDateTxt.setBounds(195, 60, 120, 20);

		// set sizes and positions for controls buttons
		size = acceptBtn.getPreferredSize();
		acceptBtn.setBounds(160, 115, 90, 23);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(280, 115, 90, 23);

		// set size and position for container
		pane.setPreferredSize(new Dimension(510, 500));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 490, 327);
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
		// user presses "Add"
		if (actionCommand.equals(acceptString)) {
			System.out.println("actionCommand:" + acceptString);
			try {
				String name = nameTxt.getText();
				String ReceiveDate = ReceiveDateTxt.getText();
				Check chackgoods = new Check(name, ReceiveDate);
				System.out.println("goods:" + chackgoods.toString());
				acceptchack (chackgoods);
				
				// reset text fields
				nameTxt.setText(null);
				ReceiveDateTxt.setText(null);
			}catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
		}else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
		ShowData();
	}
	
	private void acceptchack(Check chackgoods) {
		System.out.println("OrderDB.Chack()");
		try {
			String updateSql = "UPDATE ORDERED SET RECEIVEDATE='" + chackgoods.ReceiveDate + "' WHERE ID='" + chackgoods.name + "'";
			String updateGoodsSql = "UPDATE GOODS,ORDERED SET goods.stock = goods.stock + ORDERED.quantity  WHERE goods.idgoods = ORDERED.idgoods AND ORDERED.id = '" + chackgoods.name+"' ORDER BY ORDERED.ID DESC LIMIT 1";
			System.out.println("updateSql:" + updateSql);
			
			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.executeUpdate(updateGoodsSql);
				stmnt.close();
				con.close();
				System.out.println("Goods updated successfully.");
			}
		}catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate.");
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
		model.addColumn("RECEIVEDATE");


		try {
			String query = "SELECT * FROM ORDERED";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("id"), rs.getString("supplier"), rs.getString("idgoods"), rs.getString("good"),
						rs.getString("quantity"), rs.getString("OrderDate"), rs.getString("ReceiveDate") });
			}
			rs.close();
			st.close();
			con.close();

			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(20);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);

		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}

}
