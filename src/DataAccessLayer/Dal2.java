package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Dal2 {

	public static Connection getConnection() throws SQLException{
		String sqlConnect = "jdbc:sqlserver://Lenovo;database=CRONUS;user=hej;password=hej";
		return DriverManager.getConnection(sqlConnect);
	
	}

	
	
	public static Vector<Vector<String>> getKeys() throws SQLException {
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString = "SELECT OBJECT_NAME(OBJECT_ID) AS NameofConstraint, "
				+"SCHEMA_NAME(schema_id) AS SchemaName, "
				+ "OBJECT_NAME(parent_object_id) AS TableName, "
				+"type_desc AS ConstraintType "
				+"FROM sys.objects "
				+"WHERE type_desc IN ('FOREIGN_KEY_CONSTRAINT','PRIMARY_KEY_CONSTRAINT')";
		
		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i=1; i <= rsmd.getColumnCount(); i++){
					System.out.println(rsmd.getColumnLabel(i)+": "+rSet.getString(i));
					if(i == rsmd.getColumnCount()){
						System.out.println("\n ---");
					}
				}
				}
			}
			catch(Exception e){
			}
		return vs;
		}
	
	public static Vector<Vector<String>> getIndex() throws SQLException {
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString = " select * from sys.indexes  ";
		
		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
//				Vector<String> v = new Vector<String>();
				for(int i = 1; i <= 5; i++){
//					v.add(rset.getString(i));
					System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i) );
					if(i == 5){
						System.out.println("\n ---");
					}
				}
				
				
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return vs;
	}
	
	public static Vector<Vector<String>> getTableConstraints() throws SQLException{
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";

				try{
					rSet = stm.executeQuery(sqlString);
					ResultSetMetaData rsmd = rSet.getMetaData();
					while(rSet.next()){
						for(int i = 1; i <= rsmd.getColumnCount();i++){
							System.out.println(rsmd.getColumnName(i)+": "+ rSet.getString(i));
							if(i==rsmd.getColumnCount()){
								System.out.println("---");
							}
						}
					}
	 
				} catch (Exception e){
	}
				return vs;

}
	
	
	public static Vector<Vector<String>> getTables1() throws SQLException{
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString ="SELECT name FROM sys.tables";
		
		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i <=rsmd.getColumnCount();i++){
				System.out.println(rsmd.getColumnName(i)+": "+ rSet.getString(i));
				if( i== rsmd.getColumnCount()){
					System.out.println("---");
					}
				
				}
			}
			
		}catch(Exception e){
		}
		
		return vs;
	}
	
	public static Vector<Vector<String>> getTables2() throws SQLException{
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString ="SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES where TABLE_TYPE='BASE TABLE' ";
		
		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i <= rsmd.getColumnCount();i++){
					System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i));
					if (i==rsmd.getColumnCount()){
						System.out.println("---");
					}
				}
			}
			
		}catch(Exception e){
		}
		
		return vs;
	}

	
	public static Vector<Vector<String>> getColumn1Employee() throws SQLException{
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		
		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i <= rsmd.getColumnCount();i++){
					System.out.println(rsmd.getColumnName(i)+": "+ rSet.getString(i));
					if(i==rsmd.getColumnCount()){
						System.out.println("---");
					}
				}
			}
			
		}catch(Exception e){
		}
		
		return vs;
	}

	public static Vector<Vector<String>> getColumn2Employee() throws SQLException{
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString =" SELECT c.name "
				+ "FROM sys.objects o "
				+ "INNER JOIN sys.columns c "
				+ "ON c.object_id = o.object_id "
				+ "AND o.name = 'CRONUS Sverige AB$Employee' ";
		
//		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i <= rsmd.getColumnCount();i++){
					System.out.println(rsmd.getColumnName(i)+": "+ rSet.getString(i));
					if(i==rsmd.getColumnCount()){
						System.out.println("---");
					}
				}
			}
			
//		}catch(Exception e){
//		}
		
		return vs;
	}


// 2a



	
	public static Vector<Vector<String>> getEmployees() throws SQLException{
		Vector<Vector<String>> sv = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sql = "select [No_], [First Name], [Last Name], [Address], [City] "
				+ "from [CRONUS Sverige AB$Employee]";

		try {
			rSet = stm.executeQuery(sql);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i < 6; i++){
					System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i) + "\n");
					if (i == rsmd.getColumnCount()){
						System.out.println("---");
					}
				} 
				
			}
		}catch (Exception ex){
	}
		return sv;
	}
		
	public static Vector<Vector<String>> getAbsence() throws SQLException{
		
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString= " select * from [CRONUS Sverige AB$Employee Absence] ";

		try {
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i < 6; i++){
					System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i));
					if(i == 4){
						System.out.println("---");
					}
				}
				
			}
		}catch (Exception ex){
	}
		return vs;
}
	
	public static Vector<Vector<String>> getPortalSetup() throws SQLException{
		
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString= " SELECT * FROM [CRONUS Sverige AB$Employee Portal Setup] ";
				try {
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i < 6; i++){
					System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i) + "\n --- ");
					
				}
				
			}
		}catch (Exception ex){
		}
		return vs;
	}

	public static Vector<Vector<String>> getQualification() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	String sqlString= " SELECT * FROM [CRONUS Sverige AB$Employee Qualification]";

	try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
		while(rSet.next()){
			for(int i = 1; i < 6; i++){
				System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i)+ "\n");
			if(i == 5){
				System.out.println("---");
			}
			}
			
		}
	}catch (Exception ex){
	}
	return vs;
}

	public static Vector<Vector<String>> getRelative() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	String sqlString= " SELECT * FROM [CRONUS Sverige AB$Employee Relative] ";
	
			try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
		while(rSet.next()){
			for(int i = 1; i < 6; i++){
				System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i)+ "\n");
				if(i == 5){
					System.out.println("---");
				} ;
			
			}
			
		}
	}catch (Exception ex){
	}
	return vs;
}
	
	public static Vector<Vector<String>> getStatisticsGroup() throws SQLException{
		
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		String sqlString= " SELECT * FROM [CRONUS Sverige AB$Employee Statistics Group] ";
				
		try {
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
			while(rSet.next()){
				for(int i = 1; i < 4; i++){
					System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i)+ "\n");
					if(i==3){
						System.out.println("---");
					}
				}
				
			}
		}catch (Exception ex){
		}
		return vs;
	}

	public static Vector<Vector<String>> getContract() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	String sqlString= " SELECT * FROM [CRONUS Sverige AB$Employment Contract] ";

	try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
		while(rSet.next()){
			for(int i = 1; i < 4; i++){
				System.out.println(rsmd.getColumnName(i)+": "+rSet.getString(i)+ "\n");
				if(i==3){
					System.out.println("---");
				}
			}
			
		}
	}catch (Exception ex){
	}
	return vs;
}
	
	
	
	
	
	public static Vector<Vector<String>> getMetaDataForEmployees() throws SQLException{
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		String sqlString = "Select * from [CRONUS Sverige AB$Employee]";
		ResultSet rSet;
		Statement stm = con.createStatement();
		
		try{
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
				for(int i=1; i <= rsmd.getColumnCount();i++){
					System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
					+ "ColumnCount:" + rsmd.getColumnCount()
					+ " TableName:"+rsmd.getTableName(i)
					+" ColumnType:" + rsmd.getColumnType(i)+"\n ---" );
					
				}
				
			
		}catch (Exception e){
	}
		return vs;
	}
	
	public static Vector<Vector<String>> getMetaDataFromAbsence() throws SQLException{
		
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		
		String sqlString = " SELECT * FROM [CRONUS Sverige AB$Employee Absence] ";
		
		try {
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
					+ "ColumnCount:" + rsmd.getColumnCount()
					+ " TableName:"+rsmd.getTableName(i)
					+ " ColumnType:" + rsmd.getColumnType(i)+"\n ---" );
				}
				
		}catch (Exception ex){
		}
		return vs;
	}

	
	public static Vector<Vector<String>> getMetaDataFromPortalSetup() throws SQLException{
		
		Vector<Vector<String>> vs = new Vector<Vector<String>>();
		Connection con = Dal2.getConnection();
		Statement stm = con.createStatement();
		ResultSet rSet;
		
		String sqlString = " SELECT * FROM [CRONUS Sverige AB$Employee Portal Setup] ";
		
		try {
			rSet = stm.executeQuery(sqlString);
			ResultSetMetaData rsmd = rSet.getMetaData();
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
					+ " ColumnCount:" + rsmd.getColumnCount()
					+ " TableName:"+rsmd.getTableName(i)
					+ " ColumnType:" + rsmd.getColumnType(i)+"\n ---" );
					
					
				}
				
		}catch (Exception ex){
		}
		return vs;
	}

	public static Vector<Vector<String>> getMetaDataFromQualification() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	
	String sqlString = " SELECT * FROM [CRONUS Sverige AB$Employee Qualification] ";
	
	try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
				+ " ColumnCount:" + rsmd.getColumnCount()
				+ " TableName:"+rsmd.getTableName(i)
				+ " ColumnType:" + rsmd.getColumnType(i)+"\n ---" );}
			
	}catch (Exception ex){
	}
	return vs;
}

	public static Vector<Vector<String>> getMetaDataFromRelative() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	
	String sqlString = " SELECT * FROM [CRONUS Sverige AB$Employee Relative] ";
	
	try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
				+ " ColumnCount:" + rsmd.getColumnCount()
				+ " TableName:"+rsmd.getTableName(i)
				+" ColumnType:" + rsmd.getColumnType(i)+"\n ---" );			}
			
	}catch (Exception ex){
	}
	return vs;
}

	public static Vector<Vector<String>> getMetaDataFromStatisticsGroup() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	
	String sqlString = " SELECT * FROM [CRONUS Sverige AB$Employee Statistics Group] ";
	
	try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
				+ " ColumnCount:" + rsmd.getColumnCount()
				+ " TableName:"+rsmd.getTableName(i)
				+" ColumnType:" + rsmd.getColumnType(i)+"\n ---" );
			}
			
	}catch (Exception ex){
	}
	return vs;
}

	public static Vector<Vector<String>> getMetaDataFromContract() throws SQLException{
	
	Vector<Vector<String>> vs = new Vector<Vector<String>>();
	Connection con = Dal2.getConnection();
	Statement stm = con.createStatement();
	ResultSet rSet;
	
	String sqlString = " SELECT * FROM [CRONUS Sverige AB$Employment Contract] ";
	
	try {
		rSet = stm.executeQuery(sqlString);
		ResultSetMetaData rsmd = rSet.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				System.out.println("ColumnName:" + rsmd.getColumnLabel(i) 
				+ " ColumnCount:" + rsmd.getColumnCount()
				+ " TableName:"+rsmd.getTableName(i)
				+" ColumnType:" + rsmd.getColumnType(i)+"\n ---" );
				
			}
		
	}catch (Exception ex){
	}
	return vs;
}

}
