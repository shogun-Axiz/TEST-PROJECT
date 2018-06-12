package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UpdateService;

/**
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String newName = request.getParameter("newName");
		String newTel = request.getParameter("newTel");
		String newPass = request.getParameter("rePass");

		HttpSession session1 = request.getSession();
		String pass1 = (String) session1.getAttribute("pass1");

		if(!(pass1.equals(newPass))){
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");

			request.getRequestDispatcher("/updateConfirm.jsp").forward(request, response);

			return;
		}

		HttpSession session2 = request.getSession();
		Integer id = (Integer) session2.getAttribute("id");

		UpdateService updateService = new UpdateService();
		updateService.update(id, newName, newTel, newPass);

		request.getRequestDispatcher("/updateResult.jsp").forward(request, response);
	}

}
