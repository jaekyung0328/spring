<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>MemberList</h2>
	<table border="1">
	 		<thead>
	 			<tr>
	 				<th>NO</th>
	 				<th>ID</th>
	 				<th>NAME</th>
	 			</tr>
	 			<c:forEach var="member" items="${list}">
		 			<tr>
		 				<th>${member.memberNo}</th>
		 				<th>${member.memberId}</th>
		 				<th>${member.memberName}</th>
		 			</tr>
	 			</c:forEach>
	 			
	 		</thead>
	</table>
	

</body>
</html>