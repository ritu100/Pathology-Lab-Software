package in.labsoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ViewStock extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jdp;
	private JTable table;
	private JPanel panel;
	private JScrollPane jsp;
	private DefaultTableCellRenderer centerRenderer, rightRenderer;
	
	public ViewStock(JDesktopPane jp) {
		super("View Medicine Stock Details",false,true,false,true);
		this.jdp=jp;
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 664, 432);
		panel.setLayout(new BorderLayout(2, 2));
		getContentPane().add(panel);
		
		String[] col=new String[] {"ID","Medicine","Type","Min. Qty","Stock"};
		Object[][] data=getTableData();
		table = new JTable(new MyTableModel(data,col)){
		    private static final long serialVersionUID = 1L;
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		        Component returnComp = super.prepareRenderer(renderer, row, column);
		        Color alternateColor = new Color(252,242,206);
		        Color whiteColor = Color.YELLOW;
		        if (!returnComp.getBackground().equals(getSelectionBackground())){
		            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
		            returnComp.setBackground(bg);
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
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(new MyTableCellRenderer());
		
		table.setFillsViewportHeight(true);
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(jsp, BorderLayout.CENTER);
		
		setBounds(20, 20, 700, 490);
		setVisible(true);
	}
	
	private Object[][] getTableData(){
		Object[][] temp=null;
		String SQL = null;
		DBManager dbconn=DBManager.getInstance();
		try {
			SQL = "select stock_id,med_name,med_category,min_level,med_stock from labsoft.tbl_med_stock order by stock_id;";			
			ResultSet rs=dbconn.selectRecords(SQL);
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			temp=new Object[rows][5];
			int i=0;
			while(rs.next()) {
				temp[i][0]=rs.getObject("stock_id");
				temp[i][1]=rs.getObject("med_name");
				temp[i][2]=rs.getObject("med_category");
				temp[i][3]=rs.getObject("min_level");
				temp[i][4]=rs.getObject("med_stock");
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve medicine list", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return temp;
	}
}
