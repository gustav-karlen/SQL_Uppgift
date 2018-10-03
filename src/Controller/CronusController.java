package Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import DataAccessLayer.Dal2;
import DataAccessLayer.DalCronus;

public class CronusController {

	public static void main(String[] args) throws SQLException {
		DalCronus.getConnection();

		getKeys();
//		getIndex();
//		getTableConstraints();
//		getTables1();
//		getTables2();
//		getColumn1Employee();
//		getColumn2Employee();

	}	
	

	
	public static Vector<Vector<String>> getKeys() throws SQLException {
		return Dal2.getKeys();
	}
	public static Vector<Vector<String>> getIndex() throws SQLException {
		return Dal2.getIndex();
	}
	public static Vector<Vector<String>> getTableConstraints() throws SQLException {
		return Dal2.getTableConstraints();
	}
	public static Vector<Vector<String>> getTables1() throws SQLException{
		return Dal2.getTables1();
	}
	public static Vector<Vector<String>> getTables2() throws SQLException{
		return Dal2.getTables2();
	}
	public static Vector<Vector<String>> getColumn1Employee() throws SQLException{
		return Dal2.getColumn1Employee();
	}
	public static Vector<Vector<String>> getColumn2Employee() throws SQLException{
		return Dal2.getColumn2Employee();
	}
	
	public static List<String> getEmployee() throws SQLException {
		return DalCronus.getEmployee();
	}
	
	public static List<String> getEmployeeAbsence() throws SQLException {
		return DalCronus.getEmployeeAbsence();
	}
	public static List<String> getEmployeePortalSetup() throws SQLException {
		return DalCronus.getEmployeePortalSetup();
	}
	public static List<String> getEmployeeQualification() throws SQLException {
		return DalCronus.getEmployeeQualification();
	}
	public static List<String> getEmployeeRelative() throws SQLException {
		return DalCronus.getEmployeeRelative();
	}
	public static List<String> getEmployeeStatisticsGroup() throws SQLException {
		return DalCronus.getEmployeeStatisticsGroup();
	}
	

	public static List<String> getEmployeeMetadata() throws SQLException {
		return DalCronus.getEmployeeMetadata();
	}
	public static List<String> getEmployeeAbsenceMetadata() throws SQLException {
		return DalCronus.getEmployeeAbsenceMetadata();
	}
	public static List<String> getEmployeePortalSetupMetadata() throws SQLException {
		return DalCronus.getEmployeePortalSetupMetadata();
	}
	public static List<String> getEmployeeQualificationMetadata() throws SQLException {
		return DalCronus.getEmployeeQualificationMetadata();
	}
	public static List<String> getEmployeeRelativeMetadata() throws SQLException {
		return DalCronus.getEmployeeRelativeMetadata();
	}
	public static List<String> getEmployeeStatisticsGroupMetadata() throws SQLException {
		return DalCronus.getEmployeeStatisticsGroupMetadata();
	}
	
	
}
