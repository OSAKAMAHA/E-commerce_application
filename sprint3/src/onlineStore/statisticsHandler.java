package onlineStore;

import java.sql.SQLException;

public class statisticsHandler {
	private dataBaseConnection db;
	statisticsHandler(){
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
	public String ProductViews(int ID) throws SQLException, ClassNotFoundException {
		String q1="select * from productStore inner join product on product.ID = productStore.productID where storeID = "+ID ;
		db.rs = db.st.executeQuery(q1);
		int i = 1;
		String output = "";
		while(db.rs.next()) {
			String name = db.rs.getString("name");
		    int views = db.rs.getInt("views");
		    output+= i+". "+name+"has "+views+" views. \n";
		    i++;
		}
		return output;
	}
	public String soldOut(int ID) throws SQLException, ClassNotFoundException {
		String q1="select * from productStore inner join product on product.ID = productStore.productID where storeID = "+ID+" and quantity = 0";
		db.rs = db.st.executeQuery(q1);
		int i = 1;
		String output = "";
		while(db.rs.next()) {
			String name = db.rs.getString("name");
		    output+=i+". "+name+"\n";
		    i++;
		}
		return output;
	}
	public String numberOfProducts(int ID) throws ClassNotFoundException, SQLException {
		String q1="select count(*) from productStore where storeID = "+ID;
		db.rs = db.st.executeQuery(q1);
		db.rs.next();
		int num = db.rs.getInt(1);
		return("the store has "+num+" products. \n");
	}
}
