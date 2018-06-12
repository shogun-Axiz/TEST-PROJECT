package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Insert;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String pass1 = request.getParameter("pass");

		HttpSession session = request.getSession();
		session.setAttribute("pass1", pass1);

		Insert insert = new Insert(name, tel, pass1);

		session.setAttribute("insert", insert);

		request.getRequestDispatcher("/insertConfirm.jsp").forward(request, response);

	}

}
