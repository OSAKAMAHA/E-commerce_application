package onlineStore;

public class Brand {
	private String bName;
	private String bCatagry;
	private int ID;
	public Brand(String bName,String bCatagry) {
		this.bName = bName;
		this.bCatagry = bCatagry;
		ID = 0;
	}
	public Brand() {
		bName = "";
		bCatagry = "";
		ID = 0;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbCatagry() {
		return bCatagry;
	}
	public void setbCatagry(String bCatagry) {
		this.bCatagry = bCatagry;
	}
}
