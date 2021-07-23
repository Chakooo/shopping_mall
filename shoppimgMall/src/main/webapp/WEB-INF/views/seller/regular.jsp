<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/admin_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
    <title>Document</title>
</head>
<body>
    <h1>단골등록 된 회원목록</h1>
    
    <div class="regular_table list">
        <table>
            <thead>
                <tr>
                    <td>회원 아이디</td>
                    <td>회원 이름</td>
                    <td>회원 이메일</td>
                    <td>회원 주소</td>
                    <td>회원 연락처</td>                        
                    <td>등록일</td>
                    <td>쿠폰(미구현)</td>
                    
                </tr>
            </thead>
            <tbody id="regular_tbody">
                <c:forEach items="${list}"  var="data">
                <tr>
                 
                        <td>${data.mi_id}</td>
                        <td>${data.mi_name}</td>
                        <td>${data.mi_email}</td>
                        <td>${data.mi_address}</td>
                        <td>${data.mi_phone}</td>
                        <td>${data.rc_regist_dt}</td>
                        <td></td>
                     
                </tr>
                </c:forEach>
            </tbody>
        </table>
     
    </div>
</body>
</html>