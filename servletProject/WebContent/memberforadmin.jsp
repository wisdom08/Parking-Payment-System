<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/parking.css">


<title>대학교 주차장</title>
</head>
<body>

	<style type="text/css">
.jumbotron {
	text-shadow: black 0.2em 0.2em 0.2em;
	color: white;
	background-image: url('img/bg.jpg');
	background-size: cover;
}
</style>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapsed" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">

					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			<a class="navbar-brand" href="./">HOME</a>

			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<ul class="nav navar-nav">
					<!--  <li class="active"><a href="#">소개<span class="sr-only"></span></a></li>   -->
				</ul>
			</div>
		</div>
	</nav>
	
	
	<div class="container">
		<div class="jumbotron">
			<h2 class="text-center">
				회원 조회 결과
			</h2>

	<table style="margin-left: auto; margin-right: auto; text-align:center;" border="1">
	<tr>
		<th>id</th>
		<th>이름</th>
		<th>차번호</th>
		<th>회원타입
		<br>(1:장기회원  / 2:쿠폰이용자)</th>
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

</div>
	</div>
	
	<footer style="background-color: #ffffff;">
		<div class="container">
			<br>
			<div class="row">
				<div class="text-center" style="text-align: center;">
					<h5>Copyright &copy; 2020</h5>
					<h5>변지혜</h5>
				</div>
			</div>
		</div>
	</footer>


</body>
</html>