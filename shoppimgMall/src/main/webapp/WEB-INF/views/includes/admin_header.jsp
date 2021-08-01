<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>쇼핑몰</title>
            <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
            <link rel="stylesheet" href="/assets/css/reset.css">
            <link rel="stylesheet" href="/assets/css/admin_css/admin_header.css">
            <link rel="shortcut icon" type="image/x-icon" href="/assets/images/free-icon-shopping-cart-1136140.png">
            <script>
                $(function(){
                $("#logout").click(function () {
                    if (confirm("로그아웃 하시겠습니까?")) {
                        location.href = "/member/logout";
                    }
                })
            })
            </script>
        </head>

        <body>

            <input type="text" name="" id="si_seq" value="${seller.si_seq}" disabled hidden>
            <input type="text" name="" id="si_grade" value="${seller.si_grade}" disabled hidden>
            <header>
                <a href="/admin" id="logo">
                    <img src="/assets/images/admin.png" alt="">
                    <span>${seller.si_name}님 !! <p>어서오세요</p></span>

                </a>
                <nav id="gnb">
                    <ul>
                        <li>
                            <a href="/category/add" id="category">카테고리 관리</a>
                        </li>
                        <li>
                            <a href="/admin/regist/check" id="seller">업체 관리</a>
                        </li>
                        <li>
                            <a href="/delivery/add" id="delivery">배송업체 관리</a>
                        </li>
                        <li>
                            <a href="/product/admin" id="product">상품 관리</a>
                        </li>
                        <li>
                            <a href="/member/list" id="member">회원 관리</a>
                        </li>
                        <li>
                            <a href="/recommand" id="recommand">추천 상품 관리</a>
                        </li>

                        <li>
                            <a href="/" id="home">EE Market 으로 돌아가기</a>
                        </li>

                        <c:if test="${seller!=null}">
                            <button id="logout">로그아웃</button></a>
                        </c:if>
                    </ul>
                </nav>
            </header>

        </body>

        </html>