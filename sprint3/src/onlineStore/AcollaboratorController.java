package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class AcollaboratorController {
	business owner;
	ArrayList<store> stores;
	collaboratorHandler ch;
	int choice;
	 AcollaboratorController(business owner){
		this.owner = owner;
		stores = new ArrayList<store>();
		ch = new collaboratorHandler();
	}
	public String ViewStores() {
		stores = ch.getStores(owner);
		int j = 1;
		String output = "";
		for(int i = 0;i<stores.size();i++) {
			output+=j+". "+stores.get(i).getStoreName()+"\n";
		}
		return output;
	}
	public String AddCollaborator(String choice,String username) throws ClassNotFoundException, SQLException {
		int store = Integer.parseInt(choice);
		int storeID = ch.getStoreID(stores.get(store-1));
		int colID = ch.getUserID(username);
		if(colID == -1) {
			return "user doesn't exist \n";
		}else {
			ch.addCollaborator(colID, storeID);
			return "added successfully \n";
		}
	}
}
