package onlineStore;

public class Order {
	product Product;
	business Owner;
	int ammount;
	String shippingAddress;
	public product getProduct() {
		return Product;
	}
	public void setProduct(product product) {
		Product = product;
	}
	public business getOwner() {
		return Owner;
	}
	public void setOwner(business owner) {
		Owner = owner;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
