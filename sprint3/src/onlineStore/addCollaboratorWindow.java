package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class addCollaboratorWindow {
	addCollaboratorWindow(business current){
		AcollaboratorController pc = new AcollaboratorController(current);
		Scanner sc = new Scanner(System.in);
		String output = pc.ViewStores();
		System.out.println(output);
		System.out.println("enter the number of the store you want to add collaborator to");
		String choice = sc.nextLine();
		System.out.println("enter the collaborator username");
		String username = sc.nextLine();
		try {
			System.out.println(pc.AddCollaborator(choice, username));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
