package com.nusyn.hrmate.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class DBManager {

	public String driver;
	public String url;
	public String user;
	public String password;
	public String database;
	
	
	
	
	
	
	public Connection getConnection() {
		// TODO Auto-generated method stub
			
			Connection conn = null;
			driver = "org.postgresql.Driver";
			url = "jdbc:postgresql://localhost:5432/hrmate";
			user = "postgres";
			password = "postgres";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Connected to DB");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return conn;
	}
		
	public boolean validateUser(String username,String password) throws SQLException{
		 
			
			Connection connection = getConnection();
		    Statement stmt = connection.createStatement();
		    
		    String query = "SELECT * FROM tbl_user where vchr_user_name = '" + username + 
					"' AND vchr_password = '" + password +"'";
			
		    System.out.println("Executed Querries");
			ResultSet rs = stmt.executeQuery(query);
			
			int count = 0 ;
			
			while(rs.next()){
				count++;
			}
			
			if(count > 0){
				return true;
			}else{
				return false;
			}
		}
	
	
	public ResultSet getSelectionTypeData() throws SQLException{
		 	
		Connection connection = getConnection();
	    Statement stmt = connection.createStatement();
	    
	    String query = "SELECT vchr_selection_type,COUNT(vchr_selection_type) FROM public.tbl_audit_log GROUP BY vchr_selection_type ORDER BY COUNT \r\n" + 
	    		"\r\n" + 
	    		"(vchr_selection_type) DESC LIMIT 10";
		
	    System.out.println("Executed Querries: "+query);
		ResultSet rs = stmt.executeQuery(query);
	
	
		
		return rs;
	}
	
	public ResultSet getShopData() throws SQLException{
	 	
		Connection connection = getConnection();
	    Statement stmt = connection.createStatement();
	    
	    String query = "SELECT vchr_shop_name,COUNT(vchr_shop_name) FROM public.tbl_audit_log GROUP BY vchr_shop_name ORDER BY COUNT \r\n" + 
	    		"\r\n" + 
	    		"(vchr_shop_name) DESC LIMIT 10";
		
	    System.out.println("Executed Querries: "+query);
		ResultSet rs = stmt.executeQuery(query);
	
	
		
		return rs;
	}
	
	}

