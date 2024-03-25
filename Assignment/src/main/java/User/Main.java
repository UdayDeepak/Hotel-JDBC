package User;

import java.util.*;
import Example.UserLogin.*;

import Example.UserReg.UserReg;
import Example.Admin.*;

public class Main {
	
	public static void Login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your email : ");
		String email = sc.nextLine();
		
		System.out.print("Enter your password : ");
		String password = sc.nextLine();
		
		UserLoginDOA userlog = new ValidateLoginImpl();
		UserReg usereg = new UserReg(email, password);
		userlog.ValidateLogin(usereg);
	}
	
	public static void addUser() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your FirstName : ");
        String fname = sc.nextLine();
        
        System.out.print("Enter your LastName : ");
        String lname = sc.nextLine();

        System.out.print("Enter your Email : ");
        String email = sc.nextLine();
        
        System.out.print("Enter your Password : ");
        String password = sc.nextLine();

        System.out.print("Enter your Number : ");
        long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter your CheckIn (YYYY-MM-DD): ");
        String checkin= sc.nextLine();

        System.out.print("Enter your CheckOut (YYYY-MM-DD): ");
        String checkout = sc.nextLine();
        
        RoomTypes(); // Display room types

        System.out.print("Enter your Room Type : ");
        int roomType = sc.nextInt();
        sc.nextLine(); // Consume newline

        String roomTypeName;
        switch (roomType) {
            case 1:
                roomTypeName = "Single Room";
                break;
            case 2:
                roomTypeName = "Double Room";
                break;
            case 3:
                roomTypeName = "Triple Room";
                break;
            case 4:
                roomTypeName = "Deluxe Room";
                break;
            case 5:
                roomTypeName = "Suite Room";
                break;
            default:
                roomTypeName = "Invalid Room Type";
                break;
        }

        UserDOA userReg = new UserDOAImpl();
        UserReg user = new UserReg(fname, lname, email, password, phone, checkin, checkout, roomTypeName);
        userReg.Registration(user);
        
        sc.close();;
	}
	
	public static void RoomTypes() {
		
		System.out.println("");
		System.out.println("1. Single Room");
		System.out.println("2. Double Room");
		System.out.println("3. Triple Room");
		System.out.println("4. Deluxe Room");
		System.out.println("5. Suite Room");
		System.out.println("");
		
	}
	
	
	public static void Update() {
		
		Scanner sc = new Scanner(System.in);
		
        System.out.print("Enter your Number : ");
        long phone_1 = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter your CheckIn_1 (YYYY-MM-DD): ");
        String checkin_1= sc.nextLine();

        System.out.print("Enter your CheckOut_1 (YYYY-MM-DD): ");
        String checkout_1 = sc.nextLine();
        
        RoomTypes();
        
        System.out.print("Select Room Type: ");
        int roomType = sc.nextInt();
        sc.nextLine();
        
        String roomTypeName;
        switch (roomType) {
        case 1:
            roomTypeName = "Single Room";
            break;
        case 2:
            roomTypeName = "Double Room";
            break;
        case 3:
            roomTypeName = "Triple Room";
            break;
        case 4:
            roomTypeName = "Deluxe Room";
            break;
        case 5:
            roomTypeName = "Suite Room";
            break;
        default:
            roomTypeName = "Invalid Room Type";
            break;
    }

        UserDOA userReg_1 = new UserDOAImpl();
        UserReg user_1 = new UserReg(phone_1, checkin_1, checkout_1, roomTypeName);
        userReg_1.Update(user_1);
		
        sc.close();
	}
	
	public static void Delete() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Email : ");
        String email_2 = sc.nextLine();
        
        UserDOA userReg_2 = new UserDOAImpl();
        UserReg user_2 = new UserReg(email_2);
        userReg_2.Delete(user_2);
        
        sc.close();
		
	}
	
	public static void getAllUsers() {
		UserDOA userReg_3 = new UserDOAImpl();
        UserReg user_3 = new UserReg();
        userReg_3.GetAllUsers(user_3);
	}
	
	public static void getUserByID() {
		Scanner sc = new Scanner(System.in);
		
        System.out.print("Enter the userID : ");
        int userId = sc.nextInt();
        sc.nextLine();
        
		UserDOA userReg_3 = new UserDOAImpl();
        UserReg user_3 = new UserReg(userId);
        userReg_3.GetUserById(user_3);
        sc.close();
	}
	
	public static void getEmptyRooms() {
		        
		UserDOA userReg_3 = new UserDOAImpl();
        UserReg user_1 = new UserReg();
        user_1.setRoomType("Single Room");
        userReg_3.GetEmptyRooms(user_1);
        
        UserReg user_2 = new UserReg();
        user_2.setRoomType("Double Room");
        userReg_3.GetEmptyRooms(user_2);
        
        UserReg user_3 = new UserReg();
        user_3.setRoomType("Triple Room");
        userReg_3.GetEmptyRooms(user_3);
        
        UserReg user_4 = new UserReg();
        user_4.setRoomType("Deluxe Room");
        userReg_3.GetEmptyRooms(user_4);
        
        UserReg user_5 = new UserReg();
        user_5.setRoomType("Suite Room");
        userReg_3.GetEmptyRooms(user_5);
        
	}
	
	public static void UserRegistration() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your FirstName : ");
        String fname = sc.nextLine();
        
        System.out.print("Enter your LastName : ");
        String lname = sc.nextLine();

        System.out.print("Enter your Email : ");
        String email = sc.nextLine();
        
        System.out.print("Enter your Password : ");
        String password = sc.nextLine();

        System.out.print("Enter your Number : ");
        long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter your CheckIn (YYYY-MM-DD): ");
        String checkin= sc.nextLine();

        System.out.print("Enter your CheckOut (YYYY-MM-DD): ");
        String checkout = sc.nextLine();
        
        RoomTypes(); // Display room types

        System.out.print("Enter your Room Type : ");
        int roomType = sc.nextInt();
        sc.nextLine(); // Consume newline

        String roomTypeName;
        switch (roomType) {
            case 1:
                roomTypeName = "Single Room";
                break;
            case 2:
                roomTypeName = "Double Room";
                break;
            case 3:
                roomTypeName = "Triple Room";
                break;
            case 4:
                roomTypeName = "Deluxe Room";
                break;
            case 5:
                roomTypeName = "Suite Room";
                break;
            default:
                roomTypeName = "Invalid Room Type";
                break;
        }

        UserDOA userReg = new UserDOAImpl();
        UserReg user = new UserReg(fname, lname, email, password, phone, checkin, checkout, roomTypeName);
        userReg.UserRegistration(user);
        
        sc.close();
		
		
	}
	
	public static void Three() {
		
		System.out.println("");
		System.out.println("1. User Login");
		System.out.println("2. Admin Login");
		System.out.println("3. User Registration");
		System.out.println("0. Exit");
		System.out.println("");
		
	}
	
	
	public static void MainMenu() {
		
		System.out.println("");
		System.out.println("1. Book Room");
		System.out.println("2. Update Details By Phone Number");
		System.out.println("3. Delete User By Email");
		System.out.println("4. Fetch All Users");
		System.out.println("5. Fetch User By ID");
		System.out.println("6. Fetch empty Rooms");
		System.out.println("0. Exit");
		System.out.println("");
		
	}
	
	
	
	public static void main(String args[]) {
		System.out.println("\n");
		System.out.println("          ::::::::::::::::::::::::::          ");
		System.out.println("          :     WELCOME TO OUR     :          ");
		System.out.println("          :        HOTEL!!!!       :          ");
		System.out.println("          ::::::::::::::::::::::::::          ");
		System.out.println("\n");
		
		
		
        Three();
        Scanner sc = new Scanner(System.in);
      
        int op = sc.nextInt();
        switch(op) {
	      case 1:
	      	  Login();
	          break;
	      
	      case 2:
	      	  AdminLogin(sc);
	          break;
	          
	      case 3:
	      	  UserRegistration();
	      case 0:
	      		System.exit(0);
	      default:
	          System.out.println("Invalid option!");
	          break;
        }
        
        
        
		
        
        
         
	}
	
	private static void AdminLogin(Scanner sc) {
		AdminDOA adminlog = new AdminImpl();
    	adminlog.CreateTable(new Admin("admin","admin@gmail.com","admin123"));
    	
    	System.out.print("Enter your Email : ");
        String email = sc.next();
        System.out.println();
        System.out.print("Enter your Password : ");
        String password = sc.next();
        
        
        adminlog.AdminValidateLogin(new Admin(email, password));
		
	}
	
}
