<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/assets/js/login.js"></script>
    <script>
        <c:if test="${member != null}">
        location.href="/";
        </c:if>
        // 로그인이 된 상태에서 join / login 으로 직접 url을 입력했을떄
        // 강제로 메인으로 이동할수있도록 스크립트 처리
      </script>    
    <title>Document</title>
</head>
<body>
<h1>로그인</h1>
<div class="login_form">
    <input type="text" name="" id="user_id" placeholder="아이디">
    <input type="password" name="" id="user_pwd" placeholder="비밀번호">
    <button id="login_btn">로그인</button>
    <a href="/join"></a>
</div>
</body>
</html>