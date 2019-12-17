package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class statisticsController {
	business current;
	statisticsHandler sh;
	productHandler ph;
	ArrayList<store> userStores;
	statisticsController(business current){
		this.current = current;
		sh = new statisticsHandler();
		ph = new productHandler(current);
		userStores = ph.getStores(current);
	}
	public String views() {
		String output = "";
		int j = 1;
		for(int i = 0;i<userStores.size();i++) {
			try {
				output+= j+". "+userStores.get(i).getStoreName()+": \n";
				output+= sh.ProductViews(ph.getStoreID(userStores.get(i)));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return output;
	}
	public String sold() {
		String output = "";
		int j = 1;
		for(int i = 0;i<userStores.size();i++) {
			try {
				output+= j+". "+userStores.get(i).getStoreName()+": \n";
				output+= sh.soldOut(ph.getStoreID(userStores.get(i)));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return output;
	}
	public String available() {
		String output = "";
		int j = 1;
		for(int i = 0;i<userStores.size();i++) {
			try {
				output+= j+". "+userStores.get(i).getStoreName()+": \n";
				output+= sh.numberOfProducts(ph.getStoreID(userStores.get(i)));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return output;
	}
}
