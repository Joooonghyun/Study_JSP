<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="service.MemberService"
	import="dto.MemberDTO"%>
<%
	MemberService service = new MemberService();
	List list = service.memberView();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top.jsp" />
	<jsp:include page="nav.jsp" />
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>거주지역</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = (MemberDTO) list.get(i);

			System.out.println("dto : " + dto);

			int custno = dto.getCustno();
			String custname = dto.getCustname();
			String phone = dto.getPhone();
			String address = dto.getAddress();
			Date joindate = dto.getJoindate();
			String grade = dto.getGrade();
			String city = dto.getCity();
		%>
		<tr>
			<td><%=custno%></td>
			<td><%=custname%></td>
			<td><%=phone%></td>
			<td><%=address%></td>
			<td><%=joindate%></td>
			<td><%=grade%></td>
			<td><%=city%></td>
		</tr>
		<%
			}
		%>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>