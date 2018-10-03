package Model;

public class Course {

	private String ccode;
	private String cname;
	private String cpoints;
	
	public Course (String ccode, String cname, String cpoints){
		setCcode(ccode);
		setCname(cname);
		setCpoints(cpoints);
	}
	public Course () {
		
	}
	
	public String getCcode(){
		return ccode;
	}
	public void setCcode(String ccode){
		this.ccode = ccode;
	}
	public String getCname(){
		return cname;
	}
	public void setCname(String cname){
		this.cname = cname;
	}
	public String getCpoints(){
		return cpoints;
	}
	public void setCpoints(String cpoints){
		this.cpoints = cpoints;
	}
	
	public void addCourse(){
		this.addCourse();
	}
	
}

