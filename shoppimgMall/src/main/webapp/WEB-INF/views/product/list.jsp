<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/header.jsp" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="/assets/css/product_list.css">
                <title>Document</title>
            </head>
            <body>

                <h1> 아이템 검색 + 가격별 이름별 오름내림차순 구현</h1>
                <h1>${category}</h1>
                <c:if test="${list.size()==0}">
                    <p class="nodata">등록된 제품이 없습니다.</p>
                </c:if>
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
                <%@include file="/WEB-INF/views/includes/footer.jsp" %>
            </body>
           
            </html>