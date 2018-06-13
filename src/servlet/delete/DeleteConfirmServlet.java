package servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeleteService;

/**
 * Servlet implementation class DeleteConfirmServlet
 */
@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String Id = request.getParameter("id");

		int id = Integer.parseInt(Id);

		DeleteService deleteService = new DeleteService();
		deleteService.delete(id);

		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
	}

}
