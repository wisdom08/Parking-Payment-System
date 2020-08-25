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
	color: #337ab7;
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
				관리자님 환영합니다.
			</h2>


<% 
String result = (String)request.getAttribute("result"); 
%>

<% if(result.equals("good")){%>




    <form class="text-center" method = "post" action = "/memberforadmin">
        <input type="submit" value="회원 조회">
    </form>
    <br>
      <form class="text-center" method = "post" action = "/paymentforadmin">
        <input type="submit" value="결제 조회">
    </form>
    <br>
          <form class="text-center" method = "post" action = "/logforadmin">
        <input type="submit" value="입차 차량 조회">
    </form>
<br>
<%} else  {%>

<script>
alert("관리자만 접근 가능합니다.");
location.href='/';
</script>


<%} %>

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