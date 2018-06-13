package servlet.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Select;
import service.SelectService;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String Id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");

		SelectService selectService = new SelectService();

		if ((Id.equals("")) && (name.equals("")) && (tel.equals(""))) {

			List<Select> list = selectService.find();
			request.setAttribute("selectList", list);

			// 次画面指定
			request.getRequestDispatcher("/selectResult.jsp").forward(request, response);

		} else if ((!("".equals(Id)) && (name.equals("")) && (tel.equals("")))) {
			id = Integer.parseInt(Id);

			List<Select> Select = selectService.authentication(id);

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			boolean isSuccess = Select.size() != 0;

			if (isSuccess) {
				List<Select> list = selectService.findForId(id);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}

		} else if ((Id.equals("")) && (!("".equals(name))) && (tel.equals(""))) {
			List<Select> Select = selectService.authentication2(name);
			boolean isSuccess = Select.size() != 0;

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			if (isSuccess) {
				List<Select> list = selectService.findForName(name);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		} else if ((Id.equals("")) && (name.equals("")) && (!("".equals(tel)))) {
			List<Select> Select = selectService.authentication3(tel);
			boolean isSuccess = Select.size() != 0;

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			if (isSuccess) {
				List<Select> list = selectService.findForTel(tel);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		} else if ((!("".equals(id))) && (!("".equals(name)) && (tel.equals("")))) {
			List<Select> Select = selectService.authentication4(id, name);
			boolean isSuccess = Select.size() != 0;

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			if (isSuccess) {
				List<Select> list = selectService.findForIdAndName(id, name);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		} else if ((!("".equals(id))) && (name.equals("")) && (!("".equals(tel)))) {
			List<Select> Select = selectService.authentication5(id, tel);
			boolean isSuccess = Select.size() != 0;

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			if (isSuccess) {
				List<Select> list = selectService.findForIdAndTel(id, tel);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		} else if ((Id.equals("")) && (!("".equals(name))) && (!("".equals(tel)))) {
			List<Select> Select = selectService.authentication6(name, tel);
			boolean isSuccess = Select.size() != 0;

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			if (isSuccess) {
				List<Select> list = selectService.findForNameAndTel(name, tel);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		} else if ((!("".equals(id)) && (!("".equals(name))) && (!("".equals(tel))))) {
			List<Select> Select = selectService.authentication7(id, name, tel);
			boolean isSuccess = Select.size() != 0;

			HttpSession session = request.getSession();

			session.setAttribute("select", Select);

			if (isSuccess) {
				List<Select> list = selectService.findForIdAndNameAndTel(id, name, tel);
				request.setAttribute("selectList", list);

				// 次画面指定
				request.getRequestDispatcher("/selectResult.jsp").forward(request, response);
			} else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		}

	}

}
