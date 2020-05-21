package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.BoardDAO;
import DB.BoardDTO;

/**
 * Servlet implementation class modify
 */
@WebServlet("/modify")
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modify() {
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
//		String title = request.getParameter("isubject");
//		String name = request.getParameter("iname");
		String text = request.getParameter("ibody");
		String pwd = request.getParameter("ipwd");

		String view = null;

		BoardDAO bdao = BoardDAO.getInstance();
		BoardDTO bdto = null;

		if (num.indexOf("mod") > -1) { // 수정 전
			int f = num.indexOf("/", 0);
			num = num.substring(0, f);
			if (bdao.pwdChk(num, pwd)) { // 비밀번호 체크
				bdto = bdao.getOne(num);
				view = "modify_form.jsp";
				request.setAttribute("content", bdto);
			} else {
				bdto = bdao.getOne(num);
				view = "contents_form.jsp";
				request.setAttribute("content", bdto);
			}
		} else { // 수정 후
			bdto = bdao.getOne(num);
			bdto.setText(text);

			if (bdao.updateOne(bdto)) {
				bdto = bdao.getOne(num);
				view = "list";
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
