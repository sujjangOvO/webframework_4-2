<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex01.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 		
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<div align="center">
	<h2>전체 회원 리스트</h2>
	<hr> 
	<a href="/chap3/member/insertReq.do">회원 추가</a>
	<p>
	<table border="1">
		<tr>
			<th>아이디</th> <th>이름</th> <th>비밀번호</th> <th>이메일</th> <th>가입일</th>
		</tr>
		<c:forEach var="member" items="${requestScope.memberList}">
			<tr>
				<td><a href="/chap3/member/updateReq.do?id=${member.id}">${member.id}</a></td>
				<td>${member.name} </td>
				<td>${member.password} </td>
				<td>${member.email} </td>
				<td>${member.regdate}</td>
			</tr>
		</c:forEach>

	</table>
</div>
</body>
</html>