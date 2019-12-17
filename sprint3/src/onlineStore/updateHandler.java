package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class updateHandler {
	private dataBaseConnection db;
	private String changer;
	private int productID;
	private String updateType;
	updateHandler(){
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
	public int getStoreID(store s) throws ClassNotFoundException, SQLException {

		String q = "select store.ID from store where store.name = '"+s.getStoreName()+"' ";
		db.rs = db.st.executeQuery(q);
	    db.rs.next();
	    return db.rs.getInt("ID");
	}
	public ArrayList<store> getStores(business owner) {
		String q = "select * from store inner join users on users.ID = store.owner where users.username = '"+owner.getLoginInfo().getUsername()+"' ";
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
			    s.setOwnerName(db.rs.getString("username"));
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
	public ArrayList<String> getHistory(int storeID) {
		String q = "select * from updates where sID = "+storeID;
		ArrayList<String> outputs = new ArrayList<String>();
		try {
			db.rs = db.st.executeQuery(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(db.rs.next()) {
				String output = "";
				output+= db.rs.getInt("uID");
				output+=". ";
				output+= db.rs.getString("changer");
				output+=" ";
				output+= db.rs.getString("updateType");
				output+=" ";
				output+= db.rs.getInt("pID");
				output+="\n";
			    outputs.add(output);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputs;
	}
	public void getUpdateinfo(int updateID) {
		String q = "select * from updates where uID = "+updateID;
		try {
			db.rs = db.st.executeQuery(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(db.rs.next()) {
				updateType = db.rs.getString("updateType");
				 changer = db.rs.getString("changer");
				productID = db.rs.getInt("pID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Undo(int updateID,int storeID) throws SQLException {
		getUpdateinfo(updateID);
		if(updateType.equals("add")) {
			String q="DELETE FROM updates WHERE uID = "+updateID;
			db.st.executeUpdate(q);
			q="DELETE FROM productStore WHERE productID = "+productID+" and storeID = "+storeID;
			db.st.executeUpdate(q);
		}else if(updateType.equals("delete")) {
			String q1="select * from oldproducts where updateID = "+updateID;
			db.rs = db.st.executeQuery(q1);
			db.rs.next();
			int quantity = db.rs.getInt("quantity");
			int brandID = db.rs.getInt("brandID");
			int views = db.rs.getInt("views");
			int price = db.rs.getInt("price");
			String q = "SET IDENTITY_INSERT productStore ON insert into productStore (productID,storeID,quantity,brandID,views,price) values(" +productID+  
		            ", " +storeID+ ", " +quantity+", " +brandID+", " +views+", "+ price+ ")";
			db.st.executeUpdate(q);
			q = "DELETE FROM oldproducts WHERE updateID = "+updateID;
			db.st.executeUpdate(q);
			q="DELETE FROM updates WHERE uID = "+updateID;
			db.st.executeUpdate(q);
		}else if(updateType.equals("edit")) {
			String q1="select * from oldproducts where updateID = "+updateID;
			db.rs = db.st.executeQuery(q1);
			db.rs.next();
			int quantity = db.rs.getInt("quantity");
			int brandID = db.rs.getInt("brandID");
			int price = db.rs.getInt("price");
			String q = "UPDATE productStore quantity = "+quantity+" , brandID = "+brandID+" , price = "+price+" where productID= "+productID+" and storeID = "+storeID; 
			db.st.executeUpdate(q);
			q = "DELETE FROM oldproducts WHERE updateID = "+updateID;
			db.st.executeUpdate(q);
			q="DELETE FROM updates WHERE uID = "+updateID;
			db.st.executeUpdate(q);
		}
		
	}
}

