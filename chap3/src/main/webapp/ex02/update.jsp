<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function deleteClicked(){
		result = confirm("정말로 삭제하시겠습니까?");
		if(result){
			document.form1.action = "chap3/member/delete.do";
			document.form1.submit();
		}
		else{
			return;
		}
	}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>회원정보 수정/삭제</h2>
		<hr>
		<form name="form1" action="/chap3/member/update.do" method="post">
			<input type="hidden" name="id" value="${requestScope.member.id}">
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${requestScope.member.name}"></td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="password" value="${requestScope.member.password}"></td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${requestScope.member.email}"></td>
				</tr>
				
				<tr>
					<th>가입일</th>
					<td><input type="text" name="regdate" value="${requestScope.member.regdate}"></td>
				</tr>
				
				<tr>
					<td/>
					<td>
						<input type="submit" value="수정">
						<input type="reset" value="취소">
						<input type="button" value="삭제" onclick="deleteClicked()">
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>