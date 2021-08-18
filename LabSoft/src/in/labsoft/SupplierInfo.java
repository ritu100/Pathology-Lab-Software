package in.labsoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DesktopManager;
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

public class SupplierInfo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSuppId;
	private JTextField txtSuppName;
	private JTextField txtSuppAdd1;
	private JTextField txtSuppAdd2;
	private JTextField txtSuppAdd3;
	private JTextField txtSuppEmail;
	private JTextField txtSuppContact1;
	private JTextField txtSuppContact2;
	private JTextField txtCmpAdd1;
	private JDesktopPane jdp;
	private JTextField txtCmpAdd2;
	private JTextField txtSuppOther;
	private JComboBox cmbCmpName;
	private JButton btnCmpAdd;
	private JButton btnSuppNew;
	private JButton btnSuppEdit;
	private JButton btnSuppSave;
	private JButton btnSuppCancel;
	private JButton btnSuppSelect;
	private JButton btnSuppExit;
	private JPanel pnlFields;
	private JPanel pnlBasicOps;
	private JPanel pnlListFields;
	private JPanel pnlListOps;
	private JTable table;
	private JScrollPane jsp;

	/**
	 * Create the frame.
	 */
	public SupplierInfo(JDesktopPane jp) {
		setIconifiable(true);
		setBackground(Color.BLACK);
		this.jdp=jp;
		setClosable(true);
		setTitle("Suppliers Information");
		getContentPane().setLayout(null);
		
		pnlFields = new JPanel();
		pnlFields.setBackground(Color.BLACK);
		pnlFields.setBorder(new LineBorder(Color.GREEN));
		pnlFields.setBounds(10, 11, 394, 390);
		getContentPane().add(pnlFields);
		pnlFields.setLayout(null);
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setForeground(Color.YELLOW);
		lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupplierId.setBorder(new LineBorder(Color.MAGENTA));
		lblSupplierId.setBounds(10, 10, 107, 25);
		pnlFields.add(lblSupplierId);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setForeground(Color.YELLOW);
		lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupplierName.setBorder(new LineBorder(Color.MAGENTA));
		lblSupplierName.setBounds(10, 40, 107, 25);
		pnlFields.add(lblSupplierName);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(Color.MAGENTA));
		label_2.setBounds(10, 70, 107, 25);
		pnlFields.add(label_2);
		
		JLabel label_3 = new JLabel("Email ID");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBorder(new LineBorder(Color.MAGENTA));
		label_3.setBounds(10, 160, 107, 25);
		pnlFields.add(label_3);
		
		JLabel label_4 = new JLabel("Contact");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBorder(new LineBorder(Color.MAGENTA));
		label_4.setBounds(10, 190, 107, 25);
		pnlFields.add(label_4);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(Color.YELLOW);
		lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompanyName.setBorder(new LineBorder(Color.MAGENTA));
		lblCompanyName.setBounds(10, 250, 107, 25);
		pnlFields.add(lblCompanyName);
		
		JLabel lblCompanyAddress = new JLabel("Company Address");
		lblCompanyAddress.setForeground(Color.YELLOW);
		lblCompanyAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompanyAddress.setBorder(new LineBorder(Color.MAGENTA));
		lblCompanyAddress.setBounds(10, 280, 107, 25);
		pnlFields.add(lblCompanyAddress);
		
		JLabel lblOtherDetails = new JLabel("Other Details");
		lblOtherDetails.setForeground(Color.YELLOW);
		lblOtherDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtherDetails.setBorder(new LineBorder(Color.MAGENTA));
		lblOtherDetails.setBounds(10, 340, 107, 25);
		pnlFields.add(lblOtherDetails);
		
		JLabel label = new JLabel("* fields are compulsory");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBorder(null);
		label.setBackground(Color.BLACK);
		label.setBounds(127, 370, 246, 14);
		pnlFields.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(null);
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(380, 40, 14, 24);
		pnlFields.add(label_1);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBorder(null);
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(380, 191, 14, 24);
		pnlFields.add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBorder(null);
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(380, 220, 14, 24);
		pnlFields.add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setHorizontalTextPosition(SwingConstants.CENTER);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBorder(null);
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(380, 251, 14, 24);
		pnlFields.add(label_7);
		
		txtSuppId = new JTextField();
		txtSuppId.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuppId.setEditable(false);
		txtSuppId.setForeground(Color.YELLOW);
		txtSuppId.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSuppId.setBorder(new LineBorder(Color.RED));
		txtSuppId.setBackground(Color.BLACK);
		txtSuppId.setColumns(10);
		txtSuppId.setBounds(127, 10, 86, 25);
		pnlFields.add(txtSuppId);
		
		txtSuppName = new JTextField();
		txtSuppName.setColumns(10);
		txtSuppName.setBounds(127, 40, 246, 25);
		pnlFields.add(txtSuppName);
		
		txtSuppAdd1 = new JTextField();
		txtSuppAdd1.setColumns(10);
		txtSuppAdd1.setBounds(127, 70, 246, 25);
		pnlFields.add(txtSuppAdd1);
		
		txtSuppAdd2 = new JTextField();
		txtSuppAdd2.setColumns(10);
		txtSuppAdd2.setBounds(127, 100, 246, 25);
		pnlFields.add(txtSuppAdd2);
		
		txtSuppAdd3 = new JTextField();
		txtSuppAdd3.setColumns(10);
		txtSuppAdd3.setBounds(127, 130, 246, 25);
		pnlFields.add(txtSuppAdd3);
		
		txtSuppEmail = new JTextField();
		txtSuppEmail.setColumns(10);
		txtSuppEmail.setBounds(127, 160, 246, 25);
		pnlFields.add(txtSuppEmail);
		
		txtSuppContact1 = new JTextField();
		txtSuppContact1.setColumns(10);
		txtSuppContact1.setBounds(127, 190, 246, 25);
		pnlFields.add(txtSuppContact1);
		
		txtSuppContact2 = new JTextField();
		txtSuppContact2.setColumns(10);
		txtSuppContact2.setBounds(127, 220, 246, 25);
		pnlFields.add(txtSuppContact2);
		
		cmbCmpName = new JComboBox();
		cmbCmpName.setForeground(new Color(75, 0, 130));
		cmbCmpName.setEnabled(false);
		cmbCmpName.setBounds(127, 250, 191, 25);
		pnlFields.add(cmbCmpName);
		
		txtCmpAdd1 = new JTextField();
		txtCmpAdd1.setColumns(10);
		txtCmpAdd1.setBounds(127, 280, 246, 25);
		pnlFields.add(txtCmpAdd1);
		
		txtCmpAdd2 = new JTextField();
		txtCmpAdd2.setColumns(10);
		txtCmpAdd2.setBounds(127, 310, 246, 25);
		pnlFields.add(txtCmpAdd2);
		
		txtSuppOther = new JTextField();
		txtSuppOther.setColumns(10);
		txtSuppOther.setBounds(127, 340, 246, 25);
		pnlFields.add(txtSuppOther);
		
		btnCmpAdd = new JButton("ADD");
		btnCmpAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String company=JOptionPane.showInputDialog(null, "Please Enter Company Name...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
				if (company != null && !(company.isEmpty())) {
					DBManager dbconn=DBManager.getInstance();
					try {
						int cnt = dbconn.setCompany(company);
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "Company Name Added Successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							cmbCmpName.removeAllItems();
							ArrayList<String> companies=new ArrayList<String>();
							ResultSet rs=dbconn.getAllCompanies();
							while(rs.next()) {
								companies.add(rs.getString("cmp_name"));
							}
							rs.close();
							rs=null;
							cmbCmpName.setModel(new DefaultComboBoxModel(companies.toArray()));
						}else {
							JOptionPane.showMessageDialog(null, "Can't add new company...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnCmpAdd.setForeground(Color.MAGENTA);
		btnCmpAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCmpAdd.setBorder(new LineBorder(Color.CYAN));
		btnCmpAdd.setBackground(Color.BLACK);
		btnCmpAdd.setBounds(321, 250, 52, 25);
		pnlFields.add(btnCmpAdd);
		
		pnlBasicOps = new JPanel();
		pnlBasicOps.setBackground(Color.BLACK);
		pnlBasicOps.setBorder(new LineBorder(new Color(0, 255, 0)));
		pnlBasicOps.setBounds(10, 406, 394, 50);
		getContentPane().add(pnlBasicOps);
		pnlBasicOps.setLayout(null);
		
		btnSuppNew = new JButton("NEW");
		btnSuppNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getNewID();
				btnSuppNew.setEnabled(false);
				btnSuppEdit.setEnabled(false);
				btnSuppSave.setEnabled(true);
			}
		});
		btnSuppNew.setBorder(new LineBorder(Color.BLUE));
		btnSuppNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuppNew.setForeground(new Color(75, 0, 130));
		btnSuppNew.setBounds(10, 11, 85, 28);
		pnlBasicOps.add(btnSuppNew);
		
		btnSuppEdit = new JButton("EDIT");
		btnSuppEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEditing(true);
				btnSuppNew.setEnabled(false);
				btnSuppEdit.setEnabled(false);
				btnSuppSave.setEnabled(true);
			}
		});
		btnSuppEdit.setBorder(new LineBorder(Color.BLUE));
		btnSuppEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuppEdit.setForeground(new Color(75, 0, 130));
		btnSuppEdit.setBounds(103, 11, 85, 28);
		pnlBasicOps.add(btnSuppEdit);
		
		btnSuppSave = new JButton("SAVE");
		btnSuppSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool = checkTextFields();
				if (bool) {
					String id = txtSuppId.getText();
					String name = txtSuppName.getText();
					String add1 = txtSuppAdd1.getText();
					String add2 = txtSuppAdd2.getText();
					String add3 = txtSuppAdd3.getText();
					String email = txtSuppEmail.getText();
					String contact1 = txtSuppContact1.getText();					
					String contact2 = txtSuppContact2.getText();
					String company = cmbCmpName.getSelectedItem().toString();
					String cmpadd1 = txtCmpAdd1.getText();
					String cmpadd2 = txtCmpAdd2.getText();
					String other = txtSuppOther.getText();
					
					ArrayList<String> al=new ArrayList<String>();
					al.add(name);
					al.add(add1);
					al.add(add2);
					al.add(add3);
					al.add(email);
					al.add(contact1);
					al.add(contact2);
					al.add(company);
					al.add(cmpadd1);
					al.add(cmpadd2);
					al.add(other);
					
					int cnt = 0;
					DBManager dbconn=DBManager.getInstance();
					try {
						cnt = dbconn.insertSuppDetails(al);
						if (cnt>0) {
							JOptionPane.showMessageDialog(null, cnt + "Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							MyTableModel model=(MyTableModel)table.getModel();
							model.addRow(id, name);
							table.revalidate(); 
					        table.repaint();
					        clearFields(false);
					        btnSuppNew.setEnabled(true);
							btnSuppEdit.setEnabled(false);
							btnSuppSave.setEnabled(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							clearFields(false);
							btnSuppNew.setEnabled(true);
							btnSuppEdit.setEnabled(false);
							btnSuppSave.setEnabled(false);
						}
					} catch (Exception ev) {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						clearFields(false);
						btnSuppNew.setEnabled(true);
						btnSuppEdit.setEnabled(false);
						btnSuppSave.setEnabled(false);
					}
				}		
			}
		});
		btnSuppSave.setBorder(new LineBorder(Color.BLUE));
		btnSuppSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuppSave.setForeground(new Color(75, 0, 130));
		btnSuppSave.setBounds(195, 11, 85, 28);
		pnlBasicOps.add(btnSuppSave);
		
		btnSuppCancel = new JButton("CANCEL");
		btnSuppCancel.setBorder(new LineBorder(Color.BLUE));
		btnSuppCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuppCancel.setForeground(new Color(75, 0, 130));
		btnSuppCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearFields(false);
				btnSuppNew.setEnabled(true);
				btnSuppEdit.setEnabled(false);
				btnSuppSave.setEnabled(false);
				btnSuppSelect.setEnabled(false);
			}
		});
		btnSuppCancel.setBounds(286, 11, 85, 28);
		pnlBasicOps.add(btnSuppCancel);
		
		pnlListFields = new JPanel();
		pnlListFields.setBackground(Color.BLACK);
		pnlListFields.setBorder(new LineBorder(Color.GREEN));
		pnlListFields.setBounds(410, 11, 275, 390);
		getContentPane().add(pnlListFields);
		pnlListFields.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supplier List");
		lblNewLabel.setBorder(new LineBorder(Color.MAGENTA));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 255, 25);
		pnlListFields.add(lblNewLabel);
		
		JPanel pnlSuppList = new JPanel();
		pnlSuppList.setBorder(new LineBorder(Color.MAGENTA));
		pnlSuppList.setBackground(Color.BLACK);
		pnlSuppList.setBounds(10, 40, 255, 340);
		pnlListFields.add(pnlSuppList);
		
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
		            getSingleSuppDetails();
		        }
		        else if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		        	btnSuppSelect.setEnabled(true);
		        }
		    }
		});
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		pnlSuppList.add(table.getTableHeader(), BorderLayout.PAGE_START);
		pnlSuppList.setLayout(new BorderLayout(0, 0));
		pnlSuppList.add(jsp);
		
		pnlListOps = new JPanel();
		pnlListOps.setBackground(Color.BLACK);
		pnlListOps.setBorder(new LineBorder(Color.GREEN));
		pnlListOps.setBounds(410, 406, 275, 50);
		getContentPane().add(pnlListOps);
		pnlListOps.setLayout(null);
		
		btnSuppSelect = new JButton("SELECT");
		btnSuppSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSingleSuppDetails();
			}
		});
		btnSuppSelect.setBorder(new LineBorder(Color.BLUE));
		btnSuppSelect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuppSelect.setForeground(new Color(75, 0, 130));
		btnSuppSelect.setBounds(10, 11, 124, 28);
		pnlListOps.add(btnSuppSelect);
		
		btnSuppExit = new JButton("EXIT");
		btnSuppExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame frames[] = jdp.getAllFrames();
				DesktopManager dm = jdp.getDesktopManager();
				for (int i = 0 ; i < frames.length ; i ++){
					dm.closeFrame(frames[i]);
					try {
						frames[i].setClosed(false);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				jdp.revalidate();
				jdp.repaint();
			}
		});
		btnSuppExit.setBorder(new LineBorder(Color.BLUE));
		btnSuppExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuppExit.setForeground(new Color(75, 0, 130));
		btnSuppExit.setBounds(141, 11, 124, 28);
		pnlListOps.add(btnSuppExit);
		setBounds(20,20,707,500);
		formLoad();
		clearFields(false);
		btnSuppSelect.setEnabled(false);
		btnSuppEdit.setEnabled(false);
		btnSuppSave.setEnabled(false);
		setVisible(true);
	}
	
	private void clearFields(boolean flag) {
		txtSuppId.setText(null);
		txtSuppName.setText(null);
		txtSuppAdd1.setText(null);
		txtSuppAdd2.setText(null);
		txtSuppAdd3.setText(null);
		txtSuppEmail.setText(null);
		txtSuppContact1.setText(null);
		txtSuppContact2.setText(null);
		cmbCmpName.setSelectedIndex(-1);
		txtCmpAdd1.setText(null);
		txtCmpAdd2.setText(null);
		txtSuppOther.setText(null);
		setEditing(flag);
	}
	
	private void setEditing(boolean flag) {
		txtSuppName.setEnabled(flag);
		txtSuppAdd1.setEnabled(flag);
		txtSuppAdd2.setEnabled(flag);
		txtSuppAdd3.setEnabled(flag);
		txtSuppEmail.setEnabled(flag);
		txtSuppContact1.setEnabled(flag);
		txtSuppContact2.setEnabled(flag);
		cmbCmpName.setEnabled(flag);
		txtCmpAdd1.setEnabled(flag);
		txtCmpAdd2.setEnabled(flag);
		txtSuppOther.setEnabled(flag);
		if (flag) {
			txtSuppName.requestFocusInWindow();
		}
	}
	
	private void formLoad() {
		ArrayList<String> companies=new ArrayList<String>();
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.getAllCompanies();
			while(rs.next()) {
				companies.add(rs.getString("cmp_name"));
			}
			rs.close();
			rs=null;
			cmbCmpName.setModel(new DefaultComboBoxModel(companies.toArray()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void getNewID() {
		int id=1;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastSuppID(?)");
		} catch (Exception e) {
			id = 1;
		}
		clearFields(true);
		txtSuppId.setText(Integer.toString(id));
	}
	
	private boolean checkTextFields() {
		if (txtSuppName.getText().equals(null) || txtSuppName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Supplier Name", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtSuppName.setText("");
			txtSuppName.requestFocusInWindow();
			return false;
		}
		if (!validEmail(txtSuppEmail.getText())) {
			JOptionPane.showMessageDialog(null,"Please Enter Valid Email ID",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			txtSuppEmail.setText("");
			txtSuppEmail.requestFocusInWindow();
			return false;
		}
		if (!isInteger(txtSuppContact1.getText())) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Contact Number 1",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			txtSuppContact1.setText("");
			txtSuppContact1.requestFocusInWindow();
			return false;
		}
		if (!isInteger(txtSuppContact2.getText())) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Contact Number 2",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			txtSuppContact2.setText("");
			txtSuppContact2.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	private boolean isInteger(String str) {
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
	
	private Object[][] getTableData(){
		Object[][] temp=null;
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.getSuppNames();
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			temp=new Object[rows][2];
			int i=0;
			while(rs.next()) {
				temp[i][0]=rs.getObject("supp_id");
				temp[i][1]=rs.getObject("supp_name");
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Supplier List", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return temp;
	}
	
	private void getSingleSuppDetails() {
		MyTableModel model = (MyTableModel)table.getModel();
		int selectedRowIndex = table.getSelectedRow();
		int id=Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs = dbconn.getSingleSuppDetails(id);
			if (rs.next()) {
				txtSuppId.setText(Integer.toString(id));
				txtSuppName.setText(rs.getObject("supp_name").toString());
				txtSuppAdd1.setText(rs.getObject("supp_add1").toString());
				txtSuppAdd2.setText(rs.getObject("supp_add2").toString());
				txtSuppAdd3.setText(rs.getObject("supp_add3").toString());
				txtSuppEmail.setText(rs.getObject("supp_email").toString());
				txtSuppContact1.setText(rs.getObject("supp_contact1").toString());
				txtSuppContact2.setText(rs.getObject("supp_contact2").toString());
				cmbCmpName.setSelectedItem(rs.getObject("supp_company").toString());
				txtCmpAdd1.setText(rs.getObject("supp_cmp_add1").toString());
				txtCmpAdd2.setText(rs.getObject("supp_cmp_add2").toString());
				txtSuppOther.setText(rs.getObject("supp_other").toString());
			} else {
				JOptionPane.showMessageDialog(null, "Record Not Found in Database", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Record...\nConnection Error...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
		}
		btnSuppNew.setEnabled(false);
		btnSuppEdit.setEnabled(true);
		btnSuppSave.setEnabled(false);
		btnSuppSelect.setEnabled(false);
	}	
}
