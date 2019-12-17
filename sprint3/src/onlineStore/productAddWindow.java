package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class productAddWindow {
	public productAddWindow(business current) {
		productController pc = new productController(current);
		Scanner sc = new Scanner(System.in);
		String output = pc.ViewStores();
		System.out.println(output);
		System.out.println("enter the number of the store you want to view it's products");
		String choice = sc.nextLine();
		System.out.println("1-addproduct");
		System.out.println("2-edit/delete product");
		String secChoice = sc.nextLine();
		if(secChoice.equals("1")) {
			System.out.println("enter the product name");
			String pname = sc.nextLine();
			System.out.println("enter the amount");
			String quantity =sc.nextLine();
			System.out.println("enter the brand name");
			String brandname = sc.nextLine();
			System.out.println("enter the price");
			String price =sc.nextLine();
			try {
				System.out.println(pc.Add(choice,pname, quantity, brandname, price));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(secChoice.equals("2")) {
			try {
				System.out.println(pc.ViewProducts(Integer.parseInt(choice)));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("enter the product number");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("1.edit");
			System.out.println("2.delete");
			String num1 = sc.nextLine();
			if(num1.equals("1")) {
				System.out.println("1.edit quantity");
				System.out.println("2.edit brand");
				System.out.println("3.edit price");
				int col = Integer.parseInt(sc.nextLine());
				System.out.println("enter new value");
				String newval = sc.nextLine();
				try {
					pc.update(num, col, newval);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(num1.equals("2")) {
				try {
					pc.delete(num);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
