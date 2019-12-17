package onlineStore;

import java.sql.SQLException;

public class registerController {
	private users_handler uh;
	private user User;
	private userLoginInfo info;
	private userWindowOpener wo;
	registerController() throws ClassNotFoundException, SQLException{
		uh = new users_handler();
		User = null;
		wo = new userWindowOpener();
	}
	public boolean register(String username,String password,String name,String Email,String DOB,String phone,String country,String Type) throws SQLException {
		info = new userLoginInfo(username,Email,password);
		if(uh.userNameAvailable(username)) {
			User = uh.addUser(info, name, DOB, phone, country,Type);
			if(User == null) {
				return false;
			}
			return true;
		}else {
		return false;
		}
	}
	public void openWindow() {
		try {
			wo.open(User);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
