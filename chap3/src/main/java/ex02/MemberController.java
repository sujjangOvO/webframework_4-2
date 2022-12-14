package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member2/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        memberDAO = new MemberDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		
		System.out.println("request.getPathInfo: " + request.getPathInfo());
		System.out.println("request.getContextPath: " + request.getContextPath());
		System.out.println("request.getQueryString: " + request.getQueryString());
		System.out.println("request.getRequestURI: " + request.getRequestURI());
		System.out.println("request.getRequestURL: " + request.getRequestURL());
		System.out.println("request.getServerName: " + request.getServerName());
		System.out.println("request.getServletPath: " + request.getServletPath());
		
		if(action.equals("/login.do") && request.getMethod().equalsIgnoreCase("GET")) {
			forwardReq(request, response, "/ex02/login.jsp");
		}
		else if(action.equals("/login.do") && request.getMethod().equalsIgnoreCase("POST")) {
			processLogin(request, response);
		}
		else if (action == null || action.equals("/listMembers.do")) {
			List<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			forwardReq(request, response, "/ex02/listMembers.jsp");
		}
		
		else if (action.equals("/insert.do") && request.getMethod().equalsIgnoreCase("GET")) {
			forwardReq(request, response, "/ex02/insert.jsp");
		}
		
		else if (action.equals("/insert.do") && request.getMethod().equalsIgnoreCase("POST")) {
			member = new MemberVO();
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setEmail(request.getParameter("email"));
			member.setRegdate(request.getParameter("regdate"));
			memberDAO.insert(member);
			response.sendRedirect("listMembers.do");
		}
		else if(action.equals("/updateReq.do")){
			member = memberDAO.getMemberById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("member", member);
			System.out.println(member);
			//System.out.println(request.getParameter("id"));
			forwardReq(request, response, "/ex02/update.jsp");
		}
		else if(action.equals("/update.do")) {
			member = new MemberVO();
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setEmail(request.getParameter("email"));
			member.setRegdate(request.getParameter("regdate"));
			member.setId(Integer.parseInt(request.getParameter("id")));
			memberDAO.update(member);
			response.sendRedirect("listMembers.do");
		}
		else if(action.equals("/delete.do")){
			memberDAO.delete(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("listMembers.do");
		}
		else if(action.equals("/logout.do")) { // ???????????? ?????? ?????? ?????? ?????? ??? ??? ??????!!!!!
			HttpSession session = request.getSession(false); // false?????? ?????? ????????? ???????????? ?????? ?????? ????????? HttpSession ????????? ???????????? ?????? null??? ??????
															// ?????? true?????? ?????? ????????? ???????????? ???????????? ????????? HttpSession ????????? ???????????? ????????????.
			if(session == null || session.getAttribute("member") == null) {
				System.out.println("????????? ????????? ???????????? ????????????.");
			}
			else {
				session.invalidate(); // ????????? ???????????? ?????????
				System.out.println("????????? ???????????? ???????????? ???????????????.");
			}
			forwardReq(request,response,"/ex02/index.jsp");
			
		}
		else if(action.equals("/changepwd.do")) { // ???????????? ?????? ??????
			HttpSession session = request.getSession();
			String tempPassword = "12341234"; // ????????? ????????? ????????????

			PrintWriter out = response.getWriter();
			
			// ?????? ???????????? ??????????????? ???????????? ?????? ??????
			if(session == null || session.getAttribute("member") == null) {
				System.out.println("????????? ????????? ???????????? ????????????.");
				forwardReq(request, response, "/login.do");
			}
			else {
				int id = (int)session.getAttribute("id");
				memberDAO.updatePassword(tempPassword, id);
				System.out.println("??????????????? ?????????????????????.");
				out.println("<script>alert('??????????????? ?????????????????????.');</script>"); // ??? ?????????
				forwardReq(request,response,"/ex02/index.jsp");
				out.close();
			}
			
		}
		
		
	}
	
	private void forwardReq(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
	private void processLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
			
		HashMap<String, Boolean> errors = new HashMap<>();
		
		if(email == null || email.isEmpty()) {
			errors.put("email", true); // ??????????????? ?????? ??????
		}
		if(password == null || password.isEmpty()) {
			errors.put("password", true); // ?????????????????? ?????? ??????
		}
		
		request.setAttribute("errors", errors);
		if(!errors.isEmpty()) {
			forwardReq(request, response, "/ex02/login.jsp");
			return;
		}
		
		MemberVO member = memberDAO.getMemberByEmail(email);
		if(!password.equals(member.getPassword())) {
			errors.put("mismatch", true);
			forwardReq(request, response, "/ex02/login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		session.setAttribute("id", member.getId());
		forwardReq(request, response, "/ex02/index.jsp");
		
		
	}
}
