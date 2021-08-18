package in.labsoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import jdk.nashorn.internal.ir.TernaryNode;

public class DBManager {
	private static DBManager ref = null;
	private Connection conn = null;
	private Statement stmt = null;
	private CallableStatement cstmt = null;
	private ResultSet rs = null;
	private String sp_string = null;
	private int BUFFER = 10485760;
	
	private DBManager() throws Exception{
		try {
			InputStream input=this.getClass().getResourceAsStream("/properties/db.properties");
			Properties p=new Properties();
			p.load(input);
			String urlConn = p.getProperty("url");
	        String user = p.getProperty("user");
	        String password = p.getProperty("password");
	        conn = DriverManager.getConnection(urlConn,user,password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static DBManager getInstance() {
		if (ref == null) {
			try {
				ref = new DBManager();
			}catch(Exception e) {
				ref = null;
				System.out.println("Connection Error : "+e.getMessage());
			}
		}
		return ref;
	}
	
	private final void closeStatements() {
		sp_string = null;
	}
	
	public int insertRecords(String SQL)
	{
		int flag=0;
		try {
			stmt = conn.createStatement();
			flag= stmt.executeUpdate(SQL);
		} catch (Exception e) {
			flag = 0;
		}
		return flag;
	}
	
	public int updateRecords(String SQL)
	{
		int flag=0;
		try {
			stmt = conn.createStatement();
			flag= stmt.executeUpdate(SQL);
		} catch (Exception e) {
			flag = 0;
		}
		return flag;
	}
	
	public int deleteRecords(String SQL)
	{
		int flag=0;
		try {
			stmt = conn.createStatement();
			flag= stmt.executeUpdate(SQL);
		} catch (Exception e) {
			flag = 0;
		}
		return flag;
	}
	
	public int resetAutoInc(String tbl_name, int resetVal)
	{
		int flag = 0; 
		String SQL = "alter table " + tbl_name + " AUTO_INCREMENT = " + (resetVal - 1) + ";";
		try {
			stmt = conn.createStatement();
			flag = stmt.executeUpdate(SQL);
		} catch (Exception e) {
			flag = 0;
		}
		return flag;
	}
	
	public ResultSet selectRecords(String SQL)
	{
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(SQL);
		} catch (Exception e) {
			rs = null;
		}
		return rs;
	}
	
	public int getLastID(String sp_name) {
		int ID = 1;
		try {
			sp_string = "{call "+sp_name+"}";
			cstmt = conn.prepareCall(sp_string);
			cstmt.registerOutParameter("maxid", java.sql.Types.INTEGER);
			cstmt.executeUpdate();
			ID = cstmt.getInt("maxid") + 1;
			closeStatements();
		} catch (Exception e) {
			ID = 1;
			e.printStackTrace();
		}
		return ID;
	}
	
	public int getSelectedTestID(String tname) {
		int ID = 0;
		try {
			sp_string = "{call sp_getSelectedTestID(?,?)}";
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("tname", tname);
			cstmt.registerOutParameter("tid", java.sql.Types.INTEGER);
			cstmt.executeUpdate();
			ID = cstmt.getInt("tid");
			closeStatements();
		} catch (Exception e) {
			ID = 0;
			e.printStackTrace();
		}
		return ID;
	}
	
	public int insertDocDetails(ArrayList<String> al) {
		int cnt = 0;
		sp_string = "{call sp_insertDocDetails(?,?,?,?,?,?,?,?,?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("doc_name",al.get(0));
			cstmt.setString("doc_address", al.get(1));
			cstmt.setString("doc_email", al.get(2));
			cstmt.setLong("doc_contact1", Long.valueOf(al.get(3)));
			cstmt.setLong("doc_contact2", Long.valueOf(al.get(4)));
			cstmt.setString("doc_graduation", al.get(5));
			cstmt.setString("doc_pg", al.get(6));
			cstmt.setString("doc_other_edu", al.get(7));
			cstmt.setString("doc_hospital", al.get(8));
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	
	public ResultSet getDocNames() {
		sp_string = "{call sp_getDocNames()}";
		try {
			cstmt = conn.prepareCall(sp_string);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs = null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getSingleDocDetails(int id) {
		sp_string = "{call sp_getSingleDocDetails(?)}";
		try {
			cstmt=conn.prepareCall(sp_string);
			cstmt.setInt("docId", id);
			rs=cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public int setIssues(String issue) {
		int cnt=0;
		sp_string= "{call sp_setIssues(?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("is_name", issue);
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public ResultSet getAllIssues() {
		sp_string = "{call sp_getAllIssues()}";
		try {
			cstmt = conn.prepareCall(sp_string);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getAllDoctors() {
		sp_string = "{call sp_getAllDocNames()}";
		try {
			cstmt = conn.prepareCall(sp_string);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertPatDetails(ArrayList<String> al) {
		int cnt = 0;
		sp_string = "{call sp_insertPatDetails(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("p_name",al.get(0));
			cstmt.setString("p_add1", al.get(1));
			cstmt.setString("p_add2", al.get(2));
			cstmt.setString("p_add3", al.get(3));
			cstmt.setString("p_email", al.get(4));
			cstmt.setLong("p_contact1", Long.valueOf(al.get(5)));
			cstmt.setLong("p_contact2", Long.valueOf(al.get(6)));
			cstmt.setString("p_ocp", al.get(7));
			cstmt.setString("p_dob", al.get(8));
			cstmt.setInt("p_age", Integer.valueOf(al.get(9)));
			cstmt.setString("p_issue", al.get(10));
			cstmt.setString("p_familydoc", al.get(11));
			cstmt.setString("p_other", al.get(12));
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	
	public ResultSet getPatNames() {
		sp_string = "{call sp_getPatientNames()}";
		try {
			cstmt = conn.prepareCall(sp_string);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs = null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getCharges(int rid) {
		sp_string = "{call sp_getCharges(?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setInt("rid",rid);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs = null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getSinglePatDetails(int id) {
		sp_string = "{call sp_getSinglePatDetails(?)}";
		try {
			cstmt=conn.prepareCall(sp_string);
			cstmt.setInt("pId", id);
			rs=cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public int setCompany(String company) {
		int cnt=0;
		sp_string= "{call sp_setCompany(?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("cmpName", company);
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public ResultSet getAllCompanies() {
		sp_string = "{call sp_getAllCompanies()}";
		try {
			cstmt = conn.prepareCall(sp_string);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertSuppDetails(ArrayList<String> al) {
		int cnt = 0;
		sp_string = "{call sp_insertSuppDetails(?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("suppName",al.get(0));
			cstmt.setString("suppAdd1", al.get(1));
			cstmt.setString("suppAdd2", al.get(2));
			cstmt.setString("suppAdd3", al.get(3));
			cstmt.setString("suppEmail", al.get(4));
			cstmt.setLong("suppContact1", Long.valueOf(al.get(5)));
			cstmt.setLong("suppContact2", Long.valueOf(al.get(6)));
			cstmt.setString("suppCmpName", al.get(7));
			cstmt.setString("suppCmpAdd1", al.get(8));
			cstmt.setString("suppCmpAdd2", al.get(9));
			cstmt.setString("suppOther", al.get(10));
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	
	public ResultSet getSuppNames() {
		sp_string = "{call sp_getSuppNames()}";
		try {
			cstmt = conn.prepareCall(sp_string);
			rs = cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs = null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getSingleSuppDetails(int id) {
		sp_string = "{call sp_getSingleSuppDetails(?)}";
		try {
			cstmt=conn.prepareCall(sp_string);
			cstmt.setInt("suppId", id);
			rs=cstmt.executeQuery();
			closeStatements();
		} catch (Exception e) {
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertUserDetails(ArrayList<String> al) {
		int cnt = 0;
		sp_string = "{call sp_insertUserDetails(?,?,?,?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("userName", al.get(0));
			cstmt.setString("userType", al.get(1));
			cstmt.setString("loginName", al.get(2));
			cstmt.setString("loginPass", al.get(3));
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	
	public boolean validateUserPass(ArrayList<String> al) {
		boolean flag = false;
		sp_string = "{call sp_getUserPass(?,?,?,?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("type1", al.get(0));
			cstmt.setString("login", al.get(1));
			cstmt.setString("pass", al.get(2));
			cstmt.registerOutParameter("flag", java.sql.Types.BOOLEAN);
			cstmt.executeUpdate();
			flag = cstmt.getBoolean("flag");
			closeStatements();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public int updateStock(String medName,long qty) {
		int cnt=0;
		sp_string= "{call sp_updateStock(?,?)}";
		try {
			cstmt = conn.prepareCall(sp_string);
			cstmt.setString("medName", medName);
			cstmt.setLong("qty", qty);
			cnt = cstmt.executeUpdate();
			closeStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public String getData(String host, String port, String user, String password, String db) {
		String Mysqlpath = getMysqlBinPath(user, password, db);
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Mysqlpath);
		Process run = null;
		try {
			System.out.println(Mysqlpath + "mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + " --compact --complete-insert --extended-insert " + "--skip-comments --skip-triggers " + db);
			run = Runtime.getRuntime().exec(Mysqlpath + "mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + "  " + "--skip-comments --skip-triggers " + db);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		InputStream in = run.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuffer temp = new StringBuffer();
		int count;
		char[] cbuf = new char[BUFFER];
		try {
			while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
				temp.append(cbuf, 0, count);
			}
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			br.close();
			in.close();
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return temp.toString();
	}

	public String getMysqlBinPath(String user, String password, String db) {
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String a = "";
		try {
			rs = stmt.executeQuery("select @@basedir");
			while (rs.next()) {
				a = rs.getString(1);
			}
		} catch (Exception eee) {
			eee.printStackTrace();
		}
		a = a + "bin\\";
		System.err.println("Mysql path is :" + a);
		return a;
	}
	
	public String restoreData(String user, String pass, String db, String path) {
		String flag = null;
		try{
			String databaseName=db;
			String userName=user;
			String password=pass;
			int processComplete;
			String[] executeCmd = new String[]{"mysql", databaseName, "-u" + userName, "-p" + password, "-e", " source "+path };
			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			processComplete = runtimeProcess.waitFor();
			if(processComplete==1){
				flag = "Restore Failed";
			}
			else if(processComplete==0){
				flag = "Restore Completed";
			}
		}
		catch(Exception ex){
			flag = ex.getMessage();
		}
		return flag;
	}
}
