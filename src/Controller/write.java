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
 * Servlet implementation class write
 */
@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public write() {
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
		HttpSession session = request.getSession();
		String nowid = (String) session.getAttribute("id");
		String title = request.getParameter("ititle");
		String name = request.getParameter("iname");
		String body = request.getParameter("ibody");
		String pwd = request.getParameter("ipwd");

		BoardDAO bdao = BoardDAO.getInstance();
		BoardDTO bdto = new BoardDTO();
		bdto.setId(nowid);
		bdto.setTitle(title);
		bdto.setName(name);
		bdto.setText(body);
		bdto.setPwd(pwd);

		if (bdao.insert(bdto)) {
			String view = "list";

			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
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
