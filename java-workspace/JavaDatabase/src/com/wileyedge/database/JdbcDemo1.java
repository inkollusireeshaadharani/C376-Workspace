package com.wileyedge.database;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JdbcDemo1 {
	
	public static MysqlDataSource getDataSource() throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("empmgmt");
		ds.setUser("root");
		ds.setPassword("2529");
		ds.setServerTimezone("America/Chicago");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
		/*
		 *Server 
		 *Timezone helps the server know how to handle dates and times correctly. 
		 *Use SSL toggles SSL encryption. We would typically set 
		 *this to true, but for our local development, 
		 *it would be overkill to set up the infrastructure. We default to false for this activity.
		 *
		 *Allow Public Key Retrieval allows our JDBC driver to 
		 *send the password to our database securely.
		 *
		 */
		return ds;
	}
	//we're adding modularity to demo 1
	//having separate methods  for each query
	//usage of prepared stmts
	
	public static void displayRecords() throws SQLException {
		String select = "SELECT * FROM dept";
		Connection con = getDataSource().getConnection();
		System.out.println(con);
		
		Statement stat = con.createStatement();
		
		ResultSet rs = stat.executeQuery(select);
		System.out.println("-----------------------------------------------");
		System.out.print(rs.getMetaData().getColumnName(1)+"     ");
		System.out.print(rs.getMetaData().getColumnName(2)+"             ");
		System.out.println(rs.getMetaData().getColumnName(3)+"          ");
		System.out.println("-----------------------------------------------");
		while(rs.next()) {
			System.out.format("%-12s", rs.getInt(1));
			System.out.format("%-15s", rs.getString(2));
			System.out.format("%-15s\n", rs.getString(3));
		}
	}
	
	//robust and prevents SQL injection
	public static void insertRecord(int did, String dname, String location) throws SQLException {
		
		Connection con = getDataSource().getConnection();
//		System.out.println(con);
		
//		Statement stat = con.createStatement();
		
//		String insert = "INSERT INTO dept VALUES(90,'Tech','Pune')";
		
		PreparedStatement pstat = con.prepareStatement("INSERT INTO DEPT(DEPTID,DNAME,LOC) VALUES(?,?,?)");
		pstat.setInt(1, did);
		pstat.setString(2,dname);
		pstat.setString(3, location);
		boolean n = pstat.execute();
//		int n = stat.executeUpdate(insert);
		System.out.println("Number of rows inserted are "+n);

	}
	public static void updateRecord(int id, String loc) throws SQLException {
		
		Connection con = getDataSource().getConnection();
		String update = "update dept set loc=? where deptid=?";
		PreparedStatement pstat = con.prepareStatement(update);
		pstat.setString(1, loc);
		pstat.setInt(2, id);
		pstat.execute();
	}
	
	public static void deleteRecord(int id) throws SQLException {	
		Connection con = getDataSource().getConnection();
		String delete = "delete from dept where deptid=?";
		PreparedStatement pstat = con.prepareStatement(delete);
		pstat.setInt(1, id);
		pstat.execute();
	}

	public static void main(String[] args) {
		//callablestmt is a preparedstmt is a stmt
		//it will help for stored procedure calling
		try {
//			updateRecord(120,"Pune");

//			insertRecord(120,"dev","nashik");
			deleteRecord(110);
			displayRecords();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
