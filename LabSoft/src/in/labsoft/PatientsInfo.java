package in.labsoft;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DesktopManager;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class PatientsInfo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_9;
	private JTextField textField_8;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNew;
	private JButton btnEdit;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnSelect;
	private JButton btnExit;
	private JTable table;
	private JScrollPane jsp;

	/**
	 * Create the frame.
	 */
	public PatientsInfo(JDesktopPane jp) {
		setIconifiable(true);
		setBackground(Color.BLACK);
		this.jdp=jp;
		setClosable(true);
		setTitle("Patients Information");
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBorder(new LineBorder(Color.GREEN));
		panel_1.setBounds(10, 11, 390, 411);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setForeground(Color.YELLOW);
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatientId.setBorder(new LineBorder(Color.MAGENTA));
		lblPatientId.setBounds(10, 11, 107, 24);
		panel_1.add(lblPatientId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.YELLOW);
		textField.setColumns(10);
		textField.setBounds(127, 11, 86, 24);
		panel_1.add(textField);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setForeground(Color.YELLOW);
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatientName.setBorder(new LineBorder(Color.MAGENTA));
		lblPatientName.setBounds(10, 41, 107, 24);
		panel_1.add(lblPatientName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(75, 0, 130));
		textField_1.setColumns(10);
		textField_1.setBounds(127, 41, 246, 24);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(Color.MAGENTA));
		label_2.setBounds(10, 70, 107, 24);
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(75, 0, 130));
		textField_2.setColumns(10);
		textField_2.setBounds(127, 70, 246, 24);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(75, 0, 130));
		textField_3.setColumns(10);
		textField_3.setBounds(127, 99, 246, 24);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(75, 0, 130));
		textField_4.setColumns(10);
		textField_4.setBounds(127, 128, 246, 24);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(75, 0, 130));
		textField_5.setColumns(10);
		textField_5.setBounds(127, 156, 246, 24);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(75, 0, 130));
		textField_6.setColumns(10);
		textField_6.setBounds(127, 184, 246, 24);
		panel_1.add(textField_6);
		
		JLabel label_3 = new JLabel("Email ID");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBorder(new LineBorder(Color.MAGENTA));
		label_3.setBounds(10, 155, 107, 24);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Contact");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBorder(new LineBorder(Color.MAGENTA));
		label_4.setBounds(10, 183, 107, 24);
		panel_1.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(75, 0, 130));
		textField_7.setColumns(10);
		textField_7.setBounds(127, 213, 246, 24);
		panel_1.add(textField_7);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setForeground(Color.YELLOW);
		lblOccupation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOccupation.setBorder(new LineBorder(Color.MAGENTA));
		lblOccupation.setBounds(10, 244, 107, 24);
		panel_1.add(lblOccupation);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.YELLOW);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBorder(new LineBorder(Color.MAGENTA));
		lblDateOfBirth.setBounds(10, 275, 107, 24);
		panel_1.add(lblDateOfBirth);
		
		JLabel lblMajorIssue = new JLabel("Major Issue");
		lblMajorIssue.setForeground(Color.YELLOW);
		lblMajorIssue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMajorIssue.setBorder(new LineBorder(Color.MAGENTA));
		lblMajorIssue.setBounds(10, 305, 107, 24);
		panel_1.add(lblMajorIssue);
		
		JLabel lblFamilyDoctor = new JLabel("Family Doctor");
		lblFamilyDoctor.setForeground(Color.YELLOW);
		lblFamilyDoctor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFamilyDoctor.setBorder(new LineBorder(Color.MAGENTA));
		lblFamilyDoctor.setBounds(10, 336, 107, 24);
		panel_1.add(lblFamilyDoctor);
		
		textField_10 = new JTextField();
		textField_10.setForeground(new Color(75, 0, 130));
		textField_10.setColumns(10);
		textField_10.setBounds(127, 366, 246, 24);
		panel_1.add(textField_10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setForeground(Color.YELLOW);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBorder(new LineBorder(Color.MAGENTA));
		lblAge.setBounds(286, 274, 32, 24);
		panel_1.add(lblAge);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBackground(Color.BLACK);
		textField_9.setForeground(Color.YELLOW);
		textField_9.setColumns(10);
		textField_9.setBounds(328, 274, 45, 24);
		panel_1.add(textField_9);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(75, 0, 130));
		comboBox.setBounds(127, 305, 191, 24);
		panel_1.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(75, 0, 130));
		comboBox_1.setBounds(127, 336, 246, 24);
		panel_1.add(comboBox_1);
		
		dateChooser = new JDateChooser();
		dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
		    public void propertyChange(PropertyChangeEvent evt) {
		        Calendar dateofBirth = Calendar.getInstance();
		        dateofBirth.setTime((Date)evt.getNewValue());

		        Calendar today = Calendar.getInstance();
		        int age = today.get(Calendar.YEAR) - dateofBirth.get(Calendar.YEAR);

		        if(today.get(Calendar.MONTH) < dateofBirth.get(Calendar.MONTH) ||
		          (today.get(Calendar.MONTH) == dateofBirth.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dateofBirth.get(Calendar.DAY_OF_MONTH))) {                    
		            age--;
		        }

		        textField_9.setText(String.valueOf(age));
		    }
		});
		dateChooser.setForeground(new Color(75, 0, 130));
		dateChooser.setBounds(127, 274, 149, 24);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		panel_1.add(dateChooser);
		
		JLabel lblOtherDetails = new JLabel("Other Details");
		lblOtherDetails.setForeground(Color.YELLOW);
		lblOtherDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtherDetails.setBorder(new LineBorder(Color.MAGENTA));
		lblOtherDetails.setBounds(10, 366, 107, 24);
		panel_1.add(lblOtherDetails);
		
		textField_8 = new JTextField();
		textField_8.setForeground(new Color(75, 0, 130));
		textField_8.setColumns(10);
		textField_8.setBounds(127, 243, 246, 24);
		panel_1.add(textField_8);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(null);
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(375, 41, 14, 24);
		panel_1.add(label_1);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBorder(null);
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(375, 156, 14, 24);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBorder(null);
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(375, 184, 14, 24);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("* fields are compulsory");
		label_7.setHorizontalTextPosition(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_7.setBorder(null);
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(127, 392, 246, 12);
		panel_1.add(label_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.GREEN));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(407, 11, 275, 411);
		getContentPane().add(panel_2);
		
		JLabel lblPatientsList = new JLabel("Patients List");
		lblPatientsList.setSize(new Dimension(255, 30));
		lblPatientsList.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientsList.setForeground(Color.RED);
		lblPatientsList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatientsList.setBorder(new LineBorder(Color.MAGENTA));
		lblPatientsList.setBounds(10, 11, 255, 30);
		panel_2.add(lblPatientsList);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBorder(new LineBorder(Color.MAGENTA));
		panel_3.setBounds(10, 45, 255, 356);
		panel_2.add(panel_3);
		
		String[] col=new String[] {"ID","Name"};
		Object[][] data=getTableData();
		table = new JTable(new MyTableModel(data,col)){
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
		table.setForeground(Color.BLACK);
		table.setBackground(Color.BLACK);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.GREEN));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            getSinglePatDetails();
		        }
		        else if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		        	btnSelect.setEnabled(true);
		        }
		    }
		});
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel_3.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(jsp);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 255, 0)));
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 430, 390, 50);
		getContentPane().add(panel);
		
		btnNew = new JButton("NEW");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getNewID();
				btnNew.setEnabled(false);
				btnEdit.setEnabled(false);
				btnSave.setEnabled(true);
			}
		});
		btnNew.setBackground(SystemColor.control);
		btnNew.setForeground(Color.MAGENTA);
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNew.setBorder(new LineBorder(Color.BLUE));
		btnNew.setBounds(10, 11, 74, 28);
		panel.add(btnNew);
		
		btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEditing(true);
				btnNew.setEnabled(false);
				btnEdit.setEnabled(false);
				btnSave.setEnabled(true);
			}
		});
		btnEdit.setBackground(SystemColor.control);
		btnEdit.setForeground(Color.MAGENTA);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setEnabled(false);
		btnEdit.setBorder(new LineBorder(Color.BLUE));
		btnEdit.setBounds(94, 11, 81, 28);
		panel.add(btnEdit);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool = checkTextFields();
				if (bool) {
					String id = textField.getText();
					String name = textField_1.getText();
					String add1 = textField_2.getText();
					String add2 = textField_3.getText();
					String add3 = textField_4.getText();
					String email = textField_5.getText();
					String contact1 = textField_6.getText();					
					String contact2 = textField_7.getText();
					String ocp = textField_8.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
				    String dob = sdf.format(dateChooser.getDate());
					String age = textField_9.getText();
					String issue = comboBox.getSelectedItem().toString();
					String familydoc = comboBox_1.getSelectedItem().toString();
					String other = textField_10.getText();
					
					ArrayList<String> al=new ArrayList<String>();
					al.add(name);
					al.add(add1);
					al.add(add2);
					al.add(add3);
					al.add(email);
					al.add(contact1);
					al.add(contact2);
					al.add(ocp);
					al.add(dob);
					al.add(age);
					al.add(issue);
					al.add(familydoc);
					al.add(other);
					
					int cnt = 0;
					DBManager dbconn=DBManager.getInstance();
					try {
						cnt = dbconn.insertPatDetails(al);
						if (cnt>0) {
							JOptionPane.showMessageDialog(null, cnt + "Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							MyTableModel model=(MyTableModel)table.getModel();
							model.addRow(id, name);
							table.revalidate(); 
					        table.repaint();
					        clearFields(false);
					        btnNew.setEnabled(true);
							btnEdit.setEnabled(false);
							btnSave.setEnabled(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							clearFields(false);
							btnNew.setEnabled(true);
							btnEdit.setEnabled(false);
							btnSave.setEnabled(false);
						}
					} catch (Exception ev) {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						clearFields(false);
						btnNew.setEnabled(true);
						btnEdit.setEnabled(false);
						btnSave.setEnabled(false);
					}
				}				
			}
		});
		btnSave.setBackground(SystemColor.control);
		btnSave.setForeground(Color.MAGENTA);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setEnabled(false);
		btnSave.setBorder(new LineBorder(Color.BLUE));
		btnSave.setBounds(185, 11, 86, 28);
		panel.add(btnSave);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields(false);
				btnNew.setEnabled(true);
				btnEdit.setEnabled(false);
				btnSave.setEnabled(false);
				btnSelect.setEnabled(false);
			}
		});
		btnCancel.setBackground(SystemColor.control);
		btnCancel.setForeground(Color.MAGENTA);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBorder(new LineBorder(Color.BLUE));
		btnCancel.setBounds(281, 11, 92, 28);
		panel.add(btnCancel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GREEN));
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(407, 430, 275, 50);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSinglePatDetails();
			}
		});
		btnSelect.setBackground(SystemColor.control);
		btnSelect.setForeground(Color.MAGENTA);
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelect.setEnabled(false);
		btnSelect.setBorder(new LineBorder(Color.BLUE));
		btnSelect.setBounds(10, 11, 120, 28);
		panel_4.add(btnSelect);
		
		btnExit = new JButton("EXIT");
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
		btnExit.setBackground(SystemColor.control);
		btnExit.setForeground(Color.MAGENTA);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBorder(new LineBorder(Color.BLUE));
		btnExit.setBounds(140, 11, 125, 28);
		panel_4.add(btnExit);
		
		textField_9.setEnabled(false);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String issue=JOptionPane.showInputDialog(null, "Please Enter Major Medical Problem...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
				if (issue != null && !(issue.isEmpty())) {
					DBManager dbconn=DBManager.getInstance();
					try {
						int cnt = dbconn.setIssues(issue);
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "Issue Added Successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							comboBox.removeAllItems();
							ArrayList<String> issues=new ArrayList<String>();
							ResultSet rs=dbconn.getAllIssues();
							while(rs.next()) {
								issues.add(rs.getString("issue_name"));
							}
							rs.close();
							rs=null;
							comboBox.setModel(new DefaultComboBoxModel(issues.toArray()));
						}else {
							JOptionPane.showMessageDialog(null, "Can't add new issue...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAdd.setForeground(Color.MAGENTA);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdd.setBorder(new LineBorder(Color.CYAN));
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(321, 305, 52, 24);
		panel_1.add(btnAdd);
		
		formLoad();
		btnSelect.setEnabled(false);
		btnEdit.setEnabled(false);
		btnSave.setEnabled(false);
		clearFields(false);
		setBounds(20,20,705,523);
		setVisible(true);
	}
	
	private void clearFields(boolean flag) {
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		textField_6.setText(null);
		textField_7.setText(null);
		textField_8.setText(null);
		textField_9.setText(null);
		textField_10.setText(null);
		dateChooser.setDate(new Date());
		comboBox.setSelectedIndex(-1);
		comboBox_1.setSelectedIndex(-1);
		setEditing(flag);
	}
	
	private void setEditing(boolean flag) {
		textField_1.setEnabled(flag);
		textField_2.setEnabled(flag);
		textField_3.setEnabled(flag);
		textField_4.setEnabled(flag);
		textField_5.setEnabled(flag);
		textField_6.setEnabled(flag);
		textField_7.setEnabled(flag);
		textField_8.setEnabled(flag);
		textField_10.setEnabled(flag);
		dateChooser.setEnabled(flag);
		comboBox.setEnabled(flag);
		comboBox_1.setEnabled(flag);
		if (flag) {
			textField_1.requestFocusInWindow();
		}
	}
	
	private Object[][] getTableData(){
		Object[][] temp=null;
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.getPatNames();
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			temp=new Object[rows][2];
			int i=0;
			while(rs.next()) {
				temp[i][0]=rs.getObject("p_id");
				temp[i][1]=rs.getObject("p_name");
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Patients List", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return temp;
	}
	
	private void formLoad() {
		ArrayList<String> issues=new ArrayList<String>();
		ArrayList<String> docs=new ArrayList<String>();
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.getAllIssues();
			while(rs.next()) {
				issues.add(rs.getString("issue_name"));
			}
			rs.close();
			rs=null;
			rs = dbconn.getAllDoctors();
			while(rs.next()) {
				docs.add(rs.getString("doc_name"));
			}
			rs.close();
			rs=null;
			comboBox.setModel(new DefaultComboBoxModel(issues.toArray()));
			comboBox_1.setModel(new DefaultComboBoxModel(docs.toArray()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void getNewID() {
		int id=1;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastPatID(?)");
		} catch (Exception e) {
			id = 1;
		}
		clearFields(true);
		textField.setText(Integer.toString(id));
	}
	
	private boolean checkTextFields() {
		if (textField_1.getText().equals(null) || textField_1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Patients Name", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			textField_1.setText("");
			textField_1.requestFocusInWindow();
			return false;
		}
		if (!validEmail(textField_5.getText())) {
			JOptionPane.showMessageDialog(null,"Please Enter Valid Email ID",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			textField_5.setText("");
			textField_5.requestFocusInWindow();
			return false;
		}
		if (!isInteger(textField_6.getText())) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Contact Number 1",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			textField_6.setText("");
			textField_6.requestFocusInWindow();
			return false;
		}
		if (!isInteger(textField_7.getText())) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Contact Number 2",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			textField_7.setText("");
			textField_7.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	private boolean isInteger( String str ) {
	    try {
	    	if (str == null) {
	    		return false;
	    	}
	    	if (str.isEmpty()) {
	    		return false;
	    	}
	    	if (!(str.length() == 10)) {
				return false;
			}
	    	int i = 0;
	    	int length = str.length();
	    	if (str.charAt(0) == '-') {
	    		if (length == 1) {
	    			return false;
	    		}
	    		i = 1;
	    	}
	    	for (; i < length; i++) {
	    		char c = str.charAt(i);
	    		if (c < '0' || c > '9') {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	
	private boolean validEmail(String email)
	{
		Pattern pattern = Pattern.compile ("([a-zA-Z0-9_\\-\\.]+)@((\\[a-z]{1,3}\\.[a-z]"
		+ "{1,3}\\.[a-z]{1,3}\\.)|(([a-zA-Z\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)", Pattern.MULTILINE);
		Matcher m=pattern.matcher(email);
		boolean b=m.matches();
		if(email.length()>0){
			if(b==true){
				return true;
			}else{
				return false;				
			}
		}    
		return false;
	}
	
	private void getSinglePatDetails() {
		MyTableModel model = (MyTableModel)table.getModel();
		int selectedRowIndex = table.getSelectedRow();
		int id=Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs = dbconn.getSinglePatDetails(id);
			if (rs.next()) {
				textField.setText(Integer.toString(id));
				textField_1.setText(rs.getObject("p_name").toString());
				textField_2.setText(rs.getObject("p_add1").toString());
				textField_3.setText(rs.getObject("p_add2").toString());
				textField_4.setText(rs.getObject("p_add3").toString());
				textField_5.setText(rs.getObject("p_email").toString());
				textField_6.setText(rs.getObject("p_contact1").toString());
				textField_7.setText(rs.getObject("p_contact2").toString());
				textField_8.setText(rs.getObject("p_ocp").toString());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
				Date date = sdf.parse(rs.getObject("p_dob").toString());
				dateChooser.setDate(date);
				textField_9.setText(rs.getObject("p_age").toString());
				comboBox.setSelectedItem(rs.getObject("p_issue").toString());
				comboBox_1.setSelectedItem(rs.getObject("p_familydoc").toString());
				textField_10.setText(rs.getObject("p_other").toString());
			} else {
				JOptionPane.showMessageDialog(null, "Record Not Found in Database", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Record...\nConnection Error...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
		}
		btnNew.setEnabled(false);
		btnEdit.setEnabled(true);
		btnSave.setEnabled(false);
		btnSelect.setEnabled(false);
	}	
}
