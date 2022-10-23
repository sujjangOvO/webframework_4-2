<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/chap3/member2/login.do" method="POST">
	<c:if test="${requestScope.errors.mismatch}">아이디와 암호가 일치하지 않습니다.<br><br></c:if>
		이메일:<br>
		<input type="text" name="email" value="${param.email}">
		<c:if test="${requestScope.errors.email}">이메일을 입력해주세요!</c:if>
		<p>
		
		암호:<br>
		<input type="password" name="password">
		<c:if test="${requestScope.errors.password}">비밀번호를 입력해주세요!</c:if>
		<p>
		
		<input type="submit" value=로그인>
	</form>
</body>
</html>