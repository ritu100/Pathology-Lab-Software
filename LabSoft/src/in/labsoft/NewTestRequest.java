package in.labsoft;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DesktopManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NewTestRequest extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField formID;
	private JTextField patName;
	private JTextField docName;
	private JComboBox testName;
	private JLabel patID;
	private JLabel patEmail;
	private JLabel patContact1;
	private JLabel patContact2;
	private JLabel patAge;
	private JLabel patFamilyDoc;
	private JLabel patIssue;
	private JLabel docID;
	private JLabel docEmail;
	private JLabel docContact1;
	private JLabel docContact2;
	private JLabel docGrad;
	private JLabel docPG;
	private JLabel docDiploma;
	private JLabel testID;
	private JLabel testCat;
	private JLabel testSubCat;
	private JLabel testExam;
	private JPanel panelTab1;
	private JButton btnAdd;
	private JButton btnAddAll;
	private JButton btnRemove;
	private JButton btnRemoveAll;
	private JPanel panelTab2;
	private JButton btnExit;
	private JButton btnSave;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private DateFormat dateFormat;
	private JTextField formDate;
	private JTable table1,table2;
	private JScrollPane jsp1,jsp2;
	public NewTestRequest(JDesktopPane jp) 
	{
		super("Customer : New Request for Test",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Test Request Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel1.setBounds(10, 11, 747, 46);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel label = new JLabel(" Form ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBorder(null);
		label.setBounds(10, 15, 57, 25);
		panel1.add(label);
		
		formID = new JTextField();
		formID.setText("1");
		formID.setEditable(false);
		formID.setHorizontalAlignment(SwingConstants.CENTER);
		formID.setFont(new Font("Tahoma", Font.BOLD, 12));
		formID.setBounds(66, 15, 57, 25);
		panel1.add(formID);
		formID.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBorder(null);
		lblDate.setBounds(558, 15, 43, 25);
		panel1.add(lblDate);
		
		JLabel lblPallaviPathologicalLaboratory = new JLabel("PALLAVI PATHOLOGICAL LABORATORY, NASHIK");
		lblPallaviPathologicalLaboratory.setForeground(new Color(72, 61, 139));
		lblPallaviPathologicalLaboratory.setHorizontalAlignment(SwingConstants.CENTER);
		lblPallaviPathologicalLaboratory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPallaviPathologicalLaboratory.setBorder(new LineBorder(new Color(0, 0, 139)));
		lblPallaviPathologicalLaboratory.setBounds(133, 15, 431, 25);
		panel1.add(lblPallaviPathologicalLaboratory);
		
		formDate = new JTextField();
		formDate.setHorizontalAlignment(SwingConstants.CENTER);
		formDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		formDate.setEditable(false);
		formDate.setColumns(10);
		formDate.setBounds(611, 15, 126, 25);
		panel1.add(formDate);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Patients Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel2.setBounds(10, 60, 747, 46);
		getContentPane().add(panel2);
		
		patName = new JTextField();
		patName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = null;
				DBManager dbconn=DBManager.getInstance();
				try {
					SQL = "select p_id,p_name,p_email,p_contact1,p_contact2,p_age,p_issue,p_familydoc from labsoft.tab_patients_info where p_name like '%" + patName.getText() + "%';";
					ResultSet rs = dbconn.selectRecords(SQL);
					if (rs.next()) {
						patID.setText(String.valueOf(rs.getInt(1)));
						patName.setText(rs.getString(2));
						patEmail.setText(rs.getString(3));
						patContact1.setText(String.valueOf(rs.getLong(4)));
						patContact2.setText(String.valueOf(rs.getLong(5)));
						patAge.setText(String.valueOf(rs.getInt(6)));
						patIssue.setText(rs.getString(7));
						patFamilyDoc.setText(rs.getString(8));
						patName.setEditable(false);
						docName.setEditable(true);
						docName.requestFocus();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Patients Record Not Present In Database...\nPlease First Register the Patient...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						patName.setText(null);
						patName.requestFocus();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Can't retrieve record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					patName.setText(null);
					patName.requestFocus();
				}
			}
		});
		patName.setFont(new Font("Tahoma", Font.BOLD, 12));
		patName.setColumns(10);
		patName.setBounds(10, 15, 165, 25);
		panel2.add(patName);
		
		patID = new JLabel("1");
		patID.setHorizontalAlignment(SwingConstants.CENTER);
		patID.setFont(new Font("Tahoma", Font.BOLD, 12));
		patID.setBorder(new LineBorder(new Color(0, 0, 0)));
		patID.setBounds(178, 15, 30, 25);
		panel2.add(patID);
		
		patEmail = new JLabel("customer@gmail.com");
		patEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		patEmail.setBounds(211, 15, 140, 25);
		panel2.add(patEmail);
		
		patContact1 = new JLabel("9689925884");
		patContact1.setHorizontalAlignment(SwingConstants.RIGHT);
		patContact1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patContact1.setBorder(new LineBorder(new Color(0, 0, 0)));
		patContact1.setBounds(354, 15, 81, 25);
		panel2.add(patContact1);
		
		patAge = new JLabel("35");
		patAge.setHorizontalAlignment(SwingConstants.CENTER);
		patAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patAge.setBorder(new LineBorder(new Color(0, 0, 0)));
		patAge.setBounds(522, 15, 30, 25);
		panel2.add(patAge);
		
		patContact2 = new JLabel("9422474233");
		patContact2.setHorizontalAlignment(SwingConstants.RIGHT);
		patContact2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patContact2.setBorder(new LineBorder(new Color(0, 0, 0)));
		patContact2.setBounds(438, 15, 81, 25);
		panel2.add(patContact2);
		
		patFamilyDoc = new JLabel("Dr. Jay Patil");
		patFamilyDoc.setHorizontalAlignment(SwingConstants.LEFT);
		patFamilyDoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patFamilyDoc.setBorder(new LineBorder(new Color(0, 0, 0)));
		patFamilyDoc.setBounds(638, 15, 99, 25);
		panel2.add(patFamilyDoc);
		
		patIssue = new JLabel("Issue");
		patIssue.setHorizontalAlignment(SwingConstants.LEFT);
		patIssue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patIssue.setBorder(new LineBorder(new Color(0, 0, 0)));
		patIssue.setBounds(555, 15, 80, 25);
		panel2.add(patIssue);
		
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Doctor Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel3.setBounds(10, 109, 747, 46);
		getContentPane().add(panel3);
		
		docName = new JTextField();
		docName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = null;
				DBManager dbconn=DBManager.getInstance();
				try {
					SQL = "select doc_id,doc_name,doc_email,doc_contact1,doc_contact2,doc_graduation,doc_pg,doc_other_edu from labsoft.tab_doctors_info where doc_name like '%" + docName.getText() + "%';";
					ResultSet rs = dbconn.selectRecords(SQL);
					if (rs.next()) {
						docID.setText(String.valueOf(rs.getInt(1)));
						docName.setText(rs.getString(2));
						docEmail.setText(rs.getString(3));
						docContact1.setText(String.valueOf(rs.getLong(4)));
						docContact2.setText(String.valueOf(rs.getLong(5)));
						docGrad.setText(rs.getString(6));
						docPG.setText(rs.getString(7));
						docDiploma.setText(rs.getString(8));
						docName.setEditable(false);
						fillTestName();
						testName.setEnabled(true);
						testName.requestFocus();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Doctors Record Not Present In Database...\nPlease First Register the Doctor...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						docName.setText(null);
						docName.requestFocus();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Can't retrieve record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					docName.setText(null);
					docName.requestFocus();
				}
			}
		});
		docName.setFont(new Font("Tahoma", Font.BOLD, 12));
		docName.setColumns(10);
		docName.setBounds(10, 15, 165, 25);
		panel3.add(docName);
		
		docID = new JLabel("1");
		docID.setHorizontalAlignment(SwingConstants.CENTER);
		docID.setFont(new Font("Tahoma", Font.BOLD, 12));
		docID.setBorder(new LineBorder(new Color(0, 0, 0)));
		docID.setBounds(178, 15, 30, 25);
		panel3.add(docID);
		
		docEmail = new JLabel("doctor@gmail.com");
		docEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		docEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		docEmail.setBounds(211, 15, 140, 25);
		panel3.add(docEmail);
		
		docContact1 = new JLabel("9689925884");
		docContact1.setHorizontalAlignment(SwingConstants.RIGHT);
		docContact1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		docContact1.setBorder(new LineBorder(new Color(0, 0, 0)));
		docContact1.setBounds(354, 15, 81, 25);
		panel3.add(docContact1);
		
		docContact2 = new JLabel("9422474233");
		docContact2.setHorizontalAlignment(SwingConstants.RIGHT);
		docContact2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		docContact2.setBorder(new LineBorder(new Color(0, 0, 0)));
		docContact2.setBounds(438, 15, 81, 25);
		panel3.add(docContact2);
		
		docGrad = new JLabel("MBBS");
		docGrad.setHorizontalAlignment(SwingConstants.CENTER);
		docGrad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		docGrad.setBorder(new LineBorder(new Color(0, 0, 0)));
		docGrad.setBounds(522, 15, 48, 25);
		panel3.add(docGrad);
		
		docPG = new JLabel("MD");
		docPG.setHorizontalAlignment(SwingConstants.CENTER);
		docPG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		docPG.setBorder(new LineBorder(new Color(0, 0, 0)));
		docPG.setBounds(574, 15, 35, 25);
		panel3.add(docPG);
		
		docDiploma = new JLabel("Other Diploma");
		docDiploma.setHorizontalAlignment(SwingConstants.CENTER);
		docDiploma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		docDiploma.setBorder(new LineBorder(new Color(0, 0, 0)));
		docDiploma.setBounds(612, 15, 125, 25);
		panel3.add(docDiploma);
		
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Test Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel4.setBounds(10, 158, 747, 55);
		getContentPane().add(panel4);
		
		testName = new JComboBox();
		testName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = null;
				DBManager dbconn=DBManager.getInstance();
				if (!testName.getSelectedItem().toString().equals("None")) {
					try {
						SQL = "select test_id,test_category,test_subcat,test_exam from labsoft.tbl_major_tests where test_name = '" + testName.getSelectedItem().toString() + "';";
						ResultSet rs = dbconn.selectRecords(SQL);
						if (rs.next()) {
							testID.setText(String.valueOf(rs.getInt(1)));
							testCat.setText(rs.getString(2));
							testSubCat.setText(rs.getString(3));
							testExam.setText(rs.getString(4));
							
							try {
								MyTableModel model=(MyTableModel)table1.getModel();
								model.clearRowData(1);
								String SQL1 = "select factor_name from labsoft.tbl_test_factors where test_name = '" + testName.getSelectedItem().toString() + "';";
								ResultSet rs1 = dbconn.selectRecords(SQL1);
								if (rs1.next()) {
									do{
										model.addRow(rs1.getString(1));
									}while(rs1.next()); 	
									table1.revalidate(); 
							        table1.repaint();
								}	
								else {
									JOptionPane.showMessageDialog(null, "Factors are not available for perticular test...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
								}									
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Factors are not available for perticular test...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							}
							
							btnAdd.setEnabled(true);
							btnAddAll.setEnabled(true);
							btnRemove.setEnabled(true);
							btnRemoveAll.setEnabled(true);
							btnAdd.requestFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Test Record Not Present In Database...\nPlease First Register the Test...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							testName.setSelectedIndex(0);;
							testName.requestFocus();
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
						testName.setSelectedIndex(0);;
						testName.requestFocus();
					}
				}
			}
		});
		testName.setFont(new Font("Tahoma", Font.BOLD, 12));
		testName.setBounds(10, 15, 165, 28);
		panel4.add(testName);
		
		testCat = new JLabel("Category");
		testCat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testCat.setBorder(new LineBorder(new Color(0, 0, 0)));
		testCat.setBounds(212, 15, 165, 28);
		panel4.add(testCat);
		
		testSubCat = new JLabel("Sub-Category");
		testSubCat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testSubCat.setBorder(new LineBorder(new Color(0, 0, 0)));
		testSubCat.setBounds(381, 15, 159, 28);
		panel4.add(testSubCat);
		
		testExam = new JLabel("Examinition Type");
		testExam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testExam.setBorder(new LineBorder(new Color(0, 0, 0)));
		testExam.setBounds(545, 15, 192, 28);
		panel4.add(testExam);
		
		testID = new JLabel("1");
		testID.setHorizontalAlignment(SwingConstants.CENTER);
		testID.setFont(new Font("Tahoma", Font.BOLD, 12));
		testID.setBorder(new LineBorder(new Color(0, 0, 0)));
		testID.setBounds(178, 15, 30, 28);
		panel4.add(testID);
		
		panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Select Factors to Test", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel5.setBounds(10, 215, 747, 232);
		getContentPane().add(panel5);
		
		panelTab1 = new JPanel();
		panelTab1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTab1.setBounds(10, 21, 328, 200);
		panel5.add(panelTab1);
		panelTab1.setLayout(new BorderLayout(0, 0));
		
		String[] col1=new String[] {"Select Test Factors"};
		Object[][] data1=new Object[0][1];
		table1 = new JTable(new MyTableModel(data1,col1)){
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
		table1.setForeground(Color.BLACK);
		table1.setShowHorizontalLines(true);
		table1.setShowVerticalLines(true);
		table1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table1.setBorder(new LineBorder(Color.GREEN));
		table1.getColumnModel().getColumn(0).setPreferredWidth(300);
		DefaultTableCellRenderer cRenderer = new DefaultTableCellRenderer();
		cRenderer.setHorizontalAlignment(SwingConstants.LEADING);
		table1.getColumnModel().getColumn(0).setCellRenderer(cRenderer);
		table1.setFillsViewportHeight(true);
		jsp1=new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table1.getTableHeader().setBackground(Color.WHITE);
		table1.getTableHeader().setForeground(new Color(75,0,130));
		table1.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panelTab1.add(table1.getTableHeader(), BorderLayout.PAGE_START);
		panelTab1.add(jsp1);
		
		panelTab2 = new JPanel();
		panelTab2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTab2.setBounds(405, 21, 332, 200);
		panel5.add(panelTab2);
		panelTab2.setLayout(new BorderLayout(0, 0));
		
		String[] col2=new String[] {"Selected Test Factors"};
		Object[][] data2=new Object[0][1];
		table2 = new JTable(new MyTableModel(data2,col2)){
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
		table2.setForeground(Color.BLACK);
		table2.setShowHorizontalLines(true);
		table2.setShowVerticalLines(true);
		table2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table2.setBorder(new LineBorder(Color.GREEN));
		table2.getColumnModel().getColumn(0).setPreferredWidth(300);
		DefaultTableCellRenderer lRenderer = new DefaultTableCellRenderer();
		lRenderer.setHorizontalAlignment(SwingConstants.LEADING);
		table2.getColumnModel().getColumn(0).setCellRenderer(lRenderer);
		table2.setFillsViewportHeight(true);
		jsp2=new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table2.getTableHeader().setBackground(Color.WHITE);
		table2.getTableHeader().setForeground(new Color(75,0,130));
		table2.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panelTab2.add(table2.getTableHeader(), BorderLayout.PAGE_START);
		panelTab2.add(jsp2);
		
		btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MyTableModel model1 = (MyTableModel)table1.getModel();
					MyTableModel model2 = (MyTableModel)table2.getModel();
					int [] selectedRows = table1.getSelectedRows();
					for (int i : selectedRows) {
						model2.addRow(model1.getValueAt(i, 0).toString());
					}
					if (!btnSave.isEnabled()) {
						btnSave.setEnabled(true);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select the row first then click here...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setToolTipText("Add Single Factor");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAdd.setIcon(new ImageIcon(NewTestRequest.class.getResource("/img/left_panel/ico_26.png")));
		btnAdd.setBounds(348, 21, 47, 33);
		panel5.add(btnAdd);
		
		btnAddAll = new JButton("");
		btnAddAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MyTableModel model1 = (MyTableModel)table1.getModel();
					MyTableModel model2 = (MyTableModel)table2.getModel();
					int rowCount = table1.getRowCount();
					for (int i=0;i<rowCount;i++) {
						model2.addRow(model1.getValueAt(i, 0).toString());
					}
					if (!btnSave.isEnabled()) {
						btnSave.setEnabled(true);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Please select the row first then click here...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddAll.setToolTipText("Add All Factors");
		btnAddAll.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddAll.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAddAll.setIcon(new ImageIcon(NewTestRequest.class.getResource("/img/left_panel/ico_21.png")));
		btnAddAll.setBounds(348, 65, 47, 33);
		panel5.add(btnAddAll);
		
		btnRemove = new JButton("");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MyTableModel model1 = (MyTableModel)table2.getModel();
					int [] selectedRows = table2.getSelectedRows();
					for (int i : selectedRows) {
						model1.removeRow(i,1);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Please select the row first then click here...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemove.setToolTipText("Remove Single Factor");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.setIcon(new ImageIcon(NewTestRequest.class.getResource("/img/left_panel/ico_29.png")));
		btnRemove.setBounds(348, 109, 47, 33);
		panel5.add(btnRemove);
		
		btnRemoveAll = new JButton("");
		btnRemoveAll.setToolTipText("Remove All Factors");
		btnRemoveAll.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveAll.setIcon(new ImageIcon(NewTestRequest.class.getResource("/img/left_panel/ico_20.png")));
		btnRemoveAll.setBounds(348, 153, 47, 33);
		panel5.add(btnRemoveAll);
		
		panel6 = new JPanel();
		panel6.setBorder(new LineBorder(Color.MAGENTA));
		panel6.setBounds(10, 448, 747, 54);
		getContentPane().add(panel6);
		panel6.setLayout(null);
		
		btnSave = new JButton("SAVE TEST");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String SQL1, SQL2;
					int fid = Integer.parseInt(formID.getText());
					String fdate = formDate.getText();
					int pid = Integer.parseInt(patID.getText());
					String pname = patName.getText();
					String pmail = patEmail.getText();
					long pcontact = Long.parseLong(patContact1.getText());
					int page = Integer.parseInt(patAge.getText());
					int did = Integer.parseInt(docID.getText());
					String dname = docName.getText();
					
					int tid = Integer.parseInt(testID.getText());
					String tname = testName.getSelectedItem().toString();
					String tcat = testCat.getText();
					String tsubcat = testSubCat.getText();
					String texam = testExam.getText();
					
					MyTableModel model = (MyTableModel)table2.getModel();
					int rows = model.getRowCount();
					
					DBManager dbconn=DBManager.getInstance();
					
					int Count=0,Count1 = 0;
					for (int i = 0; i < rows; i++) {
						SQL2 = "insert into labsoft.tbl_form_details values(" + fid + "," + tid + ",'" + tname + "','" + tcat + "','" + tsubcat + "','" + texam + "','" +
							   "" + model.getValueAt(i, 0).toString() + "');";
						Count1 += dbconn.insertRecords(SQL2);
						SQL2=null;
					}
					if (Count1 > 0) {
						SQL1 = "insert into labsoft.tbl_form_main(form_date, pat_id, pat_name, pat_email, pat_contact, pat_age, doc_id, doc_name) values('" +
								"" + fdate + "'," + pid + ",'" + pname + "','" + pmail + "'," + pcontact + "," + page + "," + did + ",'" + dname + "');";
						Count = dbconn.insertRecords(SQL1);
						SQL1 = null;
					}
					if (Count > 0 && Count1 > 0) {
						JOptionPane.showMessageDialog(null, "Test Entry Saved Successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Unable to save test...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Unable to save test...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
				btnSave.setEnabled(false);
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(446, 11, 291, 32);
		panel6.add(btnSave);
		
		btnExit = new JButton("EXIT FORM");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame frames[] = jdp.getAllFrames();
				DesktopManager dm = jdp.getDesktopManager();
				for (int i = 0 ; i < frames.length ; i ++){
					dm.closeFrame(frames[i]);
					try {
						frames[i].setClosed(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				jdp.revalidate();
				jdp.repaint();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(10, 11, 273, 32);
		panel6.add(btnExit);
		setBounds(5, 20, 783, 542);
		setVisible(true);
		getFormID();
	}
	
	private void getFormID()
	{
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastFormID(?)");
		} catch (Exception e) {
			id = 1;
		}
		formID.setText(Integer.toString(id));
		disableComponents();
		Date now = new Date();  
		String currDateString = dateFormat.format(now);
		formDate.setText(currDateString);
		patName.setEditable(true);
		patName.requestFocus();
	}
	
	private void disableComponents()
	{
		docName.setEditable(false);
		testName.setEnabled(false);
		btnAdd.setEnabled(false);
		btnAddAll.setEnabled(false);
		btnRemove.setEnabled(false);
		btnRemoveAll.setEnabled(false);
		btnSave.setEnabled(false);
	}
	
	private void fillTestName()
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
			testName.setModel(new DefaultComboBoxModel(testNames.toArray()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
}
