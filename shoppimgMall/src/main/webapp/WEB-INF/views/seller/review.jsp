<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/admin_header.jsp"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    ${seller}
   
    <h1>
       <리뷰 확인하기>
    </h1>
    <div class="list">
        <table>
            <thead>
                <tr>
                    <td>제품명</td>
                    <td>아이디</td>
                    <td>내용</td>
                    <td>별점</td>
                    <td>리뷰 등록일</td>
                    <td>답변 여부</td>
                </tr>
            </thead>
            <tbody id="review_tbody">
                <c:forEach items="${r_list}" var="list">
                    <tr>                                           
                        <td>${list.pi_name}</td>
                        <td>${list.mi_id}</td>
                        <td><a href="/seller/review/${list.si_seq}/${list.rev_seq}">${list.rev_content}</a></td>
                        <td>${list.rev_rate}</td>
                        <td>${list.result_reg_dt}</td>                                       
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>