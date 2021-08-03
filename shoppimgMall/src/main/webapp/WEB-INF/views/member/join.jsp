<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/member_join.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/member_join.js"></script>
    <script>
      <c:if test="${member != null}">
      location.href="/";
      </c:if>
    </script>
    <title>Document</title>
</head>
<body>
    <h1 class="title"> 회원가입 </h1>
        
    <table class="join_table">
        <tbody>
            <tr>
                <td>아이디</td>
                <td colspan="3">
                    <input type="text" id="user_id">
                </td>
                <td>
                    <button id="chk_id">중복확인</button>
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
                    <input type="text" id="user_name">
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td colspan="3">
                    <input type="text" id="user_email" placeholder=" ex ) aaa@service.com ">
                </td>
                <td>
                    <button id="chk_email">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td>
                    <input type="text" id="user_birth_year"> 
                    <span>년</span>
                    <!-- 생년월일을 통으로 넣지않고 따로 잘라서 db에 저장하면 나중에 따로 가져와서 사용하기 쉽다 -->
                </td>
                <td>
                    <input type="text" id="user_birth_month"> 
                    <span>월</span>
                    <!-- 생년월일을 통으로 넣지않고 따로 잘라서 db에 저장하면 나중에 따로 가져와서 사용하기 쉽다 -->
                </td>
                <td>
                    <input type="text" id="user_birth_date"> 
                    <span>일</span>
                    <!-- 생년월일을 통으로 넣지않고 따로 잘라서 db에 저장하면 나중에 따로 가져와서 사용하기 쉽다 -->
                </td>
            </tr>
            <tr>
                <td>성별</td>
                <td colspan="3">
                    <select name="" id="user_gen">
                        <option value="0">남</option>
                        <option value="1">여</option>
                        <option value="2">선택안함</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td colspan="3">
                    <input type="text"  id="user_address">
                </td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td colspan="3">
                    <input type="text"  id="user_phone">
                </td>
            </tr>
            <tr>
                <td>카드번호</td>
                <td colspan="3">
                    <input type="text"  id="user_card">
                </td>
            </tr>
            <tr>
                <td>계좌번호</td>
                <td colspan="3">
                    <input type="text"  id="user_account">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button id="join">회원가입</button>
                </td>
            </tr>
        </tbody>
    </table>
</body>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>
</html>