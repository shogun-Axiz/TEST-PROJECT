package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Update;

public class UpdateDao {
	private static final String SQL_SELECT_ID = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_id = ? ";
	private static final String SQL_UPDATE_ID = "UPDATE user_info SET user_name = ?, telephone = ?, password = ? WHERE user_id = ?";

	private Connection conn;

	public UpdateDao(Connection conn) {
		this.conn = conn;
	}

	public List<Update> findById(Integer id) {
		List<Update> list = new ArrayList<Update>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1, id);


			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Update u = new Update(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public int update(int id, String newName, String newTel, String newPass) {
		try(PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_ID)){
			stmt.setString(1, newName);
			stmt.setString(2, newTel);
			stmt.setString(3, newPass);
			stmt.setInt(4, id);

			return stmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
