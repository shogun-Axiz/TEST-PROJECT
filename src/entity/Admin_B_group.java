package entity;

public class Admin_B_group {
	/*---  Field  ---*/
	private String adminId;		// 管理者ID
	private String adminName;	// 管理者名
	private String password;	// パスワード

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	//  引数なしコンストラクタ
	public Admin_B_group() {
		this.adminId = "";
		this.adminName = "";
		this.password = "";
	}
	//  引数ありコンストラクタ
	public Admin_B_group(String adminId, String adminName, String password) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}

	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  ゲッター・セッター
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*---  Method End  ---*/
}
