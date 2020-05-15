package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.BoardDAO;
import DB.BoardDTO;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");

		String num = request.getParameter("num");
		String pwd = request.getParameter("ipwd");

		String view = null;

		BoardDAO bdao = BoardDAO.getInstance();
		BoardDTO bdto = null;

		HttpSession session = request.getSession();
		String nowid = (String) session.getAttribute("id"); // 현재 브라우저에서 가지고 있는 세션값을 가져와라

		if (nowid.equals("admin")) {
			if (pwd.equals("admin")) {
				if (bdao.delOne(num)) {
					view = "list";
				}
			}
		} else {
			if (bdao.pwdChk(num, pwd)) {
				if (bdao.delOne(num)) {
					view = "list";
				}
			} else {
				bdto = bdao.getOne(num);
				view = "contents_form.jsp";
				request.setAttribute("content", bdto);
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
