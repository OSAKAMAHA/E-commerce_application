package onlineStore;

import java.sql.SQLException;

public class storeHandler {
	private dataBaseConnection db;
	storeHandler(){
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
	 public boolean addstore(store st) {
		 String q = "insert into tempStore values('" +st.getOwnerName()+  
		            "', '" +st.getStoreName()+ "', '" +st.getLocation()+ "', '" +st.getType()+ "')";
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
