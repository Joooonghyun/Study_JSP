package service;

import static DBPKG.jdbcUtil.getConnection;

import java.sql.Connection;

import DBPKG.jdbcUtil;
import dto.MemberDTO;

public class MemberService {
	jdbcUtil dao = new jdbcUtil();

	public int joinMember(MemberDTO dto) throws Exception {
		Connection con = getConnection();
		int result = dao.joinMember(dto);
		return result;
	}
}
