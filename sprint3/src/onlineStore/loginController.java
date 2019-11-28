package onlineStore;

import java.sql.SQLException;

public class loginController {
	private users_handler uh;
	private user User;
	private userLoginInfo info;
	private userWindowOpener wo;
	loginController() throws ClassNotFoundException, SQLException{
		uh = new users_handler();
		User = null;
		wo = new userWindowOpener();
	}
	public boolean verify(String username,String password) throws SQLException {
		info = new userLoginInfo(username,password);
		if(uh.verifyLogIn(info)) {
			User = uh.getUser(info);
			return true;
		}else {
			return false;
		}
	}
	public void openWindow() {
		wo.open(User);
	}
}
