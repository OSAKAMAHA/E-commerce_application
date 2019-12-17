package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class orderHandler {
	private dataBaseConnection db;
	orderHandler(){
		try {
			db = new dataBaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<product> viewProducts(){
		String q = "select * from productStore ,product, brand where productstore.productID = product.[ID] and productStore.brandID = brand.ID";
		try {
			db.rs = db.st.executeQuery(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<product> prods = new ArrayList<product>();
		try {
			while(db.rs.next()) {
				product s = new product();
				s.getPp().setName(db.rs.getString(7));
				s.getPp().setCategory(db.rs.getString(8));
				s.getPp().setType(db.rs.getString(9));
				s.setID(db.rs.getInt("productID"));
				s.setStoreID(db.rs.getInt("storeID"));
				s.setPrice(db.rs.getInt("price"));
				s.setQuantity(db.rs.getInt("quantity"));
				s.setViews(db.rs.getInt("views"));
				s.getBrand().setbName(db.rs.getString(11));
				s.getBrand().setbCatagry(db.rs.getString(12));
			    prods.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}
	public void updateViews(product prod) {
		String q="update productSrore set views = views+1 where productID = "+prod.getID()+" and storeID = "+prod.getStoreID();
		int x = 0;
		try {
			x = db.st.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateQuantity(Order order) {
		String q="update productStore set quantity = quanitity-"+order.getAmmount()+" where productID = "+order.getProduct().getID()+" and storeID = "+order.getProduct().getStoreID();
		int x = 0;
		try {
			x = db.st.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public boolean addOrder(Order ord) {
		 String q = "insert into orders values(" +ord.getProduct().getID()+  
		            ", " +ord.getProduct().getStoreID()+ ", '" +ord.getOwner().getLoginInfo().getUsername()+ "',"+
				 ord.getAmmount()+", "+ord.getProduct().getPrice()+",'"+ord.getShippingAddress()+"')";
		 	int x = 0;
			try {
				x = db.st.executeUpdate(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (x > 0) {             
	        	return true;
	        }else {            
	    		return false;
	        }
	 }
}
