package onlineStore;

public class brandController {
	admin User;
	brandHandler bh;
	public brandController(admin User){
		this.User = User;
		bh = new brandHandler();
	}
	public boolean Add(String name,String Catagory) {
		Brand b = User.makeBrand(name, Catagory);
		return(bh.addBrand(b));
	}
}
