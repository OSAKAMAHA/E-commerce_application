package onlineStore;

public class storeController {
	private business current;
	private storeHandler sh;
	storeController(business current){
		this.current = current;
		sh = new storeHandler();
	}
	public boolean Add(String name,String location,String type) {
		store s = current.makeStore(name, location, type);
		return(sh.addstore(s));
	}

}
