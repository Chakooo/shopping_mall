<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쇼핑몰</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/admin_header.css">
</head>
<body>
    <header>        
        <a href="/seller/home/{seller_id}" id="logo">
        <img src="/assets/images/logo46.png" alt="">
        <span>${seller.si_name}님 어서오세요</span>
     
        </a>
        <nav id="gnb">
            <ul>
                <li>
                    <a href="/seller/product" id="category">상품 관리</a>                
                </li>
                <li>
                    <a href="#" id="shop">단골 손님</a>                
                </li>
                <li>
                    <a href="#" id="delivery">상품 판매 현황</a>                
                </li>            
                <li>
                    <a href="#" id="recommand">추천 상품 관리</a>                
                </li>
                <li>
                    <a href="/" id="home">EE Market 으로 돌아가기</a>                
                </li>
            </ul>
        </nav>
    </header>
    
</body>
</html>