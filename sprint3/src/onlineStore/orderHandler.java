package onlineStore;

import java.sql.SQLException;

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
	 public boolean addOrder(Order ord) {
		 String q = "insert into product values('" +pro.getName()+  
		            "', '" +pro.getCategory()+ "', '" +pro.getType()+ "')";
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
