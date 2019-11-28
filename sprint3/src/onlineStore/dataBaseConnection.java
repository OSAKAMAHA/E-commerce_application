package onlineStore;

import java.sql.*;

public class dataBaseConnection {
	private Connection con;
	public Statement st;
	public ResultSet rs;
	public dataBaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=OnlineStore;integratedSecurity=true;");
		st = con.createStatement();
	}
}
