<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/header.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="/assets/images/free-icon-shopping-cart-1136140.png">
    <title>Everyday EveryTime 쇼핑 1번지</title>
</head>
<body>
    <header>
        <div class="header_top">
            
            <div class="container">
                <p>지금 가입하고 인기상품 <b>100원</b>에 받아가세요.</p>
                <a href="#">
                    <img src="/assets/images/ico_close_fff_42x42.png">
                </a>
            </div>
        </div>
        <div class="header_content">
            <div class="hc_top">
                <a href="#" id="delivery">
                   <span>실시간 순위구현</span>
                </a>
                <div class="user_menu">
                    <c:if test="${member==null}">
                        <a href="/login">로그인</a>
                        <span>|</span>
                        <a href="/join">회원가입</a>
                        <span>|</span>
                    </c:if>
                    <c:if test="${member!=null}">
                        <a href="/member/order">
                            <span class="user_grade">
                                <c:if test="${member.mi_grade==1}">웰컴</c:if>
                                <c:if test="${member.mi_grade==2}">프렌즈</c:if>
                                <c:if test="${member.mi_grade==3}">화이트</c:if>
                                <c:if test="${member.mi_grade==4}">라벤더</c:if>
                                <c:if test="${member.mi_grade==5}">퍼플</c:if>
                                <c:if test="${member.mi_grade==6}">더퍼플</c:if>
                                <c:if test="${member.mi_grade==99}">관리자</c:if>
                            </span>                            
                            ${member.mi_name}님</a>
                        <span>|</span>
                        <!-- <a href="/member/logout">로그아웃</a> -->
                        <a href="#" id="logout">로그아웃</a>
                        <span>|</span>
                    </c:if>
                    <a href="#">고객센터 <img src="/assets/images/ico_down_8x5.png" alt=""></a>
                    <span>|</span>
                </div>
            </div>
            <div class="hc_mid">
                <a href="/" id="logo">
                    <img src="/assets/images/logo2.png" alt="">
                </a>
                
            </div>
            <div class="hc_bot">
                <div class="main_menu">
                    <a href="#" id="cate_all">전체 카테고리</a>
                    <a href="#">신상품</a>
                    <a href="#">베스트</a>
                    <a href="#">알뜰쇼핑</a>
                    <a href="#">특가/혜택</a>
                </div>
                <div class="search_area">
                    <div class="search_box">
                        <input type="text" name="" id="keyword">
                        <button id="search_btn">
                            <img src="/assets/images/ico_search_x2.png" alt="">
                        </button>
                    </div>
                    <a href="#">
                        <img src="/assets/images/ico_delivery_setting.svg" alt="">
                    </a>
                    <!-- ${member} -->
                    <a href="/cart/${member.mi_id}?dqxSrEp=${member.mi_seq}" id="shopping_cart">
                        <img src="/assets/images/ico_cart.svg" alt="">
                        <c:if test="${cart_cnt != null && cart_cnt !=0}">
                            <span class="cart_badge">${cart_cnt}</span>
                        </c:if>
                        
                    </a>
                </div>
            </div>

            <div class="categories">
                <div class="cate_list">
                    <c:forEach items="${catelist}" var="cate">
                        <a href="/products?cate_seq=${cate.cate_seq}">${cate.cate_name}</a>
                    </c:forEach>
                </div>
            </div>
        </div>


    </header>    
</body>
</html>