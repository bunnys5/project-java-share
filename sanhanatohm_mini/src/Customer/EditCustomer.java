package Customer;

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

import SupplierAdmin.Le11ConnMariaDB;

public class EditCustomer extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField idTxt;
	JTextField usernameTxt;
	JTextField passwordTxt;

	private static final String editString = "Edit";
	private static final String cancelString = "cancel";
	private JTable table;

	public EditCustomer(JFrame frame) {
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
		JLabel editCustomerlabel = new JLabel("Edit Customer");
		JLabel idLabel = new JLabel("ID");
		JLabel usernameLabel = new JLabel("UserName");
		JLabel passwordLabel = new JLabel("Password");

		// create buttons
		JButton editBtn = new JButton(editString);
		JButton cancelBtn = new JButton(cancelString);

		// create texts
		idTxt = new JTextField(10);
		usernameTxt = new JTextField(20);
		passwordTxt = new JTextField(15);

		// create control buttons.
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(editCustomerlabel);
		pane.add(idLabel);
		pane.add(usernameLabel);
		pane.add(passwordLabel);

		// add text fields
		pane.add(idTxt);
		pane.add(usernameTxt);
		pane.add(passwordTxt);

		// add control buttons
		pane.add(editBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = editCustomerlabel.getPreferredSize();
		editCustomerlabel.setBounds((width - size.width) / 2, 5, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(70, 30, size.width, size.height);
		size = usernameLabel.getPreferredSize();
		usernameLabel.setBounds(70, 60, size.width, size.height);
		size = passwordLabel.getPreferredSize();
		passwordLabel.setBounds(70, 90, size.width, size.height);

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(140, 30, 120, 20);
		size = usernameTxt.getPreferredSize();
		usernameTxt.setBounds(140, 60, 120, 20);
		size = passwordTxt.getPreferredSize();
		passwordTxt.setBounds(140, 90, 120, 20);

		// set sizes and positions for controls buttons
		size = editBtn.getPreferredSize();
		editBtn.setBounds(140, 131, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(197, 131, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 165, 250, 273);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

//		pack();
//		setLocationRelativeTo(null);
		setVisible(true);

		System.out.println("AddformDialog() done!");
	}

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String actionCommand = evt.getActionCommand();
		// user presses "Add"
		if (actionCommand.equals(editString)) {
			System.out.println("actionCommand:" + editString);
			try {
				// retrieve values from text fields.
				int id = Integer.parseInt(idTxt.getText());
				String username = usernameTxt.getText();
				int password = Integer.parseInt(passwordTxt.getText());
				AdminCustomer Customer = new AdminCustomer(id, username, password);
				System.out.println("goods:" + Customer.toString());
				editCustomer(Customer);

				// reset text fields
				idTxt.setText(null);
				usernameTxt.setText(null);
				passwordTxt.setText(null);

			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			// user presses "Cancel"
		} else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
		ShowData();

	}

	private void editCustomer(AdminCustomer Customer) {
		System.out.println("GoodsDB.editGoods()");
		try {
			String updateSql = "UPDATE CUSTOMER SET USERNAME='" + Customer.username + "', password='"
					+ Customer.password + "' WHERE ID=" + Customer.id;
			System.out.println("updateSql:" + updateSql);

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Customer updated successfully.");
			}
		} catch (NumberFormatException ex) {
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
		model.addColumn("username");
		model.addColumn("password");

		try {
			String query = "SELECT * FROM CUSTOMER";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("id"), rs.getString("username"), rs.getString("password") });
			}
			rs.close();
			st.close();
			con.close();

			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);

		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
}
