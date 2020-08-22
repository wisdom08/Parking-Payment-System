<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>입차</h1>
	<!-- 입력정보: name, 차번호, type -->

	<form method="post" action="park">
	 	
		<label>차 번호: </label> 
		<input type="text" name="carNum"> <br> 
	
		<input type="submit" value="입차" onclick="btn()">
	</form>

	<script>
		function btn() {

			/* condition 추가하기 */
			
			var condition = true;
			if (condition) {
				alert("입차 완료");
			//	location.href = "index.jsp";
			}
		}
	</script>

</body>
</html>