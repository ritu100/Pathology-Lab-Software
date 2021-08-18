package in.labsoft;

import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DesktopManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MedicineInfo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTextField txtMedName;
	private JTextField txtMedPrice;
	private JTextField txtQty;
	private JTable table;
	private JScrollPane jsp;
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JComboBox cmbCmpName;
	private JComboBox cmbCategory;
	private JButton btnAddTable;
	private JButton btnSave;
	private JButton btnExit;
	private JButton btnAdd;
	private JPanel panel4;
	private JTable table1;
	private JScrollPane jsp1;
	private JButton btnExit1;
	private DefaultTableCellRenderer centerRenderer;
	/**
	 * Create the frame.
	 */
	public MedicineInfo(JDesktopPane jp) {
		setBorder(null);
		this.jdp=jp;
		setBackground(Color.BLACK);
		setLayout(null);
		
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int selectedIndex = tabbedPane.getSelectedIndex();
				if (selectedIndex == 1) {
					String[] col=new String[] {"Name","Company","Price","Type","Qty"};
					Object[][] data=getTableData();
					table1.setModel(new MyTableModel(data,col));
				}
			}
		});
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setBounds(10, 11, 654, 390);
		add(tabbedPane);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);
		tabbedPane.addTab("New Medicine", null, panel1, null);
		tabbedPane.setForegroundAt(0, new Color(75, 0, 130));
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		panel1.setLayout(null);
		
		JLabel label = new JLabel("Medicine Name");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBorder(new LineBorder(Color.MAGENTA));
		label.setBounds(10, 11, 188, 24);
		panel1.add(label);
		
		txtMedName = new JTextField();
		txtMedName.setHorizontalAlignment(SwingConstants.LEFT);
		txtMedName.setColumns(10);
		txtMedName.setBounds(10, 37, 188, 24);
		panel1.add(txtMedName);
		
		JLabel label_1 = new JLabel("Medicine Company Name");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(new LineBorder(Color.MAGENTA));
		label_1.setBounds(10, 72, 188, 24);
		panel1.add(label_1);
		
		cmbCmpName = new JComboBox();
		cmbCmpName.setEditable(true);
		cmbCmpName.setForeground(new Color(75, 0, 130));
		cmbCmpName.setBounds(10, 100, 142, 25);
		panel1.add(cmbCmpName);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompanyNames cmp=new CompanyNames(MedicineInfo.this);
				cmp.setVisible(true);
			}
		});
		btnAdd.setForeground(new Color(75, 0, 130));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdd.setBorder(new LineBorder(Color.BLUE));
		btnAdd.setBounds(156, 100, 42, 25);
		panel1.add(btnAdd);
		
		JLabel label_2 = new JLabel("Medicine Unit Price");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(Color.MAGENTA));
		label_2.setBounds(10, 136, 188, 24);
		panel1.add(label_2);
		
		txtMedPrice = new JTextField();
		txtMedPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtMedPrice.setColumns(10);
		txtMedPrice.setBounds(10, 163, 188, 24);
		panel1.add(txtMedPrice);
		
		JLabel label_3 = new JLabel("Medicine Category");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBorder(new LineBorder(Color.MAGENTA));
		label_3.setBounds(10, 197, 188, 24);
		panel1.add(label_3);
		
		cmbCategory = new JComboBox();
		String[] str = {"Tablets","Syrups","Saline","Syringe","Soluble"};
		cmbCategory.setModel(new DefaultComboBoxModel<String>(str));
		cmbCategory.setSelectedIndex(0);
		cmbCategory.setEditable(true);
		cmbCategory.setForeground(new Color(75, 0, 130));
		cmbCategory.setBounds(10, 225, 188, 25);
		panel1.add(cmbCategory);
		
		JLabel label_4 = new JLabel("Minimum Quantity Level");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBorder(new LineBorder(Color.MAGENTA));
		label_4.setBounds(10, 261, 188, 24);
		panel1.add(label_4);
		
		txtQty = new JTextField();
		txtQty.setHorizontalAlignment(SwingConstants.LEFT);
		txtQty.setColumns(10);
		txtQty.setBounds(10, 290, 188, 24);
		panel1.add(txtQty);
		
		btnAddTable = new JButton("ADD TO LIST");
		btnAddTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyTableModel model=(MyTableModel)table.getModel();
				model.addRow(txtMedName.getText(), cmbCmpName.getSelectedItem().toString(), Float.parseFloat(txtMedPrice.getText()),cmbCategory.getSelectedItem().toString(), Integer.parseInt(txtQty.getText()));
				table.revalidate(); 
		        table.repaint();
		        clearFields();
			}
		});
		btnAddTable.setForeground(new Color(75, 0, 130));
		btnAddTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddTable.setBorder(new LineBorder(Color.BLUE));
		btnAddTable.setBounds(10, 325, 188, 28);
		panel1.add(btnAddTable);
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(Color.MAGENTA));
		panel2.setBounds(208, 11, 434, 303);
		panel1.add(panel2);
		panel2.setLayout(new BorderLayout(5, 5));
		
		String[] col=new String[] {"Name","Company","Price","Type","Qty"};
		Object[][] data=new Object[0][5];
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
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel2.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel2.add(jsp, BorderLayout.CENTER);
		
		btnSave = new JButton("SAVE MEDICINES");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = null;
				int Count = 0;
				MyTableModel model=(MyTableModel)table.getModel();
				int rows = model.getRowCount();
				DBManager dbConn=DBManager.getInstance();
				try {
					for (int i = 0; i < rows; i++) {
						SQL = "insert into labsoft.tbl_medicines(med_name,med_cmp,med_price,med_type,med_qty) values('" +
							  "" + model.getValueAt(i, 0).toString() + "','" + model.getValueAt(i, 1).toString() + "'," + (float)model.getValueAt(i, 2) + ",'" +
							  "" + model.getValueAt(i, 3).toString() + "'," + (int)model.getValueAt(i, 4) + ");";
						int cnt = dbConn.insertRecords(SQL);
						Count +=cnt;
						SQL = null;
						
						SQL = "insert into labsoft.tbl_med_stock(med_name,med_category,min_level,med_stock) values('" +
							  "" + model.getValueAt(i, 0).toString() + "','" + model.getValueAt(i, 3).toString() + "'," + (int)model.getValueAt(i, 4) + ",0);";
						int cnt1 = dbConn.insertRecords(SQL);
						Count +=cnt1;
						SQL = null;
					}
					if (Count>0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						model.clearRowData(5);
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
				} catch (Exception e) {
			
				}
			}
		});
		btnSave.setForeground(new Color(75, 0, 130));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBorder(new LineBorder(Color.BLUE));
		btnSave.setBounds(348, 325, 188, 28);
		panel1.add(btnSave);
		
		btnExit = new JButton("EXIT");
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
				jdp.remove(MedicineInfo.this);
				jdp.revalidate();
				jdp.repaint();
			}
		});
		btnExit.setForeground(new Color(75, 0, 130));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBorder(new LineBorder(Color.BLUE));
		btnExit.setBounds(537, 325, 105, 28);
		panel1.add(btnExit);
		
		panel3 = new JPanel();
		panel3.setBackground(Color.BLACK);
		tabbedPane.addTab("Show Medcines", null, panel3, null);
		tabbedPane.setForegroundAt(1, new Color(75, 0, 130));
		tabbedPane.setBackgroundAt(1, Color.BLACK);
		panel3.setLayout(null);
		
		panel4 = new JPanel();
		panel4.setBorder(new LineBorder(Color.MAGENTA));
		panel4.setBounds(10, 11, 629, 311);
		panel3.add(panel4);
		panel4.setLayout(new BorderLayout(5, 5));
		
		String[] col1=new String[] {"Name","Company","Price","Type","Qty"};
		Object[][] data1=new Object[0][5];
		table1 = new JTable(new MyTableModel(data,col)){
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
		table1.setForeground(Color.BLACK);
		table1.setBackground(Color.BLACK);
		table1.setShowHorizontalLines(true);
		table1.setShowVerticalLines(true);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.setBorder(new LineBorder(Color.GREEN));
		table1.getColumnModel().getColumn(0).setPreferredWidth(300);
		table1.getColumnModel().getColumn(1).setPreferredWidth(200);
		table1.getColumnModel().getColumn(2).setPreferredWidth(80);
		table1.getColumnModel().getColumn(3).setPreferredWidth(200);
		table1.getColumnModel().getColumn(4).setPreferredWidth(80);
		table1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table1.setFillsViewportHeight(true);
		jsp1=new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table1.getTableHeader().setBackground(Color.WHITE);
		table1.getTableHeader().setForeground(new Color(75,0,130));
		table1.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel4.add(table1.getTableHeader(), BorderLayout.PAGE_START);
		panel4.add(jsp1, BorderLayout.CENTER);
		
		btnExit1 = new JButton("EXIT");
		btnExit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				jdp.remove(MedicineInfo.this);
				jdp.revalidate();
				jdp.repaint();
			}
		});
		btnExit1.setForeground(new Color(75, 0, 130));
		btnExit1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit1.setBorder(new LineBorder(Color.BLUE));
		btnExit1.setBounds(534, 323, 105, 28);
		panel3.add(btnExit1);
		
		setBounds(20,20,678,416);
		setVisible(true);
		fillCompanyCombo();
	}
	
	private void fillCompanyCombo() {
		ArrayList<String> companies=new ArrayList<String>();
		String SQL = "select med_cmp_name from labsoft.tbl_med_cmp;";
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				companies.add(rs.getString("med_cmp_name"));
			}
			rs.close();
			rs=null;
			cmbCmpName.setModel(new DefaultComboBoxModel(companies.toArray()));
			cmbCmpName.setSelectedIndex(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean validateText()
	{
		if (txtMedName.getText().equals(null) || txtMedName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter medicine name...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtMedName.setText("");
			txtMedName.requestFocus();
			return false;
		}
		if (txtMedPrice.getText().equals(null) || txtMedPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter medicine unit price...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtMedPrice.setText("");
			txtMedPrice.requestFocus();
			return false;
		}
		if (txtQty.getText().equals(null) || txtQty.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter medicine quantity...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			txtQty.setText("");
			txtQty.requestFocus();
			return false;
		}
		return true;
	}
	
	private void clearFields()
	{
		txtMedName.setText(null);
		cmbCmpName.setSelectedIndex(0);
		txtMedPrice.setText(null);
		cmbCategory.setSelectedIndex(0);
		txtQty.setText(null);
		txtMedName.requestFocus();
	}
	
	private Object[][] getTableData(){
		Object[][] temp=null;
		String SQL = null;
		DBManager dbconn=DBManager.getInstance();
		try {
			SQL = "select med_name,med_cmp,med_price,med_type,med_qty from labsoft.tbl_medicines order by med_id;";			
			ResultSet rs=dbconn.selectRecords(SQL);
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			temp=new Object[rows][5];
			int i=0;
			while(rs.next()) {
				temp[i][0]=rs.getObject("med_name");
				temp[i][1]=rs.getObject("med_cmp");
				temp[i][2]=rs.getObject("med_price");
				temp[i][3]=rs.getObject("med_type");
				temp[i][4]=rs.getObject("med_qty");
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve medicine list", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return temp;
	}
}
