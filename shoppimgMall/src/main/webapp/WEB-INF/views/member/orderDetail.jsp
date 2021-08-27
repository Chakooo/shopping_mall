<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@include file="/WEB-INF/views/includes/header.jsp" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link rel="stylesheet" href="/assets/css/orderDetail.css">
                    <script src="/assets/js/orderDetail.js"></script>
                    <title>Document</title>
                </head>

                <body>
                    ${member}
                    ${order_list}
                    <div class="container">
                        <%@include file="/WEB-INF/views/member/left_menu.jsp" %>
                            <div class="dashboard_area">
                                <h1>
                                    <fmt:formatDate value="${order_list[0].oi_reg_dt}" pattern="yyyy일 MM월 dd일"></fmt:formatDate> 주문 내역
                                </h1>



                                <div class="order_list">
                                    <c:forEach items="${order_list}" var="item">
                                        <c:if test="${item != ' '}">
                                            <div class="order_item">
                                                <div class="order_info">
                                                    <p class="order_date">


                                                        <span class="order_status">
                                                            <c:if test="${item.oi_delivery_status == 0}">배송준비중</c:if>
                                                            <c:if test="${item.oi_delivery_status == 1}">배송중</c:if>
                                                            <c:if test="${item.oi_delivery_status == 2}">배송완료</c:if>
                                                        </span>
                                                    </p>
                                                    <div class="item_info">
                                                        <img src="/image/${item.pi_img_uri}" alt="">
                                                        <div class="item_detail">
                                                            <c:if test="${item.orderCnt != 0}">
                                                                <p>[${item.si_name}]${item.pi_name}</p>
                                                            </c:if>
                                                            <c:if test="${item.orderCnt == 0}">
                                                                <p>[${item.si_name}]${item.pi_name}</p>
                                                            </c:if>
                                                            <p>${item.final_price}원 <span>${item.oi_prod_count}개</span>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="check_buttons">
                                                    <a href="#" id="delivery_detail">배송 조회</a>
                                                    <a href="#" id="delivery_return">교환,반품신청</a>

                                                    <c:if
                                                        test="${item.oi_delivery_status == 2 && item.review_written == false}">
                                                        <a href="/review?mi_seq=${member.mi_seq}&pi_seq=${item.pi_seq}&oi_seq=${item.oi_seq}"
                                                            id="review">리뷰 작성하기</a>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>






                                <div class="pay_info_wrap">
                                    <h2>결제 정보</h2>
                                    <p class=pay_info><span>상품 금액</span><span><fmt:formatNumber value="${sum_originPrice}" pattern="#,###"/>원</span></p>
                                    <p class=pay_info><span>배송비</span><span>2,500원</span></p>
                                    <p class=pay_info><span>상품할인금액</span><span><fmt:formatNumber value="${sum_discountPrice}" pattern="#,###"/>원</span></p>
                                    <p class=pay_info><span>결제 금액</span><span class="final_price"><fmt:formatNumber value="${sum_finalPrice}" pattern="#,###"/>원</span></p>
                                    <p class=pay_info><span>결제 방법</span><span>카카오 페이</span></p>
                                    <h2>주문자 정보</h2>
                                    <p class=pay_info><span>주문자 명</span><span>${member.mi_name}</span></p>
                                    <p class=pay_info><span>결제일시</span><span><fmt:formatDate value="${order_list[0].oi_reg_dt}" pattern="yyyy일 MM월 dd일 hh시 mm분 "></fmt:formatDate></span></p>
                                    <h2>배송 정보</h2>
                                    <p class=pay_info><span>받는분</span><span>${member.mi_name}</span></p>
                                    <p class=pay_info><span>핸드폰</span><span>${member.mi_phone}</span></p>
                                    <p class=pay_info><span>주소</span><span>${member.mi_address}</span></p>
                                </div>
                            </div>

                    </div>
                </body>
                <%@include file="/WEB-INF/views/includes/footer.jsp" %>

                </html>