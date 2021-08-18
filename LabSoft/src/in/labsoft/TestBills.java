package in.labsoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestBills extends JInternalFrame {
	private float totalCharge;
	private int rId;
	private String rDate,pName,dName,tName;
	private SimpleDateFormat dateFormat;
	private JDesktopPane jdp;
	private JPanel panel;
	private JTextField textDate;
	private JLabel txtTotalBillAccording;
	private JTextField textId;
	private JTextField textPatName;
	private JTextField textDocName;
	private JTextField textExam;
	private JPanel panel_1;
	private JPanel panel2;
	private JTable table;
	private JScrollPane jsp;
	private JLabel lblTotalCharges;
	private JTextField textTotal;
	
	public TestBills(JDesktopPane jp, int rID,String rDate,String pName,String dName,String tName) {
		super("Customer : Test Report Details",false,true,false,true);
		this.jdp=jp;
		this.rId = rID;
		this.rDate = rDate;
		this.pName=pName;
		this.dName=dName;
		this.tName=tName;		
		totalCharge = 0.0f;
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 747, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBorder(null);
		lblDate.setBounds(556, 51, 54, 25);
		panel.add(lblDate);
		
		textDate = new JTextField();
		textDate.setForeground(new Color(75, 0, 130));
		textDate.setText(rDate);
		textDate.setHorizontalAlignment(SwingConstants.CENTER);
		textDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		textDate.setEditable(false);
		textDate.setColumns(10);
		textDate.setBounds(611, 51, 126, 25);
		panel.add(textDate);
		
		txtTotalBillAccording = new JLabel();
		txtTotalBillAccording.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalBillAccording.setText("TOTAL BILL ACCORDING TO DIFFERENT TEST CHARGES");
		txtTotalBillAccording.setFont(new Font("Tahoma", Font.BOLD, 12));		
		txtTotalBillAccording.setBounds(10, 11, 727, 25);
		panel.add(txtTotalBillAccording);
		
		JLabel lblTestReportId = new JLabel("Test Report ID");
		lblTestReportId.setHorizontalAlignment(SwingConstants.LEFT);
		lblTestReportId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTestReportId.setBorder(null);
		lblTestReportId.setBounds(10, 51, 115, 25);
		panel.add(lblTestReportId);
		
		textId = new JTextField();
		textId.setForeground(new Color(75, 0, 130));
		textId.setEditable(false);
		textId.setText(String.valueOf(rId));
		textId.setFont(new Font("Tahoma", Font.BOLD, 12));
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setBounds(132, 51, 104, 25);
		panel.add(textId);
		textId.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPatientName.setBorder(null);
		lblPatientName.setBounds(10, 87, 115, 25);
		panel.add(lblPatientName);
		
		JLabel lblReferedBy = new JLabel("Refered By");
		lblReferedBy.setHorizontalAlignment(SwingConstants.LEFT);
		lblReferedBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReferedBy.setBorder(null);
		lblReferedBy.setBounds(10, 123, 115, 25);
		panel.add(lblReferedBy);
		
		textPatName = new JTextField();
		textPatName.setForeground(new Color(75, 0, 130));
		textPatName.setEditable(false);
		textPatName.setText(pName);
		textPatName.setHorizontalAlignment(SwingConstants.LEFT);
		textPatName.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPatName.setColumns(10);
		textPatName.setBounds(132, 87, 284, 25);
		panel.add(textPatName);
		
		textDocName = new JTextField();
		textDocName.setForeground(new Color(75, 0, 130));
		textDocName.setEditable(false);
		textDocName.setText(dName);
		textDocName.setHorizontalAlignment(SwingConstants.LEFT);
		textDocName.setFont(new Font("Tahoma", Font.BOLD, 12));
		textDocName.setColumns(10);
		textDocName.setBounds(132, 123, 284, 25);
		panel.add(textDocName);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 159, 727, 251);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textExam = new JTextField();
		textExam.setBorder(null);
		textExam.setForeground(new Color(75, 0, 130));
		textExam.setEditable(false);
		textExam.setText(tName);
		textExam.setHorizontalAlignment(SwingConstants.CENTER);
		textExam.setFont(new Font("Tahoma", Font.BOLD, 12));
		textExam.setColumns(10);
		textExam.setBounds(231, 11, 284, 25);
		panel_1.add(textExam);
		
		panel2 = new JPanel();
		panel2.setBounds(10, 43, 707, 170);
		panel_1.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		
		String[] col=new String[] {"TEST ID","TEST NAME","TEST CHARGES"};
		Object[][] data=getTableData();
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
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(right);	
		table.getColumnModel().getColumn(2).setCellRenderer(right);	
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel2.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel2.setLayout(new BorderLayout(0, 0));
		panel2.add(jsp);
		
		lblTotalCharges = new JLabel("Total Charges : ");
		lblTotalCharges.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalCharges.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalCharges.setBorder(null);
		lblTotalCharges.setBounds(482, 215, 115, 25);
		panel_1.add(lblTotalCharges);
		
		textTotal = new JTextField();
		textTotal.setForeground(new Color(75, 0, 130));
		textTotal.setEditable(false);
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		textTotal.setColumns(10);
		textTotal.setBounds(595, 218, 122, 25);
		panel_1.add(textTotal);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bill Details Saved Successfully...", cv.getLT(), JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(645, 417, 92, 21);
		panel.add(btnSave);
		
		textTotal.setText(new Float(totalCharge).toString());
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		setBounds(5, 20, 783, 500);
		setVisible(true);
	}
	
	public Object[][] getTableData(){
		Object[][] temp;
		int id;
		String name;
		float charge;
		int count = 1;
		try {
			DBManager dbconn = DBManager.getInstance();
			ResultSet rs = dbconn.getCharges(rId);
			if(rs != null) {
				rs.last();
				count = rs.getRow();
				rs.beforeFirst();
				temp=new Object[count][3];
				int i = 0;
				while(rs.next()) {
					id = rs.getInt(1);
					name = rs.getString(2);
					charge = rs.getFloat(3);					
					temp[i][0] = id;
					temp[i][1] = name;
					temp[i][2] = charge;
					totalCharge = (float)(totalCharge + charge);
					i++;
				}
			}
			else {
				temp=new Object[count][3];
			}			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			temp = new Object[count][3];
		}
		return temp;
	}
}
