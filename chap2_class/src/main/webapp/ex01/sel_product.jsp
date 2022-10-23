<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	request.setCharacterEncoding("UTF-8");
	String login = request.getParameter("login");
	if(login != null){
		session.setAttribute("login", login);
	}
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>상품 선택</h2>
		<hr>
		<%=session.getAttribute("login") %>님 환영합니다.
		<hr>
		
		<form action="add.jsp" method="post">
			<select name="product">
				<option value="사과" selected>사과</option>
				<option value="복숭아">복숭아</option>
				<option value="바나나">바나나</option>
				<option value="파인애플">파인애플</option>
			</select>
			
			<input type="submit" value="추가">
		</form>
		
		<p>
			<a href="checkout.jsp">계산</a>
		</p>
	</div>
</body>
</html>