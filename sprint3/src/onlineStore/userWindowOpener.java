package onlineStore;

import java.sql.SQLException;

public class userWindowOpener {
	public void open(user User) {
		if(User instanceof admin) {
			try {
				AdminWindow win= new AdminWindow((admin) User);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(User instanceof business) {
			try {
				businessWindow wind = new businessWindow((business) User);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
