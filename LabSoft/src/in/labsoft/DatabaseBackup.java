package in.labsoft;

import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatabaseBackup extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField textUser;
	private JTextField textDatabase;
	private JTextField textPath;
	private JButton btnBackup;
	private JButton btnBrowse;
	private JPasswordField textPass;
	private JLabel label;
	private JTextField textUname;
	private JLabel label_1;
	private JPasswordField textUpass;
	private JLabel label_2;
	private JTextField textDb;
	private JLabel lblRestorePath;
	private JTextField textFilePath;
	private JButton btnRestorePath;
	private JButton btnRestore;
	public DatabaseBackup(JDesktopPane jp) {
		super("Database Backup & Restore Wizard",false,true,false,true);
		this.jdp=jp;
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setBounds(10, 11, 414, 221);
		getContentPane().add(tabbedPane);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);
		tabbedPane.addTab("Backup", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.YELLOW);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserName.setBorder(new LineBorder(Color.MAGENTA));
		lblUserName.setBounds(10, 11, 86, 24);
		panel1.add(lblUserName);
		
		textUser = new JTextField();
		textUser.setText((String) null);
		textUser.setForeground(new Color(128, 0, 0));
		textUser.setColumns(10);
		textUser.setBorder(new LineBorder(new Color(171, 173, 179)));
		textUser.setBounds(104, 11, 167, 25);
		panel1.add(textUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBorder(new LineBorder(Color.MAGENTA));
		lblPassword.setBounds(10, 46, 86, 24);
		panel1.add(lblPassword);
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setForeground(Color.YELLOW);
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatabase.setBorder(new LineBorder(Color.MAGENTA));
		lblDatabase.setBounds(10, 81, 86, 24);
		panel1.add(lblDatabase);
		
		textDatabase = new JTextField();
		textDatabase.setText((String) null);
		textDatabase.setForeground(new Color(128, 0, 0));
		textDatabase.setColumns(10);
		textDatabase.setBorder(new LineBorder(new Color(171, 173, 179)));
		textDatabase.setBounds(104, 81, 167, 25);
		panel1.add(textDatabase);
		
		JLabel lblBackupPath = new JLabel("Backup Path");
		lblBackupPath.setForeground(Color.YELLOW);
		lblBackupPath.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBackupPath.setBorder(new LineBorder(Color.MAGENTA));
		lblBackupPath.setBounds(10, 116, 86, 24);
		panel1.add(lblBackupPath);
		
		textPath = new JTextField();
		textPath.setEditable(false);
		textPath.setText("C:\\Temp");
		textPath.setForeground(new Color(128, 0, 0));
		textPath.setColumns(10);
		textPath.setBorder(new LineBorder(new Color(171, 173, 179)));
		textPath.setBounds(104, 116, 268, 25);
		panel1.add(textPath);
		
		btnBrowse = new JButton("");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnChooseActionPerformed(arg0);
			}
		});
		btnBrowse.setIcon(new ImageIcon(DatabaseBackup.class.getResource("/img/left_panel/ico_06.png")));
		btnBrowse.setForeground(new Color(75, 0, 130));
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBrowse.setBorder(new LineBorder(Color.BLUE));
		btnBrowse.setBounds(372, 116, 27, 24);
		panel1.add(btnBrowse);
		
		btnBackup = new JButton("BACKUP");
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackupActionPerformed(e);
			}
		});
		btnBackup.setForeground(new Color(75, 0, 130));
		btnBackup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackup.setBorder(new LineBorder(Color.BLUE));
		btnBackup.setBounds(104, 152, 167, 28);
		panel1.add(btnBackup);
		
		textPass = new JPasswordField();
		textPass.setAutoscrolls(false);
		textPass.setBounds(104, 46, 167, 24);
		panel1.add(textPass);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		tabbedPane.addTab("Restore", null, panel2, null);
		panel2.setLayout(null);
		
		label = new JLabel("User Name");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBorder(new LineBorder(Color.MAGENTA));
		label.setBounds(10, 11, 86, 24);
		panel2.add(label);
		
		textUname = new JTextField();
		textUname.setText((String) null);
		textUname.setForeground(new Color(128, 0, 0));
		textUname.setColumns(10);
		textUname.setBorder(new LineBorder(new Color(171, 173, 179)));
		textUname.setBounds(104, 11, 167, 25);
		panel2.add(textUname);
		
		label_1 = new JLabel("Password");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(new LineBorder(Color.MAGENTA));
		label_1.setBounds(10, 46, 86, 24);
		panel2.add(label_1);
		
		textUpass = new JPasswordField();
		textUpass.setAutoscrolls(false);
		textUpass.setBounds(104, 46, 167, 24);
		panel2.add(textUpass);
		
		label_2 = new JLabel("Database");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(Color.MAGENTA));
		label_2.setBounds(10, 81, 86, 24);
		panel2.add(label_2);
		
		textDb = new JTextField();
		textDb.setText((String) null);
		textDb.setForeground(new Color(128, 0, 0));
		textDb.setColumns(10);
		textDb.setBorder(new LineBorder(new Color(171, 173, 179)));
		textDb.setBounds(104, 81, 167, 25);
		panel2.add(textDb);
		
		lblRestorePath = new JLabel("Restore Path");
		lblRestorePath.setForeground(Color.YELLOW);
		lblRestorePath.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRestorePath.setBorder(new LineBorder(Color.MAGENTA));
		lblRestorePath.setBounds(10, 116, 86, 24);
		panel2.add(lblRestorePath);
		
		textFilePath = new JTextField();
		textFilePath.setText("C:\\Temp");
		textFilePath.setForeground(new Color(128, 0, 0));
		textFilePath.setEditable(false);
		textFilePath.setColumns(10);
		textFilePath.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFilePath.setBounds(104, 116, 268, 25);
		panel2.add(textFilePath);
		
		btnRestorePath = new JButton("");
		btnRestorePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelectActionPerformed(e);
			}
		});
		btnRestorePath.setIcon(new ImageIcon(DatabaseBackup.class.getResource("/img/left_panel/ico_04.png")));
		btnRestorePath.setForeground(new Color(75, 0, 130));
		btnRestorePath.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRestorePath.setBorder(new LineBorder(Color.BLUE));
		btnRestorePath.setBounds(372, 116, 27, 24);
		panel2.add(btnRestorePath);
		
		btnRestore = new JButton("RESTORE");
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				btnRestoreActionPerformed(ex);
			}
		});
		btnRestore.setForeground(new Color(75, 0, 130));
		btnRestore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRestore.setBorder(new LineBorder(Color.BLUE));
		btnRestore.setBounds(104, 152, 167, 28);
		panel2.add(btnRestore);
		
		setBounds(20, 20, 450, 280);
		setVisible(true);
	}
	
	private void btnChooseActionPerformed(ActionEvent arg0) {
        textPath.setText(getBackUpPath());
    }
	
	private void btnSelectActionPerformed(ActionEvent e) {
        textFilePath.setText(getRestorePath());
    }
	
	private static String getBackUpPath() {
		String backUpPath = "";
		JFileChooser fc = null;
		if (fc == null) {
			fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fc.setAcceptAllFileFilterUsed(false);
		}
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			backUpPath = file.getAbsolutePath();
		}
		return backUpPath;
	}
	
	private static String getRestorePath() {
		String restorePath = "";
		JFileChooser fc = null;
		if (fc == null) {
			fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fc.setAcceptAllFileFilterUsed(false);
			FileFilter ff = new FileFilter(){
			    public boolean accept(File f){
			        if(f.isDirectory()) return true;
			        else if(f.getName().endsWith(".sql")) return true;
			            else return false;
			    }
			    public String getDescription(){
			        return "SQL Files";
			    }
			};
			fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
			fc.setFileFilter(ff);
		}
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			restorePath = file.getAbsolutePath();
		}
		return restorePath;
	}
	
	private void btnBackupActionPerformed(ActionEvent evt) {
		String backuppath=textPath.getText();
		String Database =textDatabase.getText();
		String Password =textPass.getText();
		String user=textUser.getText();
		DBManager dbconn = DBManager.getInstance();
		try
		{
			byte[] data = dbconn.getData("localhost", "3306", user, Password, Database).getBytes();
			File filedst = new File(backuppath+"\\"+Database+".zip");
			FileOutputStream dest = new FileOutputStream(filedst);
			ZipOutputStream zip = new ZipOutputStream(
			new BufferedOutputStream(dest));
			zip.setMethod(ZipOutputStream.DEFLATED);
			zip.setLevel(Deflater.BEST_COMPRESSION);
			zip.putNextEntry(new ZipEntry("data.sql"));
			zip.write(data);
			zip.close();
			dest.close();
			JOptionPane.showMessageDialog(null, "Back Up Successfully."+"\n"+"For Database: "+Database+"\n"+"On Dated: ","Database BackUp Wizard",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Back Up Failed."+"\n"+"For Database: "+Database+"\n "+"On Dated: ","Database BackUp Wizard",JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	private void btnRestoreActionPerformed(ActionEvent evt) {
		String result = null;
		String path=textFilePath.getText();
		String db =textDb.getText();
		String pass =textUpass.getText();
		String user=textUname.getText();
		DBManager dbconn = DBManager.getInstance();
		try
		{
			result = dbconn.restoreData(user, pass, db, path);
			if (result.equals("Restore Failed") || result.equals("") || result == null) {
				JOptionPane.showMessageDialog(null, "Restore Failed."+"\n"+"For Database: "+db+"\n "+"On Dated: ","Database Restore Wizard",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Restored Successfully."+"\n"+"For Database: "+db+"\n"+"On Dated: ","Database Restore Wizard",JOptionPane.INFORMATION_MESSAGE);
			}
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Restore Failed."+"\n"+"For Database: "+db+"\n "+"On Dated: ","Database Restore Wizard",JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}
	}
}
