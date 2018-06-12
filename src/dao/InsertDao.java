package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Insert;

public class InsertDao {
	private static final String SQL_INSERT = "INSERT INTO user_info(user_name, telephone, password) VALUES(?, ?, ?)";
	private static final String SQL_MAX = "SELECT MAX(user_id) FROM user_info";

	private Connection connection;

	public InsertDao(Connection connection) {
		this.connection = connection;
	}

	public int insert(Insert insert) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)){
			stmt.setString(1, insert.getUser_name());
			stmt.setString(2, insert.getTelephone());
			stmt.setString(3, insert.getPassword());

			return stmt.executeUpdate();

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int Id() {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_MAX)){
			ResultSet rs = stmt.executeQuery();
			int userI = 0;
			if(rs.next()) {
				userI = (rs.getInt("max"));
			}
			return userI;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
