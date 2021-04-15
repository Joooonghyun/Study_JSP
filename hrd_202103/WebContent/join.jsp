<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="service.MemberService"%>
<%
	String todate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	Calendar c1 = Calendar.getInstance();
	todate = sdf.format(c1.getTime());
	MemberService service = new MemberService();
	String custno = service.catchSeqNumber();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="nav.jsp"></jsp:include>
	<h1>홈쇼핑 회원 등록</h1>
	<form action="joinMember" method="post" id="join">
		<table>
			<tr>
				<td>회원번호 (자동 발생)</td>
				<td><input type="text" name="custno" id="custno"
					value="<%=custno%>"></td>
			</tr>
			<tr>
				<td>회원 성명</td>
				<td><input type="text" name="custname" id="custname"></td>
			</tr>
			<tr>
				<td>회원 전화</td>
				<td><input type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
				<td>회원 주소</td>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td>가입 일자</td>
				<td><input type="text" name="joindate" id="joindate" value="<%=todate%>"></td>
			</tr>
			<tr>
				<td>고객 등급 [A:VIP, B:일반, C:직원]</td>
				<td><input type="text" name="grade" id="grade"></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type="text" name="city" id="city"></td>
			</tr>
			<tr>
				<td><input type="button" value="등록" onclick="Join()"><input type="button" value="조회" onclick="location.href='memberView.jsp'"></td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		function Join() {
			var custname = document.getElementById("custname");
			var phone = document.getElementById("phone");
			var address = document.getElementById("address");
			var joindate = document.getElementById("joindate");
			var grade = document.getElementById("grade");
			var city = document.getElementById("city");

			if (custname.value == "") {
				alert("이름을 입력해 주세요.");
				custname.focus();
				return false;
			}
			if (phone.value == "") {
				alert("번호를 입력해 주세요.");
				phone.focus();
				return false;
			}
			if (address.value == "") {
				alert("주소를 입력해 주세요.");
				address.focus();
				return false;
			}
			if (joindate.value == "") {
				alert("가입일자를 입력해 주세요.");
				joindate.focus();
				return false;
			}
			if (grade.value == "") {
				alert("등급을 입력해 주세요.");
				grade.focus();
				return false;
			}
			if (city.value == "") {
				alert("도시코드를 입력해 주세요.");
				city.focus();
				return false;
			}
			join.submit();
		}
	</script>
</body>
</html>