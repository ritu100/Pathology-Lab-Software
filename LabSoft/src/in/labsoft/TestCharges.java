package in.labsoft;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class TestCharges extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField textTestID;
	private JTextField textCharges;
	private JComboBox cmbTestName;
	private JButton btnSave;
	public TestCharges(JDesktopPane jp) {
		super("Pathological Test Charges",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JLabel lblCategoryName = new JLabel(" Test ID");
		lblCategoryName.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCategoryName.setBounds(10, 11, 87, 25);
		getContentPane().add(lblCategoryName);
		
		textTestID = new JTextField();
		textTestID.setHorizontalAlignment(SwingConstants.CENTER);
		textTestID.setEditable(false);
		textTestID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textTestID.setBounds(107, 11, 101, 25);
		getContentPane().add(textTestID);
		textTestID.setColumns(10);
		
		JLabel lblTestName = new JLabel(" Test Name");
		lblTestName.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTestName.setBounds(10, 47, 87, 25);
		getContentPane().add(lblTestName);
		
		JLabel lblTestCharges = new JLabel(" Test Charges");
		lblTestCharges.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTestCharges.setBounds(10, 83, 87, 25);
		getContentPane().add(lblTestCharges);
		
		textCharges = new JTextField();
		textCharges.setHorizontalAlignment(SwingConstants.RIGHT);
		textCharges.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCharges.setColumns(10);
		textCharges.setBounds(107, 83, 101, 25);
		getContentPane().add(textCharges);
		
		cmbTestName = new JComboBox();
		cmbTestName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!cmbTestName.getSelectedItem().toString().equals("None")) {
					try {
						getTestID(cmbTestName.getSelectedItem().toString());
						enableTexts();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		cmbTestName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTestName.setBounds(107, 47, 198, 25);
		getContentPane().add(cmbTestName);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!cmbTestName.getSelectedItem().toString().equals("None") && ((!textCharges.getText().toString().equals(null)) || (!textCharges.getText().toString().equals("")))) {
					DBManager dbconn = DBManager.getInstance();
					try {
						String SQL = "insert into labsoft.tbl_test_charges values(" + Integer.parseInt(textTestID.getText()) + ",'" + cmbTestName.getSelectedItem().toString() + "'," +
					                 "" + Float.parseFloat(textCharges.getText()) + ");";
						int cnt = dbconn.insertRecords(SQL);
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, cnt + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							disableTexts();
						}
						else {
							JOptionPane.showMessageDialog(null, "Connection Error\nCan't insert records...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Application Error...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please fill all required fields...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
				btnSave.setEnabled(false);
			}
		});
		btnSave.setBounds(107, 119, 198, 33);
		getContentPane().add(btnSave);
				
		setBounds(20, 20, 332, 196);
		setVisible(true);
		
		fillCmbTest();
	}
	
	private void fillCmbTest()
	{
		ArrayList<String> testNames=new ArrayList<String>();
		testNames.add("None");
		String SQL = "select test_name from labsoft.tbl_major_tests order by test_id;";
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				testNames.add(rs.getString(1));
			}
			rs.close();
			rs=null;
			cmbTestName.setModel(new DefaultComboBoxModel(testNames.toArray()));
			disableTexts();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void disableTexts()
	{
		textTestID.setText(null);
		textTestID.setEditable(false);
		textCharges.setText(null);
		textCharges.setEditable(false);
		btnSave.setEnabled(false);
		cmbTestName.setSelectedIndex(0);
		cmbTestName.requestFocus();
	}
	
	private void enableTexts()
	{
		textCharges.setEditable(true);
		textCharges.setText(null);
		btnSave.setEnabled(true);
		textCharges.requestFocus();
	}
	
	private void getTestID(String tname)
	{
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getSelectedTestID(tname);
		} catch (Exception e) {
			id = 0;
		}
		textTestID.setText(Integer.toString(id));
		textTestID.setEditable(false);
	}
}
