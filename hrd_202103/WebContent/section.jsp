<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String pp = request.getParameter("pp");
if (pp == null) {
	pp = "main";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
console.log("<%=pp%>");
</script>
	<jsp:include page='<%=pp + ".jsp"%>'></jsp:include>
</body>
</html>