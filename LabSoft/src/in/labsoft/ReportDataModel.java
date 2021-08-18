package in.labsoft;

import java.sql.ResultSet;
import java.util.*;

public class ReportDataModel {

	public List<ReportData> getTests(int rID,String rDate,String pName,String dName,String tExam){
		List<ReportData> listTests = new ArrayList<ReportData>();
		String tn,tf,tu;
		int tmin,tmax,tread;
		try {
			String SQL = "select test_name,test_factor,test_unit,test_min,test_max,test_reading from labsoft.tbl_reading_detail where reading_id = "+ rID + ";";
			DBManager conn=DBManager.getInstance();
			ResultSet rs = conn.selectRecords(SQL);
			if(rs != null)
			{
				while(rs.next())
				{
					tn=rs.getString(1);
					tf=rs.getString(2);
					tu=rs.getString(3);
					tmin=rs.getInt(4);
					tmax=rs.getInt(5);
					tread=rs.getInt(6);
					
					listTests.add(new ReportData(rID,rDate,pName,dName,tExam,tn,tf,tu,tmin,tmax,tread));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTests;
	}
	
}
