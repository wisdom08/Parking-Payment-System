<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>계산 화면</h1>
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
	<%=request.getAttribute("carNum")%>
	님 가격은
	<%=request.getAttribute("price")%>
	원 입니다.


	<form method="post" action="checkprice">
		<label>계산 금액을 정확하게 입력해주세요. </label> <input type="text" name="uprice"
			id="uprice"> <br> <label>결제방법을 선택해주세요.</label>
		<input type="text" name="method"> <br> 
<!-- 		<input type="radio" name="method" value="카드">
		<input type="radio" name="method" value="현금"> -->
		
		영수증 발급 여부
		<input type="radio" name="receipt" value="YES">
		<input type="radio" name="receipt" value="NO">
		<input type="submit" value="결제">


		<%
			String price = request.getParameter("price");
		%>

	</form>


</body>
</html>