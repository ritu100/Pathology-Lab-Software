package in.labsoft;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CompanyNames extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Create the dialog.
	 */
	public CompanyNames(MedicineInfo mf) {
		setUndecorated(false);
		setType(Type.UTILITY);
		setResizable(false);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Add New Company Name");
		setBounds(100, 100, 453, 66);
		setLocationRelativeTo(mf);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Company Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBounds(10, 11, 109, 23);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 11, 233, 23);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBManager dbconn=DBManager.getInstance();
				try {
					String SQL = "insert into labsoft.tbl_med_cmp(med_cmp_name) values('" + textField.getText() +"');";
					int cnt = dbconn.insertRecords(SQL);
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "Company Name Added Successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
						textField.requestFocus();
					}else {
						JOptionPane.showMessageDialog(null, "Can't add new company...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(372, 11, 66, 23);
		contentPanel.add(btnNewButton);
	}
}
