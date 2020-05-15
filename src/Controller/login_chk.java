package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.MemberDAO;
import DB.MemberDTO;

/**
 * Servlet implementation class login_chk
 */
@WebServlet("/login_chk")
public class login_chk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login_chk() {
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

		String inputId = request.getParameter("iid");
		String inputPwd = request.getParameter("ipwd");

		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO mdto = mdao.selOne(inputId, inputPwd);

		String view = null;

		if (mdto != null) { // 회원 정보가 있으면
			view = "list";
			HttpSession session = request.getSession();
			session.setAttribute("id", mdto.getId());
			session.setAttribute("name", mdto.getName());
		} else { // 회원 정보가 없으면
			view = "login_form.jsp";
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
