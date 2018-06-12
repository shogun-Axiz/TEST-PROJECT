package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.UpdateDao;
import entity.Update;
import util.DbUtil;

public class UpdateService {
	public  List<Update> authentication(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		try(Connection conn = DbUtil.getConnection()){
			UpdateDao updateDao = new UpdateDao(conn);
			return updateDao.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Update> findForId(Integer id) {
		try(Connection conn = DbUtil.getConnection()){
			UpdateDao updateDao = new UpdateDao(conn);
			return  updateDao.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public int update(Integer id, String newName, String newTel, String newPass) {
		try (Connection conn = DbUtil.getConnection()) {
			UpdateDao updateDao = new UpdateDao(conn);
			return updateDao.update(id, newName, newTel, newPass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}
}
