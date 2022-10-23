package yu.homework;

public class GradeInfo {
	
	private String id;
	private String name;
	private String mexam;
	private String fexam;
	private String report;
	private String attendance;
	private int sum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMexam() {
		return mexam;
	}
	public void setMexam(String mexam) {
		this.mexam = mexam;
	}
	public String getFexam() {
		return fexam;
	}
	public void setFexam(String fexam) {
		this.fexam = fexam;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(String attendance, String report, String fexam, String mexam) {
		this.sum = Integer.parseInt(attendance) + Integer.parseInt(report) + 
				Integer.parseInt(fexam) + Integer.parseInt(mexam);
	}
	
	public boolean checkSum() {
		if(sum > 60) {
			return true;
		}
		else return false;
	}
	
}
