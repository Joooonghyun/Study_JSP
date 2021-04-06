package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

public class jdbcUtil {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:orcle:thin://localhost:1521:xe", "system", "1234");
		return con;
	}

	public int joinMember(MemberDTO dto) {
		String sql = "INSERT INTO MEMBER_TBL_02 VALUES(MEMBER_SEQ,?,?,?,TO_DATE('YYYY/MM/DD',?),?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCustname());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setDate(4, dto.getJoindate());
			pstmt.setString(5, dto.getGrade());
			pstmt.setString(6, dto.getCity());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
