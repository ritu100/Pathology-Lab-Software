package in.labsoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TestSubCategory extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private int itemNo;
	private JDesktopPane jdp;
	private JTextField text2;
	private JButton btnAdd;
	private JPanel panel;
	private JButton btnSave;
	private JComboBox cmbCat;
	private JTable table;
	private JScrollPane jsp;
	public TestSubCategory(JDesktopPane jp) {
		super("Pathological Test Sub-Categories",false,true,false,true);
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		itemNo = 0;
		
		JLabel lblCategoryName = new JLabel("Sub-Category Name");
		lblCategoryName.setBounds(10, 42, 121, 14);
		getContentPane().add(lblCategoryName);
		
		text2 = new JTextField();
		text2.setBounds(141, 39, 188, 20);
		getContentPane().add(text2);
		text2.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					itemNo++;
					MyTableModel model=(MyTableModel)table.getModel();
					model.addRow(itemNo, text2.getText());
					table.revalidate(); 
			        table.repaint();
			        clearTexts();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Can't add record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
				btnSave.setEnabled(true);
			}
		});
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setBounds(329, 39, 64, 20);
		getContentPane().add(btnAdd);
		
		JLabel label = new JLabel("Category Name");
		label.setBounds(10, 14, 121, 14);
		getContentPane().add(label);
		
		cmbCat = new JComboBox();
		cmbCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbCat.getSelectedIndex() != 0) {
					clearTexts();
					cmbCat.setEnabled(false);
				}
				else
				{
					text2.setEditable(false);
					btnAdd.setEnabled(false);
					btnSave.setEnabled(false);
				}
			}
		});
		cmbCat.setBounds(141, 11, 188, 20);
		getContentPane().add(cmbCat);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Sub-Category List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(2, 67, 393, 149);
		panel.setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel);
		
		String[] col=new String[] {"ID","Sub-Category"};
		Object[][] data=new Object[0][2];
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
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		DefaultTableCellRenderer cRenderer = new DefaultTableCellRenderer();
		cRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cRenderer);
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(jsp);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = null;
				int Count = 0;
				MyTableModel model=(MyTableModel)table.getModel();
				int rows = model.getRowCount();
				DBManager dbConn=DBManager.getInstance();
				try {
					for (int i = 0; i < rows; i++) {
						SQL = "insert into labsoft.tbl_test_subcat(cat_name,subcat_name) values('" + cmbCat.getSelectedItem().toString() + "','" + model.getValueAt(i, 1).toString() + "');";
						int cnt = dbConn.insertRecords(SQL);
						Count +=cnt;
						SQL = null;
					}
					if (Count > 0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						model.clearRowData(2);
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
				btnSave.setEnabled(false);
				text2.setEditable(false);
				btnAdd.setEnabled(false);
				cmbCat.setEnabled(true);
			}
		});
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSave.setBounds(329, 222, 64, 20);
		getContentPane().add(btnSave);
		setBounds(20, 20, 420, 282);
		setVisible(true);
		fillCmbCat();
	}
	
	private void fillCmbCat()
	{
		ArrayList<String> catNames=new ArrayList<String>();
		catNames.add("None");
		String SQL = "select cat_name from labsoft.tbl_test_cat order by cat_id;";
		DBManager dbconn=DBManager.getInstance();
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				catNames.add(rs.getString(1));
			}
			rs.close();
			rs=null;
			cmbCat.setModel(new DefaultComboBoxModel(catNames.toArray()));
			cmbCat.setSelectedIndex(0);
			formLoad();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void formLoad()
	{
		text2.setEditable(false);
		btnAdd.setEnabled(false);
		btnSave.setEnabled(false);
	}
	
	private void clearTexts()
	{
		text2.setEditable(true);
		text2.setText(null);
		btnAdd.setEnabled(true);
		text2.requestFocus();
	}
}
