<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>    
    <link rel="stylesheet" href="/assets/css/detail.css">
    <script>
        // console.log("${member}");
        let memberInfo ={
            seq:"${member.mi_seq}",
            id:"${member.mi_id}",
            name:"${member.mi_name}",            
        }
         console.log(memberInfo)
    </script>
    <script src="/assets/js/detail.js"></script>
    <title>Document</title>
</head>
<body>
    <!-- ${member}  멤버가 로그인이 되었을때 session이 유지되면서 member를 resultmap에서 가져와서 화면에 확인한다.-->
    <div class="detail_container" data-prod-seq="${product.pi_seq}">
        
        <div class="img_area">
            <img src="/image/${product.pi_img_uri}" alt="">
        </div>
        <div class="text_area">
            <h2>[${product.seller_name}]${product.pi_name}</h2>
            <p class="rate"> 
             <c:if test = "${rate==0}">
                 <span>평점이 없습니다.</span>
             </c:if>    
             <c:if test = "${rate > 0}">
             <span><c:forEach var="i" begin="1" end="${rate}">★</c:forEach><c:forEach var="i" begin="1" end="${5 - rate}">☆</c:forEach></span>
            </c:if>
            </p>
            <p>회원할인가</p>
            <p class="price">
                <span class="discounted">${product.discounted_price}</span>원
                <c:if test="${product.pi_discount_rate!=0}">
                    <span class="discount_rate">${product.pi_discount_rate}%</span>
                </c:if>
            </p>
            <c:if test="${product.pi_discount_rate!=0}">
                <p class="origin_price">${product.origin_price}원</p>
            </c:if>
            <table class="detail_info_table">
                <tbody>
                    <tr>
                        <td>중량/용량</td>
                        <td>${product.pi_weight}g</td>
                    </tr>
                    <tr>
                        <td>배송사 (배송비)</td>
                        <td>${delivery.di_name} ${delivery.di_price}원</td>
                    </tr>
                    <tr>
                        <td>주의사항</td>
                        <td>${product.pi_caution}</td>
                    </tr>
                    <tr>
                        <td>재고수량</td>
                        <td><span class="stock">${product.pi_stock}</span>개</td>
                    </tr>
                    <tr>
                        <td>구매수량</td>
                        <td>
                            <button id="minus">-</button>
                            <span id="count">1</span>
                            <button id="plus">+</button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="purchase_area">
                <div class="total_price">
                    <span>총 상품금액 : </span>
                    <b></b>
                    <span>원</span>
                </div>
            </div>
            <div class="save_point" data-point-rate="${product.pi_point_rate}">                
                <span>적립</span>
                <span>구매 시</span>
                <b></b>
                <span>적립</span>
            </div>
            <div class="buttons">   
                <button id="shopping_bag">장바구니</button>
                <button id="buy">구매하기</button>
            </div>
        </div>
    </div>
</body>
</html>