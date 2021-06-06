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
			<td>고객등급</td>
			<td>매출</td>
		</tr>
		<%
			dbConnect db = new dbConnect();
		ArrayList<dto> list = db.selectMem();
		for (dto d : list) {
		%>
		<tr>
			<td><%=d.getCustno()%></td>
			<td><%=d.getCustname()%></td>
			<td><%=d.getGrade()%></td>
			<td><%=d.getSum_price()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<script type="text/javascript">
		
	</script>
</body>
</html>