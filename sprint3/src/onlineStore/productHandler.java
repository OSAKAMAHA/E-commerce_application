package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class productHandler {
	business curr;
	private dataBaseConnection db;
	
	productHandler(business curr){
		try {
			db = new dataBaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.curr = curr;
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
		String q = "select * from store inner join collaborators on collaborators.storeID = store.ID inner join users on users.ID = collaborators.collaboratorID where users.username = '"+owner.getLoginInfo().getUsername()+"' ";
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
	public ArrayList<product> getStoreProducts(int storeID){
		String q = "select * from productStore inner join product on productstore.productID = product.[ID] inner join brand on productStore.brandID = brand.ID where store.ID = "+storeID;
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
				s.getPp().setName(db.rs.getString(8));
				s.getPp().setCategory(db.rs.getString(9));
				s.getPp().setType(db.rs.getString(10));
				s.setID(db.rs.getInt("productID"));
				s.setStoreID(db.rs.getInt("storeID"));
				s.setPrice(db.rs.getInt("price"));
				s.setQuantity(db.rs.getInt("quantity"));
				s.setViews(db.rs.getInt("views"));
				s.getBrand().setbName(db.rs.getString(12));
				s.getBrand().setbCatagry(db.rs.getString(13));
				if(s.getQuantity() > 0)
					prods.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}
	public void deleteProduct(product p) throws SQLException {
		String q1="select * from productStore where productID = "+p.getID()+" and storeID = "+p.getStoreID();
		db.rs = db.st.executeQuery(q1);
		db.rs.next();
		int quantity = db.rs.getInt("quantity");
		int brandID = db.rs.getInt("brandID");
		int views = db.rs.getInt("views");
		int price = db.rs.getInt("price");
		String q="DELETE FROM productStore WHERE productID = "+p.getID()+" and storeID = "+p.getStoreID();
		db.st.executeUpdate(q);
		q = "insert into updates (pID,sID,updateType,changer) values(" +p.getID()+  
	            ", " +p.getStoreID()+ ", 'delete' , '" +curr.getLoginInfo().getUsername()+"')";
		db.st.executeUpdate(q);
		q = "select uID from updates where pID = "+p.getID()+" and sID = "+p.getStoreID()+" and changer = '"+curr.getLoginInfo().getUsername()+"')";
		db.rs = db.st.executeQuery(q1);
		db.rs.next();
		int uID = db.rs.getInt("uID");
		q = "SET IDENTITY_INSERT oldproducts ON insert into oldproducts (updateID,productID,storeID,quantity,brandID,views,price) values("+uID+ "," +p.getID()+  
	    ", " +p.getStoreID()+ ", " +quantity+", " +brandID+", " +views+", "+ price+ ")";
		db.st.executeUpdate(q);
	}
	public void	editProduct(product p) throws SQLException {
		String q1="select * from productStore where productID = "+p.getID()+" and storeID = "+p.getStoreID();
		db.rs = db.st.executeQuery(q1);
		db.rs.next();
		int quantity = db.rs.getInt("quantity");
		int brandID = db.rs.getInt("brandID");
		int views = db.rs.getInt("views");
		int price = db.rs.getInt("price");
		String q="update productStore set quantity = "+p.getQuantity()+" , brandID = "+p.getBrand().getID()+" , price = "+p.getPrice()+ " where productID = "+p.getID()+" and storeID = "+p.getStoreID();
		db.st.executeUpdate(q);
		q = "insert into updates (pID,sID,updateType,changer) values(" +p.getID()+  
	            ", " +p.getStoreID()+ ", 'edit' , '" +curr.getLoginInfo().getUsername()+"')";
		db.st.executeUpdate(q);
		q = "select uID from updates where pID = "+p.getID()+" and sID = "+p.getStoreID()+" and changer = '"+curr.getLoginInfo().getUsername()+"')";
		db.rs = db.st.executeQuery(q1);
		db.rs.next();
		int uID = db.rs.getInt("uID");
		q = "SET IDENTITY_INSERT oldproducts ON insert into oldproducts (updateID,productID,storeID,quantity,brandID,views,price) values("+uID+ "," + +p.getID()+  
	    ", " +p.getStoreID()+ ", " +quantity+", " +brandID+", " +views+", "+ price+ ")";
		db.st.executeUpdate(q);
	}
	public void  addproductToStore(product p,int storeID) throws SQLException, ClassNotFoundException{
		int productID = getProductID(p.getPp().getName());
		String q = "SET IDENTITY_INSERT productStore ON insert into productStore (productID,storeID,quantity,brandID,views,price) values(" +productID+  
	            ", " +storeID+ ", " +p.getQuantity()+", " +p.getBrand().getID()+", " +0+", " +p.getPrice()+ ")";
		db.st.executeUpdate(q);
		 q = "insert into updates (pID,sID,updateType,changer) values(" +productID+  
	            ", " +storeID+ ", 'add' , '" +curr.getLoginInfo().getUsername()+"')";
		 db.st.executeUpdate(q);
	};
}
