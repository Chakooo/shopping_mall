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
                <!-- ${seller}
                ${r_list} -->

                <input type="text" name="" id="seller_seq" value="${seller.si_seq}" disabled hidden>





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
                                <td>리뷰확인</td>
                                <td>답변하기</td>
                            </tr>
                        </thead>
                        <tbody id="review_tbody">
                            <c:forEach items="${r_list}" var="list">
                                ${list.rev_status}
                                <tr>
                                    <td>${list.pi_name}${list.rev_seq}</td>
                                    <td>${list.mi_id}</td>
                                    <td>${list.rev_content}</td>
                                    <td>${list.rev_rate}</td>
                                    <td>${list.result_reg_dt}</td>

                                    <c:if test="${list.rev_status==1}">
                                        <td><button class="raw_btn" rev-seq=${list.rev_seq}
                                                rev-status=${list.rev_status}>리뷰 확인</button>
                                        </td>
                                    </c:if>
                                    <c:if test="${list.rev_status==0}">
                                        <td><button class="raw_btn" rev-seq=${list.rev_seq} disabled
                                                rev-status=${list.rev_status}>리뷰 확인</button>
                                        </td>
                                    </c:if>
                                    <c:if test="${list.rev_status==1}">
                                        <td><button  rev-seq=${list.rev_seq} class="raw_btn" disabled>답글달기</button>
                                        </td>
                                    </c:if>
                                    <c:if test="${list.rev_status==0}">
                                        <td><button  rev-seq=${list.rev_seq} class="raw_btn" >답글달기</button>
                                        </td>
                                    </c:if>
                                </tr>
                                <tr class="answer" style="display: none;">
                                    <td colspan="6">
                                        <p>답변등록</p>
                                        <textarea cols="30" rows="10" id="text_area"></textarea>
                                        <button class="answer_regist"rev-seq=${list.rev_seq} >등록</button>
                                    </td>
                                </tr>
                                <tr class="answer_check" style="display: none;">
                                    <td>

                                    </td>
                                </tr>

                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </body>

            </html>