package User;

public class UserReg {
	private int UserId;
	private String Firstname;
	private String Lastname;
	private String Email;
	private long Phone;
	private String CheckIn;
	private String CheckOut;
	private String RoomTypeName;
	
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}
	public String getCheckOut() {
		return CheckOut;
	}
	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}
	
	public String getRoomType() {
		return RoomTypeName;
	}
	
	public void setRoomType(String RoomTypename) {
		this.RoomTypeName = RoomTypename;
	}
	
	public int getUserId() {
		return UserId;
	}
	
	public void getUserId(int UserId) {
		this.UserId = UserId;
	}
	
	public UserReg(String firstname, String lastname, String email, long phone, String checkin, String checkout, String RoomTypename) {
		super();
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Email = email;
		this.Phone = phone;
		this.CheckIn = checkin;
		this.CheckOut = checkout;
		this.RoomTypeName = RoomTypename;
	}
	
	public UserReg( long phone, String checkin, String checkout, String RoomTypeName) {
		super();
		this.Phone = phone;
		this.CheckIn = checkin;
		this.CheckOut = checkout;
		this.RoomTypeName = RoomTypeName;
	}
	
	
	public UserReg( String email) {
		super();
		
		this.Email = email;
		
	}
	
	public UserReg( int UserId) {
		super();
		
		this.UserId = UserId;
		
	}
	
	public UserReg( ) {
		
		
	}
}
