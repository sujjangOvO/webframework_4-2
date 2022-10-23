<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
    
 <%
 	request.setCharacterEncoding("utf-8");
 	String selected = request.getParameter("product");
	ArrayList<String> plist = (ArrayList<String>)session.getAttribute("products");
	if(plist == null){
		 plist = new ArrayList<String>();
	 	session.setAttribute("products", plist);
	}
	plist.add(selected);
 %>
 
 <script>
 	alert("선택한 상품 = <%= selected %>");
 	history.go(-1);
 </script>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>