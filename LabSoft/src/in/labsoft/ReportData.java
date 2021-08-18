package in.labsoft;

public class ReportData {
	
	private int ReportId;
	private String ReportDate, PatientName, DoctorName, TestExam;
	private String TestName, TestFactor, TestUnit;
	private int TestMin, TestMax, TestActual;
	
	public ReportData(int reportId, String reportDate, String patientName, String doctorName, String testExam,
			String testName, String testFactor, String testUnit, int testMin, int testMax, int testActual) {
		super();
		ReportId = reportId;
		ReportDate = reportDate;
		PatientName = patientName;
		DoctorName = doctorName;
		TestExam = testExam;
		TestName = testName;
		TestFactor = testFactor;
		TestUnit = testUnit;
		TestMin = testMin;
		TestMax = testMax;
		TestActual = testActual;
	}

	public ReportData() {
		super();
	}

	public int getReportId() {
		return ReportId;
	}

	public void setReportId(int reportId) {
		ReportId = reportId;
	}

	public String getReportDate() {
		return ReportDate;
	}

	public void setReportDate(String reportDate) {
		ReportDate = reportDate;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getTestExam() {
		return TestExam;
	}

	public void setTestExam(String testExam) {
		TestExam = testExam;
	}

	public String getTestName() {
		return TestName;
	}

	public void setTestName(String testName) {
		TestName = testName;
	}

	public String getTestFactor() {
		return TestFactor;
	}

	public void setTestFactor(String testFactor) {
		TestFactor = testFactor;
	}

	public String getTestUnit() {
		return TestUnit;
	}

	public void setTestUnit(String testUnit) {
		TestUnit = testUnit;
	}

	public int getTestMin() {
		return TestMin;
	}

	public void setTestMin(int testMin) {
		TestMin = testMin;
	}

	public int getTestMax() {
		return TestMax;
	}

	public void setTestMax(int testMax) {
		TestMax = testMax;
	}

	public int getTestActual() {
		return TestActual;
	}

	public void setTestActual(int testActual) {
		TestActual = testActual;
	}	
}
