package servlet;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String Id = request.getParameter("id");

		if((Id.equals(""))){
			request.setAttribute("msg", "必須項目を入力してください");

			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		int id = Integer.parseInt(Id);

		HttpSession session1 = request.getSession();

		session1.setAttribute("id", id);

		UpdateService updateService = new UpdateService();

		List<Update> Update = updateService.authentication(id);

		HttpSession session2 = request.getSession();

		session2.setAttribute("update1", Update);

		boolean isSuccess = Update.size() != 0;

		if(isSuccess) {
			List<Update> list = updateService.findForId(id);

			request.setAttribute("updateList1", list);

			request.getRequestDispatcher("/updateInput.jsp").forward(request, response);
		}else {
			// メッセージ設定
			request.setAttribute("msg", "入力されたデータは存在しません");

			// 次画面指定
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		}
	}

}
