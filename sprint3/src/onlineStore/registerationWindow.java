package onlineStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class registerationWindow {
		public registerationWindow() throws IOException, SQLException, ClassNotFoundException {
		System.out.println("what are you registering as?\n client \n business");
		registerController rc = new registerController();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String regType = input.readLine();
		System.out.println("enter your username:");
		String username = input.readLine();
		System.out.println("enter your password:");
		String password = input.readLine();
		System.out.println("enter the name:");
		String name = input.readLine();
		System.out.println("enter your Email:");
		String Email = input.readLine();
		System.out.println("enter your Date of Birth YYYY/MM/DD:");
		String DOB = input.readLine();
		System.out.println("enter your phone number:");
		String phone = input.readLine();
		System.out.println("enter your country:");
		String country = input.readLine();
		if(rc.register(username, password, name, Email, DOB, phone, country,regType)) {
			System.out.println("registered successfully");
		}else {
			System.out.println("unable to register please try another username or make sure that all the fields were filled in the right way");
		}
	}

}
