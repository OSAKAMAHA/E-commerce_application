package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class productController {
	business owner;
	ArrayList<store> stores;
	productHandler ph;
	int choice;
	productController(business owner){
		this.owner = owner;
		stores = new ArrayList<store>();
		ph = new productHandler(owner);
	}
	public String ViewStores() {
		stores = ph.getStores(owner);
		int j = 1;
		String output = "";
		for(int i = 0;i<stores.size();i++) {
			output+=j+". "+stores.get(i).getStoreName()+"\n";
		}
		return output;
	}
	public String Add(String choice,String pname,String quantity,String brandName,String price) throws ClassNotFoundException, SQLException {
		if(!ph.checkAvailability(pname)) {
			return ("product not available yet");
		}
		this.choice = Integer.parseInt(choice);
		int storeID = ph.getStoreID(stores.get(this.choice-1));
		productPrototype pp = new productPrototype();
		pp.setName(pname);
		Brand brand = ph.getBrand(brandName);
		product p= owner.makeproduct(pp, Integer.parseInt(price), Integer.parseInt(quantity), 0, brand);
		ph.addproductToStore(p, storeID);
		return("product added successfully");
	}
}
