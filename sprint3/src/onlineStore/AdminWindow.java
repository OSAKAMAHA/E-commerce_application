package onlineStore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminWindow {
	AdminWindow(admin current) throws ClassNotFoundException, SQLException{
		while(true) {
		System.out.println("1.add product");
		System.out.println("2.add brand");
		System.out.println("3.view pending approves");
		System.out.println("4.exit");
		System.out.println("Enter the number of your choice.");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch(choice) {
		case "1":
			prototypeAddWindow win = new prototypeAddWindow(current);
		break;
		case "2":
			brandAddWindow bwin = new brandAddWindow(current);
		break;
		case "3":
			pendingStoreWindow swin = new pendingStoreWindow();
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
