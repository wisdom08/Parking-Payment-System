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
				결제
			</h2>
			
	<%-- 	<%
		int mtype = (int) request.getAttribute("mType");
	if (mtype == 0) {
	%>
	<%=mtype%>
	 [게스트]주차 금액은 얼마 입니다.


	<%
		}
	%>
 --%>
 <p class="text-center">
	<%=request.getAttribute("carNum")%>
	님
</p>
	<!--  시간 추가 해야한다.  -->

	<%-- <%  String price = (String) request.getAttribute("price"); 
		String mType = (String) request.getAttribute("mType"); 
	if(mType.equals("1")) {%>
 
	가격은 0 원입니다. 
	
 <%} else if(mType.equals("2")){%>
 	가격은  price/2 입니다. 
 	
 <%} %> --%>

 <p class="text-center">
	가격은
	<%=request.getAttribute("price")%>
	원 입니다.
	</p>
	<form class="text-center" method="post" action="checkprice">
		<label>계산 금액을 정확하게 입력해주세요. </label> 
		<input type="text" name="uprice" id="uprice"> <br> 
		<label>결제방법을 적어주세요.</label> 
		<input type="radio" name="method" value="1"> 카드
		<input type="radio" name="method" value="2"> 현금
		<!-- <input type="text" name="method" id="method"> --> 
		<br>
		<div id="methodchk"></div>
		영수증 발급 여부
		<input type="radio" name="receipt"> YES
		<input type="radio" name="receipt"> NO
		<br>
		<input type="hidden" name="carNum" value="<%=request.getAttribute("carNum")%>"> 
		<input type="hidden" name="price" id="price" value="<%=request.getAttribute("price")%>"> 
		<br>
		<input type="submit" value="결제" onclick="btn()">

	</form>

	<!-- <script>
		/* 	var chk = document.getElementById("methodchk")
		 var method = document.getElementById("method"); 

		 var method = document.getElementById("method");
		 method.addEventListener("blur", function( event ) {

		 if(method !== "1" || method !== "2"){
		 event.target.style.background = "pink";    
		 chk.innerHTML = "(1 또는 2를 입력해주세요)";
		 }
		
		 }, true);
		 */

		function btn() {

			var uprice = document.getElementById("uprice");
			var price = document.getElementById("price");

			var pricev = price.value; 
			var upricev = uprice.value; 
			
		
			if (pricev == upricev) {
				alert("결제 완료");

			} else {
				alert("금액이 일치하지 않습니다.");
			}
		}
	</script>

 -->

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