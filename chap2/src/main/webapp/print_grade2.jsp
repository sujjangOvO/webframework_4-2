<%@page import="yu.homework.GradeInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("UTF-8"); %>
 
 <jsp:useBean id="grade" class="yu.homework.GradeInfo" scope="request"/>
 <jsp:setProperty name="grade" property="*"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		grade.setSum(grade.getAttendance(), grade.getReport(), grade.getFexam(), grade.getMexam());
		String nextPage = (grade.checkSum())? "success.jsp" : "fail.jsp"; // 서블릿말고 jsp는 확장자를 붙여줘야 한다!
		request.setAttribute("sum", grade.getSum());
	%>
	
	<jsp:forward page="<%=nextPage%>" ></jsp:forward>
	
</body>
</html>