package onlineStore;

public abstract class user {
private userLoginInfo loginInfo;
private String name;
private String DOB;
private String phone;
private String country;
public user(userLoginInfo loginInfo,String name,String DOB,String phone, String country) {
	this.loginInfo = loginInfo;
	this.name = name;
	this.DOB = DOB;
	this.phone = phone;
	this.country = country;
}
public user() {
	this.loginInfo = new userLoginInfo();
	this.name = "";
	this.DOB = "";
	this.phone = "";
	this.country ="";
}
public userLoginInfo getLoginInfo() {
	return loginInfo;
}
public void setLoginInfo(userLoginInfo loginInfo) {
	this.loginInfo = loginInfo;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}

}
