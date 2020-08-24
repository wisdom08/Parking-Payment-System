<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 등록</h1>
	<form name="frm1" method="post" action="joinmember">

		<label>이름: </label> 
		<input type="text" id="name" name="name">
		<br>
		<div id="namechk"></div>
		<label>차번호: </label> 
		<input type="text" id="carNum" name="carNum"> <br>
		<div id="carNumchk"></div>
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

		<br>
		<input type="radio" id="couponid" name="type" value="2" 
		onclick="checkcoupon();" checked> 쿠폰 이용자 <br>
			
			
		<p>쿠폰과 장기회원의 기간은 고정으로 가입 날짜 기준 4달입니다. 
		<br>
		만료 후 개인정보는 초기화됩니다.
		<br>
		다시 회원으로 등록해주세요. 
		<p>
		<p>전기차 이용 대상 사전 발급 쿠폰 이용자는 일반 요금에서 50% 할인됩니다.등록요금 만원 부가됩니다. 
		<p>
		<p>정기회원 이용 요금 안내
		<p>
		<table border="1">
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

		<input type="submit" value="회원등록" onclick="btn()">
	</form>

	<script>
	
		for (var i = 0; i < document.frm1.length; i++) {
			document.frm1.elements[i].checked = false;
		}

		function p11(){
			var p1Code = prompt("직책 별 전용 인증 코드를 입력해주세요.", "")
			if (p1Code == "1") {
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
			if (p1Code == "2") {
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
			if (p1Code == "3") {
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
			if (p1Code == "4") {
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
			if (longtermCode == "1") {
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
			if (longtermCode == "2") {
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

</body>
</html>