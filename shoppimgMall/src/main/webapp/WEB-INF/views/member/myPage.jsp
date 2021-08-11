<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/myPage.css">
    <title>Document</title>
</head>
<body>
    <div class="modify_wrap">        
        <ul class="ul_wrap">
            <li>
                <a href="#">전체 주문내역</a>
            </li>
            <li>
                <a href="#">나의 단골가게</a>
            </li>
            <li>
                <a href="#">내가 쓴 리뷰</a>
            </li>
            <li>
                <a href="#">내 정보 수정</a>
            </li>
        </ul>
        <div class="content_wrap">
            내용
        </div>
    </div>
</body>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>    
</html>