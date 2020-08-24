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
		<th>timeIn</th>
		<th>timeOut</th>
		<th>carNum</th>
	</tr>
	<c:forEach var="temp" items="${llist}">
	<tr>
		<td>	${temp.lid}  </td>
		<td>	${temp.timeIn } </td>
 		<td>	${temp.timeOut }  </td>
		<td>	${temp.carNum } </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>