package in.labsoft;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MajorTests extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField text1;
	private JTextField text2;
	private JLabel lblTestCategory;
	private JLabel lblTestSubcategory;
	private JLabel lblExaminitionType;
	private JLabel lblTestDescription;
	private JComboBox cmbCat;
	private JComboBox cmbSubcat;
	private JComboBox cmbExam;
	private JTextPane textPane;
	private JButton btnSave;
	
	public MajorTests(JDesktopPane jp) {
		super("Pathological Major Test",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JLabel lblTestId = new JLabel("Test ID");
		lblTestId.setBounds(10, 15, 107, 14);
		getContentPane().add(lblTestId);
		
		text1 = new JTextField();
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setFont(new Font("Tahoma", Font.BOLD, 12));
		text1.setEditable(false);
		text1.setColumns(10);
		text1.setBounds(127, 11, 70, 20);
		getContentPane().add(text1);
		
		JLabel lblTestName = new JLabel("Test Name");
		lblTestName.setBounds(10, 40, 107, 14);
		getContentPane().add(lblTestName);
		
		text2 = new JTextField();
		text2.setText((String) null);
		text2.setColumns(10);
		text2.setBounds(127, 37, 202, 20);
		getContentPane().add(text2);
		
		lblTestCategory = new JLabel("Test Category");
		lblTestCategory.setBounds(10, 65, 107, 14);
		getContentPane().add(lblTestCategory);
		
		lblTestSubcategory = new JLabel("Test Sub-Category");
		lblTestSubcategory.setBounds(10, 90, 107, 14);
		getContentPane().add(lblTestSubcategory);
		
		lblExaminitionType = new JLabel("Examinition Type");
		lblExaminitionType.setBounds(10, 115, 107, 14);
		getContentPane().add(lblExaminitionType);
		
		lblTestDescription = new JLabel("Test Description");
		lblTestDescription.setBounds(10, 140, 107, 14);
		getContentPane().add(lblTestDescription);
		
		cmbCat = new JComboBox();
		cmbCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cmbCat.getSelectedItem().equals("None")) {
					ArrayList<String> subcatNames=new ArrayList<String>();
					subcatNames.add("None");
					String SQL = "select subcat_name from labsoft.tbl_test_subcat where cat_name='" + cmbCat.getSelectedItem().toString() + "' order by sub_id;";
					DBManager dbconn=DBManager.getInstance();
					try {
						ResultSet rs=dbconn.selectRecords(SQL);
						while(rs.next()) {
							subcatNames.add(rs.getString(1));
						}
						rs.close();
						rs=null;
						cmbSubcat.removeAllItems();
						cmbSubcat.setModel(new DefaultComboBoxModel(subcatNames.toArray()));
						cmbSubcat.setSelectedIndex(0);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		cmbCat.setBounds(127, 62, 202, 20);
		getContentPane().add(cmbCat);
		
		cmbSubcat = new JComboBox();
		cmbSubcat.setBounds(127, 87, 202, 20);
		getContentPane().add(cmbSubcat);
		
		cmbExam = new JComboBox();
		cmbExam.setBounds(127, 112, 202, 20);
		getContentPane().add(cmbExam);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane.setBounds(127, 140, 202, 96);
		getContentPane().add(textPane);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String SQL = "insert into labsoft.tbl_major_tests(test_name,test_category,test_subcat,test_exam,test_desc) values('"+ 
				                 "" + text2.getText().toString() + "','" + cmbCat.getSelectedItem().toString() + "','" + cmbSubcat.getSelectedItem().toString() + "','" +
							     "" + cmbExam.getSelectedItem().toString() + "','" + textPane.getText().toString() + "');";
					DBManager dbConn=DBManager.getInstance();
					int Count = dbConn.insertRecords(SQL);
					SQL = null;
					if (Count > 0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);					
						getTestID();
						cmbCat.setSelectedIndex(0);
						cmbSubcat.setSelectedIndex(0);
						cmbExam.setSelectedIndex(0);
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSave.setBounds(265, 247, 64, 20);
		getContentPane().add(btnSave);		
		
		setBounds(20, 20, 360, 308);
		setVisible(true);
		fillCatCombo();
		fillExamCombo();
		getTestID();
	}
	
	private void fillCatCombo()
	{
		ArrayList<String> catNames=new ArrayList<String>();
		catNames.add("None");
		String SQL = "select cat_name from labsoft.tbl_test_cat order by cat_id;";
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				catNames.add(rs.getString(1));
			}
			rs.close();
			rs=null;
			cmbCat.setModel(new DefaultComboBoxModel(catNames.toArray()));
			cmbCat.setSelectedIndex(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void fillExamCombo()
	{
		ArrayList<String> examTypes=new ArrayList<String>();
		examTypes.add("None");
		String SQL = "select exam_name from labsoft.tbl_test_exam order by exam_id;";
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				examTypes.add(rs.getString(1));
			}
			rs.close();
			rs=null;
			cmbExam.setModel(new DefaultComboBoxModel(examTypes.toArray()));
			cmbExam.setSelectedIndex(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void getTestID()
	{
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastTestID(?)");
		} catch (Exception e) {
			id = 1;
		}
		text1.setText(Integer.toString(id));
		text1.setEditable(false);
		clearTexts();
	}
	
	private void clearTexts()
	{
		text2.setText(null);
		text2.requestFocus();
	}
}
