<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, chap2.ex2.*"%>
 
<jsp:useBean id="dao" class="chap2.ex2.ContactDAO" scope="application"></jsp:useBean>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>주소록</h2>
		<hr>
		<a href="addr_form.html">주소 추가</a>
		
		<p>
			<table border="1">
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>성별</th>
				</tr>
				<%
					List<Contact> clist = (List<Contact>)dao.getList();	
					if(clist != null){
						for(Contact item:clist){
				%>
					<tr>		
						<td><%= item.getName() %> </td>
						<td><%= item.getPhone() %> </td>
						<td><%= item.getEmail() %> </td>
						<td><%= item.getGender() %> </td>
					</tr>
				<%
						}
					}
				%>
			</table>

	</div>
</body>
</html>