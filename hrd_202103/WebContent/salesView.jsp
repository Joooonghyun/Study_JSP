<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="service.MemberService"
	import="dto.MemberDTO"%>
<%
	MemberService service = new MemberService();
	List list = service.salesView();
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
			<td>고객등급</td>
			<td>매출</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = (MemberDTO) list.get(i);

			System.out.println("dto : " + dto);

			int custno = dto.getCustno();
			String custname = dto.getCustname();
			String grade = null;
			if (dto.getGrade().equals("A")) {
				grade = "VIP";
			} else if (dto.getGrade().equals("B")) {
				grade = "일반";
			} else if (dto.getGrade().equals("C")) {
				grade = "고객";
			}
			int price = dto.getMoney_tbl_Price();
		%>
		<tr>
			<td><%=custno%></td>
			<td><%=custname%></td>
			<td><%=grade%></td>
			<td><%=price%></td>
		</tr>
		<%
			}
		%>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>