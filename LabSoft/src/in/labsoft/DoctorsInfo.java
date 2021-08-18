package in.labsoft;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DesktopManager;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class DoctorsInfo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JDesktopPane jdp;
	private ButtonGroup grad;
	private ButtonGroup pg;
	private JButton btnNewButton;
	private JButton btnEdit;
	private JButton btnSave;
	private JButton btnCancel;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JPanel panel_2;
	private JTable table;
	private JScrollPane jsp;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton button;
	private JButton button_1;

	/**
	 * Create the frame.
	 */
	public DoctorsInfo(JDesktopPane jp) {
		super("Doctors Information",false,true,false,true);
		setBackground(Color.BLACK);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 255, 0)));
		panel.setBounds(10, 419, 383, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("NEW");
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBorder(new LineBorder(Color.CYAN));
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearFields();
				formLoad();
				setEditing(true);
				btnNewButton.setEnabled(false);
				btnEdit.setEnabled(false);
				btnSave.setEnabled(true);
			}
		});
		btnNewButton.setBounds(10, 11, 74, 28);
		panel.add(btnNewButton);
		
		btnEdit = new JButton("EDIT");
		btnEdit.setBackground(SystemColor.control);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBorder(new LineBorder(Color.CYAN));
		btnEdit.setForeground(Color.MAGENTA);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((!(textField_1.getText()==null || textField_1.getText().isEmpty()) && 
						(!(textField_5.getText()==null || textField_5.getText().isEmpty())))) {
					setEditing(true);
					btnEdit.setEnabled(false);
					btnSave.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Select The Record To Edit...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					setEditing(false);
					btnEdit.setEnabled(false);
				}
			}
		});
		btnEdit.setBounds(94, 11, 81, 28);
		panel.add(btnEdit);
		
		btnSave = new JButton("SAVE");
		btnSave.setBackground(SystemColor.control);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBorder(new LineBorder(Color.CYAN));
		btnSave.setForeground(Color.MAGENTA);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				boolean bool = checkTextFields();
				if (bool) {
					String id=textField.getText();
					String drName = textField_1.getText();
					String address = textField_2.getText() + ", " + textField_3.getText() + ", " + textField_4.getText() + ".";
					String email = textField_5.getText();
					String contact1 = textField_6.getText();					
					String contact2 = textField_7.getText();
					String edu =grad.getSelection().getActionCommand();
					String pgEdu=pg.getSelection().getActionCommand();
					String otherDip = textField_8.getText();
					String hospital = textField_9.getText();
					
					ArrayList<String> al=new ArrayList<String>();
					al.add(drName);
					al.add(address);
					al.add(email);
					al.add(contact1);
					al.add(contact2);
					al.add(edu);
					al.add(pgEdu);
					al.add(otherDip);
					al.add(hospital);
					
					int cnt = 0;
					DBManager dbconn=DBManager.getInstance();
					try {
						cnt = dbconn.insertDocDetails(al);
						if (cnt>0) {
							JOptionPane.showMessageDialog(null, cnt + "Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							MyTableModel model=(MyTableModel)table.getModel();
							model.addRow(id, drName);
							table.revalidate(); 
					        table.repaint();
					        textField.setText(null);
							clearFields();
							setEditing(false);
							btnSave.setEnabled(false);
							btnNewButton.setEnabled(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							textField.setText(null);
							clearFields();
							setEditing(false);
							btnSave.setEnabled(false);
							btnNewButton.setEnabled(true);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						clearFields();
						setEditing(false);
						btnSave.setEnabled(false);
						btnNewButton.setEnabled(true);
					}
				}
			}
		});
		btnSave.setBounds(185, 11, 86, 28);
		panel.add(btnSave);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(SystemColor.control);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBorder(new LineBorder(Color.CYAN));
		btnCancel.setForeground(Color.MAGENTA);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				btnNewButton.setEnabled(true);
				btnEdit.setEnabled(false);
				btnSave.setEnabled(false);
				clearFields();
				setEditing(false);
			}
		});
		btnCancel.setBounds(281, 11, 92, 28);
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBorder(new LineBorder(Color.GREEN));
		panel_1.setBounds(10, 11, 383, 404);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Doctor ID");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBorder(new LineBorder(Color.MAGENTA));
		label.setBounds(10, 11, 97, 24);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(111, 11, 86, 24);
		textField.setEditable(false);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Doctor Name");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(new LineBorder(Color.MAGENTA));
		label_1.setBounds(10, 41, 97, 24);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 41, 246, 24);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(Color.MAGENTA));
		label_2.setBounds(10, 71, 97, 24);
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(111, 71, 246, 24);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(111, 100, 246, 24);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(111, 128, 246, 24);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(111, 156, 246, 24);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(111, 184, 246, 24);
		panel_1.add(textField_6);
		
		JLabel label_3 = new JLabel("Email ID");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBorder(new LineBorder(Color.MAGENTA));
		label_3.setBounds(10, 155, 97, 24);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Contact");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBorder(new LineBorder(Color.MAGENTA));
		label_4.setBounds(10, 183, 97, 24);
		panel_1.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(111, 215, 246, 24);
		panel_1.add(textField_7);
		
		JLabel label_5 = new JLabel("Graduation");
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBorder(new LineBorder(Color.MAGENTA));
		label_5.setBounds(10, 244, 97, 24);
		panel_1.add(label_5);
		
		radioButton = new JRadioButton("MBBS");
		radioButton.setBackground(Color.BLACK);
		radioButton.setForeground(Color.CYAN);
		radioButton.setActionCommand("MBBS");
		radioButton.setBounds(111, 246, 118, 23);
		panel_1.add(radioButton);
		
		radioButton_1 = new JRadioButton("BDS");
		radioButton_1.setBackground(Color.BLACK);
		radioButton_1.setForeground(Color.CYAN);
		radioButton_1.setActionCommand("BDS");
		radioButton_1.setBounds(239, 246, 118, 23);
		panel_1.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("BAMS");
		radioButton_2.setBackground(Color.BLACK);
		radioButton_2.setForeground(Color.CYAN);
		radioButton_2.setActionCommand("BAMS");
		radioButton_2.setBounds(111, 272, 118, 23);
		panel_1.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("BHMS");
		radioButton_3.setBackground(Color.BLACK);
		radioButton_3.setForeground(Color.CYAN);
		radioButton_3.setActionCommand("BHMS");
		radioButton_3.setBounds(239, 272, 118, 23);
		panel_1.add(radioButton_3);
		
		grad=new ButtonGroup();
		grad.add(radioButton);
		grad.add(radioButton_1);
		grad.add(radioButton_2);
		grad.add(radioButton_3);
		
		radioButton.setSelected(true);
		
		JLabel label_6 = new JLabel("Post Graduation");
		label_6.setForeground(Color.YELLOW);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBorder(new LineBorder(Color.MAGENTA));
		label_6.setBounds(10, 296, 97, 24);
		panel_1.add(label_6);
		
		radioButton_4 = new JRadioButton("MD");
		radioButton_4.setBackground(Color.BLACK);
		radioButton_4.setForeground(Color.CYAN);
		radioButton_4.setActionCommand("MD");
		radioButton_4.setBounds(111, 298, 118, 23);
		panel_1.add(radioButton_4);
		
		radioButton_5 = new JRadioButton("MS");
		radioButton_5.setBackground(Color.BLACK);
		radioButton_5.setForeground(Color.CYAN);
		radioButton_5.setActionCommand("MS");
		radioButton_5.setBounds(239, 298, 118, 23);
		panel_1.add(radioButton_5);
		
		pg=new ButtonGroup();
		pg.add(radioButton_4);
		pg.add(radioButton_5);
		
		radioButton_4.setSelected(true);
		
		JLabel label_7 = new JLabel("Other Diploma");
		label_7.setForeground(Color.YELLOW);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBorder(new LineBorder(Color.MAGENTA));
		label_7.setBounds(10, 327, 97, 24);
		panel_1.add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(111, 327, 246, 24);
		panel_1.add(textField_8);
		
		JLabel label_8 = new JLabel("Hospital");
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBorder(new LineBorder(Color.MAGENTA));
		label_8.setBounds(10, 354, 97, 24);
		panel_1.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(111, 355, 246, 24);
		panel_1.add(textField_9);
		
		JLabel label_9 = new JLabel("*");
		label_9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBackground(Color.BLACK);
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBorder(null);
		label_9.setBounds(359, 41, 14, 24);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setHorizontalTextPosition(SwingConstants.CENTER);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBorder(null);
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(359, 184, 14, 24);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setHorizontalTextPosition(SwingConstants.CENTER);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBorder(null);
		label_11.setBackground(Color.BLACK);
		label_11.setBounds(359, 155, 14, 24);
		panel_1.add(label_11);
		
		JLabel lblMarkedAre = new JLabel("* fields are compulsory");
		lblMarkedAre.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMarkedAre.setForeground(Color.RED);
		lblMarkedAre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMarkedAre.setBorder(null);
		lblMarkedAre.setBackground(Color.BLACK);
		lblMarkedAre.setBounds(111, 383, 246, 13);
		panel_1.add(lblMarkedAre);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBorder(new LineBorder(Color.GREEN));
		panel_2.setBounds(403, 11, 275, 404);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctors List");
		lblNewLabel.setLocation(10, 11);
		lblNewLabel.setSize(new Dimension(255, 30));
		lblNewLabel.setBorder(new LineBorder(Color.MAGENTA));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 45, 255, 350);
		panel_3.setBorder(new LineBorder(Color.MAGENTA));
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(5,5));
		
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
		            getSingleDocDetails();
		        }
		        else if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		        	button.setEnabled(true);
		        }
		    }
		});
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel_3.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel_3.add(jsp, BorderLayout.CENTER);
		
		btnEdit.setEnabled(false);
		btnSave.setEnabled(false);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GREEN));
		panel_4.setBackground(Color.BLACK);
		panel_4.setLayout(null);
		panel_4.setBounds(403, 419, 275, 50);
		getContentPane().add(panel_4);
		
		button = new JButton("SELECT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSingleDocDetails();
			}
		});
		button.setBackground(SystemColor.control);
		button.setForeground(Color.MAGENTA);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setEnabled(false);
		button.setBorder(new LineBorder(Color.CYAN));
		button.setBounds(10, 11, 120, 28);
		panel_4.add(button);
		
		button_1 = new JButton("EXIT");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBackground(SystemColor.control);
		button_1.setForeground(Color.MAGENTA);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBorder(new LineBorder(Color.CYAN));
		button_1.setBounds(140, 11, 125, 28);
		panel_4.add(button_1);
		
		setBounds(20,20,705,515);
		setVisible(true);
		setEditing(false);
	}
	
	private Object[][] getTableData(){
		Object[][] temp=null;
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.getDocNames();
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			temp=new Object[rows][2];
			int i=0;
			while(rs.next()) {
				temp[i][0]=rs.getObject("doc_id");
				temp[i][1]=rs.getObject("doc_name");
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Doctors List", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return temp;
	}
	
	private void formLoad() {
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastDocID(?)");
		} catch (Exception e) {
			id = 1;
		}
		clearFields();
		textField.setText(Integer.toString(id));
	}
	
	private void setEditing(boolean flag) {
		textField_1.setEditable(flag);
		textField_2.setEditable(flag);
		textField_3.setEditable(flag);
		textField_4.setEditable(flag);
		textField_5.setEditable(flag);
		textField_6.setEditable(flag);
		textField_7.setEditable(flag);
		textField_8.setEditable(flag);
		textField_9.setEditable(flag);
		if (flag) {
			textField_1.requestFocusInWindow();
		}
	}
	
	private void clearFields() {
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		textField_6.setText(null);
		textField_7.setText(null);
		textField_8.setText(null);
		textField_9.setText(null);
		textField_1.requestFocusInWindow();
	}
	
	private boolean checkTextFields() {
		if (textField_1.getText().equals(null) || textField_1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Doctors Name", cv.getLT(), JOptionPane.ERROR_MESSAGE);
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
	
	private void getSingleDocDetails() {
		MyTableModel model = (MyTableModel)table.getModel();
		int selectedRowIndex = table.getSelectedRow();
		int id=Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs = dbconn.getSingleDocDetails(id);
			if (rs.next()) {
				textField.setText(Integer.toString(id));
				textField_1.setText(rs.getObject("doc_name").toString());
				textField_2.setText(rs.getObject("doc_address").toString());
				textField_5.setText(rs.getObject("doc_email").toString());
				textField_6.setText(rs.getObject("doc_contact1").toString());
				textField_7.setText(rs.getObject("doc_contact2").toString());
				String graduation = rs.getObject("doc_graduation").toString();
				String postgrad = rs.getObject("doc_pg").toString();
				textField_8.setText(rs.getObject("doc_other_edu").toString());
				textField_9.setText(rs.getObject("doc_hospital").toString());
				
				if (graduation.equals("MBBS")) {
					radioButton.setSelected(true);
				} else if(graduation.equals("BDS")) {
					radioButton_1.setSelected(true);
				} else if(graduation.equals("BAMS")) {
					radioButton_2.setSelected(true);
				} else {
					radioButton_3.setSelected(true);
				}
				
				if (postgrad.equals("MD")) {
					radioButton_4.setSelected(true);
				} else {
					radioButton_5.setSelected(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Record Not Found in Database", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Record...\nConnection Error...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
		}
		btnEdit.setEnabled(true);
		button.setEnabled(false);
	}
}
