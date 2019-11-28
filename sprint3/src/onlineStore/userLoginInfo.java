package onlineStore;

public class userLoginInfo {
	private String username;
	private String password;
	private String Email;
	public String getUsername() {
		return username;
	}
	public userLoginInfo(String username,String Email,String password) {
		this.username = username;
		this.Email = Email;
		this.password = password;
	}
	public userLoginInfo(String username,String password) {
		this.username = username;
		this.password = password;
		Email = "";
	}
	public userLoginInfo() {
		this.username = "";
		this.password = "";
		this.Email = "";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
