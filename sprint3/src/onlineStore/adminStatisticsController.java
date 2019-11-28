package onlineStore;

public class adminStatisticsController {
	public String [] func;
	public String [] table;
	public String [] productcolumn;
	public String [] storecolumn;
	AstatisticsHandler ah;
	
	adminStatisticsController(){
		func = new String [] {"max","min","avrage","sum"};
		table = new String [] {"products","orders","user stores"};
		productcolumn = new String[] {"price" , "quantity","views"};
		storecolumn = new String[] {"number of products"};
		ah = new AstatisticsHandler();
	}
	public String makeStatistics(int f,int t,int c) {
		String query = "";
		switch(t) {
		case 1:
			query = "select "+func[f-1]+"("+productcolumn[c-1]+") from productStore";
		break;
		case 2:
			query = "select "+func[f-1]+"(amount) from orders";
		break;
		case 3:
			query = "select "+func[f-1]+"(b.a) from (select count(*) as a,storeID from productStore group by productStore.storeID) b";
		break;
		}
		return ah.excute(query);
	}
		
}
