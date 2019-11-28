package onlineStore;

import java.util.Scanner;

public class brandAddWindow {
	brandAddWindow(admin current){
		brandController bc = new brandController(current);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the brand name");
		String bname = sc.nextLine();
		System.out.println("enter the catagory");
		String bcatagory =sc.nextLine();
		if(bc.Add(bname, bcatagory)) {
			System.out.println("brand added successfully");
		}else {
			System.out.println("failed to add brand");
		}
	}
}
