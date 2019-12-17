package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class collaboratorHandler {
	private dataBaseConnection db;
	collaboratorHandler(){
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
	public int getUserID(String username) throws SQLException {
		String q1 = "select ID from users where username = '"+username+"'";
		db.rs = db.st.executeQuery(q1);
		if(db.rs.next())
			return db.rs.getInt("ID");
		else
			return -1;
	}
	public void addCollaborator(int collabID,int storeID) throws SQLException {
		String q5 = "insert into collaborators values("+collabID+","+storeID+")";
		db.st.executeUpdate(q5);
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
}
