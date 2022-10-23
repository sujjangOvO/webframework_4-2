<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int total = Integer.parseInt(request.getParameter("mexam")) +
		Integer.parseInt(request.getParameter("fexam")) +
		Integer.parseInt(request.getParameter("report")) +
		Integer.parseInt(request.getParameter("attendance"));
		
		request.setAttribute("sum", total);
		String nextPage = (total>60)? "success.jsp" : "fail.jsp"; // 서블릿말고 jsp는 확장자를 붙여줘야 한다!
	%>
	
	<jsp:forward page = "<%=nextPage%>"></jsp:forward>  
	<!-- page에 표현식으로 자바 변수가 들어갈때도 ""를 사용해야 한다. --> 
		
</body>
</html>