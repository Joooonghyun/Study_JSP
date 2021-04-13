package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String sql = "INSERT INTO MEMBER_TBL_02 VALUES(SEQ_NUMBER.NEXTVAL,?,?,?,?,?,?)";
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

}
