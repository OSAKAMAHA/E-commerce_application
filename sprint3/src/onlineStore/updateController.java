package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class updateController {
	business owner;
	ArrayList<store> stores;
	updateHandler uh;
	int storeID;
	updateController(business owner){
		this.owner = owner;
		stores = new ArrayList<store>();
		uh = new updateHandler();
	}
	public String ViewStores() {
		stores = uh.getStores(owner);
		int j = 1;
		String output = "";
		for(int i = 0;i<stores.size();i++) {
			output+=j+". "+stores.get(i).getStoreName()+"\n";
		}
		return output;
	}
	public String viewHistory(int choice) {
		String out = "";
		try {
			storeID = uh.getStoreID(stores.get(choice-1));
			ArrayList<String> output = uh.getHistory(storeID);
			for(int i = 0;i<output.size();i++) {
				out+=output.get(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	public String Undo(int updateID) {
		try {
			uh.Undo(updateID, storeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (updateID+ "undone successully");
	}
}
