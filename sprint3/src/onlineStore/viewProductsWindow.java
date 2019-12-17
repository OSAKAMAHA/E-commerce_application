package onlineStore;

import java.util.Scanner;

public class viewProductsWindow {
	viewProductsWindow (business current){
		Scanner sc = new Scanner(System.in);
		orderController oc= new orderController(current);
		System.out.println(oc.View());
		while(true) {
		System.out.println("enter the number of the product you want to view");
		String input = sc.nextLine();
		System.out.println(oc.viewProd(Integer.parseInt(input)));
		System.out.println("1-buy product");
		System.out.println("2-back");
		input = sc.nextLine();
		if(input.equals("1")) {
			System.out.println("enter the amount you want to buy");
			String quantity = sc.nextLine();
			System.out.println("enter your address");
			String address = sc.nextLine();
			System.out.println(oc.buy(Integer.parseInt(quantity), address));
		}
		}
	}	
}
