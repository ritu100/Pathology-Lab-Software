package in.labsoft;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class TestExamType extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField text1;
	private JTextField text2;
	private JButton btnSave;
	public TestExamType(JDesktopPane jp) {
		super("Pathological Test Examinitions",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Examinition ID");
		lblNewLabel.setBounds(10, 11, 107, 14);
		getContentPane().add(lblNewLabel);
		
		text1 = new JTextField();
		text1.setFont(new Font("Tahoma", Font.BOLD, 12));
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setEditable(false);
		text1.setBounds(127, 7, 47, 20);
		getContentPane().add(text1);
		text1.setColumns(10);
		
		JLabel lblCategoryName = new JLabel("Examinition Name");
		lblCategoryName.setBounds(10, 36, 107, 14);
		getContentPane().add(lblCategoryName);
		
		text2 = new JTextField();
		text2.setBounds(127, 33, 202, 20);
		getContentPane().add(text2);
		text2.setColumns(10);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = null;
				int Count = 0;
				int examId = Integer.parseInt(text1.getText());
				DBManager dbConn=DBManager.getInstance();
				try {
					SQL = "insert into labsoft.tbl_test_exam values("+ examId + ",'" + text2.getText() + "');";
					Count = dbConn.insertRecords(SQL);
					if (Count > 0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						getCatID();
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
					SQL = null;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSave.setBounds(329, 33, 64, 20);
		getContentPane().add(btnSave);
		setBounds(20, 20, 420, 95);
		setVisible(true);
		getCatID();
	}
	
	private void getCatID()
	{
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getLastID("sp_getLastExamID(?)");
		} catch (Exception e) {
			id = 1;
		}
		text1.setText(Integer.toString(id));
		clearTexts();
	}
	
	private void clearTexts()
	{
		text2.setText(null);
		text2.requestFocus();
	}
}