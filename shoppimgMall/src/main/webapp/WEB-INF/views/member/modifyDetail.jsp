<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@include file="/WEB-INF/views/includes/header.jsp" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                    <link rel="stylesheet" href="/assets/css/myPage.css">
                    <link rel="stylesheet" href="/assets/css/modify.css">
                    <script src="/assets/js/modify.js"></script>

                    <title>Document</title>
                </head>

                <body>
                    ${member}
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
                                    <a href="/member/review_answer/${member.mi_seq}" id="review_answer"><span>나의 리뷰
                                            확인</span></a>
                                </li>
                            </ul>
                        </div>
                        <div class="dashboard_area">
                            <h1 class="title"> 수정하기 </h1>

                            <table class="join_table">
                                <tbody>
                                    <tr>
                                        <td>아이디</td>
                                        <td colspan="3">
                                            <input type="text" id="user_id" disabled value=${member.mi_id}>
                                        </td>
                                        <td>
                                            <button id="chk_id" disabled>중복확인</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>비밀번호</td>
                                        <td colspan="3">
                                            <input type="password" id="user_pwd">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>비밀번호 확인</td>
                                        <td colspan="3">
                                            <input type="password" id="user_pwd_confirm">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>이름</td>
                                        <td colspan="3">
                                            <input type="text" id="user_name" value="${member.mi_name}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>이메일</td>
                                        <td colspan="3">
                                            <input type="text" id="user_email" placeholder=" ex ) aaa@service.com "
                                                value="${member.mi_email}" disabled>
                                        </td>
                                        <td>
                                            <button id="chk_email" disabled>중복확인</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>생년월일</td>
                                        <td>
                                            <input type="text" id="user_birth_year" birth="${fn:split('박-창-현','-')}"
                                                value="${fn:split(member.mi_birth,'-')[0]}">
                                            <span>년</span>
                                            <!-- 생년월일을 통으로 넣지않고 따로 잘라서 db에 저장하면 나중에 따로 가져와서 사용하기 쉽다 -->
                                        </td>
                                        <td>
                                            <input type="text" id="user_birth_month"
                                                value="${fn:split(member.mi_birth,'-')[1]}">
                                            <span>월</span>
                                            <!-- 생년월일을 통으로 넣지않고 따로 잘라서 db에 저장하면 나중에 따로 가져와서 사용하기 쉽다 -->
                                        </td>
                                        <td>
                                            <input type="text" id="user_birth_date"
                                                value="${fn:split(member.mi_birth,'-')[2]}">
                                            <span>일</span>
                                            <!-- 생년월일을 통으로 넣지않고 따로 잘라서 db에 저장하면 나중에 따로 가져와서 사용하기 쉽다 -->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>성별</td>
                                        <td colspan="3">
                                            <select name="" id="user_gen">
                                                <c:if test="${member.mi_gen==0}">
                                                    <option value="0" selected>남</option>
                                                </c:if>
                                                <c:if test="${member.mi_gen!=0}">
                                                    <option value="0">남</option>
                                                </c:if>
                                                <c:if test="${member.mi_gen==1}">
                                                    <option value="1" selected>여</option>
                                                </c:if>
                                                <c:if test="${member.mi_gen!=1}">
                                                    <option value="1">여</option>
                                                </c:if>
                                                <c:if test="${member.mi_gen==2}">
                                                    <option value="2" selected>선택안함</option>
                                                </c:if>
                                                <c:if test="${member.mi_gen!=2}">
                                                    <option value="2">선택안함</option>
                                                </c:if>                                               
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>주소</td>
                                        <td colspan="3">
                                            <input type="text" id="sample6_postcode" placeholder="우편번호" disabled>
                                            <input type="text" id="sample6_extraAddress" placeholder="참고 사항" disabled>

                                        </td>
                                        <td>
                                            <button type="button" id="address">주소 검색</button>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td></td>
                                        <td colspan="3">
                                            <input type="text" id="sample6_address" placeholder="주소" disabled
                                                value="${member.mi_address}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td colspan="3">
                                            <input type="text" id="sample6_detailAddress" placeholder="상세 주소">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>전화번호</td>
                                        <td colspan="3">
                                            <input type="text" id="user_phone" value="${member.mi_phone}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>카드번호</td>
                                        <td colspan="3">
                                            <input type="text" id="user_card" value=${member.mi_pay_card}>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>계좌번호</td>
                                        <td colspan="3">
                                            <input type="text" id="user_account" value=${member.mi_pay_account}>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">
                                            <button id="modify_btn">수정</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </body>
                <%@include file="/WEB-INF/views/includes/footer.jsp" %>

                </html>