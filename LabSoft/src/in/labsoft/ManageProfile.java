package in.labsoft;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.DesktopManager;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageProfile extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private static int UserID = 0;
	private static String UserName = null;
	private static String LoginPass = null;
	private JDesktopPane jdp;
	private JTextField textName;
	private JTextField textLogin;
	private JTextField textID;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JTextField userID;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JPasswordField confirmPass;
	private JTabbedPane tabbedPane;
	public ManageProfile(JDesktopPane jp) {
		super("Add Test Factors",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int selectedIndex = tabbedPane.getSelectedIndex();
				if (selectedIndex == 1) {
					userID.setText(String.valueOf(UserID));
					oldPass.requestFocus();
				}
				else if (selectedIndex == 0){
					formLoad();
				}
					
			}
		});
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setBounds(10, 11, 353, 187);
		getContentPane().add(tabbedPane);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Manage Names", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel lblUserName = new JLabel(" User Name");
		lblUserName.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setBounds(10, 46, 109, 24);
		panel1.add(lblUserName);
		
		JLabel lblLoginName = new JLabel(" Login Name");
		lblLoginName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoginName.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLoginName.setBounds(10, 81, 109, 24);
		panel1.add(lblLoginName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textName.setBounds(129, 46, 205, 24);
		panel1.add(textName);
		textName.setColumns(10);
		
		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLogin.setColumns(10);
		textLogin.setBounds(129, 81, 205, 24);
		panel1.add(textLogin);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBManager dbconn=DBManager.getInstance();
				try {
					String SQL = "update labsoft.tbl_login_details set user_name = '" + textName.getText() + "', login_name = '" + textLogin.getText() + "' where user_id = " + UserID + ";";
					int cnt = dbconn.updateRecords(SQL);
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null,"Profile Updated Successfully...",cv.getLT(),JOptionPane.INFORMATION_MESSAGE);
						cv.setUser(textLogin.getText());
						formLoad();
					}
					else{
						JOptionPane.showMessageDialog(null,"Profile Not Found...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
					}
					textID.setText(String.valueOf(UserID));
					textName.setText(UserName);
					textLogin.setText(cv.getUser());
					btnUpdate.requestFocus();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnUpdate.setBounds(129, 116, 96, 29);
		panel1.add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
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
		btnCancel.setBounds(235, 116, 99, 29);
		panel1.add(btnCancel);
		
		JLabel lblUserId = new JLabel(" User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserId.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblUserId.setBounds(10, 11, 109, 24);
		panel1.add(lblUserId);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setEditable(false);
		textID.setColumns(10);
		textID.setBounds(129, 11, 99, 24);
		panel1.add(textID);
		
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Change Password", null, panel2, null);
		panel2.setLayout(null);
		
		JLabel lblOldPassword = new JLabel(" Old Password");
		lblOldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOldPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOldPassword.setBounds(10, 38, 109, 24);
		panel2.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel(" New Password");
		lblNewPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewPassword.setBounds(10, 65, 109, 24);
		panel2.add(lblNewPassword);
		
		JButton btnChange = new JButton("Update");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateText()) {
					DBManager dbconn=DBManager.getInstance();
					try {
						String SQL = "update labsoft.tbl_login_details set login_password = '" + newPass.getText() + "' where user_id = " + UserID + ";";
						int cnt = dbconn.updateRecords(SQL);
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null,"Password Changed Successfully...",cv.getLT(),JOptionPane.INFORMATION_MESSAGE);
							tabbedPane.setSelectedIndex(0);
						}
						else{
							JOptionPane.showMessageDialog(null,"Profile Not Found...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
						}
						textID.setText(String.valueOf(UserID));
						textName.setText(UserName);
						textLogin.setText(cv.getUser());
						btnUpdate.requestFocus();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnChange.setBounds(129, 117, 105, 29);
		panel2.add(btnChange);
		
		JButton btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
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
		btnExit.setBounds(235, 117, 99, 29);
		panel2.add(btnExit);
		
		JLabel label_2 = new JLabel(" User ID");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_2.setBounds(10, 11, 109, 24);
		panel2.add(label_2);
		
		userID = new JTextField();
		userID.setFont(new Font("Tahoma", Font.BOLD, 12));
		userID.setHorizontalAlignment(SwingConstants.CENTER);
		userID.setEditable(false);
		userID.setColumns(10);
		userID.setBounds(129, 11, 99, 24);
		panel2.add(userID);
		
		JLabel lblConfirmPassword = new JLabel(" Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirmPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblConfirmPassword.setBounds(10, 92, 109, 24);
		panel2.add(lblConfirmPassword);
		
		oldPass = new JPasswordField();
		oldPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		oldPass.setBounds(129, 38, 205, 24);
		panel2.add(oldPass);
		
		newPass = new JPasswordField();
		newPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newPass.setBounds(129, 65, 205, 24);
		panel2.add(newPass);
		
		confirmPass = new JPasswordField();
		confirmPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		confirmPass.setBounds(129, 92, 205, 24);
		panel2.add(confirmPass);
		setBounds(20, 20, 382, 241);
		setVisible(true);
		formLoad();
	}
	
	private void formLoad()
	{
		DBManager dbconn=DBManager.getInstance();
		try {
			String SQL = "select user_id,user_name,login_password from labsoft.tbl_login_details where user_type = '" + cv.getType() + "' and login_name = '" + cv.getUser() + "';";
			ResultSet rs = dbconn.selectRecords(SQL);
			if (rs.next()) {
				UserID = rs.getInt(1);
				UserName = rs.getString(2);
				LoginPass = rs.getString(3);
			}
			else{
				JOptionPane.showMessageDialog(null,"Profile Not Found...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			}
			textID.setText(String.valueOf(UserID));
			textName.setText(UserName);
			textLogin.setText(cv.getUser());
			btnUpdate.requestFocus();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean validateText()
	{
		if (oldPass.getText() == null || oldPass.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter old password...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			oldPass.setText(null);
			oldPass.requestFocus();
			return false;
		}
		if (!oldPass.getText().equals(LoginPass)) {
			JOptionPane.showMessageDialog(null,"Please enter correct old password...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			oldPass.setText(null);
			oldPass.requestFocus();
			return false;
		}
		if (newPass.getText() == null || newPass.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter new password...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			newPass.setText(null);
			newPass.requestFocus();
			return false;
		}
		if (!newPass.getText().equals(confirmPass.getText())) {
			JOptionPane.showMessageDialog(null,"Passwords not matched\nTry Again...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
			newPass.setText(null);
			confirmPass.setText(null);
			newPass.requestFocus();
			return false;
		}
		return true;
	}
}
