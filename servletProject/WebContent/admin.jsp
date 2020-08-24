<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>관리자 페이지입니다.</h1>
	<!-- 입력정보: name, 차번호, type -->

	<form method="post" action="admincheck">
	 	
		<label>ID: </label> 
		<input type="text" name="id"> <br> 
		<label>PW: </label> 
		<input type="text" name="pw"> <br> 
	
		<input type="submit" value="로그인" onclick="btn()">
	</form>

</body>
</html>