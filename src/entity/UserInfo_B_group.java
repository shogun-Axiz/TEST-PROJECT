package entity;

public class UserInfo_B_group {
	/*---  Field  ---*/
	private String userId;		// ユーザID
	private String userName;	// ユーザ名
	private String telephone;	// 電話番号
	private String password;	// パスワード

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	//  引数なしコンストラクタ
	public UserInfo_B_group() {
		this.userId = "";
		this.userName = "";
		this.telephone = "";
		this.password = "";
	}
	//  引数ありコンストラクタ
	public UserInfo_B_group(String userId, String userName, String telephone, String password) {
		this.userId = userId;
		this.userName = userName;
		this.telephone = telephone;
		this.password = password;
	}

	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  ゲッター・セッター
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	/*---  Method End  ---*/
}
