package in.labsoft;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestReports extends JInternalFrame {
	private int rId;
	private String rDate,pName,dName,tName;
	private SimpleDateFormat dateFormat;
	private JDesktopPane jdp;
	private JPanel panel;
	private JButton btnDelivered;
	
	public TestReports(JDesktopPane jp, int rID,String rDate,String pName,String dName,String tName) {
		super("Customer : Test Report Details",false,true,false,true);
		this.jdp=jp;
		this.rId = rID;
		this.rDate = rDate;
		this.pName=pName;
		this.dName=dName;
		this.tName=tName;		
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 747, 449);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnDelivered = new JButton("Delivered");
		btnDelivered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String SQL = "update labsoft.tbl_reading_main set IsDelivered = 1 where reading_id = " + rId + " and reading_date = '" + rDate + "';";
					DBManager conn=DBManager.getInstance();
					int count = conn.updateRecords(SQL);
					if(count > 0) {
						JOptionPane.showMessageDialog(null, "Report Status Updated Successfully...", cv.getLT(), JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Can't update report status...", cv.getLT(), JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelivered.setForeground(Color.GREEN);
		btnDelivered.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelivered.setBorder(new LineBorder(Color.RED));
		btnDelivered.setBackground(Color.BLACK);
		btnDelivered.setBounds(590, 471, 167, 39);
		getContentPane().add(btnDelivered);
		
		FillReportDetails();
		
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		setBounds(5, 20, 783, 550);
		setVisible(true);
	}
	
	private void FillReportDetails()
	{
		try {
			ReportDataModel reportModel=new ReportDataModel();
			List<Map<String,?>> dataSource=new ArrayList<Map<String,?>>();
			
			for(ReportData data : reportModel.getTests(rId, rDate, pName, dName, tName)) {
				Map<String,Object> m=new HashMap<String,Object>();
				m.put("ReportId",data.getReportId());
				m.put("ReportDate", data.getReportDate());
				m.put("PatientName", data.getPatientName());
				m.put("DoctorName", data.getDoctorName());
				m.put("TestExam", data.getTestExam());
				m.put("TestName", data.getTestName());
				m.put("TestFactor", data.getTestFactor());
				m.put("TestUnit", data.getTestUnit());
				m.put("TestMin", data.getTestMin());
				m.put("TestMax", data.getTestMax());
				m.put("TestActual", data.getTestActual());
				dataSource.add(m);
			}
			
			JRDataSource jrSource=new JRBeanCollectionDataSource(dataSource);
			String rptSource="src/in/labsoft/TestReport.jrxml";
			JasperReport report = JasperCompileManager.compileReport(rptSource);
			JasperPrint printReport = JasperFillManager.fillReport(report,null,jrSource);
			panel.add(new JRViewer(printReport),BorderLayout.CENTER);
			
			
			/*String SQL = "select test_id,test_name,test_factor,test_unit,test_min,test_max,test_reading from labsoft.tbl_reading_detail where reading_id = "+rId+";";
			DBManager dbconn = DBManager.getInstance();
			ResultSet rs = dbconn.selectRecords(SQL);
			if(rs != null) {
				JRDataSource jrDataSource = new JRResultSetDataSource(rs);
				String source="reports/TestReport.jrxml";
				JasperReport report = JasperCompileManager.compileReport(source);
				JasperPrint printReport = JasperFillManager.fillReport(report,null,jrDataSource);
				panel.add(new JRViewer(printReport),BorderLayout.CENTER);
			}
			else {
				JOptionPane.showMessageDialog(null, "Test Information is not available", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			}*/
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
