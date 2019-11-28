package onlineStore;

import java.util.Scanner;

public class pendingStoreWindow {
	public pendingStoreWindow() {
		pendingStoreController Sc = new pendingStoreController();
		Scanner sc = new Scanner(System.in);
		String output = Sc.View();
		System.out.println(output);
		System.out.println("Enter the name of the store you want to approve");
		String sname = sc.nextLine();
		Sc.approve(sname);
	}
}
