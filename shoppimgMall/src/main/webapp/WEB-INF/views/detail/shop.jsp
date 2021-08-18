<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/header.jsp" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="/assets/css/shop.css">
                <script src="/assets/js/shop.js"></script>
                <title>Document</title>
            </head>

            <body>
                <input type="text" name="" id="seller_seq" value="${seller_seq}" disabled hidden>
                <input type="text" name="" id="mi_seq" value="${member.mi_seq}" disabled hidden>

                <section class="recommand_prod_area">
                    <div class="recommand_place">

                        <h1>${seller_name}</h1>

                    </div>
                    <c:if test="${reco_list.size()!=0}">
                        <div class="sell_top4">
                            <h2>판매 BEST ITEM 4</h2>
                            <div class="insert_regular"><button id="insert_btn"><img src="/assets/images/free-icon-houses-3325784.png"
                                        alt=""></button>
                            </div>
                            <div class=regular_wrap>

                                <div class="div_regular"><img src="/assets/images/free-icon-house-2873188.png" alt="">
                                    우리가게단골
                                    (${r_count}명)</div>
                            </div>
                            <div class="recommand_wrap">
                                <c:forEach items="${reco_list}" var="item">
                                    <a href="/detail?prod_seq=${item.pi_seq}" class="recommand_item prod_item">
                                        <!-- 클래스 두개 적용 -->
                                        <div class="img_area">
                                            <img src="/image/${item.pi_img_uri}" alt="">
                                        </div>

                                        <div class="text_area">
                                            <h2>[${item.seller_name}] ${item.pi_name}</h2>
                                            <p class="price">
                                                <c:if test="${item.pi_discount_rate!=0}">
                                                    <span class="discount_rate">${item.pi_discount_rate}%</span>
                                                </c:if>
                                                <span>
                                                    ${item.discounted_price}원
                                                    <!-- 원가에서 할인된 가격을 보여준다.  -->
                                                </span>
                                            </p>
                                            <c:if test="${item.pi_discount_rate!=0}">
                                                <p class="origin_price">${item.origin_price}원</p>
                                            </c:if>
                                        </div>
                                    </a>
                                </c:forEach>
                            </div>
                    </c:if>
                </section>


                <c:if test="${list.size()==0}">
                    <p class="nodata">등록된 제품이 없습니다.</p>
                </c:if>
                <c:if test="${list != ''}">
                    <div class="item_list">
                        <c:forEach items="${list}" var="item">
                            <a href="/detail?prod_seq=${item.pi_seq}">
                                <span class="img_box">
                                    <img src="/image/${item.pi_img_uri}" alt="">
                                </span>

                                <span class="name">[${item.seller_name}] ${item.pi_name}</span>
                                <span class="price">
                                    <c:if test="${item.pi_discount_rate!=0}">
                                        <span class="discount_rate">${item.pi_discount_rate}%</span>
                                    </c:if>
                                    <span class="discounted_price">${item.discounted_price}원</span>
                                </span>
                                <c:if test="${item.pi_discount_rate!=0}">
                                    <span class="origin_price">${item.origin_price}원</span>
                                </c:if>
                            </a>
                        </c:forEach>
                    </div>
                </c:if>

            </body>
            <%@include file="/WEB-INF/views/includes/footer.jsp" %>

            </html>