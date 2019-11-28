package onlineStore;

import java.util.Scanner;

public class statisticsAddWindow {
	statisticsAddWindow(admin User){
		Scanner sc = new Scanner(System.in);
		adminStatisticsController asc = new adminStatisticsController ();
		System.out.println("choose the function you want to use");
		int i = 1;
		for(String b:asc.func) {
			System.out.println(i+". "+b);
			i++;
		}
		int funchoice = Integer.parseInt(sc.nextLine());
		int colchoice = 0;
		System.out.println("choose what you want to do this on");
		i = 1;
		for(String b:asc.table) {
			System.out.println(i+". "+b);
			i++;
		}
		int	tabchoice = Integer.parseInt(sc.nextLine());
		if(tabchoice == 1) {
			System.out.println("choose what exactly should this be done on");
			i = 1;
			for(String b:asc.productcolumn) {
				System.out.println(i+". "+b);
				i++;
				colchoice = Integer.parseInt(sc.nextLine());
			}
		}
		System.out.println(asc.makeStatistics(funchoice, tabchoice, colchoice));
	}
}
