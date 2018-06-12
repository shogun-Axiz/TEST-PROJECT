package entity;

public class User {
	private String admin_id;
	private static String admin_name;
	private String password;

	public User() {

	}

	public User(String admin_id, String admin_name, String password) {
		this.admin_id = admin_id;
		User.admin_name = admin_name;
		this.password = password;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public static String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		User.admin_name = admin_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
