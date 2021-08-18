package in.labsoft;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class RegisterDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRegId;
	private JTextField txtUserName;
	private JTextField txtLoginName;
	private JPasswordField txtPassword;
	private JComboBox<String> cmbUserType;
	private JButton btnRegister;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	
	public RegisterDialog(Window f) {
		super(f);
		setTitle("Register User");
		setModal(true);
		setUndecorated(false);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBackground(Color.BLACK);
		setBounds(100, 100, 430, 300);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(Color.RED));
		contentPanel.setBackground(Color.BLACK);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlFields = new JPanel();
		pnlFields.setBorder(new LineBorder(Color.GREEN));
		pnlFields.setBackground(Color.BLACK);
		pnlFields.setBounds(10, 11, 404, 184);
		contentPanel.add(pnlFields);
		pnlFields.setLayout(null);
		
		JLabel lblUserId = new JLabel(" User ID");
		lblUserId.setForeground(Color.YELLOW);
		lblUserId.setBorder(new LineBorder(Color.CYAN));
		lblUserId.setBounds(26, 11, 120, 23);
		pnlFields.add(lblUserId);
		
		JLabel lblUserName = new JLabel(" User Name");
		lblUserName.setForeground(Color.YELLOW);
		lblUserName.setBorder(new LineBorder(Color.CYAN));
		lblUserName.setBounds(26, 45, 120, 23);
		pnlFields.add(lblUserName);
		
		JLabel lblUserType = new JLabel(" User Type");
		lblUserType.setForeground(Color.YELLOW);
		lblUserType.setBorder(new LineBorder(Color.CYAN));
		lblUserType.setBounds(26, 79, 120, 23);
		pnlFields.add(lblUserType);
		
		JLabel lblLoginName = new JLabel(" Login Name");
		lblLoginName.setForeground(Color.YELLOW);
		lblLoginName.setBorder(new LineBorder(Color.CYAN));
		lblLoginName.setBounds(26, 113, 120, 23);
		pnlFields.add(lblLoginName);
		
		JLabel lblLoginPassword = new JLabel(" Login Password");
		lblLoginPassword.setForeground(Color.YELLOW);
		lblLoginPassword.setBorder(new LineBorder(Color.CYAN));
		lblLoginPassword.setBounds(26, 147, 120, 23);
		pnlFields.add(lblLoginPassword);
		
		txtRegId = new JTextField();
		txtRegId.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegId.setForeground(Color.YELLOW);
		txtRegId.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtRegId.setEditable(false);
		txtRegId.setBorder(new LineBorder(Color.RED));
		txtRegId.setBackground(Color.BLACK);
		txtRegId.setBounds(156, 11, 57, 23);
		pnlFields.add(txtRegId);
		txtRegId.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(156, 45, 220, 23);
		pnlFields.add(txtUserName);
		
		txtLoginName = new JTextField();
		txtLoginName.setColumns(10);
		txtLoginName.setBounds(156, 113, 220, 23);
		pnlFields.add(txtLoginName);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(156, 147, 220, 23);
		pnlFields.add(txtPassword);
		
		cmbUserType = new JComboBox<String>();
		cmbUserType.addItem("Admin");
		cmbUserType.addItem("Standard");
		cmbUserType.addItem("Guest");
		cmbUserType.setBounds(156, 79, 220, 23);
		pnlFields.add(cmbUserType);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBorder(new LineBorder(Color.GREEN));
		pnlButtons.setBackground(Color.BLACK);
		pnlButtons.setBounds(156, 206, 258, 53);
		contentPanel.add(pnlButtons);
		pnlButtons.setLayout(null);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean bool = checkTextFields();
				if (bool) {
					String name = txtUserName.getText();
					String type = cmbUserType.getSelectedItem().toString();
					String login = txtLoginName.getText();
					String pass = txtPassword.getText();
					
					ArrayList<String> al=new ArrayList<String>();
					al.add(name);
					al.add(type);
					al.add(login);
					al.add(pass);
					
					int cnt = 0;
					DBManager dbconn=DBManager.getInstance();
					try {
						cnt = dbconn.insertUserDetails(al);
						if (cnt>0) {
							JOptionPane.showMessageDialog(null, "User registered successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Can't register user \nconnection error...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							clearFields();
							formLoad();
						}
					} catch (Exception ev) {
						JOptionPane.showMessageDialog(null, "Can't register user \nconnection error...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						clearFields();
						formLoad();
					}
				}		
			}
		});
		btnRegister.setBorder(new LineBorder(Color.CYAN));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setForeground(new Color(75, 0, 130));
		btnRegister.setActionCommand("register");
		btnRegister.setBounds(10, 11, 111, 31);
		pnlButtons.add(btnRegister);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterDialog.this.dispose();
			}
		});
		btnExit.setForeground(new Color(75, 0, 130));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBorder(new LineBorder(Color.CYAN));
		btnExit.setActionCommand("register");
		btnExit.setBounds(131, 11, 117, 31);
		pnlButtons.add(btnExit);
		
		formLoad();
		setLocationRelativeTo(f);
		setVisible(true);
	}
	
	private void formLoad() {
		int id=1;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastUserID(?)");
		} catch (Exception e) {
			id = 1;
		}
		clearFields();
		txtRegId.setText(Integer.toString(id));
	}
	
	private void clearFields() {
		txtUserName.setText(null);
		cmbUserType.setSelectedIndex(0);
		txtLoginName.setText(null);
		txtPassword.setText(null);
	}
	
	private boolean checkTextFields() {
		if (txtUserName.getText().equals(null) || txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter User Name", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtUserName.setText("");
			txtUserName.requestFocusInWindow();
			return false;
		}
		if (txtLoginName.getText().equals(null) || txtLoginName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Login Name", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtLoginName.setText("");
			txtLoginName.requestFocusInWindow();
			return false;
		}
		if (txtPassword.getText().equals(null) || txtPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Password", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtPassword.setText("");
			txtPassword.requestFocusInWindow();
			return false;
		}
		if (txtPassword.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, "Please Enter Minimum 8 Character Password", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtPassword.setText("");
			txtPassword.requestFocusInWindow();
			return false;
		}
		return true;
	}
}
