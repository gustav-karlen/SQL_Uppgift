package Model;

public class Donereading {

	public String ccode;
	public String spnr;
	public String grade;
	public String term;

	public Donereading (String ccode, String spnr,String grade, String term){
		setCcode(ccode);
		setSpnr(spnr);
		setGrade(grade);
		setTerm(term);
	}
	public Donereading () {
		
	}
	public String getCcode(){
		return ccode;
	}
	public void setCcode(String ccode){
		this.ccode = ccode;
	}
	public String getSpnr(){
		return spnr;
	}
	public void setSpnr(String spnr){
		this.spnr = spnr;
	}
	public String getGrade(){
		return grade;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}
	public String getTerm(){
		return term;
	}
	public void setTerm(String term){
		this.term = term; 
	}
}

