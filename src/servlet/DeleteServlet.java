package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Delete;
import service.DeleteService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String Id = request.getParameter("id");

		if((Id.equals(""))){
			request.setAttribute("msg", "必須項目を入力してください");

			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		int id = Integer.parseInt(Id);

		DeleteService deleteService = new DeleteService();

		List<Delete> Delete = deleteService.authentication(id);

		HttpSession session = request.getSession();

		session.setAttribute("delete", Delete);

		boolean isSuccess = Delete.size() != 0;

		if(isSuccess) {
			List<Delete> list = deleteService.findForId(id);

			request.setAttribute("deleteList", list);

			request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
		}else {
			// メッセージ設定
			request.setAttribute("msg", "入力されたデータは存在しません");

			// 次画面指定
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}
	}

}
