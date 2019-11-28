package onlineStore;

public class product {
private productPrototype pp;
private int price;
private int quantity;
private int views;
private Brand brand;
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
