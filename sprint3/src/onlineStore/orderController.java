package onlineStore;

import java.util.ArrayList;

public class orderController {
	orderHandler oh;
	business current;
	ArrayList<product> prods;
	int choice;
	orderController(business current){
		this.current = current;
		oh = new orderHandler();
		prods = new ArrayList<product>();
	}
	public String View() {
		prods = oh.viewProducts();
		int i = 1;
		String output = "";
		for(int j = 0;j<prods.size();j++) {
			if(prods.get(i).getQuantity()>0) {
				output+=i +". "+prods.get(i).getPp().getName()+"    "+prods.get(i).getPrice()+"    "+prods.get(i).getBrand().getbName()+ "\n";
				i++;
			}
		}
		return output;
	}
	public String viewProd(int choice) {
		this.choice = choice;
		String output = "";
		output+="product info \n";
		oh.updateViews(prods.get(choice-1));
		return output;
	}
	public String buy(int quantity,String shippingAddress) {
		Order ord = current.makeOrder(prods.get(choice-1), quantity, shippingAddress);
		String output = "";
		if(oh.addOrder(ord)) {
			output = "order made successfully \n";
			oh.updateQuantity(ord);
		}else {
			output = "failed to make order";
		}return output;
		
	}
}
