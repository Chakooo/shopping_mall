<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="/assets/css/reset.css">
            <link rel="stylesheet" href="/assets/css/footer.css">
            <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="/assets/js/footer.js"></script>
            <link rel="shortcut icon" type="image/x-icon" href="/assets/images/free-icon-shopping-cart-1136140.png">
            <title>Everyday EveryTime 쇼핑 1번지</title>
        </head>

        <body>
            <footer>
                <div class="seller_login">
                    <c:if test="${member==null && seller==null}">
                        <a href="/seller/login">판매자 로그인</a>
                        <span>|</span>
                        <a href="/seller/join">판매자 회원가입</a>
                        <span>|</span>
                    </c:if>
                </div>
            </footer>
        </body>

        </html>