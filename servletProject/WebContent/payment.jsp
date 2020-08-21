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
 
 <!--  시간 추가 해야한다.  -->

	<%-- <%  String price = (String) request.getAttribute("price"); 
		String mType = (String) request.getAttribute("mType"); 
	if(mType.equals("1")) {%>
 
	가격은 0 원입니다. 
	
 <%} else if(mType.equals("2")){%>
 	가격은  price/2 입니다. 
 <%} %> --%>
 
 
	가격은
	<%=request.getAttribute("price")%>
	원 입니다.

	<form method="post" action="checkPrice">
		<label>계산 금액을 정확하게 입력해주세요. </label> <input type="text" name="uprice"
			id="uprice"> <br> <label>결제방법을 적어주세요.(1은 카드 2는 현금)</label> <input
			type="text" name="type"> <br> <input type="submit" value="결제" onclick="btn()">


	<%-- 	<%
			String price = request.getParameter("price");
		%> --%>

	</form>

	<script>
	
		function btn() {

				

			
			

	/* 		let uprice = document.getElementyById("uprice"); */
		<%-- 	let price = '<%= price %>';  --%>
/* 
				alert("price::::" + price);
				alert("uprice::::" + uprice);
		 */
			
			var condition = true;
			if (condition) {
				alert("결제 완료");
			}
		}
		let uprice = document.getElementById("uprice");
<%-- 	<%=price%> --%>
	</script>


</body>
</html>