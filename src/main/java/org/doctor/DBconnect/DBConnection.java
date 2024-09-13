package org.doctor.DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  public static Connection getConn() {
    String loadDriver = "com.mysql.cj.jdbc.Driver"; // Updated driver
    String dbURL = "jdbc:mysql://localhost:3306/doctordb";
    String dbUSERNAME = "root";
    String dbPASSWORD = "Amar2003";
    
    Connection con = null;
    try {
      // Load the driver class
      Class.forName(loadDriver);
      
      // Establish the connection
      con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);
    } catch (ClassNotFoundException e) {
      // Handle the exception and return a meaningful error
      System.out.println("Database Driver not found.");
      e.printStackTrace();
    } catch (SQLException e) {
      // Handle the exception and return a meaningful error
      System.out.println("Failed to connect to the database.");
      e.printStackTrace();
    }
    
    // Check if the connection was successful
    if (con == null) {
      System.out.println("Connection is null. Check database configuration.");
    }
    
    return con;
  }
}
