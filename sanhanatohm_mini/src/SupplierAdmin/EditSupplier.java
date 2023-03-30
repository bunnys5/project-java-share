package SupplierAdmin;

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

public class EditSupplier extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField idTxt;
	JTextField nameTxt;
	JTextField addressTxt;
	JTextField provinceTxt;
	JTextField phoneTxt;

	private static final String editString = "Edit";
	private static final String cancelString = "cancel";
	private JTable table;

	public EditSupplier(JFrame frame) {
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
		JLabel addSupplierlabel = new JLabel("Edit Supplier");
		JLabel idLabel = new JLabel("ID");
		JLabel nameLabel = new JLabel("Name");
		JLabel addressLabel = new JLabel("address");
		JLabel provinceLabel = new JLabel("province");
		JLabel phoneLabel = new JLabel("phone");

		// create buttons
		JButton editBtn = new JButton(editString);
		editBtn.setBackground(new Color(0, 255, 128));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 128));

		// create texts
		idTxt = new JTextField(10);
		nameTxt = new JTextField(20);
		addressTxt = new JTextField(15);
		provinceTxt = new JTextField(10);
		phoneTxt = new JTextField(10);

		// create control buttons.
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(addSupplierlabel);
		pane.add(idLabel);
		pane.add(nameLabel);
		pane.add(addressLabel);
		pane.add(provinceLabel);
		pane.add(phoneLabel);

		// add text fields
		pane.add(idTxt);
		pane.add(nameTxt);
		pane.add(addressTxt);
		pane.add(provinceTxt);
		pane.add(phoneTxt);

		// add control buttons
		pane.add(editBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addSupplierlabel.getPreferredSize();
		addSupplierlabel.setBounds((width - size.width) / 2, 5, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(70, 30, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(70, 60, size.width, size.height);
		size = addressLabel.getPreferredSize();
		addressLabel.setBounds(70, 90, size.width, size.height);
		size = provinceLabel.getPreferredSize();
		provinceLabel.setBounds(70, 120, size.width, size.height);
		size = phoneLabel.getPreferredSize();
		phoneLabel.setBounds(70, 150, size.width, size.height);
		
		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(140, 30, 120, 20);
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(140, 60, 120, 20);
		size = addressTxt.getPreferredSize();
		addressTxt.setBounds(140, 90, 120, 20);
		size = provinceTxt.getPreferredSize();
		provinceTxt.setBounds(140, 120, 120, 20);
		size = phoneTxt.getPreferredSize();
		phoneTxt.setBounds(140, 150, 120, 20);
		
		// set sizes and positions for controls buttons
		size = editBtn.getPreferredSize();
		editBtn.setBounds(139, 190, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(210, 190, size.width, size.height);
		
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

		System.out.println("AddformDialog() done!");

	}

	@Override
	// TODO Auto-generated method stub
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String actionCommand = evt.getActionCommand();
		// user presses "Add"
		if (actionCommand.equals(editString)) {
			System.out.println("actionCommand:" + editString);
			try {
				// retrieve values from text fields.
				int id = Integer.parseInt(idTxt.getText());
				String name = nameTxt.getText();
				String address = addressTxt.getText();
				String province = provinceTxt.getText();
				String phone = phoneTxt.getText();
				AdminSupplier Supplier = new AdminSupplier(id, name, address, province, phone);
				System.out.println("goods:" + Supplier.toString());
				editSupplier(Supplier);

				// reset text fields
				idTxt.setText(null);
				nameTxt.setText(null);
				addressTxt.setText(null);
				provinceTxt.setText(null);
				phoneTxt.setText(null);

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

	private void editSupplier(AdminSupplier Supplier) {
		System.out.println("GoodsDB.editGoods()");
		try {
			String updateSql = "UPDATE SUPPLIER SET NAME='" + Supplier.name + "', address='" + Supplier.address
					+ "', province='" + Supplier.province + "', phone='" + Supplier.phone + "' WHERE ID=" + Supplier.id;
			System.out.println("updateSql:" + updateSql);

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Goods updated successfully.");
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
		model.addColumn("NAME");
		model.addColumn("address");
		model.addColumn("province");
		model.addColumn("phone");

		try {
			String query = "SELECT * FROM SUPPLIER";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("id"), rs.getString("name"), rs.getString("address"),
						rs.getString("province"), rs.getString("phone"), });
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


}
