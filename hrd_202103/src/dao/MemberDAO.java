package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private MemberDAO() {
	};

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int joinMember(MemberDTO dto) {
		String sql = "INSERT INTO MEMBER_TBL_02 VALUES(?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCustno());
			pstmt.setString(2, dto.getCustname());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddress());
			pstmt.setDate(5, dto.getJoindate());
			pstmt.setString(6, dto.getGrade());
			pstmt.setString(7, dto.getCity());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String catchSeqNumber() {
		String sql = "SELECT SEQ_NUMBER.NEXTVAL FROM DUAL";
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List memberView() {
		String sql = "SELECT * FROM MEMBER_TBL_02 ORDER BY CUSTNO ASC";
		List result = new ArrayList();
		MemberDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MemberDTO();
				dto.setCustno(rs.getInt(1));
				dto.setCustname(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setJoindate(rs.getDate(5));
				dto.setGrade(rs.getString(6));
				dto.setCity(rs.getString(7));
				result.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List salesView() {
		String sql = "SELECT M.CUSTNO, M.CUSTNAME, M.GRADE, SUM(N.PRICE) AS TOTAL FROM MEMBER_TBL_02 M JOIN MONEY_TBL_02 N ON M.CUSTNO = N.CUSTNO GROUP BY(M.CUSTNO, M.CUSTNAME, M.GRADE) ORDER BY TOTAL DESC";
		List result = new ArrayList();
		MemberDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MemberDTO();
				dto.setCustno(rs.getInt(1));
				dto.setCustname(rs.getString(2));
				dto.setGrade(rs.getString(3));
				dto.setMoney_tbl_Price(rs.getInt(4));
				result.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
