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
	background-image: url('img/bg.jpg');
	background-size: cover;
	color: #337ab7;
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
				차량 번호판 스캔
			</h2>

	<!-- <h1>입차</h1> -->
	<!-- 입력정보: name, 차번호, type -->

	<form class="text-center" method="post" action="park">
	 	
		<label>차량 번호: </label> 
		<input type="text" name="carNum"> 
	
		<input type="submit" value="입차" onclick="btn()">
	</form>
	
	<br><br>
	
	
<table style="margin-left: auto; margin-right: auto;" border="1">
			<tr>
				<td>시간</td>
				<td>이용 요금</td>
			</tr>

			<tr>
				<td>1시간</td>
				<td>1000원</td>
			</tr>

			<tr>
				<td>1일 (24시간) </td>
				<td>12000원</td>
			</tr>


		</table>

	</div>
	</div>

	<script>
		function btn() {

			/* condition 추가하기 */
			
			var condition = true;
			if (condition) {
				//alert("입차 완료");
			//	location.href = "index.jsp";
			}
		}
	</script>
	
	
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