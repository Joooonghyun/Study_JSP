<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" import="model.dto" import="model.dbConnect" import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updatemember" method="post" name="update">
<%
	ArrayList<dto> list = (ArrayList<dto>) request.getAttribute("list");
	String jdate = list.get(0).getJoindate();
	String joindate = null;
	if (jdate != null) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date day = sdf.parse(jdate);
		sdf = new SimpleDateFormat("yyyyMMdd");
		joindate = sdf.format(day);
	}
%>
<input type="text" id="custno" name="custno" value="<%=list.get(0).getCustno() %>">
<input type="text" id="custname" name="custname" value="<%=list.get(0).getCustname() %>">
<input type="text" id="phone" name="phone" value="<%=list.get(0).getPhone() %>">
<input type="text" id="address" name="address" value="<%=list.get(0).getAddress() %>">
<input type="text" id="joindate" name="joindate" value="<%=joindate %>">
<input type="text" id="grade" name="grade" value="<%=list.get(0).getGrade() %>">
<input type="text" id="city" name="city" value="<%=list.get(0).getCity() %>">
<input type="button" value="등록" onclick="updatemember()">
</form>
<script type="text/javascript">
function updatemember() {
	if(document.update.custno.value == ""){
		alert('번호');
		document.update.custno.focus();
		return false;
	}
	if(document.update.custname.value == ""){
		alert('이름');
		document.update.custname.focus();
		return false;
	}	
	if(document.update.phone.value == ""){
		alert('전화번호');
		document.update.phone.focus();
		return false;
	}
	if(document.update.joindate.value == ""){
		alert('날짜');
		document.update.joindate.focus();
		return false;
	}	
	if(document.update.grade.value == ""){
		alert('등급');
		document.update.grade.focus();
		return false;
	}
	if(document.update.city.value == ""){
		alert('도시');
		document.update.city.focus();
		return false;
	}	
	
	alert('회원정보수정성공');
	document.update.submit();
}
</script>
</body>
</html>