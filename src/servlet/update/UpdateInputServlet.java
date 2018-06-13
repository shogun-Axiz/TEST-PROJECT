package servlet.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Update;
import service.UpdateService;

/**
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String newName = request.getParameter("newName");
		String newTel = request.getParameter("newTel");
		String newPass = request.getParameter("newPass");

		HttpSession session = request.getSession();



		HttpSession session1 = request.getSession();
		session1.setAttribute("pass1", newPass);

		HttpSession session2 = request.getSession();

		Integer id = (Integer) session2.getAttribute("id");

		UpdateService updateService = new UpdateService();

		List<Update> Update = updateService.authentication(id);

		HttpSession session3 = request.getSession();

		session3.setAttribute("update1", Update);

		boolean isSuccess = Update.size() != 0;

		Update update = new Update(id, newName, newTel, newPass);

		session.setAttribute("update2", update);

		if (isSuccess) {
			List<Update> list = updateService.findForId(id);

			String oldName = list.get(0).getUser_name();
			String oldTel = list.get(0).getTelephone();
			String oldPass = list.get(0).getPassword();

			session.setAttribute("updateList1", list);
			session.setAttribute("oldPass", oldPass);

			if(!(oldPass.equals(newPass))) {
				session.removeAttribute("oldPass");
			}

			if ((oldName.equals(newName)) && (oldTel.equals(newTel)) && (oldPass.equals(newPass))) {
				// メッセージ設定
				request.setAttribute("msg", "１項目以上変更してください");

				// 次画面指定
				request.getRequestDispatcher("/updateInput.jsp").forward(request, response);

			}

		}

		request.getRequestDispatcher("/updateConfirm.jsp").forward(request, response);
	}

}
