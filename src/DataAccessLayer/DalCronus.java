package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DalCronus {

	public static Connection getConnection() throws SQLException{
		String sqlConnect = "jdbc:sqlserver://Lenovo;database=CRONUS;user=hej;password=hej";
		return DriverManager.getConnection(sqlConnect);
	}

	public static List<String> getEmployee(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "select [No_], [First Name], [Last Name], [Address], [City] from [CRONUS Sverige AB$Employee]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while(result.next()){
				temp.add(result.getString("No_"));  
				temp.add(result.getString("First Name"));
				temp.add(result.getString("Last Name"));
				temp.add(result.getString("Address"));
				temp.add(result.getString("City"));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}

	public static List<String> getEmployeeAbsence ()
	{
		List<String> temp = new ArrayList <String> ();
		try
		{
			Connection con = DalCronus.getConnection();
			String sql = "select [Entry No_], [Employee No_], [From Date], [To Date], [Cause of Absence Code]  from [CRONUS Sverige AB$Employee Absence]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				temp.add(result.getString("Entry No_"));
				temp.add(result.getString("Employee No_"));
				temp.add(result.getString("From Date"));
				temp.add(result.getString("To Date"));
				temp.add(result.getString("Cause of Absence Code"));
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return temp;
	}

	public static List<String> getEmployeePortalSetup ()
	{
		List<String> temp = new ArrayList <String> ();
		try
		{
			Connection con = DalCronus.getConnection();
			String sql = "select [Primary Key], [Search Limit], [Debugging Path], [Search Tool Pane Caption], [Write Debugging Info_]  from [CRONUS Sverige AB$Employee Portal Setup]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				temp.add(result.getString("Primary Key"));
				temp.add(result.getString("Search Limit"));
				temp.add(result.getString("Debugging Path"));
				temp.add(result.getString("Search Tool Pane Caption"));
				temp.add(result.getString("Write Debugging Info_"));
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return temp;
	}

	public static List<String> getEmployeeQualification ()
	{
		List<String> temp = new ArrayList <String> ();
		try
		{
			Connection con = DalCronus.getConnection();
			String sql = "select [Employee No_], [Line No_], [Cost], [Employee Status], [From Date]  from [CRONUS Sverige AB$Employee Qualification]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				temp.add(result.getString("Employee No_"));
				temp.add(result.getString("Line No_"));
				temp.add(result.getString("Cost"));
				temp.add(result.getString("Employee Status"));
				temp.add(result.getString("From Date"));
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return temp;
	}

	public static List<String> getEmployeeRelative ()
	{
		List<String> temp = new ArrayList <String> ();
		try
		{
			Connection con = DalCronus.getConnection();
			String sql = "select [Employee No_], [Line No_], [First Name], [Last Name], [Birth Date]  from [CRONUS Sverige AB$Employee Relative]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				temp.add(result.getString("Employee No_"));
				temp.add(result.getString("Line No_"));
				temp.add(result.getString("First Name"));
				temp.add(result.getString("Last Name"));
				temp.add(result.getString("Birth Date"));
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return temp;
	}
	
	public static List<String> getEmployeeStatisticsGroup ()
	{
		List<String> temp = new ArrayList <String> ();
		try
		{
			Connection con = DalCronus.getConnection();
			String sql = "select [timestamp], [Code], [Description]  from [CRONUS Sverige AB$Employee Statistics Group]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				temp.add(result.getString("timestamp"));
				temp.add(result.getString("Code"));
				temp.add(result.getString("Description"));
				
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return temp;
	}
	
	public static List<String> getEmployeeMetadata(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "Select * from [CRONUS Sverige AB$Employee]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				temp.add(rsmd.getColumnLabel(i));
				temp.add(rsmd.getTableName(i));
				temp.add(rsmd.getCatalogName(i));
				temp.add("" + rsmd.getColumnDisplaySize(i));
				temp.add("" + rsmd.getScale(i));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}

	public static List<String> getEmployeeAbsenceMetadata(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "Select * from [CRONUS Sverige AB$Employee Absence]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				temp.add(rsmd.getColumnLabel(i));
				temp.add(rsmd.getTableName(i));
				temp.add(rsmd.getCatalogName(i));
				temp.add("" + rsmd.getColumnDisplaySize(i));
				temp.add("" + rsmd.getScale(i));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
	
	public static List<String> getEmployeePortalSetupMetadata(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "Select * from [CRONUS Sverige AB$Employee Portal Setup]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				temp.add(rsmd.getColumnLabel(i));
				temp.add(rsmd.getTableName(i));
				temp.add(rsmd.getCatalogName(i));
				temp.add("" + rsmd.getColumnDisplaySize(i));
				temp.add("" + rsmd.getScale(i));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
	
	public static List<String> getEmployeeQualificationMetadata(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "Select * from [CRONUS Sverige AB$Employee Qualification]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				temp.add(rsmd.getColumnLabel(i));
				temp.add(rsmd.getTableName(i));
				temp.add(rsmd.getCatalogName(i));
				temp.add("" + rsmd.getColumnDisplaySize(i));
				temp.add("" + rsmd.getScale(i));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
	
	public static List<String> getEmployeeRelativeMetadata(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "Select * from [CRONUS Sverige AB$Employee Relative]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				temp.add(rsmd.getColumnLabel(i));
				temp.add(rsmd.getTableName(i));
				temp.add(rsmd.getCatalogName(i));
				temp.add("" + rsmd.getColumnDisplaySize(i));
				temp.add("" + rsmd.getScale(i));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
	
	public static List<String> getEmployeeStatisticsGroupMetadata(){
		List <String> temp = new ArrayList <String> ();
		try{
			Connection con = DalCronus.getConnection();
			String sql = "Select * from [CRONUS Sverige AB$Employee Statistics Group]";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				temp.add(rsmd.getColumnLabel(i));
				temp.add(rsmd.getTableName(i));
				temp.add(rsmd.getCatalogName(i));
				temp.add("" + rsmd.getColumnDisplaySize(i));
				temp.add("" + rsmd.getScale(i));
			}

		} catch (Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
}
