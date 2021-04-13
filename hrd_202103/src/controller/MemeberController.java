package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class MemeberController
 */
@WebServlet(value = { "/MemeberController", "/joinMember" } )
public class MemeberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemeberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberService service = new MemberService();
		PrintWriter out = response.getWriter();
		
		switch (request.getServletPath()) {
		case "/joinMember":
			MemberDTO dto = new MemberDTO();
			dto.setCustname(request.getParameter("custname"));
			dto.setPhone(request.getParameter("phone"));
			dto.setAddress(request.getParameter("address"));
			dto.setJoindate(Date.valueOf(request.getParameter("joindate")));
			dto.setGrade(request.getParameter("grade"));
			dto.setCity(request.getParameter("city"));

			int result = service.joinMember(dto);
			System.out.println(result);
			if (result > 0) {
				response.setContentType("text/html; charset = UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입 성공')");
				out.println("location.href='index.jsp'");
				out.println("</script>");
			}
			break;
		case "":
			
			break;
		}
	}
}
