package Example.UserLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Example.Admin.CRUD;
import Example.UserReg.UserReg;
import User.Main;


public class ValidateLoginImpl implements UserLoginDOA {
	String JDBC_URL = "jdbc:mysql://localhost:3306/hotel";
    String USERNAME = "root";
    String PASSWORD = "Deepak@2001";
    
    public void ValidateLogin(UserReg reg) {
    	try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, reg.getEmail());
                statement.setString(2, reg.getPassword());
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // User exists with provided credentials
        	            System.out.println("");
        	            System.out.println("=====================");
                        System.out.println("Login Successfull!!!!");
                        System.out.println("=====================");
        	            System.out.println("");
                        
        	            CRUD.userlogin();
        	    		
        	    		Scanner sc = new Scanner(System.in);
        	    	      
        	            int op = sc.nextInt();
        	            switch(op) {
        	    	      case 1:
        	    	    	  Main.Update();
        	    	          break;
        	    	      
        	    	      case 2:
        	    	    	  Main.getEmptyRooms();
        	    	          break;
        	    	          
        	    	      case 0:
							try {
								Main.main(null);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        	    	      default:
        	    	          System.out.println("Invalid option!");
        	    	          break;
        	            }
                        
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
