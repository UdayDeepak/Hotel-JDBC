package Example.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AdminImpl implements AdminDOA {
	String JDBC_URL = "jdbc:mysql://localhost:3306/hotel";
    String USERNAME = "root";
    String PASSWORD = "Deepak@2001";
    
    @Override
    public void CreateTable(Admin login) {
    	try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
    	    ResultSet resultSet = conn.getMetaData().getTables(null, null, "admin", null);
    	    if (!resultSet.next()) { // Table doesn't exist, create it
    	        String CreateTable = "CREATE TABLE admin ("
    	                + "Admin_ID INT AUTO_INCREMENT PRIMARY KEY,"
    	                + "AdminName VARCHAR(255),"
    	                + "AdminEmail VARCHAR(255) UNIQUE,"
    	                + "AdminPassword VARCHAR(255))";
    	        String InsertData = "INSERT INTO admin (AdminName, AdminEmail, AdminPassword) VALUES (?, ?, ?)";
    	        try (PreparedStatement createStmt = conn.prepareStatement(CreateTable);
    	        	     PreparedStatement insertStmt = conn.prepareStatement(InsertData)) {
    	        	    createStmt.executeUpdate();
    	        	    insertStmt.setString(1, login.getAdminName());
    	        	    insertStmt.setString(2, login.getAdminEmail());
    	        	    insertStmt.setString(3, login.getAdminPassword());
    	        	    insertStmt.executeUpdate();
    	        	    
    	        	    System.out.println("");
        	            System.out.println("=============================================");
    	        	    System.out.println("Table created and data inserted successfully!");
    	        	    System.out.println("=============================================");
    	        	    System.out.println("");
    	        	}
    	    }
    	} catch (SQLException e) {
    		System.out.println("");
            System.out.println("=========================");
    		System.out.println("Table already exists!!!!!");
    		System.out.println("=========================");
    		System.out.println("");
    	}
    }
    
    @Override
    public void AdminValidateLogin(Admin login) { 	
    	
    	try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM admin WHERE AdminEmail = ? AND AdminPassword = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, login.getAdminEmail());
                statement.setString(2, login.getAdminPassword());
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                    	System.out.println("");
        	            System.out.println("=====================");
                        System.out.println("Login Successfull!!!!");
                        System.out.println("=====================");
                        System.out.println("");
                        CRUD.main(null);
                    } else {
                        // User does not exist or credentials are incorrect
                    	System.out.println("");
        	            System.out.println("=========================");
                        System.out.println("Email/Password wrong!!!!!");
                        System.out.println("=========================");
                        System.out.println("");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
