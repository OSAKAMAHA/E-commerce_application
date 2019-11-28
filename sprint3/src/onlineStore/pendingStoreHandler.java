package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class pendingStoreHandler {
	private dataBaseConnection db;
	public pendingStoreHandler(){
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
	public void approveStore(String storeName) throws ClassNotFoundException, SQLException {
		String q1="select * from tempStore where name = '"+storeName+"'";
		db.rs = db.st.executeQuery(q1);
	    db.rs.next();
	    int ID = db.rs.getInt("ID");
	    String name = db.rs.getString("name");
	    String username = db.rs.getString("ownerUser");
	    String location = db.rs.getString("location");
	    String type = db.rs.getString("type");
	    System.out.println("got here");
		String q2="select ID from business where username ='"+username+"' ";
		db.rs = db.st.executeQuery(q2);
		db.rs.next();
		int ownerID = db.rs.getInt(1);
		String q3 = "insert into store values(" +ownerID + ", '" +location+"', '" +type+"', '" +name+ "')";
		db.st.executeUpdate(q3);
		String q4 = "delete from tempStore where ID = "+ID;
		db.st.executeUpdate(q4);
	}
	public ArrayList<store> viewPendingApproves(){
		String q1="select * from tempStore";
		ArrayList<store> pendingStores = new ArrayList<store>();
		try {
			db.rs = db.st.executeQuery(q1);
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
			    pendingStores.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pendingStores;
	}
}
