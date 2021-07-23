<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="/assets/js/seller_login.js"></script>
            <link rel="stylesheet" href="/assets/css/login.css">
            <script>
                <c:if test="${member != null}">
                    location.href="/";
                </c:if>
            </script>
            <title>Document</title>
        </head>

        <body>

            <div class="login_form">
                <h1 class="title">판매자 로그인</h1>
                <table>
                    <tbody>
                        <tr>
                            <td><input type="text" name="" id="user_id" placeholder="아이디"></td>
                        </tr>
                        <tr>
                            <td><input type="password" name="" id="user_pwd" placeholder="비밀번호"></td>
                        </tr>
                        <tr>
                            <td><button id="login_btn">로그인</button></td>
                        </tr> 
                        <tr>   
                            <td><button id="id_search">아이디,비밀번호찾기</button> </td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </body>

        </html>