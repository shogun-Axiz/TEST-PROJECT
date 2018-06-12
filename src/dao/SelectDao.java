package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Select;

public class SelectDao {

	private static final String SQL_SELECT_ALL = "SELECT user_id, user_name, telephone, password FROM user_info";
	private static final String SQL_SELECT_ID = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_id = ? ";
	private static final String SQL_SELECT_NAME = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_name = ? ";
	private static final String SQL_SELECT_TEL = "SELECT user_id, user_name, telephone, password FROM user_info WHERE telephone = ? ";
	private static final String SQL_SELECT_ID_NAME = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_id = ? AND user_name = ?";
	private static final String SQL_SELECT_ID_TEL = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_id = ? AND telephone = ?";
	private static final String SQL_SELECT_NAME_TEL = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_name = ? AND telephone = ?";
	private static final String SQL_SELECT_ID_NAME_TEL = "SELECT user_id, user_name, telephone, password FROM user_info WHERE user_id = ? AND user_name = ? AND telephone = ?";

	private Connection conn;

	public SelectDao(Connection conn) {
		this.conn = conn;
	}

	public List<Select> findAll() {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ALL)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findById(Integer id) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findByName(String name) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_NAME)) {
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findByTel(String tel) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_TEL)) {
			stmt.setString(1, tel);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findByIdAndName(int id, String name) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID_NAME)) {
			stmt.setInt(1, id);
			stmt.setString(2, name);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findByIdAndTel(int id, String tel) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID_TEL)) {
			stmt.setInt(1, id);
			stmt.setString(2, tel);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findByNameAndTel(String name, String tel) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_NAME_TEL)) {
			stmt.setString(1, name);
			stmt.setString(2, tel);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Select> findByIdAndNameAndTel(int id, String name, String tel) {
		List<Select> list = new ArrayList<Select>();

		try (PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ID_NAME_TEL)) {
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, tel);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Select u = new Select(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"),
						rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

}
