package onlineStore;

import java.util.Scanner;

public class storeAddWindow {
	storeAddWindow(business current){
		storeController Sc = new storeController(current);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the store name");
		String name = sc.nextLine();
		System.out.println("enter the location(onsight/online)");
		String location =sc.nextLine();
		System.out.println("enter the type");
		String type = sc.nextLine();
		if(Sc.Add(name,location,type)) {
			System.out.println("store added successfully waiting for admin approval");
		}else {
			System.out.println("failed to add store");
		}	
	}
}
