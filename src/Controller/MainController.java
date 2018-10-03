package Controller;

import java.util.ArrayList;
import java.util.List;

import DataAccessLayer.Dal;
import Model.Course;
import Model.Donereading;
import Model.Student;

public class MainController {


	public MainController (){

	}

	public static void createStudent (String spnr, String sname) throws Exception{
		Dal.createStudent(spnr, sname);
	}

	public static void createCourse (String ccode, String cname, String cpoints) throws Exception{
		Dal.createCourse(ccode, cname, cpoints);
	}


	public static Model.Course findCourse (String courseCode) throws Exception{
		return Dal.findCourse(courseCode);
	}

	public static ArrayList<Donereading> findDonereading (String ccode) throws Exception{
		return Dal.findDonereading(ccode);
	}


	public static void createStudentOnReading (String spnr, String ccode, String term) throws Exception {
		Dal.createStudentOnReading(spnr, ccode, term);
	}

	public static void createStudentOnDoneReadingStudent (String spnr, String ccode, String grade, String term)throws Exception {
		Dal.createStudentOnDonereading(ccode, spnr, grade, term);
	}



	public static List<Donereading> searchGrade (String spnr) throws Exception {
		return Dal.searchGrade(spnr);
	}
	public static ArrayList<Donereading> getAllGrades (String ccode) throws Exception{
		return Dal.findDonereading(ccode);
	}




	public List<Student> searchStudents (String spnr) throws Exception {
		return Dal.searchStudents(spnr);
	}
	public List<Student> getAllStudents () throws Exception{
		return Dal.getAllStudents();
	}




	public static List<Course> searchCourses (String ccode) throws Exception {
		return Dal.searchCourses(ccode);
	}

	public static List<Course> getAllCourses () throws Exception {
		return Dal.getAllCourses();
	}




	public static List<Donereading> searchDonereading (String ccode) throws Exception{
		return Dal.searchDonereading(ccode);
	}

	public static List<Donereading> getAllDonereading () throws Exception{
		return Dal.getAllDonereading();
	}
}


