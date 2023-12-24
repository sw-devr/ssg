<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>장바구니 화면입니다.</h1>
<!-- <@include>는 실행전에 정적으로 포함시킴 .jsp파일은 2개 .java 파일은  1개 -->
<!-- <..jsp:include>는 jsp파일 실행하고 동적으로 포함시킴. jsp파일은 2개. java 파일은 2개  --> 
<!--  flush="true"로 설정한 경우 버퍼가 다 차지 않아도 전송함. 화면깨짐 방지 -->
<jsp:include page="commons/top.jsp" flush="true" /> <br>
<jsp:include page="commons/menu.jsp" flush="true" /> <br><hr>
<jsp:include page="goods/cartList.jsp" flush="true"/><br>

</body>
</html>