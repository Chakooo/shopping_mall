<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/admin_header.jsp" %>
            <% String strReferer=request.getHeader("referer"); if(strReferer==null){ %>
                <script>
                    alert("정상적인 경로 이용하세요")
                    document.location.href = "/";
                </script>
                <% return; } %>
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <script src="/assets/js/admin_js/recommand.js"></script>
                        <link rel="stylesheet" href="/assets/css/admin_css/recommand.css">
                        <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
                        <title>Document</title>
                    </head>

                    <body>
                        <h1>추천상품 관리</h1>
                        <div class="container list">
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
                                    <select id="cate">

                                    </select>
                                    <select id="seller_list">

                                    </select>
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