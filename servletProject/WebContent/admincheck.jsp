<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 
String result = (String)request.getAttribute("result"); 
%>

<% if(result.equals("good")){%>


관리자님 환영합니다.

    <form method = "post" action = "/memberforadmin">
        <input type="submit" value="멤버 조회">
    </form>
    
      <form method = "post" action = "/paymentforadmin">
        <input type="submit" value="결제 조회">
    </form>
    
          <form method = "post" action = "/logforadmin">
        <input type="submit" value="입차 차량 조회">
    </form>

<%} else  {%>

<script>
alert("관리자만 접근 가능합니다.");
location.href='/';
</script>


<%} %>

</body>
</html>