package onlineStore;

import java.util.ArrayList;

public class business extends user{
private ArrayList<store> Stores;
business(){
	super();
	Stores = new ArrayList<store>();
}
public store makeStore(String name,String location,String type) {
	store s = new store();
	s.setStoreName(name);
	s.setOwnerName(this.getLoginInfo().getUsername());
	s.setLocation(location);
	s.setType(type);
	return s;
}
public product makeproduct(productPrototype pp,int price,int quantity,int views,Brand brand) {
	product p = new product();
	p.setPp(pp);
	p.setPrice(price);
	p.setQuantity(quantity);
	p.setViews(views);
	p.setBrand(brand);
	return p;
}
public ArrayList<store> getStores() {
	return Stores;
}
public void setStores(ArrayList<store> stores) {
	Stores = stores;
}

}
