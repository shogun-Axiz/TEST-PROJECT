package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String adminId = request.getParameter("admin_id");
		String adminPassword = request.getParameter("password");

		if ((adminId == null || adminPassword == null) || ("".equals(adminId)) || ("".equals(adminPassword))) {
			request.setAttribute("msg", "IDまたはPASSが間違っています");

			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User user = userService.authentication(adminId, adminPassword);
		boolean isSuccess = (user != null);

		HttpSession session = request.getSession();
		String adminName = User.getAdmin_name();

		if (adminName == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		session.setAttribute("name", adminName);

		if (isSuccess) {
			request.getRequestDispatcher("menu.jsp").forward(request, response);

		} else {
			request.setAttribute("msg", "ログインできませんでした。");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
