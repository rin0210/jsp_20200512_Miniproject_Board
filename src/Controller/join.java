package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.ModelAbstractChannelMixer;

import DB.MemberDAO;
import DB.MemberDTO;

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public join() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");

		String inputId = request.getParameter("iid");
		String inputPwd = request.getParameter("ipwd");
		String inputName = request.getParameter("iname");

		String view = null;

		MemberDAO mdao = MemberDAO.getInstance();

//		if (mdao.idCheck(inputId) == false) { // 중복 아이디가 있다면
////			request.setAttribute("message", "no");
////			view = "join_form.jsp";
//			response.sendRedirect("join_form.jsp");
//		} else {
			MemberDTO mdto = new MemberDTO();
			mdto.setId(inputId);
			mdto.setPwd(inputPwd);
			mdto.setName(inputName);
			mdao.insert(mdto);

//			request.setAttribute("message", "yes");
			view = "list";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
//	}

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
