package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class dbConnect {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connection getConnection() throws SQLException {
		String jdbc_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName(jdbc_driver);
			Connection con = DriverManager.getConnection(db_url, "system", "1111");
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<dto> member() {
		ArrayList<dto> list = new ArrayList<dto>();
		String sql = "SELECT * FROM MEMBER_TBL_02";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto d = new dto();
				d.setCustno(rs.getInt(1));
				d.setCustname(rs.getNString(2));
				d.setPhone(rs.getString(3));
				d.setAddress(rs.getString(4));
				d.setJoindate(rs.getString(5));
				d.setGrade(rs.getString(6));
				d.setCity(rs.getString(7));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<dto> selectMem() {
		ArrayList<dto> list = new ArrayList<dto>();
//		SELECT M.CUSTNO, M.CUSTNAME, M.GRADE, SUM(N.PRICE) AS TOTAL FROM MEMBER_TBL_02 M JOIN MONEY_TBL_02 N ON M.CUSTNO = N.CUSTNO GROUP BY(M.CUSTNO, M.CUSTNAME, M.GRADE) ORDER BY TOTAL DESC
		String sql = "select m.custno, m.custname, m.grade, sum(n.price) as sum_price from MEMBER_TBL_02 m join money_tbl_02 n on m.custno = n.custno group by (m.custno, m.custname, m.grade) order by sum_price desc ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto dto = new dto();
				dto.setCustno(rs.getInt(1));
				dto.setCustname(rs.getString(2));
				dto.setGrade(rs.getString(3));
				dto.setSum_price(rs.getInt(4));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void add(HttpServletRequest request) throws ParseException {
		String sql = "insert into MEMBER_TBL_02 values(SEQ_NUMBER.NEXTVAL, ? ,?, ? ,? ,? ,? )";
		try {
			con = getConnection();

			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			java.util.Date date = new SimpleDateFormat("yyyMMdd").parse(request.getParameter("joindate"));
			java.sql.Date joindate = new java.sql.Date(date.getTime());

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setDate(4, joindate);
			pstmt.setString(5, grade);
			pstmt.setString(6, city);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<dto> select(HttpServletRequest request) {
		String sql = "SELECT * FROM MEMBER_TBL_02 WHERE CUSTNO = ?";
		int custno = Integer.parseInt(request.getParameter("custno"));
		try {
			con = getConnection();
			ArrayList<dto> list = new ArrayList<dto>();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto d = new dto();
				d.setCustno(rs.getInt(1));
				d.setCustname(rs.getString(2));
				d.setPhone(rs.getString(3));
				d.setAddress(rs.getNString(4));
				d.setJoindate(rs.getString(5));
				d.setGrade(rs.getString(6));
				d.setCity(rs.getString(7));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void update(HttpServletRequest request) {
		String sql = "UPDATE MEMBER_TBL_02 SET CUSTNAME= ?, PHONE=?, ADDRESS=?, JOINDATE=?, GRADE=?, CITY=? WHERE CUSTNO = ?";
		try {
			con = getConnection();

			int custno = Integer.parseInt(request.getParameter("custno"));
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String joindate = request.getParameter("joindate");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			System.out.println(custname + phone + address + joindate + grade + city);

			pstmt.setString(1, custname);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, joindate);
			pstmt.setString(5, grade);
			pstmt.setString(6, city);
			pstmt.setInt(7, custno);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int selectCustno() {
		String sql = "SELECT COUNT(CUSTNO) AS CUSTNO FROM MEMBER_TBL_02";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int custno = 0;
			if (rs.next()) {
				custno = rs.getInt(1);
			}
			return custno;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
