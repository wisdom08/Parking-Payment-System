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
	<%= request.getAttribute("carNum") %> 님
	
	가격은
	<%=request.getAttribute("price")%>
	원 입니다.


	<form method="post" action="checkPrice">
		<label>계산 금액을 정확하게 입력해주세요. </label> <input type="text" name="uprice"
			id="uprice"> <br> <label>결제방법을 적어주세요.1은 카드 2는 현금</label> <input
			type="text" name="method"> <br> <input type="submit" value="결제"
			>


		<%
			String price = request.getParameter("price");
		%>

	</form>

	<script>
		let uprice = document.getElementById("uprice");
	<%=price%>

	
		
		/* function btn() {

			var condition = true;
			if (condition) {
		/* 	alert("price::::" + price);
			alert("uprice::::" + uprice); */
				alert("결제 완료");
			}
		} */
	</script>


</body>
</html>