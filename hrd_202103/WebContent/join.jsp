<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈쇼핑 회원 등록</h1>
	<table>
		<tr>
			<td>회원번호 (자동 발생)</td>
			<td><input type="text" name="custno"></td>
		</tr>
		<tr>
			<td>회원 성명</td>
			<td><input type="text" name="custname"></td>
		</tr>
		<tr>
			<td>회원 전화</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>회원 주소</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>가입 일자</td>
			<td><input type="text" name="joindate"></td>
		</tr>
		<tr>
			<td>고객 등급 [A:VIP, B:일반, C:직원]</td>
			<td><input type="text" name="grade"></td>
		</tr>
		<tr>
			<td>도시코드</td>
			<td><input type="text" name="city"></td>
		</tr>
		<tr>
			<td><input type="button" value="등록"><input type="button" value="조회"></td>
		</tr>
	</table>
</body>
</html>