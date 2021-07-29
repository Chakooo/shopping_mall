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

    <input type="text" name="" id="si_seq" value="${r_vo.si_seq}" disabled hidden>
    <input type="text" name="" id="rev_seq" value="${r_vo.rev_seq}" disabled hidden>
    <h1>
        < [${r_vo.mi_id}]님의 [${r_vo.pi_name}]에 대한 리뷰>
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
                </tr>
            </thead>
            <tbody id="review_tbody">
                <tr>
                    <td>${r_vo.pi_name}</td>
                    <td>${r_vo.mi_id}</td>
                    <td>${r_vo.rev_content}</td>
                    <td>${r_vo.rev_rate}</td>
                    <td>${r_vo.result_reg_dt}</td>
                </tr>
            </tbody>
        </table>
    </div>


</body>

</html>