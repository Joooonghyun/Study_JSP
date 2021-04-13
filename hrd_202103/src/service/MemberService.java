package service;

import java.sql.Connection;
import static DBPKG.jdbcUtil.*;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {

	public int joinMember(MemberDTO dto) throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.joinMember(dto);
		return result;
	}

	public String catchSeqNumber() throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		String result = dao.catchSeqNumber();
		return result;
	}
}
