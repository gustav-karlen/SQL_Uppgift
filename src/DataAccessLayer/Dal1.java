package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.*;

public class Dal {

	public static Connection getConnection() throws SQLException{
		String sqlConnect = "jdbc:sqlserver://Lenovo;databasename=DATABAS;user=DATABAS;password=hej";
		return DriverManager.getConnection(sqlConnect);
	}	

	public static void test(){
		Connection con = null;
		try {
			con = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void createStudent(String spnr, String sname) throws Exception {
		PreparedStatement pstm;
		String sqlString;
		Connection con = getConnection();

		sqlString = "INSERT INTO student (spnr, sname) VALUES(?,?)";

		try{
			pstm = con.prepareStatement(sqlString);
			pstm.setString(1, spnr);
			pstm.setString(2, sname);
			pstm.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void createCourse(String ccode, String cname, String cpoints) throws Exception {
		PreparedStatement pstm;
		String sqlString;
		Connection con = getConnection();
		sqlString = "INSERT INTO Course (ccode, cname, cpoints) VALUES (?,?,?)";

		try {
			pstm = con.prepareStatement(sqlString);
			pstm.setString(1, ccode);
			pstm.setString(2, cname);   
			pstm.setString(3, cpoints);
			pstm.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}




	public static Course findCourse (String courseCode) throws Exception{
		PreparedStatement pstm;
		ResultSet rSet;
		Connection con = Dal.getConnection();
		String sqlString;
		Course c = null;

		sqlString = "SELECT * FROM Course WHERE ccode = ?";

		try {
			pstm = con.prepareStatement(sqlString);
			pstm.setString(1, courseCode );
			rSet = pstm.executeQuery();
			if (rSet.next()){
				c = new Course();
				c.setCcode(courseCode);
				c.setCname(rSet.getString("Coursename"));
				c.setCpoints(rSet.getString(0)); 
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return c;
	}


	public static void createStudentOnReading (String spnr, String ccode, String term)throws Exception {
		PreparedStatement pstm;
		Connection con = Dal.getConnection();

		String sqlString ="INSERT INTO reading (spnr, ccode, term) VALUES (?,?,?)";

		try {
			pstm = con.prepareStatement(sqlString);
			pstm.setString(1, spnr);
			pstm.setString(2, ccode);
			pstm.setString(3, term);
			pstm.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}



	public static void createStudentOnDonereading (String ccode, String spnr, String grade, String term)throws Exception {
		PreparedStatement pstm;
		Connection con = Dal.getConnection();
		String sqlString;
		Donereading dr = new Donereading();
		dr.getSpnr();
		dr.getCcode();
		dr.getGrade();
		dr.getTerm();

		sqlString = "INSERT INTO donereading (spnr, ccode, grade, term) VALUES(?,?,?,?)";

		try{
			pstm = con.prepareStatement(sqlString);
			pstm.setString(1, spnr);
			pstm.setString(2, ccode);
			pstm.setString(3, grade);
			pstm.setString(4, term);
			pstm.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}




	public static List<Donereading> searchGrade (String spnr) throws Exception {
		List<Donereading> list = new ArrayList<>();
		PreparedStatement pstm;
		ResultSet rSet;
		Connection con = Dal.getConnection();
		try{
			spnr+="%";
			pstm = con.prepareStatement("select * from donereading where spnr like ?");
			pstm.setString(1, spnr);
			rSet = pstm.executeQuery();

			while(rSet.next()){
				Donereading tempDone = convertRowToGrade(rSet);
				list.add(tempDone);
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}


	private static Donereading convertRowToGrade(ResultSet rSet) throws Exception {

		String ccode = rSet.getString("ccode");
		String term =rSet.getString("term");
		String grade = rSet.getString("grade");
		String spnr =rSet.getString("spnr");

		Donereading tempDone = new Donereading(ccode,spnr,grade,term);
		return tempDone;
	}




	public static ArrayList<Donereading> findDonereading (String ccode) throws Exception {
		PreparedStatement pstm;
		Connection con = Dal.getConnection();
		String sqlString;
		ResultSet rSet;

		sqlString ="select * from donereading where ccode = ?";

		ArrayList<Donereading> lista = new ArrayList<Donereading>();

		try {
			pstm = con.prepareStatement(sqlString);
			pstm.setString(1, ccode);

			rSet = pstm.executeQuery();
			while(rSet.next()){
				Donereading dr = new Donereading();
				dr.setSpnr(rSet.getString("spnr"));
				dr.setTerm(rSet.getString("term"));
				dr.setGrade(rSet.getString("grade"));
				dr.setCcode(rSet.getString("ccode"));
				lista.add(dr);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}

	public static List<Student> searchStudents (String spnr) throws Exception {
		List<Student> list = new ArrayList<>();
		PreparedStatement pstm;
		ResultSet rSet;
		Connection con = Dal.getConnection();
		try{
			spnr+="%";
			pstm = con.prepareStatement("select * from student where spnr like ?");
			pstm.setString(1, spnr);
			rSet = pstm.executeQuery();

			while(rSet.next()){
				Student tempStudent = convertRowToStudents(rSet);
				list.add(tempStudent);
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public static List<Student> getAllStudents () throws Exception {
		List<Student> list = new ArrayList<Student>();

		Connection con = Dal.getConnection();
		Statement stm;
		ResultSet rSet;
		try{
			stm = con.createStatement();
			rSet = stm.executeQuery("select * from student");

			while (rSet.next()){
				Student tempStudents = convertRowToStudents(rSet);
				list.add(tempStudents);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return list;

	}

	private static Student convertRowToStudents(ResultSet rSet) throws Exception {

		String spnr = rSet.getString("spnr");
		String name = rSet.getString("sname");

		Student tempStudents = new Student(spnr,name);
		return tempStudents;
	}

	public static List <Course> searchCourses (String ccode) throws Exception {
		List<Course> list = new ArrayList<>();
		PreparedStatement pstm;
		ResultSet rSet;
		Connection con = Dal.getConnection();
		try{
			ccode+="%";
			pstm = con.prepareStatement("select * from course where ccode like ?");
			pstm.setString(1, ccode);
			rSet = pstm.executeQuery();

			while(rSet.next()){
				Course tempCourses = convertRowToCourse(rSet);
				list.add(tempCourses);
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public static List<Course> getAllCourses () throws Exception {
		List<Course> courselist = new ArrayList<Course>();

		Connection con = Dal.getConnection();
		Statement stm;
		ResultSet rSet;
		try{
			stm = con.createStatement();
			rSet = stm.executeQuery("select * from course");

			while (rSet.next()){
				Course tempCourses = convertRowToCourse(rSet);
				courselist.add(tempCourses);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return courselist;
	}

	private static Course convertRowToCourse(ResultSet rSet) throws Exception{

		String ccode = rSet.getString("ccode");
		String cname = rSet.getString("cname");
		String cpoints =rSet.getString("cpoints");

		Course tempCourse = new Course(ccode,cname,cpoints);
		return tempCourse;
	}

	public static List <Donereading> searchDonereading (String ccode) throws Exception {
		List<Donereading> list = new ArrayList<>();
		PreparedStatement pstm;
		ResultSet rSet;
		Connection con = Dal.getConnection();
		try{
			ccode +="%";
			pstm = con.prepareStatement("select * from donereading where ccode like ?");
			pstm.setString(1, ccode);
			rSet = pstm.executeQuery();

			while(rSet.next()){
				Donereading tempDone = convertRowToDonereading(rSet);
				list.add(tempDone);
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public static List<Donereading> getAllDonereading () throws Exception {
		List<Donereading> doneList = new ArrayList<Donereading>();

		Connection con = Dal.getConnection();
		Statement stm;
		ResultSet rSet;
		try{
			stm = con.createStatement();
			rSet = stm.executeQuery("select * from donereading");

			while (rSet.next()){
				Donereading tempDone = convertRowToDonereading(rSet);
				doneList.add(tempDone);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return doneList;
	}

	private static Donereading convertRowToDonereading(ResultSet rSet) throws Exception {

		String ccode = rSet.getString("ccode");
		String term =rSet.getString("term");
		String grade = rSet.getString("grade");
		String spnr =rSet.getString("spnr");

		Donereading tempDone = new Donereading (ccode,spnr,grade,term);
		return tempDone; 
	}

}
