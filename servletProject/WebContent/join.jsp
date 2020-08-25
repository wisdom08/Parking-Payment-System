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
				회원 등록
			</h2>
	
	<form class="text-center" name="frm1" method="post" action="joinmember">

		<label>이름: </label> 
		<input type="text" id="name" name="name">
		<br>
		<div id="namechk"></div>
		<label>차량 번호: </label> 
		<input type="text" id="carNum" name="carNum"> <br>
		<div id="carNumchk"></div>
		<br>
		
		<label>회원 타입 </label>
		<br>
		<input type="radio" id="longid" name="type" 
		value="1" onclick="checklongterm();" checked> 정기 회원
		
		<div id="con" style="display:none">
			<input type="radio" name="position" value="1" id="p1" onclick="p11();" checked> 교수
			<input type="radio" name="position" value="2" id="p2" onclick="p22();" checked> 강사, 직원, 조교
			<input type="radio" name="position" value="3" id="p3" onclick="p33();" checked> 박사과정, 연구원
			<input type="radio" name="position" value="4" id="p4" onclick="p44();" checked> 상시근무자, 상시출입업자
		</div>
		
		<div id=pay style="display:none">
			<p>paymnet<p>
		</div>

		
		<input type="radio" id="couponid" name="type" value="2" 
		onclick="checkcoupon();" checked> 쿠폰 이용자 <br>
			
		<br><br>
		
		<p>쿠폰과 정기회원의 기간은 고정으로 가입 날짜 기준 4달입니다. 
		<br>
		만료 후 개인정보는 초기화됩니다.
		<br>
		다시 회원으로 등록해주세요. 
		<p>
		<p>전기차 이용 대상 사전 발급 쿠폰 이용자는 일반 요금에서 50% 할인됩니다.
		<br>
		등록요금 만원 부가됩니다. 
		<p>
		<p>정기회원 이용 요금 안내
		<p>
		<table style="margin-left: auto; margin-right: auto;" border="1">
			<tr>
				<td>직책</td>
				<td>이용 요금</td>
			</tr>

			<tr>
				<td>교수</td>
				<td>4달 만원</td>
			</tr>

			<tr>
				<td>강사, 직원, 조교</td>
				<td>4달 4만원</td>
			</tr>

			<tr>
				<td>박사과정, 연구원</td>
				<td>4달 8만원</td>
			</tr>

			<tr>
				<td>상시근무자, 상시출입업자</td>
				<td>4달 12만원</td>
			</tr>

		</table>
	<br>
		<input type="submit" value="회원등록" onclick="btn()">
	</form>

	<script>
	
		for (var i = 0; i < document.frm1.length; i++) {
			document.frm1.elements[i].checked = false;
		}

		function p11(){
			var p1Code = prompt("직책 별 전용 인증 코드를 입력해주세요.", "")
			if (p1Code == "corrine1") {
				alert("코드 인증 완료");
			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.position.length; i++) {
					document.frm1.position[i].checked = false;
					history.go(0);
				}
			}
		}


		function p22(){
			var p1Code = prompt("직책 별 전용 인증 코드를 입력해주세요.", "")
			if (p1Code == "corrine2") {
				alert("코드 인증 완료");
			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.length; i++) {
					document.frm1.elements[i].checked = false;
					history.go(0);
				}
			}
		}

		function p33(){
			var p1Code = prompt("직책 별 전용 인증 코드를 입력해주세요.", "")
			if (p1Code == "corrine3") {
				alert("코드 인증 완료");
			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.length; i++) {
					document.frm1.elements[i].checked = false;
					history.go(0);
				}
			}
		}

		function p44(){
			var p1Code = prompt("직책 별 전용 인증 코드를 입력해주세요.", "")
			if (p1Code == "corrine4") {
				alert("코드 인증 완료");
			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.length; i++) {
					document.frm1.elements[i].checked = false;
					history.go(0);
				}
			}
		}
		
		

		function checklongterm() {

			var longtermCode = prompt("정기회원 첫 번 째 인증 코드를 입력해주세요.", "")
			if (longtermCode == "jihye1") {
				alert("코드 인증 완료");

			var longid = document.getElementById("longid");

			var p1 = document.getElementById("p1"); 
			 
			var con = document.getElementById("con"); 
			var positions = document.getElementsByName("position");
			var pay = document.getElementById("price"); 
			
			if(longid.value == "1"){
				con.style.display = ""; // 보여줌

			
				
				
			}else{
				con.style.display = "none"; // 숨김
			}
				

			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.position.length; i++) {
					document.frm1.position[i].checked = false;
					
				}
				history.go(0);
			}

		}

		

		function checkcoupon() {

			let longtermCode = prompt("쿠폰 인증 코드를 입력해주세요.", "")
			if (longtermCode == "jihye2") {
				alert("코드 인증 완료");
				con.style.display = "none"; // 숨김
	
				

			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.length; i++) {
					document.frm1.elements[i].checked = false;
				}
				history.go(0);
			}

		}
	</script>
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