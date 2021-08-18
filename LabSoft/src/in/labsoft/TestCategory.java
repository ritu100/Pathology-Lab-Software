package in.labsoft;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TestCategory extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField text1;
	private JTextField text2;
	private JButton btnSave;
	public TestCategory(JDesktopPane jp) {
		super("Pathological Test Categories",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category ID");
		lblNewLabel.setBounds(10, 11, 107, 14);
		getContentPane().add(lblNewLabel);
		
		text1 = new JTextField();
		text1.setFont(new Font("Tahoma", Font.BOLD, 12));
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setEditable(false);
		text1.setBounds(127, 7, 47, 20);
		getContentPane().add(text1);
		text1.setColumns(10);
		
		JLabel lblCategoryName = new JLabel("Category Name");
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
				int catId = Integer.parseInt(text1.getText());
				DBManager dbConn=DBManager.getInstance();
				try {
					SQL = "insert into labsoft.tbl_test_cat values("+ catId + ",'" + text2.getText() + "');";
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
			id = dbconn.getLastID("sp_getLastCatID(?)");
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
