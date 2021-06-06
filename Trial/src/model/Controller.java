package model;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.b;

/**
 * Servlet implementation class Controller
 */
@WebServlet(value = { "/addmember", "/select", "/updatemember", "/update" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
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
		try {
			doProcess(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String value = request.getServletPath();
		switch (value) {
		case "/addmember":
			dbConnect db = new dbConnect();
			db.add(request);
			break;
		case "/select":
			db = new dbConnect();
			ArrayList<dto> list = db.select(request);
			request.setAttribute("list", list);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("selectSales.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "/update":
			db = new dbConnect();
			list = db.select(request);
			request.setAttribute("list", list);
			requestDispatcher = request.getRequestDispatcher("updateMember.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "/updatemember":
			db = new dbConnect();
			db.update(request);
			requestDispatcher = request.getRequestDispatcher("main.jsp");
			break;
		}
	}
}
