package onlineStore;

public class admin extends user implements product_handler,IBrandMaker{
	admin(){
		super();
	}

	public Brand makeBrand(String name, String Catagory) {
		Brand b = new Brand(name,Catagory);
		return b;
	}

}
