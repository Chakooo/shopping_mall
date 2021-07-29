<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ include file="/WEB-INF/views/includes/admin_header.jsp" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="/assets/css/admin_css/review.css">
                <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="/assets/js/admin_js/review.js"></script>
                <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
                <title>Document</title>
            </head>

            <body>
                <!-- ${r_list} -->

                <input type="text" name="" id="seller_seq" value="${si_seq}" disabled hidden>


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
                                    <td><button value="${list.rev_seq}"class="rev_seq" style="border:0; outline:0; cursor: pointer; background-color: white;" >${list.rev_content}</button></td>
                                    <td>${list.rev_rate}</td>
                                    <td>${list.result_reg_dt}</td>
                                    <td><input type="button" value="답변등록" rev-seq=${list.rev_seq} class="raw_btn">                                        
                                    </td>
                                </tr>
                                <tr class="answer" style="display: none;">
                                    <td colspan="6">
                                        <p>답변등록</p>
                                        <textarea cols="30" rows="10"></textarea>
                                    </td>
                                </tr>

                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </body>

            </html>