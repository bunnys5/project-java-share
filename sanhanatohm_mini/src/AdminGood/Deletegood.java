package AdminGood;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Deletegood extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField idgoodsTxt;

	private static final String deleteString = "Delete";
	private static final String cancelString = "cancel";
	private JTable table;

	public Deletegood(JFrame frame) {
//		super(frame, true);
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent arg0) {
//				ShowData();
//			}
//		});

		// Create pane as container
//		Container pane = getContentPane();
		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel deletegoodlabel = new JLabel("Delete Goods");
		deletegoodlabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel idLabel = new JLabel("ID");

		// create buttons
		JButton deleteBtn = new JButton(deleteString);
		deleteBtn.setBackground(new Color(0, 255, 128));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 128));

		// create texts
		idgoodsTxt = new JTextField(10);

		// create control buttons.
		deleteBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(deletegoodlabel);
		pane.add(idLabel);

		// add text fields
		pane.add(idgoodsTxt);

		// add control buttons
		pane.add(deleteBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = deletegoodlabel.getPreferredSize();
		deletegoodlabel.setBounds(160, 10, 80, 14);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(127, 83, size.width, size.height);

		// set sizes and positions for labels
		size = idgoodsTxt.getPreferredSize();
		idgoodsTxt.setBounds(160, 80, 80, 20);

		// set sizes and positions for controls buttons
		size = deleteBtn.getPreferredSize();
		deleteBtn.setBounds(127, 140, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(210, 140, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 231, 360, 258);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

//		pack();
//		setLocationRelativeTo(null);
		setVisible(true);

		System.out.println("DeleteformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String actionCommand = evt.getActionCommand();
		// user presses "Add"
		if (actionCommand.equals(deleteString)) {
			System.out.println("actionCommand:" + deleteString);
			try {
				// retrieve values from text fields.
				String idgoods = idgoodsTxt.getText();
				
				int id = 0;
				Admingoods Delete = new Admingoods(idgoods, actionCommand, actionCommand, id, id);
				deleteGoods(Delete);
				
				// reset text fields
				idgoodsTxt.setText(null);
			}catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			// user presses "Cancel"
		} else if (actionCommand.equals(cancelString)) {
		    	System.out.println("actionCommand:" + cancelString);
				setVisible(false);
		}
		ShowData();
	}
	private void deleteGoods(Admingoods goods) {
		System.out.println("GoodsDB.deleteGoods()");
		try {
			String deleteSql = "DELETE FROM GOODS WHERE IDGOODS=" + "'" + goods.idgoods + "'";
			System.out.println("selectSql:" + deleteSql);

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(deleteSql);
				stmnt.close();
				con.close();
				System.out.println("Product Delete successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid ID.");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private void ShowData() {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("Description");
		model.addColumn("PRICE");
		model.addColumn("STOCK");

		try {
			String query = "SELECT * FROM GOODS";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("idgoods"), rs.getString("name"), rs.getString("Description"),
						rs.getString("price"), rs.getString("stock"), });
			}
			rs.close();
			st.close();
			con.close();

			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);

		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}

//	private Connection con() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}

