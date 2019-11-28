package onlineStore;

import java.sql.SQLException;

public class brandHandler {
	private dataBaseConnection db;
	brandHandler(){
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
	 public boolean addBrand(Brand b) {
		 String q = "insert into brand values('" +b.getbName()+  
		            "', '" +b.getbCatagry()+"')";
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
