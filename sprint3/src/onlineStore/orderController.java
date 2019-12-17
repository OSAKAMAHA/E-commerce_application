package onlineStore;

import java.util.ArrayList;

public class orderController {
	orderHandler oh;
	business current;
	ArrayList<product> prods;
	discountController dc;
	int choice;
	orderController(business current){
		this.current = current;
		oh = new orderHandler();
		prods = new ArrayList<product>();
		dc = new discountController();
	}
	public String View() {
		prods = oh.viewProducts();
		int i = 1;
		String output = "";
		for(int j = 0;j<prods.size();j++) {
			if(prods.get(j).getQuantity()>0) {
				output+=i +". "+prods.get(j).getPp().getName()+"    "+prods.get(j).getPrice()+"    "+prods.get(j).getBrand().getbName()+ "\n";
				i++;
			}
		}
		return output;
	}
	public String viewProd(int choice) {
		this.choice = choice;
		String output = "";
		product curr = prods.get(choice-1);
		output+=curr.getPp().getName()+"\n";
		output+=curr.getPrice()+"\n";
		oh.updateViews(curr);
		return output;
	}
	public String buy(int quantity,String shippingAddress) {
		String output = "";
		output+= dc.disc(current, prods.get(choice-1), quantity);
		Order ord = current.makeOrder(prods.get(choice-1), quantity, shippingAddress);
		if(oh.addOrder(ord)) {
			output += "order made successfully \n";
			oh.updateQuantity(ord);
		}else {
			output = "failed to make order";
		}return output;
	}
}
