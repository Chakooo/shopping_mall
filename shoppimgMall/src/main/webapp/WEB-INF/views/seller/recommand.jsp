<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ include file="/WEB-INF/views/includes/admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
    <link rel="stylesheet" href="/assets/css/admin_css/recommand.css">
    <script src="/assets/js/admin_js/recommand.js"></script>
    <title>Document</title>
</head>
<body>
    ${seller}
    ${seller.si_seq}
    <input type="text"  id="seller_seq" value="${seller.si_seq}" disabled hidden>
    <input type="text"  id="si_seq" value="${si_seq}" disabled hidden>
    <div class="container list">
        <h1>추천상품 관리</h1>
        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>제품명</td>
                    <td>제품이미지</td>
                    <td>카테고리</td>
                    <td>업체명</td>
                    <td></td>
                </tr>
            </thead>
            <tbody id="recommand_tbody">
                <!-- api로 입력되는부분 -->
            </tbody>
        </table>
        <button class="add">추천상품 추가</button>
    </div>
    <div class="add_recommand">
        <div class="add_recommand_wrap">
            <h1>상품 추가</h1>
            <button class="close">닫기</button>
            <div class="search_area">
                
                <input type="text" id="keyword" placeholder="제품명 검색">
                <button id="search">검색</button>

            </div>
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>제품명</td>
                        <td>제품이미지</td>
                        <td>카테고리</td>
                        <td>업체명</td>
                    </tr>
                </thead>
                <tbody class="product_list">

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>