package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class storeCollaboratorWindow {
	storeCollaboratorWindow(business current) throws ClassNotFoundException, SQLException{
		while(true) {
			System.out.println("1.add a new store");
			System.out.println("2.add product to store");
			System.out.println("3.buy a product");
			System.out.println("4.exit");
			System.out.println("Enter the number of your choice.");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				storeAddWindow win = new storeAddWindow(current);
			break;
			case "2":
				productAddWindow wind = new productAddWindow(current);
			break;
			case "3":
				viewProductsWindow windso = new viewProductsWindow(current);
			break;
			case "4":
				System.exit(0);
			break;
			default:
				System.out.println("Please enter a valid option.");
			break;	
			}
		}
	}
}
