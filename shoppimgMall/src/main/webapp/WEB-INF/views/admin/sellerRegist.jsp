<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
    <link rel="stylesheet" href="/assets/css/admin_css/sellerRegist.css">
    <script src="/assets/js/admin_js/seller.js"></script>
    <title>Document</title>
</head>
<body>
    <h1>판매자 관리</h1>
    <div class="seller_list list">
        <table class="seller_table">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>아이디</td>                  
                    <td>업체명</td>
                    <td>주소</td>
                    <td>이메일</td>
                    <td>전화번호</td>
                    <td>등급</td>
                    <td>제품수</td>
                    <td></td>
                </tr>
            </thead>
            <tbody class="seller_tbody">               
            </tbody>
        </table>
    </div>
    <h1>판매자 정식 등록확인</h1>
    <div class="seller_list list">
        <table class="seller_table">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>아이디</td>    
                    <td>업체명</td>    
                    <td>주소</td>    
                    <td>이메일</td>    
                    <td>전화번호</td>    
                    <td>사업자 등록증</td>    
                    <td>회원 등급 변경</td>
                </tr>
            </thead>
            <tbody class="img_tbody">               
            </tbody>
         
        </table>
    </div>
</body>
</html>