package in.labsoft;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DesktopManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.BorderLayout;

public class RecieveOrder extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> orderIds; 
	private ArrayList<String> medicines; 
	private JDesktopPane jdp;
	private JTextField textRecvId;
	private JTextField textPrice;
	private JTextField textQty;
	private JTextField textTax;
	private JTextField textTotal;
	private JComboBox cmbOrdId;
	private JDateChooser dcRecvDate;
	private JLabel lblOrderDate;
	private JLabel lblSupplier;
	private JLabel lblEmail;
	private JLabel lblContact;
	private JLabel lblCompany;
	private JComboBox cmbMedicine;
	private JLabel lblType;
	private JLabel lblQty;
	private JButton btnRecieve;
	private JTextField textAmount;
	private JPanel panelTable;
	private JTable table;
	private JScrollPane jsp;
	private JLabel label_2;
	private JTextField textFinTotal;
	private JLabel lblDiscount;
	private JTextField textDisc;
	private JLabel lblAmountToBe;
	private JTextField textAmtPaid;
	private JButton btnRecieveOrder;
	public RecieveOrder(JDesktopPane jp) {
		super("Recieve Purchase Order",false,true,false,true);
		this.jdp=jp;
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblRecieveId = new JLabel("Recieve ID");
		lblRecieveId.setForeground(Color.YELLOW);
		lblRecieveId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecieveId.setBorder(new LineBorder(Color.MAGENTA));
		lblRecieveId.setBounds(10, 11, 63, 24);
		getContentPane().add(lblRecieveId);
		
		textRecvId = new JTextField();
		textRecvId.setText("1");
		textRecvId.setHorizontalAlignment(SwingConstants.CENTER);
		textRecvId.setForeground(new Color(128, 0, 0));
		textRecvId.setEditable(false);
		textRecvId.setColumns(10);
		textRecvId.setBorder(new LineBorder(new Color(171, 173, 179)));
		textRecvId.setBounds(83, 11, 45, 24);
		getContentPane().add(textRecvId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.YELLOW);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBorder(new LineBorder(Color.MAGENTA));
		lblDate.setBounds(277, 12, 34, 23);
		getContentPane().add(lblDate);
		
		dcRecvDate = new JDateChooser();
		dcRecvDate.setDateFormatString("dd-MM-yyyy");
		dcRecvDate.setBorder(new LineBorder(Color.LIGHT_GRAY));
		dcRecvDate.setBounds(321, 11, 141, 24);
		getContentPane().add(dcRecvDate);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setForeground(Color.YELLOW);
		lblOrderId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrderId.setBorder(new LineBorder(Color.MAGENTA));
		lblOrderId.setBounds(138, 11, 56, 24);
		getContentPane().add(lblOrderId);
		
		cmbOrdId = new JComboBox();
		cmbOrdId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL;
				DBManager dbconn=DBManager.getInstance();
				try {		
					SQL = "select ord_date, supp_name, supp_email, supp_contact1, supp_cmp from labsoft.tbl_purchase_master where ord_id = "+ Integer.parseInt(cmbOrdId.getSelectedItem().toString()) + ";";
					ResultSet rs = dbconn.selectRecords(SQL);
					if (rs.next()) {
						lblOrderDate.setText(rs.getString(1));
						lblSupplier.setText(rs.getString(2));
						lblEmail.setText(rs.getString(3));
						lblContact.setText(String.valueOf(rs.getLong(4)));
						lblCompany.setText(rs.getString(5));
					}
					rs.close();
					rs = null;
					
					medicines = new ArrayList<String>();
					SQL = "select med_name from labsoft.tbl_purchase_details where ord_id = " + Integer.parseInt(cmbOrdId.getSelectedItem().toString()) + " order by ord_id;";
					rs = dbconn.selectRecords(SQL);
					while(rs.next()) {
						medicines.add(rs.getString("med_name"));
					}
					rs.close();
					rs=null;
					cmbMedicine.setModel(new DefaultComboBoxModel(medicines.toArray()));
					cmbMedicine.setSelectedIndex(0);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cmbOrdId.setForeground(new Color(75, 0, 130));
		cmbOrdId.setEditable(true);
		cmbOrdId.setBorder(new LineBorder(new Color(171, 173, 179)));
		cmbOrdId.setBounds(204, 11, 63, 25);
		getContentPane().add(cmbOrdId);
		
		lblOrderDate = new JLabel("Order Date");
		lblOrderDate.setForeground(Color.YELLOW);
		lblOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrderDate.setBorder(new LineBorder(Color.MAGENTA));
		lblOrderDate.setBounds(10, 46, 88, 24);
		getContentPane().add(lblOrderDate);
		
		lblSupplier = new JLabel("Supplier Name");
		lblSupplier.setForeground(Color.YELLOW);
		lblSupplier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupplier.setBorder(new LineBorder(Color.MAGENTA));
		lblSupplier.setBounds(108, 46, 174, 24);
		getContentPane().add(lblSupplier);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.YELLOW);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBorder(new LineBorder(Color.MAGENTA));
		lblEmail.setBounds(292, 46, 155, 24);
		getContentPane().add(lblEmail);
		
		lblContact = new JLabel("Contact");
		lblContact.setForeground(Color.YELLOW);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContact.setBorder(new LineBorder(Color.MAGENTA));
		lblContact.setBounds(457, 46, 109, 24);
		getContentPane().add(lblContact);
		
		lblCompany = new JLabel("Company");
		lblCompany.setForeground(Color.YELLOW);
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompany.setBorder(new LineBorder(Color.MAGENTA));
		lblCompany.setBounds(576, 46, 109, 24);
		getContentPane().add(lblCompany);
		
		panelTable = new JPanel();
		panelTable.setBackground(Color.BLACK);
		panelTable.setBounds(10, 169, 675, 197);
		getContentPane().add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		String[] col=new String[] {"Medicine","Type","OrdQty","Price","RecvQty","Amount","Tax","Total"};
		Object[][] data=new Object[0][8];
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
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panelTable.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panelTable.add(jsp, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Medicine");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBorder(new LineBorder(Color.MAGENTA));
		label.setBounds(10, 81, 169, 17);
		getContentPane().add(label);
		
		cmbMedicine = new JComboBox();
		cmbMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL;
				DBManager dbconn=DBManager.getInstance();
				try {
					SQL = "select med_type, med_qty from labsoft.tbl_purchase_details where med_name = '" + cmbMedicine.getSelectedItem().toString() + "';";
					ResultSet rs = dbconn.selectRecords(SQL);
					if (rs.next()) {
						lblType.setText(rs.getString(1));
						lblQty.setText(String.valueOf(rs.getInt(2)));
						textPrice.requestFocus();
					}
					rs.close();
					rs=null;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cmbMedicine.setForeground(new Color(75, 0, 130));
		cmbMedicine.setEditable(true);
		cmbMedicine.setBorder(new LineBorder(new Color(171, 173, 179)));
		cmbMedicine.setBounds(10, 101, 169, 20);
		getContentPane().add(cmbMedicine);
		
		JLabel label_1 = new JLabel("Type");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBorder(new LineBorder(Color.MAGENTA));
		label_1.setBounds(189, 81, 74, 17);
		getContentPane().add(label_1);
		
		lblType = new JLabel("");
		lblType.setForeground(Color.YELLOW);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType.setBorder(new LineBorder(Color.MAGENTA));
		lblType.setBounds(189, 101, 74, 20);
		getContentPane().add(lblType);
		
		JLabel label_3 = new JLabel("Quantity");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBorder(new LineBorder(Color.MAGENTA));
		label_3.setBounds(273, 81, 50, 17);
		getContentPane().add(label_3);
		
		lblQty = new JLabel("");
		lblQty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQty.setForeground(Color.YELLOW);
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQty.setBorder(new LineBorder(Color.MAGENTA));
		lblQty.setBounds(273, 101, 50, 20);
		getContentPane().add(lblQty);
		
		JLabel label_5 = new JLabel("Unit Price");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBorder(new LineBorder(Color.MAGENTA));
		label_5.setBounds(333, 81, 56, 17);
		getContentPane().add(label_5);
		
		textPrice = new JTextField();
		textPrice.setText((String) null);
		textPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		textPrice.setForeground(new Color(128, 0, 0));
		textPrice.setColumns(10);
		textPrice.setBorder(new LineBorder(new Color(171, 173, 179)));
		textPrice.setBounds(333, 101, 56, 20);
		getContentPane().add(textPrice);
		
		JLabel label_6 = new JLabel("Recv Qty");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.YELLOW);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBorder(new LineBorder(Color.MAGENTA));
		label_6.setBounds(399, 81, 56, 17);
		getContentPane().add(label_6);
		
		textQty = new JTextField();
		textQty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				float price = Float.parseFloat(textPrice.getText());
				int qty = Integer.parseInt(textQty.getText());
				float amt = qty * price;
				textAmount.setText(String.valueOf(amt));
				textTax.requestFocus();
			}
		});
		textQty.setText((String) null);
		textQty.setHorizontalAlignment(SwingConstants.RIGHT);
		textQty.setForeground(new Color(128, 0, 0));
		textQty.setColumns(10);
		textQty.setBorder(new LineBorder(new Color(171, 173, 179)));
		textQty.setBounds(399, 101, 56, 20);
		getContentPane().add(textQty);
		
		JLabel label_7 = new JLabel("Tax");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.YELLOW);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBorder(new LineBorder(Color.MAGENTA));
		label_7.setBounds(533, 81, 50, 17);
		getContentPane().add(label_7);
		
		textTax = new JTextField();
		textTax.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				float amt = Float.parseFloat(textAmount.getText());
				float tax = (Float.parseFloat(textTax.getText()) / 100) * amt;
				float total = amt + tax;
				textTotal.setText(String.valueOf(total));
				btnRecieve.requestFocus();
			}
		});
		textTax.setText((String) null);
		textTax.setHorizontalAlignment(SwingConstants.RIGHT);
		textTax.setForeground(new Color(128, 0, 0));
		textTax.setColumns(10);
		textTax.setBorder(new LineBorder(new Color(171, 173, 179)));
		textTax.setBounds(533, 101, 50, 20);
		getContentPane().add(textTax);
		
		JLabel label_8 = new JLabel("Total");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBorder(new LineBorder(Color.MAGENTA));
		label_8.setBounds(593, 81, 92, 17);
		getContentPane().add(label_8);
		
		textTotal = new JTextField();
		textTotal.setText((String) null);
		textTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotal.setForeground(new Color(128, 0, 0));
		textTotal.setEditable(false);
		textTotal.setColumns(10);
		textTotal.setBorder(new LineBorder(new Color(171, 173, 179)));
		textTotal.setBounds(593, 101, 92, 20);
		getContentPane().add(textTotal);
		
		btnRecieve = new JButton("RECIEVE MEDICINE");
		btnRecieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyTableModel model=(MyTableModel)table.getModel();
				model.addRow(cmbMedicine.getSelectedItem().toString(), lblType.getText().toString(),Integer.parseInt(lblQty.getText()),Float.parseFloat(textPrice.getText()),
						Integer.parseInt(textQty.getText()),Float.parseFloat(textAmount.getText()),Float.parseFloat(textTax.getText()),Float.parseFloat(textTotal.getText()));
				table.revalidate(); 
		        table.repaint();
		        float total = Float.parseFloat(textFinTotal.getText());
		        total = total + Float.parseFloat(textTotal.getText());
		        textFinTotal.setText(String.valueOf(total));
		        cmbMedicine.requestFocus();
			}
		});
		btnRecieve.setForeground(new Color(75, 0, 130));
		btnRecieve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRecieve.setBorder(new LineBorder(Color.BLUE));
		btnRecieve.setBounds(285, 132, 144, 26);
		getContentPane().add(btnRecieve);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setForeground(Color.YELLOW);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAmount.setBorder(new LineBorder(Color.MAGENTA));
		lblAmount.setBounds(467, 81, 56, 17);
		getContentPane().add(lblAmount);
		
		textAmount = new JTextField();
		textAmount.setText((String) null);
		textAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		textAmount.setForeground(new Color(128, 0, 0));
		textAmount.setEditable(false);
		textAmount.setColumns(10);
		textAmount.setBorder(new LineBorder(new Color(171, 173, 179)));
		textAmount.setBounds(467, 101, 56, 20);
		getContentPane().add(textAmount);
		
		label_2 = new JLabel("Total");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBorder(new LineBorder(Color.MAGENTA));
		label_2.setBounds(343, 370, 92, 17);
		getContentPane().add(label_2);
		
		textFinTotal = new JTextField();
		textFinTotal.setEditable(false);
		textFinTotal.setText((String)"0");
		textFinTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textFinTotal.setForeground(new Color(128, 0, 0));
		textFinTotal.setColumns(10);
		textFinTotal.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFinTotal.setBounds(343, 390, 92, 20);
		getContentPane().add(textFinTotal);
		
		lblDiscount = new JLabel("Discount");
		lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiscount.setForeground(Color.YELLOW);
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiscount.setBorder(new LineBorder(Color.MAGENTA));
		lblDiscount.setBounds(445, 370, 56, 17);
		getContentPane().add(lblDiscount);
		
		textDisc = new JTextField();
		textDisc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				float amt = Float.parseFloat(textFinTotal.getText());
				float disc = (Float.parseFloat(textDisc.getText()) / 100) * amt;
				float total = amt - disc;
				textAmtPaid.setText(String.valueOf(total));
				btnRecieveOrder.requestFocus();
			}
		});
		textDisc.setText((String) null);
		textDisc.setHorizontalAlignment(SwingConstants.RIGHT);
		textDisc.setForeground(new Color(128, 0, 0));
		textDisc.setColumns(10);
		textDisc.setBorder(new LineBorder(new Color(171, 173, 179)));
		textDisc.setBounds(445, 390, 56, 20);
		getContentPane().add(textDisc);
		
		lblAmountToBe = new JLabel("Amount to be Paid");
		lblAmountToBe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmountToBe.setForeground(Color.YELLOW);
		lblAmountToBe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAmountToBe.setBorder(new LineBorder(Color.MAGENTA));
		lblAmountToBe.setBounds(511, 370, 174, 17);
		getContentPane().add(lblAmountToBe);
		
		textAmtPaid = new JTextField();
		textAmtPaid.setText((String) null);
		textAmtPaid.setHorizontalAlignment(SwingConstants.RIGHT);
		textAmtPaid.setForeground(new Color(128, 0, 0));
		textAmtPaid.setEditable(false);
		textAmtPaid.setColumns(10);
		textAmtPaid.setBorder(new LineBorder(new Color(171, 173, 179)));
		textAmtPaid.setBounds(511, 390, 174, 20);
		getContentPane().add(textAmtPaid);
		
		btnRecieveOrder = new JButton("RECIEVE ORDER");
		btnRecieveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = null;
				int Count = 0;
				int recvId = Integer.parseInt(textRecvId.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
			    String dor = sdf.format(dcRecvDate.getDate());
				MyTableModel model=(MyTableModel)table.getModel();
				int rows = model.getRowCount();
				DBManager dbConn=DBManager.getInstance();
				try {
					for (int i = 0; i < rows; i++) {
						SQL = "insert into labsoft.tbl_recv_details(recv_id,med_name,med_type,ord_qty,unit_price,recv_qty,med_amt,amt_tax,med_total) values(" +
							  "" + recvId + ",'" + model.getValueAt(i, 0).toString() + "','" + model.getValueAt(i, 1).toString() + "'," + (int)model.getValueAt(i, 2) + "," +
							  "" + (float)model.getValueAt(i, 3) +","+ (int)model.getValueAt(i, 4) +","+ (float)model.getValueAt(i, 5) +","+ (float)model.getValueAt(i, 6) +","+ (float)model.getValueAt(i, 7) + ");";
						int cnt = dbConn.insertRecords(SQL);
						Count +=cnt;
						
						int cnt1 = dbConn.updateStock(model.getValueAt(i, 0).toString(), (int)model.getValueAt(i, 4));
						Count += cnt1;
						SQL = null;
					}
					SQL = "insert into labsoft.tbl_recv_master(ord_id,recv_date,ord_date,supp_name,supp_contact,recv_total,recv_disc,recv_paid) values(" + Integer.parseInt(cmbOrdId.getSelectedItem().toString()) + ",'" +
						  "" + dor + "','" + lblOrderDate.getText() + "','" + lblSupplier.getText() + "'," + Long.parseLong(lblContact.getText()) + "," + Double.parseDouble(textFinTotal.getText()) + "," + Float.parseFloat(textDisc.getText()) + "," + Double.parseDouble(textAmtPaid.getText()) + ");";
					JOptionPane.showMessageDialog(null,"SQL = "+SQL);
					int cnt1 = dbConn.insertRecords(SQL);
					SQL = null;
					if (Count>0 && cnt1 > 0) {
						JOptionPane.showMessageDialog(null, Count + " Records inserted successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
						SQL = "update labsoft.tbl_purchase_master set is_active=0 where ord_id = " + Integer.parseInt(cmbOrdId.getSelectedItem().toString()) + ";";
						dbConn.deleteRecords(SQL);
						SQL = null;
						model.clearRowData(8);
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
		btnRecieveOrder.setForeground(new Color(75, 0, 130));
		btnRecieveOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRecieveOrder.setBorder(new LineBorder(Color.BLUE));
		btnRecieveOrder.setBounds(343, 421, 342, 26);
		getContentPane().add(btnRecieveOrder);
		setBounds(20, 20, 710, 490);
		setVisible(true);
		formLoad();
	}
	
	private void formLoad() {
		String SQL;
		orderIds = new ArrayList<Integer>();
		DBManager dbconn=DBManager.getInstance();
		textRecvId.setText(String.valueOf(dbconn.getLastID("sp_getLastRecvID(?)")));
		try {
			SQL = "select ord_id from labsoft.tbl_purchase_master where is_active=1 order by ord_id;";
			ResultSet rs=dbconn.selectRecords(SQL);
			while(rs.next()) {
				orderIds.add(rs.getInt("ord_id"));
			}
			rs.close();
			rs=null;
			cmbOrdId.setModel(new DefaultComboBoxModel(orderIds.toArray()));
			cmbOrdId.setSelectedIndex(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Can't Retrieve Data from \nDatabase Tables...",cv.getLT(),JOptionPane.ERROR_MESSAGE);
		}
	}
}
