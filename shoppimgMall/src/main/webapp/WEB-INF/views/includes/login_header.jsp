<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="/assets/css/login.css">
        <link rel="stylesheet" href="/assets/css/reset.css">
        <link rel="shortcut icon" type="image/x-icon" href="/assets/images/free-icon-shopping-cart-1136140.png">
        <title>Document</title>
    </head>

    <body>
        ${seller} ${member}
        <div id="header">
            <div id="layout_header">
                <div class="box_header">
                    <h1 class="box_title_logo"><a href="/"><span><img src="/assets/images/logo8.png" alt=""></span></a>
                    </h1>
                    <div class="search_box">
                        <input type="text" name="" id="keyword" placeholder="통합 검색">
                        <button id="search_btn">
                            <img src="/assets/images/ico_search_x2.png" alt="">
                        </button>
                    </div>

                    <div class="category">
                        <div clas="category_a">
                            <a href="/login">카테고리</a>
                            <span>|</span>
                            <a href="/join">서비스</a>
                            <span>|</span>
                            <a href="/join">나의 쇼핑정보</a>
                            <span>|</span>
                            <a href="/join">최근본상품</a>
                            <span>|</span>
                            <a href="/join">장바구니</a>
                            <span>|</span>
                            <a href="/join">고객센터</a>
                            <span>|</span>
                            
                            <c:if test="${member != null || seller != null || seller.si_grade==2}">
                                <a href="/member/logout">로그아웃</a>
                                <span>|</span>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>