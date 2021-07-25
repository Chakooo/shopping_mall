<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/cart.css">
    <script src="/assets/js/cart.js"></script>
    <title>Document</title>
</head>

<body> 
    ${list}
    <h1>장바구니</h1> 
    <div class="cart_container">
        <div class="container_left">
            <table>
                <thead>
                    <tr>
                        <td colspan="2">
                            <input type="checkbox" name="" id="check_all">
                            <label for="check_all">
                            </label>
                            <span class="count">
                                <span>전체선택</span>
                                (<span class="sel">0</span>/<span class="total">${list.size()}</span>)
                            </span>
                        </td>
                        <td>
                            <button class="delete_selected">선택삭제</button>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${list.size()==0}">
                    <tr>
                        <td colspan="6" class="nodata">장바구니에 담긴 상품이 없습니다.</td>
                    </tr>
                    </c:if>
                    <c:forEach items="${list}" var="item">                        
                        <tr class="cart_prod" data-seq="${item.pi_seq}" data-mi-seq=${member.mi_seq} data-si-seq=${item.pi_si_seq}
                            data-pi-name= ${item.pi_name} >
                            <td>
                                <input type="checkbox" data-seq="${item.pi_seq}" id="sel${item.pi_seq}">
                                <label for="sel${item.pi_seq}">선택</label>
                            </td>
                            <td>
                                <img src="/image/${item.pi_img_uri}">
                            </td>
                            <td>
                                <p>[${item.seller_name}] ${item.pi_name}</p>
                            </td>
                            <td data-final-price ="${item.discounted_price}" data-origin-price="${item.pi_price}">
                                <button class="minus" data-seq="${item.pi_seq}"
                                    data-user-seq="${member.mi_seq}">-</button>
                                    
                                <!-- <span class="cnt">${item.sc_count}</span> -->
                                <input type="text" class="cnt" value="${item.sc_count}" style="display:inline-block; width: 50px;"
                                data-seq="${item.pi_seq}" data-stock = "${item.pi_stock}" data-user-seq="${member.mi_seq}">

                                <button class="plus" data-seq="${item.pi_seq}" data-stock = "${item.pi_stock}"
                                    data-user-seq="${member.mi_seq}">+</button>
                            </td>
                            <td>
                            <span class="final_price">${item.discounted_price * item.sc_count}</span>
                            <span>원</span>
                            <br>
                                <c:if test="${item.pi_discount_rate !=0}">
                                    <!-- 할인률이 없을때는 그냥 할인된가격을 보여주지않고 원가만 보여주기위한 if문 처리 -->
                                    <span class="origin_price">${item.pi_price * item.sc_count}</span>
                                    <span>원</span>
                                </c:if>
                                    <!-- 할인률이 없을때에도 계산식을 처리하기위해서 가져온다. -->
                                <c:if test="${item.pi_discount_rate ==0}">
                                    <span class="origin_price" style = "display:none">${item.pi_price * item.sc_count}</span>
                                    <span style="display:none">원</span>
                                </c:if>
                            </td>
                            <td>
                                <button class="delete" data-seq="${item.pi_seq}"
                                    data-user-seq="${member.mi_seq}">&times;</button>
                                <!-- https://blog.outsider.ne.kr/380 
                                     HTML 엔티티 정리해놓은것 한번보기 -->
                                <!-- times 는 x표 모양 -->
                            </td>
                        </tr>
                    </c:forEach>
              
                </tbody>
            </table>

        </div>
        <div class="container_right">
            <div class="address">
                <h3><img src="/assets/images/ico_delivery_setting.svg" alt=""> 배송지</h3>
                <p>${member.mi_address}</p>
                <button id="change_address">배송지 변경</button>
            </div>
            <div class="total_payment">
                <table>
                    <tbody>
                    <tr> 
                        <td>상품금액</td>
                        <td id="total_price">
                            <span>10000</span>원
                        </td>
                    </tr>
                    <tr>
                        <td>상품할인금액</td>
                        <td id="total_discount">
                            <span>-200</span>원
                        </td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td id="total_delivery_price">
                            <span>2500</span>원
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td>결제예정금액</td>
                        <td class="payment">
                            <span>12300</span>원
                        </td>
                    </tr>
                    <!-- <tr>
                        <td colspan="2">
                            <span>적립</span>
                            <span>구매 시 <span class="point">260</span>원 적립</span>
                        </td>
                    </tr> -->
                </tfoot>
                </table>
            </div>
            <div class="order">
                <button id="order_btn">주문하기</button>
                <ul>
                    <li>쿠폰/적립금은 주문서에서 사용가능합니다.</li>
                    <li>'입금확인' 상태일때는 주문내역 상세에서 직접 주문취소가 가능합니다.</li>
                    <li>'입금확인' 이후 상태에는 고객센터로 문의해주세요.</li>
                </ul>
            </div>
        </div>
    </div>
</body>

</html>


<!-- 서브쿼리와 조인 차이점과 사용법 확인하기 -->