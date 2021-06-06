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
<%
	dbConnect db = new dbConnect();
	int custno = db.selectCustno();
	custno += 100001;
%>
<form action="addmember" method="post" name="add">
<input type="text" id="custno" name="custno" value="<%=custno%>">
<input type="text" id="custname" name="custname">
<input type="text" id="phone" name="phone">
<input type="text" id="address" name="address">
<input type="text" id="joindate" name="joindate">
<input type="text" id="grade" name="grade">
<input type="text" id="city" name="city">
<input type="button" value="등록" onclick="addmember()">
</form>
<script type="text/javascript">
function addmember() {
	if(document.add.custno.value == ""){
		alert('번호');
		document.add.custno.focus();
		return false;
	}
	if(document.add.custname.value == ""){
		alert('이름');
		document.add.custname.focus();
		return false;
	}	
	if(document.add.phone.value == ""){
		alert('전화번호');
		document.add.phone.focus();
		return false;
	}
	if(document.add.address.value == ""){
		alert('날짜');
		document.add.address.focus();
		return false;
	}
	if(document.add.joindate.value == ""){
		alert('날짜');
		document.add.joindate.focus();
		return false;
	}	
	if(document.add.grade.value == ""){
		alert('등급');
		document.add.grade.focus();
		return false;
	}
	if(document.add.city.value == ""){
		alert('도시');
		document.add.city.focus();
		return false;
	}	
	
	alert('회원가입성공');
	document.add.submit();
}
</script>
</body>
</html>