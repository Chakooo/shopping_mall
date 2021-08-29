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
                    <link rel="stylesheet" href="/assets/css/myPage.css">
                    <script src="/assets/js/myPage.js"></script>
                    <title>Document</title>
                </head>

                <body>
               
                    <div class="container">
                        <%@include file="/WEB-INF/views/member/left_menu.jsp" %>
                            <div class="dashboard_area">
                                <h1>내 주문 정보</h1>
                                <div class="order_list">

                                    <c:forEach items="${order_list}" var="item">
                                        <c:if test="${item != ' '}">
                                            <div class="order_item">
                                                <div class="order_info">
                                                    <p class="order_date">
                                                        <fmt:formatDate value="${item.oi_reg_dt}"pattern="yyyy일 MM월 dd일"></fmt:formatDate>

                                                        <!-- 날짜 형식 바꾸는 JSTL  라이브러리  -->
                                                        <!-- <span class="order_status">
                                                            <c:if test="${item.oi_delivery_status == 0}">배송준비중</c:if>
                                                            <c:if test="${item.oi_delivery_status == 1}">배송중</c:if>
                                                            <c:if test="${item.oi_delivery_status == 2}">배송완료</c:if>
                                                        </span> -->
                                                    </p>
                                                    <div class="item_info">
                                                        <img src="/image/${item.pi_img_uri}" alt="">
                                                        <div class="item_detail">
                                                            <c:if test="${item.orderCnt != 0}">
                                                                <p>[${item.si_name}]${item.pi_name} <span
                                                                        id="order_cnt">외${item.orderCnt}건</span></p>
                                                            </c:if>
                                                            <c:if test="${item.orderCnt == 0}">
                                                                <p>[${item.si_name}]${item.pi_name}</p>
                                                            </c:if>
                                                            <p>${item.final_price}원 <span>${item.oi_prod_count}개</span>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="order_buttons">
                                                 
                                                    <span><a
                                                            href="/memberOrder_detail/${member.mi_seq}/${item.oi_reg_dt}">주문
                                                            내역 상세 조회</a></span>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${order_list.size()==0}">
                                        <p class="nodata">구매한 상품이 없습니다.</p>
                                    </c:if>
                                </div>
                            </div>
                    </div>
                </body>
                <%@include file="/WEB-INF/views/includes/footer.jsp" %>

                </html>