<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<jsp:useBean id="contact" class="chap2.ex2.Contact" scope="page"></jsp:useBean>   
<jsp:setProperty property="*" name="contact"/>
<jsp:useBean id="dao" class="chap2.ex2.ContactDAO" scope="application"></jsp:useBean>
<% dao.insert(contact); %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>등록 내용</h2>
		이름: <%= contact.getName() %> <br>
		전화번호: <%= contact.getPhone() %> <br>
		이메일: <%= contact.getEmail() %> <br>
		성별: ${contact.gender} <br>
		<hr>
		<a href="addr_list.jsp">목록 보기</a>
	</div>
</body>
</html>