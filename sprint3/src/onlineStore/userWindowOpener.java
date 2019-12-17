package onlineStore;

import java.sql.SQLException;

public class userWindowOpener {
	public void open(user User) throws ClassNotFoundException, SQLException {
		if(User instanceof admin) {
			try {
				AdminWindow win= new AdminWindow((admin) User);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(User instanceof business) {
			if(((business) User).isStoreOwner()) {
				storeOwnerWindow wind = new storeOwnerWindow((business) User);
			}else if(((business) User).isStoreCollaborator()) {
				storeCollaboratorWindow wiidn = new storeCollaboratorWindow((business) User);
			}else {
				businessWindow winn = new businessWindow((business) User);
			}
		}
	}
}
