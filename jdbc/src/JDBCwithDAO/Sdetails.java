package JDBCwithDAO;




public class Sdetails {
	
	private int id;
	private static String Sname;
	private String Remarks;
	private int maths;
	private int science;
	private int english;
	private String  result;
	private String Division;
	public Sdetails(int id, String sname, String result,int science, int english, int maths, String remarks,
			String division) {
		
		this.id = id;
		Sname = sname;
		this.maths = maths;
		this.science = science;
		this.english = english;
		this.result = result;
		Remarks = remarks;
		Division = division;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sdetails.Sname = sname;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	
	
	@Override
	public String toString() {
		return "Sdetails [id=" + id + ", Sname=" + Sname + ", maths=" + maths + ", science=" + science + ", english="
				+ english + ", result=" + result + ", Remarks=" + Remarks + ", Division=" + Division + "]";
	}
	
	

}
