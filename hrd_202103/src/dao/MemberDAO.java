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

}
