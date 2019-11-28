package onlineStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class logInWindow {
	public logInWindow() throws IOException, ClassNotFoundException, SQLException {
		loginController LC = new loginController();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your username");
		String username = input.readLine();
		System.out.println("Enter your password");
		String password = input.readLine();
		if(LC.verify(username,password)) {
			LC.openWindow();
		}else {
			System.out.println("incorrect username or password");
			System.exit(0);
		}
		
	}
}
