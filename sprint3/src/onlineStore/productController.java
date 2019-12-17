package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class productController {
	business owner;
	ArrayList<store> stores;
	ArrayList<product> products;
	productHandler ph;
	int choice;
	int storeID;
	productController(business owner){
		this.owner = owner;
		stores = new ArrayList<store>();
		ph = new productHandler(owner);
		products = new ArrayList<product>();
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
	public String ViewProducts(int choice) throws ClassNotFoundException, SQLException {
		storeID = ph.getStoreID(stores.get(choice-1));
		products = ph.getStoreProducts(storeID);
		int j = 1;
		String output = "";
		for(int i = 0;i<stores.size();i++) {
			output+=j+". "+products.get(i).getPp().getName()+"\n";
		}
		return output;
	}
	public void delete(int choice) throws SQLException {
		ph.deleteProduct(products.get(choice-1));
	}
	public void update(int choice,int colchoice,String newval) throws SQLException {
		switch(colchoice) {
		case 1:
			products.get(choice-1).setQuantity(Integer.parseInt(newval));
			break;
		case 2:
			Brand b = ph.getBrand(newval);
			products.get(choice-1).setBrand(b);
			break;
		case 3:
			products.get(choice-1).setPrice(Integer.parseInt(newval));
			break;
		}
		ph.editProduct(products.get(choice-1));
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
