package onlineStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class prog {
	public static void main(String[]args) throws IOException, ClassNotFoundException, SQLException {
		user current = null;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("welcome to the store");
		System.out.println("what would you like to do?");
		System.out.println("login");
		System.out.println("register");
		String choice = input.readLine();
		if(choice.equals("login")) {
			logInWindow win = new logInWindow();
		}else if(choice.equals("register")) {
			registerationWindow win = new registerationWindow();
		}else {
			System.out.println("non valid choice");
			System.exit(0);
		}
		System.out.println("welcome " + current.getName());
		if(current instanceof admin) {
			AdminWindow win= new AdminWindow((admin) current);
		}else if(current instanceof business) {
			businessWindow wind = new businessWindow((business) current);
		}
	}
}
