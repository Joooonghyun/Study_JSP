<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="model.dto"
	import="model.dbConnect" import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입일</td>
			<td>등급</td>
			<td>도시</td>
		</tr>
		<%
			dbConnect db = new dbConnect();
		ArrayList<dto> list = db.member();
		for (dto d : list) {
			
			String jdate = d.getJoindate();
			String joindate = null;
			if (jdate != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date day = sdf.parse(jdate);
				sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				joindate = sdf.format(day);
			}
			
		%>
		<tr>
			<td><a href='update?custno=<%=d.getCustno()%>'><%=d.getCustno()%></a></td>
			<td><%=d.getCustname()%></td>
			<td><%=d.getPhone()%></td>
			<td><%=d.getAddress()%></td>
			<td><%=joindate%></td>
			<td><%=d.getGrade()%></td>
			<td><%=d.getCity()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<script type="text/javascript">
		
	</script>
</body>
</html>