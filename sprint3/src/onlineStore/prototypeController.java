package onlineStore;

public class prototypeController {
	private admin current;
	private PrototypeHandler ph;
	prototypeController(admin current){
		this.current = current;
		ph = new PrototypeHandler();
	}
	boolean Add(String name,String catagory,String Type) {
		productPrototype p = current.createProduct(name, catagory, Type);
		return(ph.addproduct(p));
	}
}
