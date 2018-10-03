package Model;

public class Student  {
//	tillfällig
	private String spnr;
	private String sname;
	
	
	/*this.spnr = spnr;
	this sname = sname;		
	this.setCourses(new ArrayList <course>());*/
	
	public Student (String spnr, String sname){
		setSpnr(spnr);
		setSname(sname);
	}
	public Student (){
		
	}
	
	public String getSpnr()
	{
		return spnr;
	}
	public void setSpnr(String spnr)
	{
		this.spnr = spnr;
	}
	public String getSname()
	{
		return sname;	
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	
	// skapa metoder på detta sättet?
	
	public void removeStudent(Student student){
		this.removeStudent(student);
	}
	public void updateStudent(Student student){
		student.setSpnr(spnr);
		student.setSname(sname);
	}
	public void addstudent(String name, String spnr, String ccode) {
		this.addstudent(name, spnr, ccode);
		
	}
	
}


