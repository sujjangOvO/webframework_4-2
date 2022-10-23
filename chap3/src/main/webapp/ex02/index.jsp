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
	<c:if test="${sessionScope.member!=null}"> <h2>${sessionScope.member.name}님, 안녕하세요</h2> </c:if>
	<p>
	<a href="/chap3/member2/logout.do">[로그아웃]</a>
	<a href="/chap3/member2/changepwd.do">[암호변경]</a>
</body>
</html>