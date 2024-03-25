package Example.Admin;

import java.util.Scanner;

import User.Main;

public class CRUD {
	
	public static void userlogin() {
		System.out.println("");
 		System.out.println("1. Update Details By Phone Number");
 		System.out.println("2. Fetch empty Rooms");
 		System.out.println("0. Exit");
 		System.out.println("");
	}
	public static void main(String args[]) {
		Main.MainMenu();
	    Scanner sc = new Scanner(System.in);
	    
	    int option = sc.nextInt();
	    
	    switch(option) {
		    case 1:
		    	Main.addUser();
		        System.out.println("Room booked successfully!");
		        break;
		    
		    case 2:
		    	Main.Update();
		        System.out.println("Details updated successfully!");
		        break;
		    
		    case 3:
		    	Main.Delete();
		        System.out.println("User deleted successfully!");
		        break;
		    
		    case 4:
		    	System.out.println("Fetching all users...");
		    	Main.getAllUsers();
		        break;
		        
		    case 5:
		        System.out.println("Fetching User");
		        Main.getUserByID();
		        break;
		    
		    case 6:
		        System.out.println("Fetching empty rooms...");
		        Main.getEmptyRooms();
		        break;
		    
		    case 0:
		    	Main.main(null);
		    default:
		        System.out.println("Invalid option!");
		        break;
	}
	    sc.close();
}
}
