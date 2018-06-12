package service;

import java.sql.Connection;

import dao.UserDao;
import entity.User;
import util.DbUtil;

public class UserService {
	public User authentication(String adminId, String adminPassword) {
		// TODO 自動生成されたメソッド・スタブ
		try(Connection conn = DbUtil.getConnection()){
			UserDao userDao = new UserDao(conn);
			User user = userDao.findByIdAndPass(adminId, adminPassword);

			return user;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
