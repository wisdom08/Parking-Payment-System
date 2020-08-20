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
	<form method="post" action="joinmember">

		<label>이름: </label> <input type="text" name="name"> <br>
		<label>차번호: </label> <input type="text" name="carNum"> <br>
		<label>회원 타입(1. 정기 회원 / 2. 쿠폰 이용자): </label> <input type="number" name="type"> <br>
		
		<input type="submit" value="회원등록" onclick="btn()">
	</form>

	<script>
		function btn() {

			/* condition 추가하기 */

			var condition = true;
			if (condition) {
				alert("회원 등록 완료");
				//	location.href = "index.jsp";
			}
		}
	</script>

</body>
</html>