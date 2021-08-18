package in.labsoft;

import javax.swing.table.AbstractTableModel;

public class MyReadingTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Object[][] rowData;
	private String[] columnNames;
	
	private final Class[] columnClass = new Class[] {
	        Integer.class, String.class, Double.class, Boolean.class
	    };
	
	public MyReadingTableModel(Object[][] data, String[] cols) {
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
	
	public boolean isCellEditable(int row, int col){ return true; }
	
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
