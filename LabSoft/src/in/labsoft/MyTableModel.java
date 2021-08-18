package in.labsoft;

import java.awt.Color;
import java.awt.Component;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class MyTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private Object[][] rowData;
	private String[] columnNames;
	
	public MyTableModel(Object[][] data, String[] cols) {
		this.rowData = data;
		this.columnNames = cols;
	}
	
	public String getColumnName(int col) {
		return columnNames[col].toString();
	}
	
	public int getRowCount() { return rowData.length; }
	
	public int getColumnCount() { return columnNames.length; }
	
	public Object getValueAt(int row, int col) {
		return rowData[row][col];
	}
	
	public boolean isCellEditable(int row, int col){ return false; }
	
	public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }
	
	public void setValueAt(Object value, int row, int col) {
		rowData[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	public void clearRowData(int col)
	{
		rowData = new Object[0][col];
		fireTableDataChanged();
	}
	
	public void addRow(String fname) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][1];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
		}
		rowData[newData.length][0]=fname;
		fireTableDataChanged();
	}
	
	public void removeRow(int rowIndex,int col)
	{
		int i=0,j=0,k=0;
		Object[][] newData=rowData;
		rowData = new Object[newData.length - 1][col];
		for (i=0;i<newData.length;i++) {
			if(i != rowIndex)
			{
				for(j=0;j<col;j++)
				{
					rowData[k][j]=newData[i][j];
				}
				k++;
			}
		}
		fireTableDataChanged();
	}
	
	public void addRow(String id,String name) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][2];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
		}
		rowData[newData.length][0]=id;
		rowData[newData.length][1]=name;
		fireTableDataChanged();
	}
	
	public void addRow(int id,String name) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][2];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
		}
		rowData[newData.length][0]=id;
		rowData[newData.length][1]=name;
		fireTableDataChanged();
	}
	
	public void addRow(String medName,String cmpName,float unitPrice,String medCat,int qty) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][5];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
			rowData[i][2]=newData[i][2];
			rowData[i][3]=newData[i][3];
			rowData[i][4]=newData[i][4];
		}
		rowData[newData.length][0]=medName;
		rowData[newData.length][1]=cmpName;
		rowData[newData.length][2]=unitPrice;
		rowData[newData.length][3]=medCat;
		rowData[newData.length][4]=qty;
		fireTableDataChanged();
	}
	
	public void addRow(int itemNo,String medName,String medType,int qty) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][4];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
			rowData[i][2]=newData[i][2];
			rowData[i][3]=newData[i][3];
		}
		rowData[newData.length][0]=itemNo;
		rowData[newData.length][1]=medName;
		rowData[newData.length][2]=medType;
		rowData[newData.length][3]=qty;
		fireTableDataChanged();
	}
	
	public void addRow(String medName,String medType,int oqty,float price,int rqty,float amt,float tax,float total) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][8];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
			rowData[i][2]=newData[i][2];
			rowData[i][3]=newData[i][3];
			rowData[i][4]=newData[i][4];
			rowData[i][5]=newData[i][5];
			rowData[i][6]=newData[i][6];
			rowData[i][7]=newData[i][7];
		}
		rowData[newData.length][0]=medName;
		rowData[newData.length][1]=medType;
		rowData[newData.length][2]=oqty;
		rowData[newData.length][3]=price;
		rowData[newData.length][4]=rqty;
		rowData[newData.length][5]=amt;
		rowData[newData.length][6]=tax;
		rowData[newData.length][7]=total;
		fireTableDataChanged();
	}
	
	public void addRow(String factor,String unit,int min,int max) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][4];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
			rowData[i][2]=newData[i][2];
			rowData[i][3]=newData[i][3];
		}
		rowData[newData.length][0]=factor;
		rowData[newData.length][1]=unit;
		rowData[newData.length][2]=min;
		rowData[newData.length][3]=max;
		fireTableDataChanged();
	}
	
	public void addRow(int id,String test,String factor,String unit,int min,int max,int reading) {
		Object[][] newData=rowData;
		rowData = new Object[newData.length + 1][7];
		for (int i=0;i<newData.length;i++) {
			rowData[i][0]=newData[i][0];
			rowData[i][1]=newData[i][1];
			rowData[i][2]=newData[i][2];
			rowData[i][3]=newData[i][3];
			rowData[i][4]=newData[i][4];
			rowData[i][5]=newData[i][5];
			rowData[i][6]=newData[i][6];
		}
		rowData[newData.length][0]=id;
		rowData[newData.length][1]=test;
		rowData[newData.length][2]=factor;
		rowData[newData.length][3]=unit;
		rowData[newData.length][4]=min;
		rowData[newData.length][5]=max;
		rowData[newData.length][6]=reading;
		fireTableDataChanged();
	}
}
