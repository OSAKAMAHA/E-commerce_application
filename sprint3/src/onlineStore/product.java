package onlineStore;

public class product {
private productPrototype pp;
private int ID;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
private int price;
private int quantity;
private int views;
private Brand brand;
private int storeID;
product(){
	pp = new productPrototype();
	brand = new Brand();
	price = 0;
	quantity = 0;
	views = 0;
	storeID = 0;
	ID = 0;
}
public int getStoreID() {
	return storeID;
}
public void setStoreID(int storeID) {
	this.storeID = storeID;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}

public productPrototype getPp() {
	return pp;
}
public void setPp(productPrototype pp) {
	this.pp = pp;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Brand getBrand() {
	return brand;
}
public void setBrand(Brand brand) {
	this.brand = brand;
}


}
