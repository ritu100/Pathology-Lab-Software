package in.labsoft;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private FormMainGUI frmMain;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JComboBox<String> cmbUserType;

	/**
	 * Create the dialog.
	 */
	public LoginDialog(FormMainGUI f) {
		super(f,"Login Details",true);
		setResizable(false);
		this.frmMain = f;
		setUndecorated(false);
		setBounds(100, 100, 344, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GREEN));
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 10, 320, 170);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("User Name");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBorder(new LineBorder(Color.CYAN));
		label.setBounds(10, 10, 75, 30);
		panel.add(label);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(new Color(139, 0, 0));
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserName.setColumns(10);
		txtUserName.setBounds(95, 10, 215, 30);
		panel.add(txtUserName);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBorder(new LineBorder(Color.CYAN));
		label_1.setBounds(10, 90, 75, 30);
		panel.add(label_1);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					Toolkit.getDefaultToolkit().beep(); 
					String usr = txtUserName.getText();
					String type = cmbUserType.getSelectedItem().toString();
					String pass = String.valueOf(txtPassword.getPassword());
					
					ArrayList<String> al=new ArrayList<String>();
					al.add(type);
					al.add(usr);
					al.add(pass);
					DBManager dbconn = DBManager.getInstance();
					try {
						boolean flag = dbconn.validateUserPass(al);
						if (flag) {
							cv.setUser(usr);
							cv.setType(type);
							f.setUserProfile();
							dispose();
							JOptionPane.showMessageDialog(null, "Welcome \"" + cv.getUser().toUpperCase() + "\"... \nPallavi Pathological Laboratory Management", cv.getLT(), JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Sorry, invalid user or password\ntry again", cv.getLT(), JOptionPane.ERROR_MESSAGE);
							txtUserName.setText("");
							txtPassword.setText("");
							txtUserName.requestFocus();
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Sorry, Connection Error...\nPlease start database", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						txtUserName.setText("");
						txtPassword.setText("");
						txtUserName.requestFocus();
					}
				}
			}
		});
		txtPassword.setForeground(new Color(139, 0, 0));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(95, 90, 215, 30);
		panel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usr = txtUserName.getText();
				String type = cmbUserType.getSelectedItem().toString();
				String pass = String.valueOf(txtPassword.getPassword());
				
				ArrayList<String> al=new ArrayList<String>();
				al.add(type);
				al.add(usr);
				al.add(pass);
				DBManager dbconn = DBManager.getInstance();
				try {
					boolean flag = dbconn.validateUserPass(al);
					if (flag) {
						cv.setUser(usr);
						cv.setType(type);
						f.setUserProfile();
						dispose();
						JOptionPane.showMessageDialog(null, "Welcome \"" + cv.getUser().toUpperCase() + "\"... \nPallavi Pathological Laboratory Management", cv.getLT(), JOptionPane.PLAIN_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Sorry, invalid user or password\ntry again", cv.getLT(), JOptionPane.ERROR_MESSAGE);
						txtUserName.setText("");
						txtPassword.setText("");
						txtUserName.requestFocus();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry, Connection Error...\nPlease start database", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					txtUserName.setText("");
					txtPassword.setText("");
					txtUserName.requestFocus();
				}
			}
		});
		btnLogin.setForeground(new Color(75, 0, 130));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBorder(new LineBorder(Color.RED));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setActionCommand("Login");
		btnLogin.setBounds(95, 130, 102, 30);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(new Color(75, 0, 130));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBorder(new LineBorder(Color.RED));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setActionCommand("Cancel");
		btnCancel.setBounds(196, 130, 114, 30);
		panel.add(btnCancel);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setForeground(Color.YELLOW);
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserType.setBorder(new LineBorder(Color.CYAN));
		lblUserType.setBounds(10, 50, 75, 30);
		panel.add(lblUserType);
		
		cmbUserType = new JComboBox<String>();
		cmbUserType.addItem("Admin");
		cmbUserType.addItem("Standard");
		cmbUserType.addItem("Guest");
		cmbUserType.setBounds(95, 50, 215, 30);
		panel.add(cmbUserType);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.GREEN));
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(105, 190, 225, 50);
		contentPanel.add(panel1);
		panel1.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ancestor = SwingUtilities.getWindowAncestor(btnRegister);
				new RegisterDialog(ancestor);
			}
		});
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBorder(new LineBorder(Color.RED));
		btnRegister.setBounds(10, 10, 204, 30);
		panel1.add(btnRegister);
		
		cmbUserType.setSelectedIndex(0);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(frmMain);
	}
}
