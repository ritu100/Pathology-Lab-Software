package in.labsoft;

public class cv {
	
	private static String userName;
	private static String userType;
	private static int WT;
	private static int HT;
	private static String LT = "LabSoft v1.0";
	
	public static void setUser(String usr) {
		userName = usr;
	}
	
	public static String getUser() {
		return userName;
	}
	
	public static void setType(String type) {
		userType = type;
	}
	
	public static String getType() {
		return userType;
	}
	
	public static void setWH(int w, int h) {
		WT = w;
		HT = h;
	}
	
	public static int getWT() {
		return WT;
	}
	
	public static int getHT() {
		return HT;
	}
	
	public static String getLT() {
		return LT;
	}
}
