package onlineStore;

public class client extends user{
public client() {
	super();
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
