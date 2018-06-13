package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Admin_B_group;
import util.DbUtil;

public class AdminDao_B_group {
	/*---  Field  ---*/
	private String SQLCommandWrite;		//変数名概要
	private Connection connection;		//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	//  処理概要
	public AdminDao_B_group() {
		this.connection = DbUtil.getConnection();
	}

	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public List<Admin_B_group> selectAll() {
		// 変数宣言
		List<Admin_B_group>list = new ArrayList<Admin_B_group>();

		// 初期化
		SQLCommandWrite = "";

		// SQL文発行
		SQLCommandWrite += "SELECT ";
		SQLCommandWrite += "* ";
		SQLCommandWrite += "FROM ";
		SQLCommandWrite += "admin";

		try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Admin_B_group admuser = new Admin_B_group();

				admuser.setAdminId(rs.getString("admin_id"));
				admuser.setAdminName(rs.getString("admin_name"));
				admuser.setPassword(rs.getString("password"));

				list.add(admuser);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**  admin_id検索処理
	 * 戻り値
	 * 　正常終了：Admin型インスタンス
	 * 　異常終了：null
	 */
	public Admin_B_group findById(String inputId) {
		// 変数宣言
		Admin_B_group retAdminData = new Admin_B_group();

		// 入力値がnullもしくは空文字かどうか確認
		if(inputId == null || inputId.equals("")) {
			// nullもしくは空文字だった場合
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
			SQLCommandWrite += "admin ";
			SQLCommandWrite += "WHERE ";
			SQLCommandWrite += "admin_id = ?";

			try (PreparedStatement stmt = connection.prepareStatement(SQLCommandWrite)) {
				stmt.setString(1, inputId);

				ResultSet rs = stmt.executeQuery();
				// SELECT文の出力があるかどうか確認
				if(rs.next()) {
					// ある場合
					// 出力データを戻り値に格納
					retAdminData.setAdminId(rs.getString("admin_id"));
					retAdminData.setAdminName(rs.getString("admin_name"));
					retAdminData.setPassword(rs.getString("password"));
					// 検索結果を返す
					return retAdminData;
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
	/*---  Method End  ---*/
}
