package onlineStore;


import java.sql.SQLException;

public interface product_handler {
public default productPrototype createProduct(String name,String catagory,String Type) {
	productPrototype pro = new productPrototype();
	pro.setName(name);
	pro.setCategory(catagory);
	pro.setType(Type);
	return pro;
}

};
