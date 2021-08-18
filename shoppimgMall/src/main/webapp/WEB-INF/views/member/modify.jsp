<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/header.jsp" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="/assets/css/myPage.css">
                <link rel="stylesheet" href="/assets/css/modify.css">
                <script src="/assets/js/modify.js"></script>

                <title>Document</title>
            </head>

            <body>
                <input type="text" name="" id="seq" value="${member.mi_seq}" disabled hidden>
                <div class="container">
                    <div class="left_menu">
                        <a href="#" id="main_logo">나의 EE</a>
                        <ul class="menu">
                            <li>
                                <a href="/member/myPage/${member.mi_seq}" id="my_order"><span>내 주문정보</span></a>
                            </li>
                            <li>
                                <a href="/member/modify" id="modify"><span>개인 정보 수정</span></a>
                            </li>
                            <li>
                                <a href="/member/review_answer/${member.mi_seq}" id="review_answer"><span>나의 리뷰 확인</span></a>
                            </li>
                        </ul>
                    </div>
                    <div class="login_form">
                        <h1 class="main_title">비밀번호 재확인</h1>
                        <div class="login">
                            <table>
                                <tbody>
                                    <tr>
                                        <td><input type="text" value="${member.mi_id}" id="user_id" placeholder="아이디" disabled></td>
                                    </tr>
                                    <tr>
                                        <td><input type="password" name="" id="getPwd" placeholder="비밀번호"></td>
                                    </tr>
                                    <tr>
                                        <td><button id="check_btn">확인</button></td>
                                    </tr>                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </body>
            <%@include file="/WEB-INF/views/includes/footer.jsp" %>

            </html>