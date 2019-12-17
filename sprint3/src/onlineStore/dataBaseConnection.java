package onlineStore;

import java.sql.*;

public class dataBaseConnection {
	private Connection con;
	public Statement st;
	public ResultSet rs;
	public dataBaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://SQL5014.site4now.net;databaseName=DB_A50F4B_OnlineStore;user=DB_A50F4B_OnlineStore_admin;password=password123;");
		st = con.createStatement();
	}
}
