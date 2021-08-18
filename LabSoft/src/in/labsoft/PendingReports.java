package in.labsoft;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PendingReports extends JInternalFrame {
	private FormMainGUI mainForm;
	private SimpleDateFormat dateFormat;
	private JDesktopPane jdp;
	private JPanel panel;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane jsp;
	
	public PendingReports(FormMainGUI rm,JDesktopPane jp) {
		super("Customer : Test Reading Details",false,true,false,true);
		this.mainForm = rm;
		this.jdp=jp;
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "List of Pending Reports", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.setBounds(10, 11, 747, 396);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("GET REPORT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					int Row = table.getSelectedRow();
					int rID = (int)table.getModel().getValueAt(Row, 0);
					String rDate = table.getModel().getValueAt(Row, 1).toString();
					String pName = table.getModel().getValueAt(Row, 2).toString();
					String dName = table.getModel().getValueAt(Row, 3).toString();
					String tName = table.getModel().getValueAt(Row, 4).toString();
					
					//JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information" + rID + "  ,   " + rDate, cv.getLT(), JOptionPane.ERROR_MESSAGE);
					
					mainForm.closeOpenedChilds();
					jp.add(new TestReports(jp,rID,rDate,pName,dName,tName));
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBorder(new LineBorder(Color.BLUE));
		btnNewButton.setForeground(new Color(148, 0, 211));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(557, 407, 200, 35);
		getContentPane().add(btnNewButton);
		
		String[] col=new String[] {"ID","Date","Patient","Doctor","Test"};
		Object[][] data=getTableData();
		table = new JTable(new MyReadingTableModel(data,col)){
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
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(right);		
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(jsp);
		
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		setBounds(5, 20, 783, 482);
		setVisible(true);
	}
	
	public Object[][] getTableData(){
		Object[][] temp;
		try {
			String SQL = "select reading_id,reading_date,cust_name,doc_name,test_exam from labsoft.tbl_reading_main where IsDelivered = 0;";
			DBManager dbconn = DBManager.getInstance();
			ResultSet rs = dbconn.selectRecords(SQL);
			if(rs != null) {
				rs.last();
				int count = rs.getRow();
				rs.beforeFirst();
				temp=new Object[count][5];
				int i = 0;
				while(rs.next()) {
					int id = rs.getInt(1);
					String date = rs.getString(2);
					String name = rs.getString(3);
					String dname = rs.getString(4);
					String tname = rs.getString(5);
					temp[i][0] = id;
					temp[i][1] = date;
					temp[i][2] = name;
					temp[i][3] = dname;
					temp[i][4] = tname;
					i++;
				}
			}
			else {
				temp = new Object[0][5];
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			temp = new Object[0][5];
		}
		return temp;
	}
}
