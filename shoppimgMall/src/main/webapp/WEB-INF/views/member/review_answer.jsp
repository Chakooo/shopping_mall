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
                <link rel="stylesheet" href="/assets/css/review_answer.css">
                <script src="/assets/js/review_answer.js"></script>
                <title>Document</title>
            </head>

            <body>
                <div class="container">
                    <%@include file="/WEB-INF/views/member/left_menu.jsp" %>

                    <div class="dashboard_area list">
                        <table>
                            <thead>
                                <c:if test="${r_list.size()!= ''}">
                                    <tr>
                                        <td>제품사진</td>
                                        <td>상품명</td>
                                        <td>내용</td>
                                        <td>별점</td>
                                        <td>리뷰 등록일</td>
                                        <td></td>


                                    </tr>
                            </thead>
                            <tbody id="review_tbody">

                                <c:forEach items="${r_list}" var="list" varStatus="status">
                                    <tr class="answer" rev-seq="${list.rev_seq}">
                                        <td class="f_td">
                                            <a href="/detail?prod_seq=${list.pi_seq}"><img
                                                    src="/image/${list.pi_img_uri}" id="prod_imag" alt=""></a>
                                        </td>
                                        <td>
                                            <a href="/detail?prod_seq=${list.pi_seq}">[${list.si_name}]
                                                ${list.pi_name}</a>
                                        </td>
                                        <td>${list.rev_content}</td>
                                        <td>
                                            <c:if test="${list.rev_rate ==0}">
                                                <span>평점이 없습니다.</span>
                                            </c:if>
                                            <c:if test="${list.rev_rate > 0}">
                                                <span class="star">
                                                    <c:forEach var="i" begin="1" end="${list.rev_rate}"><img
                                                            src="/assets/images/free-icon-star-2107957.png" alt="">
                                                    </c:forEach>
                                                    <c:forEach var="i" begin="1" end="${5 - list.rev_rate}"><img
                                                            src="/assets/images/free-icon-star-1828970.png" alt="">
                                                    </c:forEach>
                                                </span>
                                            </c:if>
                                        </td>
                                        <td>${list.result_reg_dt}</td>
                                        <td>
                                            <c:if test="${list.review_answer==true}">
                                                <button class="get_answer" rev-seq=${list.rev_seq}>판매자 답글
                                                    보기</button>
                                            </c:if>
                                            <c:if test="${list.review_answer==false}">
                                                <button class="get_answer" rev-seq=${list.rev_seq} disabled>판매자 답글
                                                    없음</button>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr class="answer_check" style="display: none; ">

                                    </tr>

                                </c:forEach>
                                </c:if>
                                <c:if test="${r_list.size()==0}">
                                    <p class="nodata">구매한 상품이 없습니다.</p>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>

            </body>
            <%@include file="/WEB-INF/views/includes/footer.jsp" %>

            </html>