package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class businessWindow {
	businessWindow(business current) throws ClassNotFoundException, SQLException{
		while(true) {
			System.out.println("1.buy a product");
			System.out.println("2.add a new store");
			System.out.println("3.exit");
			System.out.println("Enter the number of your choice.");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			switch(choice) {
			case "2":
				storeAddWindow win = new storeAddWindow(current);
			break;
			case "1":
				viewProductsWindow windso = new viewProductsWindow(current);
			break;
			case "3":
				System.exit(0);
			break;
			default:
				System.out.println("Please enter a valid option.");
			break;	
			}
		}
	}
}
