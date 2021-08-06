<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!-- 빠른 페이지전환을 위해서 이전페이지를 캐시 저장해두기때문에 디테일 페이지에서 
    아이템을 장바구니에 추가시 뒤로가기를 누르면 장바구니에 아이템이 담겨있지않음. 그것을 방지하기위해서 캐시 삭제를 한다.
    회원가입완료후에도 뒤로가기를하면 데이터가 남아있는데 캐시삭제를 하면 남아있지않는다.
-->
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
       ${seller}
        ${member}
        <input type="text" name="" id="si_grade" value="${seller.si_grade}" disabled hidden>
        <input type="text" name="" id="si_seq" value="${seller.si_seq}" disabled hidden>
        <input type="text" name="" id="seller" value="${seller}" disabled hidden>
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
                    <c:if test="${member==null && seller==null}">
                        <a href="/login">로그인</a>
                        <span>|</span>
                        <a href="/join">회원가입</a>
                        <span>|</span>
                    </c:if>
                    <c:if test="${member!=null || seller !=null}">
                        <a href="/member/myPage/${member.mi_seq}">
                            
                            <span class="user_grade">
                                <c:if test="${member.mi_grade==1}">웰컴</c:if>
                                <c:if test="${member.mi_grade==2}">프렌즈</c:if>
                                <c:if test="${member.mi_grade==3}">화이트</c:if>
                                <c:if test="${member.mi_grade==4}">라벤더</c:if>
                                <c:if test="${member.mi_grade==5}">퍼플</c:if>
                                <c:if test="${member.mi_grade==6}">더퍼플</c:if>
                                <c:if test="${seller.si_grade==0}">사업자 등록이 필요합니다</c:if>
                                <c:if test="${seller.si_grade==1}">${seller.si_name}</c:if>
                                <c:if test="${seller.si_grade==99}">관리자</c:if>
                            </span>                            
                            ${member.mi_name}님</a>
                        <span>|</span>
                        <a href="/member/order">주문정보 보기</a>
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
                <span><img src="" alt=""></span>
                
            </div>
            <div class="hc_bot">
                <div class="main_menu">
                    <a href="#" id="cate_all">전체 카테고리</a>
                    <a href="#" id="shop_all">전체 S H O P</a>
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
                    <c:if test="${seller == null}">
                    <a href="/cart/${member.mi_id}?dqxSrEp=${member.mi_seq}" id="shopping_cart">
                        <img src="/assets/images/ico_cart.svg" alt="">
                        <c:if test="${cart_cnt != null && cart_cnt !=0}">
                            <span class="cart_badge">${cart_cnt}</span>
                        </c:if>                        
                    </a>
                     </c:if>
                     <c:if test="${seller != null && seller.si_grade==1 }">
                    <a href="/seller/home/${seller.si_seq}" id="seller_home" class="seller_home_icon">
                        <img src="/assets/images/free-icon-house-5103132.png" alt="" style="width:35.99px;height:35.99px">                                           
                    </a>
                     </c:if>
                     <c:if test="${seller != null && seller.si_grade==99}">
                    <a href="/admin" id="seller_home" class="seller_home_icon">
                        <img src="/assets/images/admin (1).png" alt="" style="width:35.99px;height:35.99px">                                           
                    </a>
                     </c:if>
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