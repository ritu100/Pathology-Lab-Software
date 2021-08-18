package in.labsoft;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestFactors extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField textTestID;
	private JTextField textFactor;
	private JTextField textUnit;
	private JTextField textMin;
	private JTextField textMax;
	private JComboBox cmbTestName;
	private JButton btnAdd;
	private JPanel panel;
	private JButton btnSave;
	private JTable table;
	private JScrollPane jsp;
	public TestFactors(JDesktopPane jp) {
		super("Add Test Factors",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		JLabel lblTestId = new JLabel("Test ID");
		lblTestId.setHorizontalAlignment(SwingConstants.LEFT);
		lblTestId.setBounds(10, 15, 75, 14);
		getContentPane().add(lblTestId);
		
		textTestID = new JTextField();
		textTestID.setHorizontalAlignment(SwingConstants.CENTER);
		textTestID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textTestID.setEditable(false);
		textTestID.setColumns(10);
		textTestID.setBounds(95, 11, 75, 20);
		getContentPane().add(textTestID);
		
		JLabel lblTestName = new JLabel("Test Name");
		lblTestName.setHorizontalAlignment(SwingConstants.LEFT);
		lblTestName.setBounds(10, 45, 76, 14);
		getContentPane().add(lblTestName);
		
		textFactor = new JTextField();
		textFactor.setText((String) null);
		textFactor.setColumns(10);
		textFactor.setBounds(10, 87, 132, 20);
		getContentPane().add(textFactor);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyTableModel model=(MyTableModel)table.getModel();
				model.addRow(textFactor.getText().toString(), textUnit.getText().toString(), Integer.parseInt(textMin.getText().toString()),Integer.parseInt(textMax.getText().toString()));
				table.revalidate(); 
		        table.repaint();
		        btnSave.setEnabled(true);
		        textFactor.setText(null);
		        textUnit.setText(null);
		        textMin.setText(null);
		        textMax.setText(null);
		        textFactor.requestFocus();
			}
		});
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setBounds(238, 118, 186, 20);
		getContentPane().add(btnAdd);
		
		cmbTestName = new JComboBox();
		cmbTestName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!cmbTestName.getSelectedItem().toString().equals("None")) {
					try {
						getTestID(cmbTestName.getSelectedItem().toString());
						enableTexts();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		cmbTestName.setBounds(95, 42, 329, 20);
		getContentPane().add(cmbTestName);
		
		JLabel lblFactorName = new JLabel("Factor Name");
		lblFactorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFactorName.setBounds(10, 73, 132, 14);
		getContentPane().add(lblFactorName);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setBounds(152, 73, 76, 14);
		getContentPane().add(lblUnit);
		
		JLabel lblMinValue = new JLabel("Min Value");
		lblMinValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinValue.setBounds(238, 73, 88, 14);
		getContentPane().add(lblMinValue);
		
		JLabel lblMaxValue = new JLabel("Max Value");
		lblMaxValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxValue.setBounds(336, 73, 88, 14);
		getContentPane().add(lblMaxValue);
		
		textUnit = new JTextField();
		textUnit.setText((String) null);
		textUnit.setColumns(10);
		textUnit.setBounds(152, 87, 76, 20);
		getContentPane().add(textUnit);
		
		textMin = new JTextField();
		textMin.setText((String) null);
		textMin.setColumns(10);
		textMin.setBounds(238, 87, 88, 20);
		getContentPane().add(textMin);
		
		textMax = new JTextField();
		textMax.setText((String) null);
		textMax.setColumns(10);
		textMax.setBounds(336, 87, 88, 20);
		getContentPane().add(textMax);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(10, 150, 414, 233);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		String[] col=new String[] {"Factor","Unit","Min","Max"};
		Object[][] data=new Object[0][4];
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
		table.setForeground(new Color(75,0,130));
		table.setFont(new Font("Tahoma",Font.BOLD,12));
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.black));
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(2).setCellRenderer(right);
		table.getColumnModel().getColumn(3).setCellRenderer(right);
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(jsp, BorderLayout.CENTER);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = null;
				int Count = 0;
				int testId = Integer.parseInt(textTestID.getText());
				String testName = cmbTestName.getSelectedItem().toString();
				MyTableModel model=(MyTableModel)table.getModel();
				int rows = model.getRowCount();
				DBManager dbConn=DBManager.getInstance();
				try {
					for (int i = 0; i < rows; i++) {
						SQL = "insert into labsoft.tbl_test_factors(test_id,test_name,factor_name,factor_unit,factor_min,factor_max) values(" +
							  "" + testId + ",'" + testName + "','" + model.getValueAt(i, 0).toString() + "','" +
							  "" + model.getValueAt(i, 1).toString() + "'," + (int)model.getValueAt(i, 2) + "," + (int)model.getValueAt(i, 3) + ");";
						int cnt = dbConn.insertRecords(SQL);
						Count +=cnt;
					}
					if (Count>0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						model.clearRowData(4);
						disableTexts();
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSave.setBounds(238, 394, 186, 29);
		getContentPane().add(btnSave);
		setBounds(20, 20, 450, 465);
		setVisible(true);
		fillCmbTest();
	}
	
	private void fillCmbTest()
	{
		ArrayList<String> testNames=new ArrayList<String>();
		testNames.add("None");
		String SQL = "select test_name from labsoft.tbl_major_tests order by test_id;";
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				testNames.add(rs.getString(1));
			}
			rs.close();
			rs=null;
			cmbTestName.setModel(new DefaultComboBoxModel(testNames.toArray()));
			disableTexts();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void disableTexts()
	{
		textTestID.setText(null);
		textTestID.setEditable(false);
		textFactor.setEditable(false);
		textUnit.setEditable(false);
		textMin.setEditable(false);
		textMax.setEditable(false);
		btnAdd.setEnabled(false);
		btnSave.setEnabled(false);
		cmbTestName.setSelectedIndex(0);
		cmbTestName.requestFocus();
	}
	
	private void enableTexts()
	{
		textFactor.setEditable(true);
		textUnit.setEditable(true);
		textMin.setEditable(true);
		textMax.setEditable(true);
		btnAdd.setEnabled(true);
		textFactor.setText(null);
		textUnit.setText(null);
		textMin.setText(null);
		textMax.setText(null);
		textFactor.requestFocus();
	}
	
	private void getTestID(String tname)
	{
		int id;
		DBManager dbconn=DBManager.getInstance();
		try {
			id = dbconn.getSelectedTestID(tname);
		} catch (Exception e) {
			id = 0;
		}
		textTestID.setText(Integer.toString(id));
		textTestID.setEditable(false);
	}
}
