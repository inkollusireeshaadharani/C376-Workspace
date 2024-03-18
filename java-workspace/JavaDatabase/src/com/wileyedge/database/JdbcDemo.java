package com.wileyedge.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		//1. load and register the JDBC driver
		//2. Get the Connection object by
		//passing URL, username and password
		//3. Get the Statement from the Connection
		//4. Get the Result from the Statement
		//5. print the Result
		Connection con = null;
		//step 1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Type 4 driver of mysql is loaded into memory");
			//step2
			
			con = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/empmgmt?useSSL=false","root","2529");
			
			System.out.println("Connection obj is "+con);
			
			//step 3
			Statement stat = con.createStatement();
			
//			String insert = "INSERT INTO dept VALUES(80,'Tech','Pune')";
//			int n = stat.executeUpdate(insert);
//			System.out.println("Number of rows inserted are "+n);
			
			
//			String select = "SELECT * FROM dept";
//			ResultSet rs = stat.executeQuery(select);
//			
//			while(rs.next()) {
//				System.out.println(rs.getInt(1) + " "+
//								   rs.getString(2)+ " "+
//								   rs.getString(3));
//			}
			
			String update = "update dept set loc='mumbai' where deptid=70";
			int n = stat.executeUpdate(update);
			System.out.println("Number of rows updated are "+n);
			
			String delete = "delete from dept where deptid = 70";
			stat.executeUpdate(delete);
			
			String select = "SELECT * FROM dept";
			ResultSet rs = stat.executeQuery(select);
			System.out.println("-----------------------------------------------");
			System.out.print(rs.getMetaData().getColumnName(1)+"     ");
			System.out.print(rs.getMetaData().getColumnName(2)+"                 ");
			System.out.println(rs.getMetaData().getColumnName(3)+"          ");
			System.out.println("-----------------------------------------------");
			while(rs.next()) {
				System.out.format("%-12s", rs.getInt(1));
				System.out.format("%-20s", rs.getString(2));
				System.out.format("%-15s\n", rs.getString(3));
			}
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver class is not found");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
