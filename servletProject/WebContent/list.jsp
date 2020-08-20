<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member</title>
</head>
<body>

	<h1> 조회 </h1>
	<table border="1" >
	<tr>
		<th>id</th>
		<th>name</th>
		<th>carNum</th>
		<th>type(0.게스트 1.장기회원 2.쿠폰 이용자)</th>
		<th>regDate</th>
		<th>expDate</th>
	</tr>
	<c:forEach var="member" items="${memberList}">
	<tr>
		<td>	${member.id }  </td>
		<td>	${member.name } </td>
 		<td>	${member.carNum }  </td>
		<td>	${member.type } </td>
		<td>	${member.regDate } </td>
		<td>	${member.expDate } </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>