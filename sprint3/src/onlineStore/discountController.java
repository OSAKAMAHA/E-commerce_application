package onlineStore;

import java.sql.SQLException;

public class discountController {
	private business current;
	private product pro;
	String output;
	private boolean boughtBefore() throws ClassNotFoundException, SQLException {
		dataBaseConnection db = new dataBaseConnection();
		String q = "select * from orders where orderedproductID = "+pro.getID()+"and ownerUserName = '"+current.getLoginInfo().getUsername()+"'";
		db.rs = db.st.executeQuery(q);
	    if(db.rs.next()) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
	public String disc(business current,product pro,int quantity) {
		this.current = current;
		this.pro = pro;
		double discAmount = 0;
		output = "";
		if(current.isStoreOwner()) {
			output+="you got 15% because you are a store owner \n";
			discAmount += 0.15;
		}
		if(quantity >= 2) {
			output+="you got 10% because you bought 2 or more items of the same product \n";
			discAmount += 0.10;
		}
		try {
			if(!boughtBefore()) {
				output+="you got 5% because it's the first time buying this product \n";
				discAmount += 0.5;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro.setPrice((int)(pro.getPrice()*(1-discAmount)));
		return output;
	}
}
