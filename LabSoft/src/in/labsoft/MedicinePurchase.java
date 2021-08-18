package in.labsoft;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DesktopManager;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class MedicinePurchase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int itemNo;
	private ArrayList<String> suppliers, medicines;
	private JDesktopPane jdp;
	private JTextField textOrdId;
	private JTextField textEmail;
	private JTextField textContact1;
	private JTextField textCmp;
	private JTextField textContact2;
	private JTextField textPrice;
	private JTextField textQty;
	private DefaultTableCellRenderer centerRenderer;
	private JTable table;
	private JScrollPane jsp;
	private JTextField textType;
	private JComboBox cmbSuppName;
	private JComboBox cmbMedicine;
	private JButton btnAddToList;
	private JButton btnPlaceOrder;
	/**
	 * Create the frame.
	 */
	public MedicinePurchase(JDesktopPane jp) {
		super("Medicine Purchase Order",false,true,false,true);
		this.jdp=jp;
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.RED));
		panel.setBounds(10, 11, 735, 434);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.YELLOW));
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(10, 11, 715, 79);
		panel.add(panel1);
		panel1.setLayout(null);
		
		textOrdId = new JTextField();
		textOrdId.setForeground(new Color(128, 0, 0));
		textOrdId.setBorder(new LineBorder(new Color(171, 173, 179)));
		textOrdId.setHorizontalAlignment(SwingConstants.CENTER);
		textOrdId.setEditable(false);
		textOrdId.setColumns(10);
		textOrdId.setBounds(83, 11, 86, 24);
		panel1.add(textOrdId);
		
		JDateChooser dcOrdDate = new JDateChooser();
		dcOrdDate.setBorder(new LineBorder(Color.LIGHT_GRAY));
		dcOrdDate.setDateFormatString("dd-MM-yyyy");
		dcOrdDate.setBounds(587, 11, 118, 24);
		panel1.add(dcOrdDate);
		
		cmbSuppName = new JComboBox();
		cmbSuppName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select supp_email,supp_contact1,supp_contact2,supp_company from labsoft.tbl_supplier_info where supp_name='" + cmbSuppName.getSelectedItem().toString() + "';";
				DBManager dbconn=DBManager.getInstance();
				try {
					ResultSet rs = dbconn.selectRecords(SQL);
					if (rs.next()) {
						textEmail.setText(rs.getString(1).toString());
						textContact1.setText(String.valueOf(rs.getLong(2)));
						textContact2.setText(String.valueOf(rs.getLong(3)));
						textCmp.setText(rs.getString(4).toString());
					}
					rs.close();
					rs=null;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cmbSuppName.setBorder(new LineBorder(new Color(171, 173, 179)));
		cmbSuppName.setEditable(true);
		cmbSuppName.setForeground(new Color(75, 0, 130));
		cmbSuppName.setBounds(270, 11, 228, 25);
		panel1.add(cmbSuppName);
		
		textEmail = new JTextField();
		textEmail.setForeground(new Color(128, 0, 0));
		textEmail.setBorder(new LineBorder(new Color(171, 173, 179)));
		textEmail.setEditable(false);
		textEmail.setText((String) null);
		textEmail.setColumns(10);
		textEmail.setBounds(83, 43, 182, 25);
		panel1.add(textEmail);
		
		textContact1 = new JTextField();
		textContact1.setForeground(new Color(128, 0, 0));
		textContact1.setBorder(new LineBorder(new Color(171, 173, 179)));
		textContact1.setEditable(false);
		textContact1.setText((String) null);
		textContact1.setColumns(10);
		textContact1.setBounds(270, 43, 102, 25);
		panel1.add(textContact1);
		
		textCmp = new JTextField();
		textCmp.setForeground(new Color(128, 0, 0));
		textCmp.setBorder(new LineBorder(new Color(171, 173, 179)));
		textCmp.setEditable(false);
		textCmp.setText((String) null);
		textCmp.setColumns(10);
		textCmp.setBounds(484, 43, 221, 25);
		panel1.add(textCmp);
		
		JLabel label = new JLabel("Order ID");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBorder(new LineBorder(Color.MAGENTA));
		label.setBounds(10, 11, 63, 24);
		panel1.add(label);
		
		JLabel label_1 = new JLabel("Supplier Name");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(new LineBorder(Color.MAGENTA));
		label_1.setBounds(179, 11, 86, 24);
		panel1.add(label_1);
		
		JLabel lblInfo = new JLabel("Details");
		lblInfo.setForeground(Color.YELLOW);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setBorder(new LineBorder(Color.MAGENTA));
		lblInfo.setBounds(10, 43, 63, 25);
		panel1.add(lblInfo);
		
		JLabel label_5 = new JLabel("Order Date");
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBorder(new LineBorder(Color.MAGENTA));
		label_5.setBounds(508, 11, 69, 23);
		panel1.add(label_5);
		
		textContact2 = new JTextField();
		textContact2.setForeground(new Color(128, 0, 0));
		textContact2.setBorder(new LineBorder(new Color(171, 173, 179)));
		textContact2.setEditable(false);
		textContact2.setText((String) null);
		textContact2.setColumns(10);
		textContact2.setBounds(378, 43, 102, 25);
		panel1.add(textContact2);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(Color.YELLOW));
		panel2.setBackground(Color.BLACK);
		panel2.setBounds(10, 92, 715, 47);
		panel.add(panel2);
		panel2.setLayout(null);
		
		cmbMedicine = new JComboBox();
		cmbMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select med_price,med_type from labsoft.tbl_medicines where med_name='" + cmbMedicine.getSelectedItem().toString() + "';";
				DBManager dbconn=DBManager.getInstance();
				try {
					ResultSet rs = dbconn.selectRecords(SQL);
					if (rs.next()) {
						textPrice.setText(rs.getString(1).toString());
						textType.setText(rs.getString(2).toString());	
						textQty.requestFocus();
					}
					rs.close();
					rs=null;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cmbMedicine.setBorder(new LineBorder(new Color(171, 173, 179)));
		cmbMedicine.setEditable(true);
		cmbMedicine.setForeground(new Color(75, 0, 130));
		cmbMedicine.setBounds(84, 12, 181, 25);
		panel2.add(cmbMedicine);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setForeground(Color.YELLOW);
		lblMedicine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedicine.setBorder(new LineBorder(Color.MAGENTA));
		lblMedicine.setBounds(10, 12, 63, 24);
		panel2.add(lblMedicine);
		
		textPrice = new JTextField();
		textPrice.setBorder(new LineBorder(new Color(171, 173, 179)));
		textPrice.setText((String) null);
		textPrice.setColumns(10);
		textPrice.setBounds(394, 12, 63, 25);
		panel2.add(textPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.YELLOW);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBorder(new LineBorder(Color.MAGENTA));
		lblQuantity.setBounds(467, 12, 55, 24);
		panel2.add(lblQuantity);
		
		textQty = new JTextField();
		textQty.setBorder(new LineBorder(new Color(171, 173, 179)));
		textQty.setText((String) null);
		textQty.setColumns(10);
		textQty.setBounds(525, 12, 77, 25);
		panel2.add(textQty);
		
		itemNo = 0;
		btnAddToList = new JButton("ADD TO LIST");
		btnAddToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemNo++;
				MyTableModel model=(MyTableModel)table.getModel();
				model.addRow(itemNo, cmbMedicine.getSelectedItem().toString(), textType.getText().toString(),Integer.parseInt(textQty.getText()));
				table.revalidate(); 
		        table.repaint();
			}
		});
		btnAddToList.setForeground(new Color(75, 0, 130));
		btnAddToList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddToList.setBorder(new LineBorder(Color.BLUE));
		btnAddToList.setBounds(608, 9, 97, 28);
		panel2.add(btnAddToList);
		
		textType = new JTextField();
		textType.setBorder(new LineBorder(new Color(171, 173, 179)));
		textType.setEditable(false);
		textType.setText((String) null);
		textType.setColumns(10);
		textType.setBounds(272, 12, 112, 25);
		panel2.add(textType);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new LineBorder(Color.MAGENTA));
		panel3.setBounds(10, 143, 715, 254);
		panel.add(panel3);
		panel3.setLayout(new BorderLayout(5, 5));
		
		String[] col=new String[] {"Item No.","Medicines","Type","Quantity"};
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
		table.setForeground(Color.BLACK);
		table.setBackground(Color.BLACK);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.GREEN));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel3.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel3.add(jsp, BorderLayout.CENTER);
		
		btnPlaceOrder = new JButton("PLACE ORDER");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = null;
				int Count = 0;
				int ordId = Integer.parseInt(textOrdId.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
			    String dop = sdf.format(dcOrdDate.getDate());
				MyTableModel model=(MyTableModel)table.getModel();
				int rows = model.getRowCount();
				DBManager dbConn=DBManager.getInstance();
				try {
					for (int i = 0; i < rows; i++) {
						SQL = "insert into labsoft.tbl_purchase_details(ord_id,ord_date,med_name,med_type,med_qty) values(" +
							  "" + ordId + ",'" + dop + "','" + model.getValueAt(i, 1).toString() + "','" +
							  "" + model.getValueAt(i, 2).toString() + "'," + (int)model.getValueAt(i, 3) + ");";
						int cnt = dbConn.insertRecords(SQL);
						Count +=cnt;
					}
					SQL = "insert into labsoft.tbl_purchase_master(ord_date,supp_name,supp_email,supp_contact1,supp_contact2,supp_cmp) values('" +
						  "" + dop + "','" + cmbSuppName.getSelectedItem().toString() + "','" + textEmail.getText().toString() + "'," +
						  "" + Long.parseLong(textContact1.getText()) + "," + Long.parseLong(textContact2.getText()) + ",'" + textCmp.getText().toString() + "');";
					int cnt1 = dbConn.insertRecords(SQL);
					if (Count>0 && cnt1 > 0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						model.clearRowData(4);
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);						
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Can't insert record...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
				}
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
		btnPlaceOrder.setForeground(new Color(75, 0, 130));
		btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPlaceOrder.setBorder(new LineBorder(Color.BLUE));
		btnPlaceOrder.setBounds(593, 400, 132, 28);
		panel.add(btnPlaceOrder);
		
		setBounds(20,20,768,490);
		setVisible(true);
		formLoad();
	}
	
	private void formLoad() {
		suppliers=new ArrayList<String>();
		String SQL = "select supp_name from labsoft.tbl_supplier_info order by supp_id;";
		DBManager dbconn=DBManager.getInstance();
		textOrdId.setText(String.valueOf(dbconn.getLastID("sp_getLastOrdID(?)")));
		try {
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				suppliers.add(rs.getString("supp_name"));
			}
			rs.close();
			rs=null;
			cmbSuppName.setModel(new DefaultComboBoxModel(suppliers.toArray()));
			cmbSuppName.setSelectedIndex(0);
			
			medicines=new ArrayList<String>();
			SQL = "select med_name from labsoft.tbl_medicines order by med_id;";
			rs = dbconn.selectRecords(SQL);
			while(rs.next()) {
				medicines.add(rs.getString("med_name"));
			}
			rs.close();
			rs=null;
			cmbMedicine.setModel(new DefaultComboBoxModel(medicines.toArray()));
			cmbMedicine.setSelectedIndex(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
}
