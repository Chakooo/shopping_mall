<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes/admin_header.jsp" %>
<% String strReferer = request.getHeader("referer");
    if(strReferer ==null){
        %>
        <script>
            alert("정상적인 경로 이용")
            document.location.href="/";
        </script>
        <%
        return;
    }
    %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
        <script src="/assets/js/admin_js/delivery.js"></script>
    </head>

    <body>
        
            <h1>배송사 추가</h1>
            <div class="">
                <table>
                    <tbody>
                        <tr>
                            <td>업체명</td>
                            <td><input type="text" name="" id="di_name"></td>
                            <td><button id="dub_chk">중복확인</button></td>
                        </tr>
                        <tr>
                            <td>업체 전화번호</td>
                            <td><input type="text" name="" id="di_phone"></td>
                        </tr>
                        <tr>
                            <td>배송비</td>
                            <td><input type="number" name="" id="di_price"></td>
                        </tr>
                        <tr>
                            <td> <button id="add">추가</button></td>
                        </tr>
                    </tbody>
                </table>

                <div class="delivery_list list">
                    <table class="delivery_table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>배송사</td>
                                <td>전화번호</td>
                                <td>배송비</td>
                                <td>제품수</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody class="delivery_tbody">
                           
                        </tbody>
                    </table>
                </div>

            </div>
    </body>

    </html>