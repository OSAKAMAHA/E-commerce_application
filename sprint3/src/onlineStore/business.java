package onlineStore;

import java.util.ArrayList;

public class business extends user{
private ArrayList<store> Stores;
boolean storeOwner;
boolean storeCollaborator;
public boolean isStoreOwner() {
	return storeOwner;
}
public void setStoreOwner(boolean storeOwner) {
	this.storeOwner = storeOwner;
}
public boolean isStoreCollaborator() {
	return storeCollaborator;
}
public void setStoreCollaborator(boolean storeCollaborator) {
	this.storeCollaborator = storeCollaborator;
}
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
public Order makeOrder(product prod,int ammount,String shipping) {
	Order ord = new Order();
	ord.setProduct(prod);
	ord.setOwner(this);
	ord.setAmmount(ammount);
	ord.setShippingAddress(shipping);
	return ord;
}
}
