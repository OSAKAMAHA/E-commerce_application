package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class updatesWindow {
	public updatesWindow (business current) {
		updateController uc = new updateController(current);
		Scanner sc = new Scanner(System.in);
		String output = uc.ViewStores();
		System.out.println(output);
		System.out.println("enter the number of the store you want to view it's products update history");
		String choice = sc.nextLine();
		System.out.print(uc.viewHistory(Integer.parseInt(choice)));
		System.out.println("enter the ID of the update you want to undo");
		int uID = Integer.parseInt(sc.nextLine());
		System.out.println(uc.Undo(uID));	
	}
}
