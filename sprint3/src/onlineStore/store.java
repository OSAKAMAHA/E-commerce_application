package onlineStore;
public class store {
	private String storeName;
	private String location;
	private String ownerName;
	private String Type;
	private product[] availible;
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public product[] getAvailible() {
		return availible;
	}
	public void setAvailible(product[] availible) {
		this.availible = availible;
	}
	
}
