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
	<%=request.getAttribute("carNum")%> 차주
	<%=request.getAttribute("name")%>
	님

	<!--  시간 추가 해야한다.  -->

	<%-- <%  String price = (String) request.getAttribute("price"); 
		String mType = (String) request.getAttribute("mType"); 
	if(mType.equals("1")) {%>
 
	가격은 0 원입니다. 
	
 <%} else if(mType.equals("2")){%>
 	가격은  price/2 입니다. 
 <%} %> --%>

<% String position = (String)request.getAttribute("position"); 
	String name = (String)request.getAttribute("name");
	String carNum = (String)request.getAttribute("carNum");
	
	long price = 0; 
	if(position.equals("1")){  price = 10000; %>
	이용요금은 10,000 원입니다. 
	<%} else if(position.equals("2")){ price = 40000; %>
	이용요금은 40,000 원입니다. 
		<%} else if(position.equals("3")){ price = 80000; %>
	이용요금은 80,000 원입니다. 
		<%} else if(position.equals("4")){ price = 120000; %>
	이용요금은 120,000 원입니다. 
		<%} else {  price = 10000; %>
	이용요금은 10,000 원입니다. 
	<%} %>

	<form method="post" action="mcheckprice">
		<label>계산 금액을 정확하게 입력해주세요. </label> 
		<input type="text" name="uprice" id="uprice"> <br> 
		<label>결제방법을 적어주세요.</label> 
		<input type="radio" name="method" value="1"> 카드
		<input type="radio" name="method" value="2"> 현금
		<!-- <input type="text" name="method" id="method"> --> 
		<br>
		<div id="methodchk"></div>
		영수증 발급 여부
		<input type="radio" name="receipt"> YES
		<input type="radio" name="receipt"> NO
		<br>
		<input type="hidden" name="carNum" value=<%=request.getAttribute("carNum")%>> 
		<input type="hidden" name="name" value= <%=request.getAttribute("name")%>> 
		<input type="hidden" name="type" value=<%=request.getAttribute("type")%>> 
		<input type="hidden" name="price" id="price" value= <%=request.getAttribute("price")%>> 
		<input type="submit" value="결제" onclick="btn()">

	</form>

	<!-- <script>
		/* 	var chk = document.getElementById("methodchk")
		 var method = document.getElementById("method"); 

		 var method = document.getElementById("method");
		 method.addEventListener("blur", function( event ) {

		 if(method !== "1" || method !== "2"){
		 event.target.style.background = "pink";    
		 chk.innerHTML = "(1 또는 2를 입력해주세요)";
		 }
		
		 }, true);
		 */

		function btn() {

			var uprice = document.getElementById("uprice");
			var price = document.getElementById("price");

			var pricev = price.value; 
			var upricev = uprice.value; 
			
		
			if (pricev == upricev) {
				alert("결제 완료");

			} else {
				alert("금액이 일치하지 않습니다.");
			}
		}
	</script>

 -->
</body>
</html>