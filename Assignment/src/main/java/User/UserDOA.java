package User;

import Example.UserReg.UserReg;

public interface UserDOA {
	void Registration(UserReg reg);
	void Update(UserReg reg);
	void Delete(UserReg reg);
	void UserRegistration(UserReg reg);
	void GetAllUsers(UserReg ur);
	void GetUserById(UserReg ur);
	void GetEmptyRooms(UserReg ur);
}
