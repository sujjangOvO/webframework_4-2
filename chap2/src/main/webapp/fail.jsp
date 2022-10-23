<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>총점이 60점 미만입니다!!</h2>
	
	<p>
		학번: <%=request.getParameter("id") %> <br>
		이름: <%=request.getParameter("name") %>
	</p>
	
	<p>
		중간시험: <%=request.getParameter("mexam") %> <br>
		기말시험: <%=request.getParameter("fexam") %> <br>
		리포트: <%=request.getParameter("report") %> <br>
		출석: <%=request.getParameter("attendance") %> 
	</p>
	
	총점은 <%=request.getAttribute("sum") %>점 입니다.
</body>
</html>