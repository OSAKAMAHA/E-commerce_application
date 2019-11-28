package onlineStore;

import java.sql.SQLException;

public class AstatisticsHandler {
	private dataBaseConnection db;
	AstatisticsHandler(){
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
	public String excute(String q) {
		String output = "";
		try {
			db.rs= db.st.executeQuery(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			output = db.rs.getString(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
		}
}
