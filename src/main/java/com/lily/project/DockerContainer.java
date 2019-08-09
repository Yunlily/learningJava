package com.lily.project;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.time.LocalDate;


public class DockerContainer {

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  

    final static String DB_URL = "jdbc:mysql://localhost:3306/bankDB";

    final static String USER = "root";

    final static String PASS = "Dapiyanzi123";
    
    static Connection conn = null;
    
    public static void createAccountTable() {
        
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");

                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

                  System.out.println("Creating a table");

                  Statement stmt = conn.createStatement();
                  
                  String clear = "DROP TABLE IF EXISTS ACCOUNT";
                  
                  stmt.execute(clear);
                  
                  String sql = " CREATE TABLE ACCOUNT " +

                              " (ID INTEGER NOT NULL AUTO_INCREMENT, " +
                              
                              " FIRSTNAME VARCHAR(255),"+
                              
                              " LASTNAME VARCHAR(255)," +

                              " BALANCE INTEGER, " + 

                              " MODIFIEDDATE DATE, " + 

                              " PRIMARY KEY ( ID ))"; 
                  
                  stmt.executeUpdate(sql);

                  System.out.println("Table Created");


            } catch (SQLException | ClassNotFoundException e) {

                  // TODO Auto-generated catch block

                  e.printStackTrace();

            }
    }
    
    
	@SuppressWarnings("finally")
	public static String addAccount(String firstName, String lastName, int balance) {
        
        String res = null;
		try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
          
                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

                  System.out.println("Adding an account...");

                  Statement stmt = conn.createStatement();
                  
                  LocalDate date = LocalDate.now();
                  
                  String sql = " INSERT INTO ACCOUNT(FIRSTNAME,"
                		  
                  				+ "LASTNAME, BALANCE, MODIFIEDDATE) VALUES (" +
                  
                  				"'" + firstName + "','" + 
                  				
                  				lastName + "',"+ balance + ",'" + date + "');";
                  
//                  System.out.println(sql);
                  stmt.execute(sql);
                  
                  String query = "SELECT * FROM ACCOUNT ORDER BY ID DESC LIMIT 1";
                  
                  ResultSet rs = stmt.executeQuery(query);
                  
                  while(rs.next()) {
                	  res = rs.getString("ID");
                  }


            } catch (SQLException | ClassNotFoundException e) {

                  // TODO Auto-generated catch block
                  e.printStackTrace();

            }
		
        	finally {
        		System.out.println("Account added");
        		return res;
        	}
	}
	
	@SuppressWarnings("finally")
	public static String fetchName(int accountId) {
		String res = null;
		 try {
			 
	            Class.forName("com.mysql.jdbc.Driver");

	            System.out.println("taking account Id now...");

	                  conn = DriverManager.getConnection(DB_URL,USER,PASS);


	                  Statement stmt = conn.createStatement();

	                  String query = "SELECT * FROM ACCOUNT WHERE ID = " + Integer.toString(accountId) + ";";
	                  
	                  ResultSet rs = stmt.executeQuery(query);
	                  
	                  while(rs.next()) {
	                	  
	                	  String firstName = rs.getString("FIRSTNAME");
	                	  
	                	  String lastName = rs.getString("LASTNAME");
	                	  
	                	  res = firstName + " " + lastName;
	                	  
	                  }

	                  System.out.println("Now Quering the table");
	                  
	            } catch (SQLException | ClassNotFoundException e) {

	                  // TODO Auto-generated catch block

	                  e.printStackTrace();

	            }
		 		finally {
		 			return res;
		 		}
	}

	@SuppressWarnings("finally")
	public static double fetchBalance(int accountId) {
		double res = 0;
		 try {
			 
	            Class.forName("com.mysql.jdbc.Driver");

	            System.out.println("taking account Id now...");

	                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

	                  Statement stmt = conn.createStatement();

	                  String query = "SELECT * FROM ACCOUNT WHERE ID = " + Integer.toString(accountId) + ";";
	                  
	                  ResultSet rs = stmt.executeQuery(query);
	                  
	                  while(rs.next()) {
	                	  
	                	  int balance = rs.getInt("BALANCE");
	                	  
	                	  res = balance;
	                	  
	                  }

	                  System.out.println("Now Quering the table");
	                  
	            } catch (SQLException | ClassNotFoundException e) {

	                  // TODO Auto-generated catch block

	                  e.printStackTrace();

	            }
		 		finally {
		 			return res;
		 		}
	}
	
	public static void deleteAccount(int accountId) {
		try {
			 
            Class.forName("com.mysql.jdbc.Driver");

                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

                  Statement stmt = conn.createStatement();
                  
                  String sql1 = "DELETE FROM HISTORY WHERE ACCOUNTID = " + Integer.toString(accountId) + ";";

                  String sql2 = "DELETE FROM ACCOUNT WHERE ID = " + Integer.toString(accountId) + ";";
                  
                  stmt.execute(sql1);
                  
                  stmt.execute(sql2);

            } catch (SQLException | ClassNotFoundException e) {


                  e.printStackTrace();

            }
	}
	
	
	public static void createHistoryTable(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

            Statement stmt = conn.createStatement();
            
            String clear = "DROP TABLE IF EXISTS HISTORY";
            
            stmt.execute(clear);
            
            String sql = " CREATE TABLE HISTORY " +

                        " (ID INTEGER NOT NULL AUTO_INCREMENT, " +
                        
                        " ACTIVITY VARCHAR(255), "+

                        " AMOUNT VARCHAR(255), " + 
                        
                        " BALANCE INTEGER, " +
                        
                        " STATUS VARCHAR(255)," +

                        " MODIFIEDDATE DATE, " + 
                        
                        " ACCOUNTID INTEGER, " +
                       
                        " PRIMARY KEY ( ID ), " +
                         
                        " FOREIGN KEY (ACCOUNTID) REFERENCES ACCOUNT(ID));"; 
            
            stmt.executeUpdate(sql);

            System.out.println("History Table Created");
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void setAccount(int accountId,String firstName,String lastName,double balance) {
		try {
			 
            Class.forName("com.mysql.jdbc.Driver");


                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

                  Statement stmt = conn.createStatement();
                  
                  LocalDate date = LocalDate.now();

                  String sql = "UPDATE ACCOUNT SET FIRSTNAME = '" 
                		  
                		  + firstName + "', LASTNAME = '" + lastName
                		  
                		  + "', BALANCE = " + balance + ", MODIFIEDDATE = '" + date
                		  
                		  + "', WHERE ID = "
                		  
                		  + accountId + ";";                  
                  
                  stmt.execute(sql);

                  
            } catch (SQLException | ClassNotFoundException e) {

                  // TODO Auto-generated catch block

                  e.printStackTrace();

            }
	}
	
	public static void addHistory(String activity,String status, double amount, double balance,int accountId) {
		try {
			 
            Class.forName("com.mysql.jdbc.Driver");


                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

                  Statement stmt = conn.createStatement();
                  
                  LocalDate date = LocalDate.now();
                  
                  String amountChange = null;
                  if(activity.contentEquals("Deposit")) {
                	  amountChange = "+".concat(Double.toString(amount));
                  }
                  else if(activity.contentEquals("Withdraw")) {
                	  amountChange = "-".concat(Double.toString(amount));
                  }
                  else {
                	  amountChange = "0.0";
                  }
                  
//                  System.out.println("amountChange is: " + amountChange);
                  
                  String sql =  " INSERT INTO HISTORY(ACTIVITY, "
                		  
                  				+ "AMOUNT, BALANCE, STATUS, MODIFIEDDATE,"
                  				
                  				+ "ACCOUNTID) VALUES(" +
                  
                  				"'" + activity + "','" + 
                  				
                  				amountChange + "',"+ balance + 
                  				
                  				",'" + status + "','" + date
                  				
                  				+ "'," + accountId + ");"; 
                  
                  System.out.println(sql);
                  
                  stmt.execute(sql);

                  
            } catch (SQLException | ClassNotFoundException e) {

                  // TODO Auto-generated catch block

                  e.printStackTrace();

            }
	}
	
	

}
