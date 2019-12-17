package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class productHandler {
	private dataBaseConnection db;
	productHandler(){
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
	public boolean checkAvailability(String prodName) throws SQLException, ClassNotFoundException{    
		dataBaseConnection db;
		db = new dataBaseConnection();
	    String q = "select count(*) from product where name = '"+prodName+"'";
	    db.rs = db.st.executeQuery(q);
	    db.rs.next();
	    if(db.rs.getInt(1) > 0) {
	    	return true;
	    }else {
	    	return false;
	    }
	};
	public int getProductID(String prodName) throws SQLException, ClassNotFoundException {
		String q = "select ID from product where name = '"+prodName+"'";
	    db.rs = db.st.executeQuery(q);
	    db.rs.next();
	    return db.rs.getInt("ID");
	}
	public int getStoreID(store s) throws ClassNotFoundException, SQLException {

		String q = "select store.ID from store where store.name = '"+s.getStoreName()+"' ";
		db.rs = db.st.executeQuery(q);
	    db.rs.next();
	    return db.rs.getInt("ID");
	}
	public ArrayList<store> getStores(business owner) {
		String q = "select * from store inner join collaborators on collaborators.collaboratorID = store.ID inner join users on users.ID = collaborators.collaboratorID where users.username = '"+owner.getLoginInfo().getUsername()+"' ";
		ArrayList<store> ownerstores = new ArrayList<store>();
		try {
			db.rs = db.st.executeQuery(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(db.rs.next()) {
				store s = new store();
				s.setStoreName(db.rs.getString("name"));
			    s.setOwnerName(db.rs.getString("ownerUser"));
			    s.setLocation(db.rs.getString("location"));
			    s.setType(db.rs.getString("type"));
			    ownerstores.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ownerstores;
	}
	public Brand getBrand(String Brandname) throws SQLException {
		Brand b = new Brand();
		String q1 = "select * from brand where name = '"+Brandname+"'";
		db.rs = db.st.executeQuery(q1);
		if(db.rs.next()) {
		b.setID(db.rs.getInt("ID"));
		b.setbName("name");
		b.setbCatagry(db.rs.getString("catagory"));
		return b;
		}
		return null;
	}
	public void  addproductToStore(product p,int storeID) throws SQLException, ClassNotFoundException{
		int productID = getProductID(p.getPp().getName());
		String q = "insert into productStore values(" +productID+  
	            ", " +storeID+ ", " +p.getQuantity()+", " +p.getBrand().getID()+", " +0+", " +p.getPrice()+ ")";
		int x = db.st.executeUpdate(q);
		
	};
}
