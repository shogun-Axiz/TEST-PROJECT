package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import common.JudgeStr_B_group;
import entity.UserInfo_B_group;
import util.DbUtil;

public class UserInfoDao_B_group {
	/*---  Field  ---*/
	private String SQLCommandWrite;		//変数名概要
	private Connection connection;		//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	//  処理概要
	public UserInfoDao_B_group() {
		this.connection = DbUtil.getConnection();
	}

	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	/**  user_info全出力処理
	 * @return
	 *   正常終了：List<UserInfo>型インスタンス
	 *   異常終了：null
	 */
	public List<UserInfo_B_group> SelectAll() {
		// 変数宣言
		List<UserInfo_B_group>list = new ArrayList<UserInfo_B_group>();

		// 初期化
		SQLCommandWrite = "";

		// SQL文発行
		SQLCommandWrite += "SELECT ";
		SQLCommandWrite += "* ";
		SQLCommandWrite += "FROM ";
		SQLCommandWrite += "user_info";

		try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserInfo_B_group user = new UserInfo_B_group();

				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setTelephone(rs.getString("telephone"));
				user.setPassword(rs.getString("password"));

				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**  user_info検索処理
	 * @return
	 *   正常終了：List<UserInfo>型インスタンス
	 *   異常終了：null
	 */
	public List<UserInfo_B_group> FindByUI(UserInfo_B_group inputUI) {
		// 変数宣言
		String userId;
		String userName;
		String telephone;
		String password;

		Integer cntbit = 1;

		List<UserInfo_B_group> list = new ArrayList<UserInfo_B_group>();

		BitSet bitflg = new BitSet(4);

		// 入力値がnullかどうかを確認
		if(inputUI == null) {
			// nullだった場合
			// nullを返す
			return null;
		}else {
			// null、空文字ではなかった場合(正規処理)
			// 初期化
			SQLCommandWrite = "";

			// SQL文発行
			SQLCommandWrite += "SELECT ";
			SQLCommandWrite += "* ";
			SQLCommandWrite += "FROM ";
			SQLCommandWrite += "user_info ";
			// これ以降の条件をANDでつなぐため、
			// 1 = 1 (全て条件を満たす)を入れている
			SQLCommandWrite += "WHERE 1 = 1";

			// 以下、ビットによってフラグ処理を行う


			userId = inputUI.getUserId();
			userName = inputUI.getUserName();
			telephone = inputUI.getTelephone();
			password = inputUI.getPassword();

			// ユーザID入力確認
			// 0b 0001 -> userId flg
			if (JudgeStr_B_group.isNumber(userId) == true) {
				SQLCommandWrite += " AND user_id = ?";
				bitflg.set(0);
			}

			// ユーザ名入力確認
			// 0b 0010 -> userName flg
			if (JudgeStr_B_group.isUseStr(userName) == true) {
				SQLCommandWrite += " AND user_name = ?";
				bitflg.set(1);
			}

			// 電話番号入力確認
			// 0b 0100 -> telephone flg
			if (JudgeStr_B_group.isUseStr(telephone) == true) {
				SQLCommandWrite += " AND telephone = ?";
				bitflg.set(2);
			}

			// パスワード入力確認
			// 0b 1000 -> password flg
			if (JudgeStr_B_group.isUseStr(password) == true) {
				SQLCommandWrite += " AND password = ?";
				bitflg.set(3);
			}

			// 正しい検索条件が一つも指定されていないことを確認
			if (bitflg.isEmpty()) {
				// 正しい検索条件が一つも指定されていなかった場合
				// 検索結果をnullにするため、
				// 1 != 1 (全て条件を満たさない)を入れている
				SQLCommandWrite += " AND 1 != 1";
			}

			try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
				// ユーザIDの?を埋める処理
				// 0b 0001 -> userId flg をチェック
				if(bitflg.get(0) == true) {
					stmt.setInt(cntbit, Integer.parseInt(userId));
					cntbit++;
				}
				// ユーザ名の?を埋める処理
				// 0b 0010 -> userName flg をチェック
				if(bitflg.get(1) == true) {
					stmt.setString(cntbit, userName);
					cntbit++;
				}
				// 電話番号の?を埋める処理
				// 0b 0100 -> telephone flg をチェック
				if(bitflg.get(2) == true) {
					stmt.setString(cntbit, telephone);
					cntbit++;
				}
				// パスワードの?を埋める処理
				// 0b 1000 -> password flg をチェック
				if(bitflg.get(3) == true) {
					stmt.setString(cntbit, password);
					cntbit++;
				}

				ResultSet rs = stmt.executeQuery();
				// SELECT文の出力があるかどうか確認
				if(rs.next()) {
					// ある場合
					// 出力データを戻り値に格納
					do {
						UserInfo_B_group user = new UserInfo_B_group();

						user.setUserId(rs.getString("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setTelephone(rs.getString("telephone"));
						user.setPassword(rs.getString("password"));

						list.add(user);
					}while (rs.next());
					// 検索結果を返す
					return list;
				}else {
					// ない場合
					// nullを返す
					return null;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * user_info登録処理
	 */
	public Boolean Insert(UserInfo_B_group inputUI) {
		// 変数宣言
		String userName = inputUI.getUserName();
		String telephone = inputUI.getTelephone();
		String password = inputUI.getPassword();
		Boolean isReturn = false;

		// 初期化
		SQLCommandWrite = "";

		// SQL文発行
		SQLCommandWrite += "INSERT ";
		SQLCommandWrite += "INTO ";
		SQLCommandWrite += "user_info ";
		SQLCommandWrite += "(user_name, telephone, password) ";
		SQLCommandWrite += "VALUES ";
		SQLCommandWrite += "(?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
			stmt.setString(1, userName);
			stmt.setString(2, telephone);
			stmt.setString(3, password);

			stmt.executeUpdate();

			isReturn = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return isReturn;
	}

	/**  user_info ID検索処理
	 * @return
	 *   正常終了：UserInfo型インスタンス(検索結果)
	 *   異常終了：null
	 */
	public UserInfo_B_group FindId(UserInfo_B_group inputUI) {
		// 変数宣言
		UserInfo_B_group retUI = new UserInfo_B_group();

		// 初期化
		SQLCommandWrite = "";

		// SQL文発行
		SQLCommandWrite += "SELECT ";
		SQLCommandWrite += "* ";
		SQLCommandWrite += "FROM ";
		SQLCommandWrite += "user_info ";
		SQLCommandWrite += "WHERE ";
		SQLCommandWrite += "user_name = ? ";
		SQLCommandWrite += "AND ";
		SQLCommandWrite += "telephone = ? ";
		SQLCommandWrite += "AND ";
		SQLCommandWrite += "password = ?";

		try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
			stmt.setString(1, inputUI.getUserName());
			stmt.setString(2, inputUI.getTelephone());
			stmt.setString(3, inputUI.getPassword());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				retUI.setUserId(rs.getString("user_id"));
				retUI.setUserName(rs.getString("user_name"));
				retUI.setTelephone(rs.getString("telephone"));
				retUI.setPassword(rs.getString("password"));
			}else {
				retUI = null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retUI;
	}

	/**  user_info ID検索処理
	 * @return
	 *   正常終了：UserInfo型インスタンス(検索結果)
	 *   異常終了：null
	 */
	public UserInfo_B_group FindById(String inputId) {
		// 変数宣言
		UserInfo_B_group retUI = new UserInfo_B_group();

		// 入力値が数値であることを確認
		if(JudgeStr_B_group.isNumber(inputId) == true) {
			// 数値である場合
			// 初期化
			SQLCommandWrite = "";

			// SQL文発行
			SQLCommandWrite += "SELECT ";
			SQLCommandWrite += "* ";
			SQLCommandWrite += "FROM ";
			SQLCommandWrite += "user_info ";
			SQLCommandWrite += "WHERE ";
			SQLCommandWrite += "user_id = ?";

			try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
				stmt.setInt(1, Integer.parseInt(inputId));

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					retUI.setUserId(rs.getString("user_id"));
					retUI.setUserName(rs.getString("user_name"));
					retUI.setTelephone(rs.getString("telephone"));
					retUI.setPassword(rs.getString("password"));
				}else {
					retUI = null;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}else {
			// 数値ではない場合
			// ユーザ情報をnullに設定
			retUI = null;
		}
		return retUI;
	}

	/**
	 * user_info更新処理
	 */
	public Boolean Update(UserInfo_B_group inputUI) {
		// 変数宣言
		String userName = inputUI.getUserName();
		String telephone = inputUI.getTelephone();
		String password = inputUI.getPassword();
		String userId = inputUI.getUserId();
		Boolean isReturn = false;

		// 初期化
		SQLCommandWrite = "";

		// SQL文発行
		SQLCommandWrite += "UPDATE ";
		SQLCommandWrite += "user_info ";
		SQLCommandWrite += "SET ";
		SQLCommandWrite += "user_name = ?, ";
		SQLCommandWrite += "telephone = ?, ";
		SQLCommandWrite += "password = ? ";
		SQLCommandWrite += "WHERE ";
		SQLCommandWrite += "user_id = ?";

		try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
			stmt.setString(1, userName);
			stmt.setString(2, telephone);
			stmt.setString(3, password);
			stmt.setInt(4, Integer.parseInt(userId));

			stmt.executeUpdate();

			isReturn = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return isReturn;
	}

	/**
	 * user_info削除処理
	 */
	public Boolean Delete(String inputId) {
		// 変数宣言
		Boolean isReturn = false;

		// 初期化
		SQLCommandWrite = "";

		// SQL文発行
		SQLCommandWrite += "DELETE ";
		SQLCommandWrite += "FROM ";
		SQLCommandWrite += "user_info ";
		SQLCommandWrite += "WHERE ";
		SQLCommandWrite += "user_id = ?";

		try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
			stmt.setInt(1, Integer.parseInt(inputId));

			stmt.executeUpdate();

			isReturn = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return isReturn;
	}

	/*---  Method End  ---*/
}
