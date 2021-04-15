package service;

import static DBPKG.jdbcUtil.getConnection;

import java.sql.*;
import java.util.*;

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
	
	public List memberView() throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List result = dao.memberView();
		return result;
	}
}
