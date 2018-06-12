package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.SelectDao;
import entity.Select;
import util.DbUtil;

public class SelectService {

	public List<Select> find() {
		// TODO 自動生成されたメソッド・スタブ
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<Select> authentication(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> authentication2(String name) {
		// TODO 自動生成されたメソッド・スタブ
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> authentication3(String tel) {
		// TODO 自動生成されたメソッド・スタブ
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByTel(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> findForId(Integer id) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Select> findForName(String name) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Select> findForTel(String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByTel(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Select> authentication4(int id, String name) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByIdAndName(id, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> findForIdAndName(int id, String name) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByIdAndName(id, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Select> authentication5(int id, String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByIdAndTel(id, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> findForIdAndTel(int id, String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByIdAndTel(id, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> authentication6(String name, String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByNameAndTel(name, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> findForNameAndTel(String name, String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByNameAndTel(name, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> authentication7(int id, String name, String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByIdAndNameAndTel(id, name, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Select> findForIdAndNameAndTel(int id, String name, String tel) {
		try (Connection conn = DbUtil.getConnection()) {
			SelectDao selectDao = new SelectDao(conn);
			return selectDao.findByIdAndNameAndTel(id, name, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
