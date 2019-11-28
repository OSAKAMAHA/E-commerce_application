package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class prototypeAddWindow {
	 prototypeAddWindow(admin current){
		 	prototypeController pc = new prototypeController(current);
		 	Scanner sc = new Scanner(System.in);
		 	System.out.println("enter the product name");
			String name = sc.nextLine();
			System.out.println("enter the catagory");
			String catagory =sc.nextLine();
			System.out.println("enter the type");
			String type = sc.nextLine();
			if(pc.Add(name,catagory,type)) {
				System.out.println("product added successfully");
			}else {
				System.out.println("failed to add product");
			}		
	 }
}
