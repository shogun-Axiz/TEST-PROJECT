package entity;

public class Insert {
	private String user_name;
	private String telephone;
	private String password;

	public Insert() {

	}

	public Insert(String user_name, String telephone, String password) {
		this.user_name = user_name;
		this.telephone = telephone;
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
