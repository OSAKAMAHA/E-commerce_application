package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class pendingStoreController {
	private pendingStoreHandler sh;
	public pendingStoreController() {
		sh = new pendingStoreHandler();
	}
	public String View() {
		String output ="";
		ArrayList<store> pending = sh.viewPendingApproves();
		int j = 1;
		if(pending.size() == 0) {
			output = "no current stores waiting for approval";
		}else {
		for(int i = 0;i<pending.size();i++) {
			output += j+". store name: "+pending.get(i).getStoreName()+" owner: "+pending.get(i).getOwnerName()+
					" type: "+pending.get(i).getType()+ " location: "+pending.get(i).getLocation()+"\n";
			j++;
		}
		}
		return output;
	}
	public void approve(String name) {
		try {
			sh.approveStore(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
