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
            <link rel="stylesheet" href="/assets/css/admin_css/admin_header.css">
            <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="/assets/js/admin_js/header.js"></script>

        </head>

        <body>
            
            <header>
                <a href="/seller/home/{seller_id}" id="logo">
                    <img src="/assets/images/logo46.png" alt="">
                    <span>${seller.si_name}님 <p>어서오세요</p></span>

                </a>
                <nav id="gnb">
                    
                    <ul>
                        <li>
                            <a href="/seller/product" id="category">상품 관리</a>
                        </li>
                        <li>
                            <a href="/seller/regular/${seller.si_seq}" id="regular">단골 손님</a>
                        </li>
                        <li>
                            <a href="#" id="">상품 판매 현황</a>
                        </li>
                        <li>
                            <a href="#" id="recommand">추천 상품 관리</a>
                        </li>
                        <li>
                            <a href="/order/${seller.si_seq}">배송 현황 관리</a>
                        </li>
                        <li>
                            <a href="/" id="home">EE Market 으로 돌아가기</a>
                        </li>
                        <c:if test="${seller ==null}">                            
                             <button id="login">로그인</button>                               
                        </c:if>
                        <c:if test="${seller!=null}">                         
                             <button id="logout">로그아웃</button></a>                           
                        </c:if>
                    </ul>
                </nav>
            </header>

        </body>

        </html>