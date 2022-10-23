<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
<div align="center">
<h2>회원 등록</h2>
<hr>
<form action="/chap3/member/insert.do" method="post">
	<table border="1">
		<tr>
			<th>이름</th> <td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<th>비밀번호</th> <td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<th>이메일</th> <td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<th>가입일</th> <td><input type="text" name="regdate" /></td>
		</tr>
		<tr>
			<td></td> <td><input type="submit" value="등록"/> <input type="reset" value="취소" /></td>
		</tr>
	</table>
</form>
</div>

</body>
</html>