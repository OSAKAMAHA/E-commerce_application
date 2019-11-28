package onlineStore;

import java.util.Scanner;

public class statisticsWindow {
	statisticsWindow(business current){
	boolean exit = false;
	while(!exit) {
	Scanner sc = new Scanner(System.in);
	statisticsController Sc = new statisticsController(current);
	System.out.println("1.product views");
	System.out.println("2.sold out products");
	System.out.println("3.number of available products");
	System.out.println("4.back");
	System.out.println("Enter the number of your choice.");
	String choice = sc.nextLine();
	String output = "";
	switch(choice) {
	case "1":
		output = Sc.views(); 
	break;
	case "2":
		output = Sc.sold();
	break;
	case "3":
		output = Sc.available();
	break;
	case "4":
		exit = true;
	break;
	default:
		output = "Please enter a valid option.";
	break;	
	}
	System.out.println(output);
	}
	}
}
