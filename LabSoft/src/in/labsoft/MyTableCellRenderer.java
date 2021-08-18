package in.labsoft;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyTableCellRenderer extends JLabel implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	//private static final TableCellRenderer Renderer = new DefaultTableCellRenderer(); 
	private static final DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
	public MyTableCellRenderer()
	{
		setOpaque(true);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		Renderer.setHorizontalAlignment(SwingConstants.RIGHT);
		Component returnComp = Renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		String val1=table.getModel().getValueAt(row, col - 1).toString();
		if (col == 4) {
			if (Integer.parseInt(val1) >= Integer.parseInt(value.toString())) {
				returnComp.setForeground(Color.RED);
			}
			else
			{
				returnComp.setForeground(Color.BLACK);
			}
		}
		return returnComp;
	}
}
