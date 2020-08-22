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

		<label>이름: </label> <input type="text" id="name" name="name">
		<br>
		<div id="namechk"></div>
		<label>차번호: </label> <input type="text" id="carNum" name="carNum"> <br>
		<div id="carNumchk"></div>
		<label>회원 타입 </label> <input type="radio" id="longid" name="type"
			value="1" onclick="checklongterm();" checked> 정기 회원 <input
			type="radio" id="couponid" name="type" value="2"
			onclick="checkcoupon();" checked> 쿠폰 이용자 <br>
		<p>쿠폰과 장기회원의 기간은 고정으로 가입 날짜 기준 4달입니다.
		<p>
		<p>전기차 이용 대상 사전 발급 쿠폰 이용자는 일반 요금에서 50% 할인됩니다
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
				<td>면제</td>
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
				<td>4달 10만원</td>
			</tr>

		</table>

		<input type="submit" value="회원등록" onclick="btn()">
	</form>

	<script>
		for (var i = 0; i < document.frm1.length; i++) {
			document.frm1.elements[i].checked = false;
		}

		/* var namechk = document.getElementById("name"); 
		var name = namechk.value; 
		var carNumchk = document.getElementById("carNum"); 
		var carNum = carNumchk.value; 
		var longid = document.getElementById("longid"); 
		var couponid = document.getElementById("couponid"); 
		

		function btn() {

			if(!name){
				alert("hahah");
			} else if(!carNum){
				alert("차 번호를 입력해주세요."); 
			} else if(!longid && !couponid){
				alert("회원 타입을 선택해주세요."); 
			} else {
				
			}

			

		} */

		function checklongterm() {

			let longtermCode = prompt("정기회원 인증 코드를 입력해주세요.", "")
			if (longtermCode == "ThisIsSecretCode0808") {
				alert("코드 인증 완료");
				alert("★인증 코드는 절대비밀입니다!!");

			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.length; i++) {
					document.frm1.elements[i].checked = false;
				}
			}

		}

		function checkcoupon() {

			let longtermCode = prompt("쿠폰 인증 코드를 입력해주세요.", "")
			if (longtermCode == "ThisIsSecretCode1111") {
				alert("코드 인증 완료");
				alert("★인증 코드는 절대비밀입니다!!");

			} else {
				alert("코드 인증 실패");
				for (var i = 0; i < document.frm1.length; i++) {
					document.frm1.elements[i].checked = false;
				}
			}

		}
	</script>

</body>
</html>