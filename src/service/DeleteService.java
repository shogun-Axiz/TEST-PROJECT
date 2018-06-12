package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.DeleteDao;
import entity.Delete;
import util.DbUtil;

public class DeleteService {
	public  List<Delete> authentication(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		try(Connection conn = DbUtil.getConnection()){
			DeleteDao deleteDao = new DeleteDao(conn);
			return deleteDao.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Delete> findForId(Integer id) {
		try(Connection conn = DbUtil.getConnection()){
			DeleteDao deleteDao = new DeleteDao(conn);
			return  deleteDao.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public int delete(int id) {
		try (Connection conn = DbUtil.getConnection()) {
			DeleteDao deleteDao = new DeleteDao(conn);
			return deleteDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
