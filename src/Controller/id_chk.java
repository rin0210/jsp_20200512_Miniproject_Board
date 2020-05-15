package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.MemberDAO;

/**
 * Servlet implementation class id_chk
 */
@WebServlet("/id_chk")
public class id_chk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public id_chk() {
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

		String id = request.getParameter("id");
		System.out.println("아이디체크?" + id);

		MemberDAO mdao = MemberDAO.getInstance();

		if (mdao.idCheck(id) == false) { // 중복 아이디가 있다면
			request.setAttribute("id", id);
			request.setAttribute("result", 1);
		} 
		else if (id == null) { // 빈칸이면
			request.setAttribute("result", 3);
		} 
		else { // 아이디가 사용 가능하면
			request.setAttribute("id", id);
			request.setAttribute("result", 2);
		}

		String view = "idChk_form.jsp";
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
