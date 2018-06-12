package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {

	private static final String SQL_SELECT_ID_AND_PASS = "SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?";

	private Connection conn;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	public User findByIdAndPass(String adminId, String adminPassword) {
		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
			stmt.setString(1, adminId);
			stmt.setString(2, adminPassword);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getString("admin_id"), rs.getString("admin_name"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



}
