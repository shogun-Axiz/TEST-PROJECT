package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Delete;

public class DeleteDao {

	private static final String SQL_SELECT_ID = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_id = ? ";
	private static final String SQL_DELETE_ID = "DELETE FROM user_info WHERE user_id = ?";

	private Connection conn;

	public DeleteDao(Connection conn) {
		this.conn = conn;
	}

	public List<Delete> findById(Integer id) {
		List<Delete> list = new ArrayList<Delete>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Delete u = new Delete(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public int delete(int id) {
		try(PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_ID)){
			stmt.setInt(1, id);

			return stmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
