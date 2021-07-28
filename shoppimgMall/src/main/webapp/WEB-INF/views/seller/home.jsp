<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ include file="/WEB-INF/views/includes/admin_header.jsp" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
                <script src="/assets/js/admin_js/home.js"></script>
                <link rel="stylesheet" href="/assets/css/admin_css/home.css">
                <title>쇼핑몰</title>

            </head>

            <body>


                <input type="text" name="" id="seller_seq" value="${seller.si_seq}" disabled hidden>
                <h1 class="main_h1">
                    < ${seller.si_name} HOME>
                </h1>
                <div>
                    <div class="left">
                        <h1>
                            <우리가게 탑 5 상품>
                        </h1>
                        <div class="chart">
                            <canvas id="prod_cnt"></canvas>
                        </div>
                    </div>
                    <div class="right">
                        <h1>
                            <a href="/seller/review"><리뷰 확인하기></a>
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
                    </div>
                </div>



            </body>

            </html>