package servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Insert;
import service.InsertService;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet("/insertConfirm")
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String pass2 = request.getParameter("rePass");

		System.out.println(pass2);

		HttpSession session1 = request.getSession();
		String pass1 = (String) session1.getAttribute("pass1");

		System.out.println(pass1);

		if(!(pass2.equals(pass1))){
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");

			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
		}

		Insert insert = new Insert(name, tel, pass2);

		InsertService insertService = new InsertService();
		insertService.register(insert);

		request.setAttribute("insert", insert);

		int maxId = insertService.id();

		HttpSession session = request.getSession();

		session.setAttribute("id", maxId);

		request.getRequestDispatcher("insertResult.jsp").forward(request, response);

	}

}
