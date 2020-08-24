<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payment</title>
</head>
<body>

	<h1> 조회 </h1>
	<table border="1" >
	<tr>
		<th>id</th>
		<th>이용요금</th>
		<th>결제 방법(1은 카드 / 2는 현금)</th>
		<th>결제날짜</th>
		<th>차번호</th>
	</tr>
	<c:forEach var="temp" items="${plist}">
	<tr>
		<td>	${temp.pid}  </td>
		<td>	${temp.amount } </td>
 		<td>	${temp.method }  </td>
		<td>	${temp.date } </td>
		<td>	${temp.carNum } </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>