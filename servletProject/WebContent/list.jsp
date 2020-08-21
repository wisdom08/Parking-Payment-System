<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>개인 별 조회</h1>
	
	<form method="get" action="inquire">
	
		<label>차번호: </label> 
		<input type="text" name="carNum"> <br> 
	
		<input type="submit" value="조회" onclick="btn()">
	</form>

</body>
</html>