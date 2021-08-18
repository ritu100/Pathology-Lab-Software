package in.labsoft;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestReadings extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat dateFormat;
	private JDesktopPane jdp;
	private JTextField labelReadingId;
	private JTextField labelReadingDate;
	private JTextField labelCustName;
	private JTextField labelDocName;
	private JLabel labelCustId;
	private JLabel labelCustEmail;
	private JLabel labelCustContact1;
	private JLabel labelDocId;
	private JLabel labelDocEmail;
	private JLabel labelDocContact1;
	private JLabel labelDocGrad;
	private JLabel labelDocPost;
	private JLabel labelDocDip;
	private JLabel labelTestExam;
	private JPanel panelReadings;
	private JButton btnSave;
	private JTable table;
	private JScrollPane jsp;
	private JComboBox<?> comboFormIds;
	private JLabel labelFormDate;

	public TestReadings(JDesktopPane jp) {
		super("Customer : Test Reading Details",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.MAGENTA));
		panel.setBounds(0, 0, 767, 128);
		getContentPane().add(panel);
		
		labelReadingId = new JTextField();
		labelReadingId.setText("1");
		labelReadingId.setHorizontalAlignment(SwingConstants.CENTER);
		labelReadingId.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelReadingId.setEditable(false);
		labelReadingId.setColumns(10);
		labelReadingId.setBounds(10, 4, 30, 25);
		panel.add(labelReadingId);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(null);
		label_1.setBounds(595, 4, 35, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("PALLAVI PATHOLOGICAL LABORATORY, NASHIK");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(72, 61, 139));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBorder(new LineBorder(new Color(0, 0, 139)));
		label_2.setBounds(43, 4, 552, 25);
		panel.add(label_2);
		
		labelReadingDate = new JTextField();
		labelReadingDate.setText("26-03-2019");
		labelReadingDate.setHorizontalAlignment(SwingConstants.CENTER);
		labelReadingDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelReadingDate.setEditable(false);
		labelReadingDate.setColumns(10);
		labelReadingDate.setBounds(631, 4, 126, 25);
		panel.add(labelReadingDate);
		
		labelCustId = new JLabel("1");
		labelCustId.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustId.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCustId.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelCustId.setBounds(10, 66, 30, 25);
		panel.add(labelCustId);
		
		labelCustName = new JTextField();
		labelCustName.setText("Mr. Ganesh Patil");
		labelCustName.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCustName.setEditable(false);
		labelCustName.setColumns(10);
		labelCustName.setBounds(43, 66, 165, 25);
		panel.add(labelCustName);
		
		labelCustEmail = new JLabel("customer@gmail.com");
		labelCustEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCustEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelCustEmail.setBounds(211, 66, 140, 25);
		panel.add(labelCustEmail);
		
		labelCustContact1 = new JLabel("9689925884");
		labelCustContact1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCustContact1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCustContact1.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelCustContact1.setBounds(354, 66, 81, 25);
		panel.add(labelCustContact1);
		
		labelDocId = new JLabel("1");
		labelDocId.setHorizontalAlignment(SwingConstants.CENTER);
		labelDocId.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDocId.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDocId.setBounds(10, 95, 30, 25);
		panel.add(labelDocId);
		
		labelDocName = new JTextField();
		labelDocName.setText("Dr. Dinesh Shinde");
		labelDocName.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDocName.setEditable(false);
		labelDocName.setColumns(10);
		labelDocName.setBounds(43, 95, 165, 25);
		panel.add(labelDocName);
		
		labelDocEmail = new JLabel("doctor@gmail.com");
		labelDocEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDocEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDocEmail.setBounds(211, 95, 140, 25);
		panel.add(labelDocEmail);
		
		labelDocContact1 = new JLabel("9689925884");
		labelDocContact1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDocContact1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDocContact1.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDocContact1.setBounds(354, 95, 81, 25);
		panel.add(labelDocContact1);
		
		labelDocGrad = new JLabel("MBBS");
		labelDocGrad.setHorizontalAlignment(SwingConstants.CENTER);
		labelDocGrad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDocGrad.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDocGrad.setBounds(439, 95, 48, 25);
		panel.add(labelDocGrad);
		
		labelDocPost = new JLabel("MD");
		labelDocPost.setHorizontalAlignment(SwingConstants.CENTER);
		labelDocPost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDocPost.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDocPost.setBounds(491, 95, 35, 25);
		panel.add(labelDocPost);
		
		labelDocDip = new JLabel("Other Diploma");
		labelDocDip.setHorizontalAlignment(SwingConstants.CENTER);
		labelDocDip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDocDip.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDocDip.setBounds(529, 95, 125, 25);
		panel.add(labelDocDip);
		
		comboFormIds = new JComboBox();
		comboFormIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FillReadingForm();
			}
		});
		comboFormIds.setEditable(true);
		comboFormIds.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboFormIds.setBounds(43, 33, 81, 28);
		panel.add(comboFormIds);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblId.setBounds(10, 33, 30, 28);
		panel.add(lblId);
		
		labelFormDate = new JLabel("26-03-2019");
		labelFormDate.setHorizontalAlignment(SwingConstants.CENTER);
		labelFormDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFormDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelFormDate.setBounds(126, 33, 82, 28);
		panel.add(labelFormDate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Test Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_3.setBounds(0, 128, 767, 386);
		getContentPane().add(panel_3);
		
		labelTestExam = new JLabel("TEST EXAMINATION");
		labelTestExam.setHorizontalAlignment(SwingConstants.CENTER);
		labelTestExam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTestExam.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelTestExam.setBounds(213, 11, 307, 28);
		panel_3.add(labelTestExam);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String SQL = null;
					int Count1 = 0;
					int Count2 = 0;
					DBManager dbconn = DBManager.getInstance();
					SQL = "insert into labsoft.tbl_reading_main(reading_date,form_id,form_date,cust_id,cust_name,doc_id,doc_name,test_exam,IsDelivered) values('";
					SQL += labelReadingDate.getText() + "'," + Integer.parseInt(comboFormIds.getSelectedItem().toString()) + ",'" + labelFormDate.getText() + "',";
					SQL += Integer.parseInt(labelCustId.getText()) + ",'" + labelCustName.getText() + "'," + Integer.parseInt(labelDocId.getText()) + ",'";
					SQL += labelDocName.getText() + "','" + labelTestExam.getText() + "',0);";
					Count1 = dbconn.insertRecords(SQL);
					
					MyReadingTableModel model=(MyReadingTableModel)table.getModel();
					int rows = model.getRowCount();
					for (int i = 0; i < rows; i++) {
						SQL = "insert into labsoft.tbl_reading_detail(reading_id,test_id,test_name,test_factor,test_unit,test_min,test_max,test_reading) values(";
						SQL += Integer.parseInt(labelReadingId.getText()) + "," + (int)model.getValueAt(i, 0) + ",'" + model.getValueAt(i, 1).toString() + "','";
						SQL += model.getValueAt(i, 2).toString() + "','" + model.getValueAt(i, 3).toString() + "'," + (int)model.getValueAt(i, 4) + ",";
						SQL += (int)model.getValueAt(i, 5) + "," + (int)model.getValueAt(i, 6) + ");";
						
						Count2 += dbconn.insertRecords(SQL);						
					}
					if (Count1>0 && Count2 > 0) {
						JOptionPane.showMessageDialog(null, " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						SQL = "update labsoft.tbl_form_main set is_active = 0 where form_id = " + (int)comboFormIds.getSelectedItem() + ";";
						int cnt = dbconn.updateRecords(SQL);
						model.clearRowData(7);
						labelTestExam.setText(null);
						labelDocDip.setText(null);
						labelDocPost.setText(null);
						labelDocGrad.setText(null);
						labelDocContact1.setText(null);
						labelDocEmail.setText(null);
						labelDocName.setText(null);
						labelDocId.setText(null);
						labelCustContact1.setText(null);
						labelCustEmail.setText(null);
						labelCustName.setText(null);
						labelCustId.setText(null);
						labelFormDate.setText(null);
						labelReadingDate.setText(null);
						labelReadingId.setText(null);
						comboFormIds.removeAllItems();
						getFormID();
						FillComboFormIds();
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(670, 343, 92, 32);
		panel_3.add(btnSave);
		
		panelReadings = new JPanel();
		panelReadings.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Test Factor Readings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panelReadings.setBounds(0, 35, 767, 307);
		panel_3.add(panelReadings);
		
		String[] col=new String[] {"ID","Test","Factor","Unit","Min","Max","Reading"};
		Object[][] data=new Object[0][7];
		table = new JTable(new MyReadingTableModel(data,col)){
		    private static final long serialVersionUID = 1L;
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		        Component returnComp = super.prepareRenderer(renderer, row, column);
		        Color alternateColor = new Color(252,242,206);
		        Color whiteColor = Color.YELLOW;
		        if (!returnComp.getBackground().equals(getSelectionBackground())){
		            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
		            returnComp .setBackground(bg);
		            bg = null;
		        }
		        return returnComp;
		    }
		};
		table.setForeground(new Color(75,0,130));
		table.setFont(new Font("Tahoma",Font.BOLD,12));
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.black));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(4).setCellRenderer(right);
		table.getColumnModel().getColumn(5).setCellRenderer(right);
		table.getColumnModel().getColumn(6).setCellRenderer(right);
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panelReadings.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panelReadings.setLayout(new BorderLayout(0, 0));
		panelReadings.add(jsp);
		
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		setBounds(5, 20, 783, 542);
		getFormID();
		FillComboFormIds();
		setVisible(true);
	}
	
	private void getFormID()
	{
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastReadingID(?)");
		} catch (Exception e) {
			id = 1;
		}
		labelReadingId.setText(Integer.toString(id));		
		Date now = new Date();  
		String currDateString = dateFormat.format(now);
		labelReadingDate.setText(currDateString);		
	}
	
	private void FillComboFormIds()
	{
		try {
			ArrayList<Integer> formIds=new ArrayList<Integer>();			
			String SQL = "select form_id from labsoft.tbl_form_main where is_active = 1 order by form_id;";
			DBManager dbconn=DBManager.getInstance();
			try {
				ResultSet rs=dbconn.selectRecords(SQL);
				while(rs.next()) {
					formIds.add(rs.getInt(1));
				}
				rs.close();
				rs=null;
				comboFormIds.setModel(new DefaultComboBoxModel(formIds.toArray()));
				comboFormIds.setSelectedIndex(0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void FillReadingForm()
	{
		try {
			int formID = Integer.parseInt(comboFormIds.getSelectedItem().toString());
			String SQL = "select form_date from labsoft.tbl_form_main where form_id = "+formID+";";
			DBManager dbconn = DBManager.getInstance();
			try {
				ResultSet rs=dbconn.selectRecords(SQL);
				if(rs.next()) {
					labelFormDate.setText(rs.getString(1).toString());
				}
				else
				{
					Date now = new Date();  
					String currDateString = dateFormat.format(now);
					labelFormDate.setText(currDateString);
				}
				rs.close();
				rs=null;
				
				SQL = "select pat_id,pat_name,pat_email,pat_contact from labsoft.tbl_form_main where form_id = "+formID+";";
				rs = dbconn.selectRecords(SQL);
				if(rs.next()) {
					labelCustId.setText(String.valueOf(rs.getInt(1)));
					labelCustName.setText(rs.getString(2));
					labelCustEmail.setText(rs.getString(3));
					labelCustContact1.setText(String.valueOf(rs.getLong(4)));
				}
				rs.close();
				rs = null;
				
				int docID = 1;
				SQL = "select doc_id from labsoft.tbl_form_main where form_id = "+formID+";";
				rs = dbconn.selectRecords(SQL);
				if(rs.next()) {
					docID = Integer.parseInt(String.valueOf(rs.getInt(1)));
					SQL = "select doc_name, doc_email, doc_contact1, doc_graduation, doc_pg, doc_other_edu from labsoft.tab_doctors_info where doc_id = " + docID + ";";
					rs = dbconn.selectRecords(SQL);
					if(rs.next()) {
						labelDocId.setText(String.valueOf(docID));
						labelDocName.setText(rs.getString(1));
						labelDocEmail.setText(rs.getString(2));
						labelDocContact1.setText(String.valueOf(rs.getLong(3)));
						labelDocGrad.setText(rs.getString(4));
						labelDocPost.setText(rs.getString(5));
						labelDocDip.setText(rs.getString(6));
					}
					rs.close();
					rs = null;
				}
							
				SQL = "select test_exam from labsoft.tbl_form_details where form_id = " + formID +" limit 1;";
				rs = dbconn.selectRecords(SQL);
				if(rs.next()) {
					labelTestExam.setText(rs.getString(1));
				}
				rs.close();
				rs =null;
				
				SQL = "select test_id,test_name,test_factor from labsoft.tbl_form_details where form_id = " + formID +";";
				rs = dbconn.selectRecords(SQL);
				while(rs.next()) {
					int test_id = rs.getInt(1);
					String test_name = rs.getString(2);
					String test_factor = rs.getString(3);
					String sql1 = "select factor_unit,factor_min,factor_max from labsoft.tbl_test_factors where test_id = " + test_id + " and factor_name = '" + test_factor + "';";
					ResultSet rs1 = dbconn.selectRecords(sql1);
					if(rs1.next()) {
						String factor_unit = rs1.getString(1);
						int factor_min = rs1.getInt(2);
						int factor_max = rs1.getInt(3);
						
						MyReadingTableModel model=(MyReadingTableModel)table.getModel();
						model.addRow(test_id, test_name, test_factor, factor_unit, factor_min, factor_max,0);
						table.revalidate(); 
				        table.repaint();
					}					
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
