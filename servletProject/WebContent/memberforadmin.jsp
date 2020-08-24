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
		<th>이름</th>
		<th>차번호</th>
		<th>회원타입(1은 장기회원 / 2는 쿠폰이용자)</th>
		<th>등록일</th>
		<th>만료일</th>
	</tr>
	<c:forEach var="temp" items="${mlist}">
	<tr>
		<td>	${temp.id}  </td>
		<td>	${temp.name } </td>
		<td>	${temp.carNum } </td>
 		<td>	${temp.type }  </td>
		<td>	${temp.regDate } </td>
		<td>	${temp.expDate } </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>