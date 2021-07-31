<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/login_header.jsp" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <script src="/assets/js/seller_js/registration.js"></script>
                <link rel="stylesheet" href="/assets/css/seller_css/registration.css">


                <title>Document</title>
            </head>

            <body>

                <input type="text" name="" id="seller_seq" value="${si_seq}" disabled hidden>
                <div class="regi_div">
                    <div class="img_form">
                        <h1 class="regi_h1">사업자 등록 과정</h1>
                        <h3>사업자 등록증을 등록해주세요</h3>
                        <p>경우에 따라 3일~7일이 소요됩니다.</p>
                        <span id="img_preview">
                        </span>
                        <form id="image_form">
                            <input type="file" accept="image/gif,image/jpeg,image/png" name="file" value="제품이미지 선택"
                               >
                            <button type="button" id="img_save">등록</button>
                        </form>
                    </div>
                </div>
            </body>
            </html>