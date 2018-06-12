package service;

import java.sql.Connection;

import dao.InsertDao;
import entity.Insert;
import util.DbUtil;

public class InsertService {
	public int register(Insert insert) {
		try (Connection conn = DbUtil.getConnection()) {
			InsertDao userDao = new InsertDao(conn);
			return userDao.insert(insert);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int id() {
		try(Connection conn = DbUtil.getConnection()){
			InsertDao userInfo = new InsertDao(conn);
			return userInfo.Id();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
