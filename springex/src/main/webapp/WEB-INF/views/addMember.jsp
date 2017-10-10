<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addMember</title>
</head>
<body>
	<h2> add Member</h2>
	<form action = "./addMember" method="post">
		<table border="1">
			<tr>
				<td>memberId</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td><input type="text" name="memberPw"></td>
			</tr>
			<tr>
				<td>memberName</td>
				<td><input type="text" name="memberName"></td>
			</tr>
		</table>
		<input type="submit" value="addMember">

		
	</form>
</body>
</html>