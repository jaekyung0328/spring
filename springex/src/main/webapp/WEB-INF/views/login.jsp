<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2> 로그인 화면 </h2>
	<form action="./login" method="post">
		<table border="1">
			<tr>	
				<td>ID</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="memberPw"></td>
			</tr>
			
		</table>
		<input type="submit" value="로그인">
	</form>
</body>
</html>