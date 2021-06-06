<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
	String memberno = "2105132000001";
char no = memberno.charAt(6);
String member = null;
if (no == '1' || no == '3' || no == '5') {
	member = "남자";
}
if (no == '2' || no == '4' || no == '6') {
	member = "여자";
}
%>
<%
String todate = "20210513";
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
Date nowDate = sdf.parse(todate);
sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
String tod = sdf.format(nowDate);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=member%>
	<%=tod%>
	
	<!-- DB까지 연결 form태그의 action은 어떻게 -->
	<form action="" name="add" method="post">
		<input type="text" id="id" name="id"> <input type="button"
			value="가입" onclick="subbtn()"> <input type="reset" value="리셋"
			onclick="rsbtn()">
	</form>
	<script type="text/javascript">
		function subbtn() {
			if (document.add.id.value == "") {
				alert("아이디를 입력하세요");
				document.add.id.focus();

				return false;
			}
			var id = document.add.id.value;
			alert("회원가입성공");
			location.href="TEST.jsp";
			/* document.add.submit(); */
		}

		function rsbtn() {
			alert("리셋");
			document.add.id.focus();
		}
	</script>
</body>
</html>