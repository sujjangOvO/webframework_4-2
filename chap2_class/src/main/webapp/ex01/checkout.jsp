<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>계산</h2>
		<p>
			<% session.getAttribute("login");%>님이 선택한 상품 목록
		</p>
		<hr>
		<%
			ArrayList<String> plist = (ArrayList<String>)session.getAttribute("products");
			if(plist != null){
				for(String product:plist){
					out.println(product+"<br>");
				}
			}
		%>
	</div>
</body>
</html>