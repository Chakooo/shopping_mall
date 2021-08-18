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
                <script src="/assets/js/myPage.js"></script>
                <title>Document</title>
            </head>

            <body>
                ${member}
                ${r_list}
                ${order_list}
                <div class="container">
                    <div class="left_menu">
                        <a href="#" id="main_logo">나의 EE</a>
                        <ul class="menu">
                            <li>
                                <a href="/member/myPage/${member.mi_seq}" id="my_order"><span>내 주문정보</span></a>
                            </li>
                            <li>
                                <a href="/member/modify" id="modify"><span>개인 정보 수정</span></a>
                            </li>
                            <li>
                                <a href="/member/review_answer/${member.mi_seq}" id="review_answer"><span>나의 리뷰
                                        확인</span></a>
                            </li>
                        </ul>
                    </div>
                    <div class="dashboard_area">
                        <h1>내 주문 정보</h1>
                        <div class="order_list">

                            <c:if test="${item != ' '}">
                                <c:forEach items="${order_list}" var="item">
                                    <div class="order_item">
                                        <div class="order_info">
                                            <p class="order_date">
                                                <fmt:formatDate value="${item.oi_reg_dt}" pattern="yyyy년 MM월 dd일 (EE)">
                                                </fmt:formatDate>
                                                <!-- 날짜 형식 바꾸는 JSTL  라이브러리  -->
                                                <span class="order_status">
                                                    <c:if test="${item.oi_delivery_status == 0}">배송준비중</c:if>
                                                    <c:if test="${item.oi_delivery_status == 1}">배송중</c:if>
                                                    <c:if test="${item.oi_delivery_status == 2}">배송완료</c:if>
                                                </span>
                                            </p>
                                            <div class="item_info">
                                                <img src="/image/${item.pi_img_uri}" alt="">
                                                <div class="item_detail">
                                                    <p>${item.pi_name}</p>
                                                    <p>${item.final_price}원 <span>${item.oi_prod_count}개</span></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="order_buttons">
                                            <a href="#" id="delivery_detail">배송 조회</a>
                                            <a href="#" id="delivery_return">교환,반품신청</a>

                                            <c:if
                                                test="${item.oi_delivery_status == 2 && item.review_written == false}">
                                                <a href="/review?mi_seq=${member.mi_seq}&pi_seq=${item.pi_seq}&oi_seq=${item.oi_seq}"
                                                    id="review">리뷰 작성하기</a>
                                            </c:if>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <c:if test="${order_list.size()==0}">
                                <p class="nodata">구매한 상품이 없습니다.</p>
                            </c:if>
                        </div>
                    </div>
                </div>
            </body>
            <%@include file="/WEB-INF/views/includes/footer.jsp" %>

            </html>