<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>log 조회</h1>

	<table border="1">
		<tr>
			<th>timeIn</th>
			<th>timeOut</th>
			<th>carNum</th>
		</tr>
		<c:forEach var="temp" items="${logs}">
			<tr>
				<td>${temp.timeIn }</td>
				<td>${temp.timeOut }</td>
				<td>${temp.carNum }</td>
			</tr>
		</c:forEach>
	</table>

 	
		가격:
		<%= request.getAttribute("price") %>



	멤버타입:
	<%=request.getAttribute("mType")%>
	
(0 게스트
1 장기회원
2 쿠폰이용자
)

<br>
<a href="./"><label>HOME</label></a>

</body>
</html>