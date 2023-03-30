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

public class AddCustomer extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	
	JTextField usernameTxt;
	JTextField passwordTxt;

	private static final String addString = "Add";
	private static final String cancelString = "cancel";
	private JTable table;

	public AddCustomer(JFrame frame) {
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
		JLabel AddCustomerlabel = new JLabel("Add Customer");
		JLabel usernameLabel = new JLabel("UserName");
		JLabel passwordLabel = new JLabel("Password");

		// create buttons
		JButton addBtn = new JButton(addString);
		JButton cancelBtn = new JButton(cancelString);

		// create texts
		
		usernameTxt = new JTextField(20);
		passwordTxt = new JTextField(15);

		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(AddCustomerlabel);

		pane.add(usernameLabel);
		pane.add(passwordLabel);

		// add text fields

		pane.add(usernameTxt);
		pane.add(passwordTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = AddCustomerlabel.getPreferredSize();
		AddCustomerlabel.setBounds((width - size.width) / 2, 5, size.width, size.height);

		size = usernameLabel.getPreferredSize();
		usernameLabel.setBounds(70, 60, size.width, size.height);
		size = passwordLabel.getPreferredSize();
		passwordLabel.setBounds(70, 90, size.width, size.height);

		// set sizes and positions for labels

		size = usernameTxt.getPreferredSize();
		usernameTxt.setBounds(140, 60, 120, 20);
		size = passwordTxt.getPreferredSize();
		passwordTxt.setBounds(140, 90, 120, 20);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(140, 121, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(201, 121, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 400));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 155, 250, 231);
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
		if (actionCommand.equals(addString)) {
			System.out.println("actionCommand:" + addString);
			try {
				// retrieve values from text fields.
				int id = 0;
				String username = usernameTxt.getText();
				int password = Integer.parseInt(passwordTxt.getText());
				AdminCustomer Customer = new AdminCustomer(id, username, password);
				System.out.println("goods:" + Customer.toString());
				addCustomer(Customer);

				// reset text fields

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
	private void addCustomer(AdminCustomer Customer) {
		System.out.println("CustomerDB.addCustomer()");
		try {
			String insertSql = "INSERT INTO CUSTOMER VALUES (  NULL  , '" + Customer.username + "', '"
					+ Customer.password + "')";
			System.out.println("selectSql:" + insertSql);

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Customer add successfully.");
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
		model.addColumn("username");
		model.addColumn("password");

		try {
			String query = "SELECT * FROM CUSTOMER";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("id"), rs.getString("username"), rs.getString("password")});
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
