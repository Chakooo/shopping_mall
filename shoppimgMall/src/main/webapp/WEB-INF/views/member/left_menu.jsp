<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="/assets/css/myPage.css">
                <title>Document</title>
            </head>

            <body>
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
                            <a href="/member/review_answer/${member.mi_seq}" id="review_answer"><span>판매자 답글 보기</span></a>
                        </li>
                    </ul>
                </div>
            </body>

            </html>