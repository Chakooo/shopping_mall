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
                <script src="/assets/js/chart.js"></script>
                <link rel="stylesheet" href="/assets/css/admin_css/chart.css">
                <title>Document</title>
            </head>

            <body>
                <input type="text" name="" id="seller_seq" value="${si_seq}" disabled hidden>
                <input type="text" name="" id="prod_name" value="${prod_name}" disabled hidden>


                <div class="main">

                    <h1>총 판매량</h1>
                    <h3>
                       <총<b> ${list_size}</b> 개 품목 판매>
                    </h3>
                    <div class="prod_area">
                        <div class="all_prod_cnt">
                            <canvas id="prod_cnt"></canvas>
                        </div>
                    </div>
                </div>
                <div>
                    <table class="table">
                        <tbody>
                            <tr>
                                <c:forEach items="${list}" var="list">
                                    <td class="name">${list.pi_name}</td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <c:forEach items="${list}" var="list">
                                    <td>${list.pc_count}</td>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="main">
                    <h1>최근 한달간 판매량</h1>
                    <h3>
                        <총 <b>${m_list_size}</b>개 품목 판매>
                    </h3>


                    <div class="prod_area">
                        <div class="all_prod_cnt">
                            <canvas id="prod_cnt_month"></canvas>
                        </div>
                    </div>
                </div>
                <div>
                    <table class="table">
                        <tbody>
                            <tr>
                                <c:forEach items="${m_list}" var="m_list">
                                    <td class="name">${m_list.pi_name}</td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <c:forEach items="${m_list}" var="m_list">
                                    <td>${m_list.pc_count}</td>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="main">
                    <h1>최근 일주일간 판매량</h1>
                    <h3>
                      <총 <b>${w_list_size}</b>개 품목 판매>
                    </h3>
                    <div class="prod_area">
                        <div class="all_prod_cnt">
                            <canvas id="prod_cnt_week"></canvas>
                        </div>
                    </div>
                </div>
                <div>
                    <table class="table">
                        <tbody>
                            <tr>
                                <c:forEach items="${w_list}" var="w_list">
                                    <td class="name">${w_list.pi_name}</td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <c:forEach items="${w_list}" var="w_list">
                                    <td>${w_list.pc_count}</td>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="main">
                    <h1>날짜별 판매량</h1>
                    <h3 class="prod_cnt_date"></h3>
                    <h3 class="prod_cnt_today"></h3>
                    <h3 class="prod_cnt_chice"></h3>
                    <div class="prod_area">
                        <div class="all_prod_cnt">
                            <canvas id="prod_cnt_search"></canvas>
                        </div>
                    </div>
                </div>
                <div>
                    <table class="table">
                        <thead>
                            <tr id="date_prod_cnt_headaer">
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="date_prod_cnt_body">
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="select_date_button">
                    <input type="date" name="" id="select_date">
                    <button class="btn">선택</button>
                </div>
            </body>

            </html>