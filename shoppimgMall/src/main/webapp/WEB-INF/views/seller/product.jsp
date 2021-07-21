<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/admin_header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>상품 관리</title>    
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
            integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="/assets/js/admin_js/product_list.js"></script>
        <link rel="stylesheet" href="/assets/css/admin_css/product.css">
        <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
    </head>
<body>        
    ${seller}
    <input type="text" name="" id="si_seq" value="${seller.si_seq}" disabled hidden>

    <h1>${seller.si_name}업체 상품관리</h1>
    <div class="product_form">
        <h1>상품 추가</h1>       
        <table class="prod_form_table">
           
            <tbody>
                <tr>
                    <td>상품명</td>
                    <td><input type="text" name="" id="pi_name" placeholder="상품명"></td>  
                    <td>가격</td>             
                    <td><input type="number" name="" id="pi_price" placeholder="가격"></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select name="" id="pi_cate_seq">
                            <option value="null">카테고리 선택</option>
                            <c:forEach items="${clist}" var="cate">
                                <option value="${cate.cate_seq}">${cate.cate_name}</option>
                            </c:forEach>                        
                        </select>
                    </td>
                    <td>재고수량</td>
                    <td><input type="number" id="pi_stock" placeholder="재고"></td>
                 
                </tr>
                <tr>
                    <td>무게</td>
                    <td>
                        <input type="number" min="0" id="pi_weight" placeholder="무게(g)">
                    </td>
                    <td>할인률</td>
                    <td>
                        <input type="number" name="" id="pi_discount_rate" min="0" max="100" placeholder="할인률">
                    </td>    
                </tr>              
                <tr>                  
                    <td>적릴률</td>    
                    <td>
                        <input type="number" name="" id="pi_point_rate" min="0" max="100" placeholder="적립률">
                    </td>
                    <td>배송업체</td>
                    <td colspan="3">
                        <select name="" id="pi_di_seq">
                            <option value="null">배송업체 선택</option>
                            <c:forEach items="${dlist}" var="delivery">
                                <option value="${delivery.di_seq}">${delivery.di_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>               
                <tr>
                    <td>주의사항</td>
                    <td colspan="3">
                        <textarea name="" id="pi_caution" cols="20" placeholder="주의사항"></textarea>
                    </td>
                </tr>
              
              
                <tr>
                    <td>제품이미지</td>
                </tr>
                <tr>
                    <td class="img_form_td" colspan="4">
                        <span id="img_preview">
                        </span>
                        <form id="image_form">
                            <input type="file" accept="image/gif,image/jpeg,image/png" name="file" value="제품이미지 선택">
                            <button type="button" id="img_save">등록</button>
                            <button type="button" id="img_delete" disabled>삭제</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <button id="save">등록하기</button>
                        <button id="modify">수정하기</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <button id="close">&times;</button>
    </div>
    
    <div class="product_list list">
        <div class="search_area">
            <span>카테고리</span>
            <select id="cate_search">
                <option>전체</option>
                <c:forEach items="${clist}" var="cate">
                    <option value="${cate.cate_seq}">${cate.cate_name}</option>
                </c:forEach>
            </select>
            <input type="text" name="" id="search_keyword" placeholder="제품명검색">
            <button id="search">검색</button>
        </div>

        <div>
            <table id="product_table">
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>제품명</td>
                        <td>사진정보</td>
                        <td>카테고리</td>
                        <td>재고</td>                        
                        <td>등록일</td>
                        <td>할인율</td>
                        <td>적릴율</td>
                        <td>주의사항</td>
                        <td>무게</td>
                        <td>배송사</td>
                        <td>제품가격</td>
                        <td>수정</td>
                        <td>삭제</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody id="product_tbody">
                    <!-- ajax로 내용넣음 -->
                </tbody>
            </table>
            <div class="button_area">
                <button id="add_product">상품추가</button>
            </div>
        </div>
    </div>
</body>
</html>