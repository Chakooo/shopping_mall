<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="image/x-icon" href="/assets/images/shopping-cart.png">
    <link rel="stylesheet" href="/assets/css/index.css">
    <title>Everyday EveryTime 쇼핑 1번지</title>
</head>
<body>
   
    <main>
        <section class="main_banner_area"> 
            <div class="banner_item">
        <!-- 메인 배너 사진 나오는 부분 -->
            </div>
        </section>
        <section class="recommand_prod_area">
            <div class="recommand_place">
            <h1>오늘의 발견 | <span>오늘 E E 마켓이 엄선한 가장 HOT 한 상품 !</span> </h1>
            </div>    
            <div class="recommand_wrap">
                <c:forEach items="${reco_list}" var="item">                
                <a href="/detail?prod_seq=${item.pi_seq}" class="recommand_item prod_item"> <!-- 클래스 두개 적용 -->                   
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
        </section>

        <section class="recommand_seller">
            <div class="seller_place">
            <h1>E E 마켓 추천 > | <span>오늘의 상점</span> </h1>
            </div>    
            <div class="seller_wrap">
                <c:forEach items="${seller_list}" var="item">                
                <a href="/detail?prod_seq=${item.pi_seq}" class="recommand_item seller_home"> <!-- 클래스 두개 적용 -->                   
                    <div class="img_area">
                        <img src="/image/${item.pi_img_uri}" alt="">
                    </div>
                    <div class="text_area">
                        <h2>[${item.seller_name}]</h2> 
                        <p>${item.pi_name}</p>
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
        </section>
      
    </main>
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>    
</body>
</html>

