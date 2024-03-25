package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Example.Admin.CRUD;
import Example.UserReg.UserReg;


public class UserDOAImpl implements UserDOA {
	String JDBC_URL = "jdbc:mysql://localhost:3306/hotel";
    String USERNAME = "root";
    String PASSWORD = "Deepak@2001";
    
    @Override
    public void Update(UserReg reg) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Check if the record with the specified phone number exists
            String selectQuery = "SELECT * FROM users WHERE Phone=?";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setLong(1, reg.getPhone());
                ResultSet resultSet = selectStmt.executeQuery();

                if (!resultSet.next()) {
                    System.out.println("No record found for the specified phone number.");
                    return; // Exit the method if no record is found
                }
            }

            // Perform the update operation
            String updateQuery = "UPDATE users SET CHECKIN=?, CHECKOUT=?, ROOMTYPE =? WHERE Phone=?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                updateStmt.setString(1, reg.getCheckIn());
                updateStmt.setString(2, reg.getCheckOut());
                updateStmt.setString(3, reg.getRoomType());
                updateStmt.setLong(4, reg.getPhone());

                int rowsAffected = updateStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Update successful!!!");
                } else {
                    System.out.println("Failed to update data.");
                }
            }
            
            Main.main(null);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException appropriately based on your application's needs.
        }
    }

    @Override
    public void Delete(UserReg reg) {
    	
    	try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
    	    String deleteQuery = "DELETE FROM users WHERE Email = ?";
    	    try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
    	        stmt.setString(1, reg.getEmail()); // Assuming email is the unique identifier for a user

    	        int rowsAffected = stmt.executeUpdate();
    	        if (rowsAffected > 0) {
    	            System.out.println("Deletion successful!!!");
    	        } else {
    	            System.out.println("No matching records found for deletion.");
    	        }
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace(); // Handle SQLException appropriately
    	}

    	Main.main(null);
    }
    	
    
    @Override
    public void Registration(UserReg reg) {
    	
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
        	    ResultSet resultSet = conn.getMetaData().getTables(null, null, "users", null);
        	    if (resultSet.next()) { // Table doesn't exist, create it
        	        String CreateTable = "CREATE TABLE Users ("
        	                + "User_ID INT AUTO_INCREMENT PRIMARY KEY,"
        	                + "FIRSTNAME VARCHAR(255),"
        	                + "LASTNAME VARCHAR(255),"
        	                + "Email VARCHAR(255) UNIQUE,"
        	                + "Password varchar(255),"
                            + "Phone BIGINT,"
        	                + "CHECKIN DATE,"
        	                + "CHECKOUT DATE,"
        	                + "ROOMTYPE VARCHAR(255))";
        	        try (PreparedStatement stmts = conn.prepareStatement(CreateTable)) {
        	            stmts.executeUpdate();
        	            System.out.println("Table created successfully!!!!!");
        	        }
        	    }
        	} catch (SQLException e) {
        		System.out.println("Table already exists!!!!!");
        	}
            
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String InsertTable = "INSERT INTO users (FIRSTNAME, LASTNAME, Email, Password, Phone, CHECKIN, CHECKOUT, ROOMTYPE) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmts = conn.prepareStatement(InsertTable)) {
                    stmts.setString(1, reg.getFirstname());
                    stmts.setString(2, reg.getLastname());
                    stmts.setString(3, reg.getEmail()); // setLong for BIGINT
                    stmts.setString(4, reg.getPassword());
                    stmts.setLong(5, reg.getPhone());
                    stmts.setString(6, reg.getCheckIn());
                    stmts.setString(7, reg.getCheckOut());
                    stmts.setString(8, reg.getRoomType());
                    int rowsAffected = stmts.executeUpdate();
                    if (rowsAffected > 0) {
                    	System.out.println("Registration successful!!!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                }
                
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                System.out.println("Duplicate entry: Email or phone already exists.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            CRUD.main(null);
    	}
    
    @Override
    public void UserRegistration(UserReg reg) {
    	
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
        	    ResultSet resultSet = conn.getMetaData().getTables(null, null, "users", null);
        	    if (resultSet.next()) { // Table doesn't exist, create it
        	        String CreateTable = "CREATE TABLE Users ("
        	                + "User_ID INT AUTO_INCREMENT PRIMARY KEY,"
        	                + "FIRSTNAME VARCHAR(255),"
        	                + "LASTNAME VARCHAR(255),"
        	                + "Email VARCHAR(255) UNIQUE,"
        	                + "Password varchar(255),"
                            + "Phone BIGINT,"
        	                + "CHECKIN DATE,"
        	                + "CHECKOUT DATE,"
        	                + "ROOMTYPE VARCHAR(255))";
        	        try (PreparedStatement stmts = conn.prepareStatement(CreateTable)) {
        	            stmts.executeUpdate();
        	            System.out.println("Table created successfully!!!!!");
        	        }
        	    }
        	} catch (SQLException e) {
        		System.out.println("Table already exists!!!!!");
        	}
            
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String InsertTable = "INSERT INTO users (FIRSTNAME, LASTNAME, Email, Password, Phone, CHECKIN, CHECKOUT, ROOMTYPE) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmts = conn.prepareStatement(InsertTable)) {
                    stmts.setString(1, reg.getFirstname());
                    stmts.setString(2, reg.getLastname());
                    stmts.setString(3, reg.getEmail()); // setLong for BIGINT
                    stmts.setString(4, reg.getPassword());
                    stmts.setLong(5, reg.getPhone());
                    stmts.setString(6, reg.getCheckIn());
                    stmts.setString(7, reg.getCheckOut());
                    stmts.setString(8, reg.getRoomType());
                    int rowsAffected = stmts.executeUpdate();
                    if (rowsAffected > 0) {
                    	System.out.println("Registration successful!!!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                }
                
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                System.out.println("Duplicate entry: Email or phone already exists.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Main.main(null);
    	}
    
    @Override
    public void GetAllUsers(UserReg ur) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String selectQuery = "SELECT * FROM Users";
            try (PreparedStatement stmts = conn.prepareStatement(selectQuery)) {
                ResultSet resultSet = stmts.executeQuery();
                while (resultSet.next()) {
                    // Process each row in the result set
                    int User_ID = resultSet.getInt("User_ID");
                    String Firstname = resultSet.getString("FIRSTNAME");
                    String Lastname = resultSet.getString("LASTNAME");
                    String Email = resultSet.getString("Email");
                    String Password = resultSet.getString("Password");
                    long Phone = resultSet.getLong("Phone");
                    String CheckIn = resultSet.getString("CHECKIN");
                    String Checkout = resultSet.getString("CHECKOUT");
                    String RoomType = resultSet.getString("ROOMTYPE");
                    // You can process the retrieved data as needed, such as printing or storing it
                    System.out.println("User_ID: " + User_ID + ", Firstname: " + Firstname + ", Lastname: " + Lastname + ", Email: " + Email + ", Password: " + Password + ", Phone: " + Phone + ", CheckIn: " + CheckIn + ", Checkout: " + Checkout + ", RoomType: " + RoomType);
                }
                // Optionally, you can perform further actions after retrieving all orders
             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CRUD.main(null);
    }
    
    
    
    @Override
    public void GetUserById(UserReg ur) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String selectQuery = "SELECT * FROM Users WHERE User_ID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
    	        stmt.setInt(1, ur.getUserId()); // Assuming email is the unique identifier for a user

    	        ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    // Process each row in the result set
                    int User_ID = resultSet.getInt("User_ID");
                    String Firstname = resultSet.getString("FIRSTNAME");
                    String Lastname = resultSet.getString("LASTNAME");
                    String Email = resultSet.getString("Email");
                    long Phone = resultSet.getLong("Phone");
                    String Password = resultSet.getString("Password");
                    String CheckIn = resultSet.getString("CHECKIN");
                    String Checkout = resultSet.getString("CHECKOUT");
                    String RoomType = resultSet.getString("ROOMTYPE");
                    // You can process the retrieved data as needed, such as printing or storing it
                    System.out.println("User_ID: " + User_ID + ", Firstname: " + Firstname + ", Lastname: " + Lastname + ", Email: " + Email + ", Password: " + Password + ", Phone: " + Phone + ", CheckIn: " + CheckIn + ", Checkout: " + Checkout + ", RoomType: " + RoomType);
                }
    	    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CRUD.main(null);
    } 
    
    @Override   
    public void GetEmptyRooms(UserReg ur) {
        String selectQuery = "SELECT COUNT(*) FROM Users WHERE ROOMTYPE = ?";
        int singleroom = 20;
        int doubleroom = 10;
        int tripleroom = 5;
        int deluxeroom = 10;
        int suiteroom = 20;
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(selectQuery)) {
            
        	if(ur.getRoomType() == "Single Room") {
	            statement.setString(1, ur.getRoomType());
	
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    System.out.println("Number of " + ur.getRoomType() + " rooms left: " + (singleroom - count));
	                }
	            }
        	}
        	else if(ur.getRoomType() == "Double Room") {
        		statement.setString(1, ur.getRoomType());
        		
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    System.out.println("Number of " + ur.getRoomType() + " rooms left: " + (doubleroom - count));
	                }
	            }
        		
        	}
        	else if(ur.getRoomType() == "Triple Room") {
        		statement.setString(1, ur.getRoomType());
        		
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    System.out.println("Number of " + ur.getRoomType() + " rooms left: " + (tripleroom - count));
	                }
	            }
        		
        	}
        	
        	else if(ur.getRoomType() == "Deluxe Room") {
        		statement.setString(1, ur.getRoomType());
        		
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    System.out.println("Number of " + ur.getRoomType() + " rooms left: " + (deluxeroom - count));
	                }
	            }
        		
        	}
        	else{
        		statement.setString(1, ur.getRoomType());
        		
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    System.out.println("Number of " + ur.getRoomType() + " rooms left: " + (suiteroom - count));
	                }
	            }
        	}
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    }
