package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class productAddWindow {
	public productAddWindow(business current) {
		productController pc = new productController(current);
		Scanner sc = new Scanner(System.in);
		String output = pc.ViewStores();
		System.out.println(output);
		System.out.println("enter the number of the store you want to add to");
		String choice = sc.nextLine();
		System.out.println("enter the product name");
		String pname = sc.nextLine();
		System.out.println("enter the amount");
		String quantity =sc.nextLine();
		System.out.println("enter the brand name");
		String brandname = sc.nextLine();
		System.out.println("enter the price");
		String price =sc.nextLine();
		try {
			output = pc.Add(choice,pname, quantity, brandname, price);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(output);
		
	}
}
