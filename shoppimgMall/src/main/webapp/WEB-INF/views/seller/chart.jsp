<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/seller_header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="/assets/js/chart.js"></script>
    <link rel="stylesheet" href="/assets/css/seller_css/chart.css">
    <title>Document</title>
</head>

<body>
    <input type="text" name="" id="seller_seq" value="${si_seq}" disabled hidden>
    <input type="text" name="" id="prod_name" value="${prod_name}" disabled hidden>
    <input type="text" name="" id="list_size" value="${list_size}" disabled hidden>
    <h1 class="main_date"></h1>
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
                <!-- <tr>
                    <c:forEach items="${list}" var="list">
                        <td class="name">${list.pi_name}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach items="${list}" var="list">
                        <td>${list.pc_count}</td>
                    </c:forEach>
                </tr> -->
            </tbody>
        </table>
    </div>

    <div class="main">
        <h1>기간별 판매량</h1>

        <h3 class="prod_cnt_date">
        </h3>
        <div class="prod_area">
            <div class="all_prod_cnt">
                <canvas id="prod_cnt_term"></canvas>
            </div>
        </div>
    </div>
    <!-- <div>
        <table class="table">
            <thead>
                <tr id="term_prod_cnt_headaer">
                </tr>
            </thead>
            <tbody>
                <tr id="term_prod_cnt_body">
                </tr>
            </tbody>
        </table>
    </div> -->
    <div class="select_btn_area">
        <div class="select_date_button">
            <button class="term_select_week c_button" value="week">이번 주 (월 ~ 일)</button>
            <button class="term_select_month c_button" value="month">이번 달</button>
            <button class="term_select_year c_button" value="year">올해</button>
            <div class="select_date_button">
                <input type="date" name="" id="start_date"> ~ <input type="date" name="" id="end_date">
                <button class="select_date_btn c_button">선택</button>
            </div>
        </div>
    </div>

    <div class="main">
        <h1>어제오늘 판매량 비교</h1>

        <h3 class="prod_cnt_date">
        </h3>
        <div class="prod_area">
            <div class="all_prod_cnt">
                <canvas id="prod_cnt_ydate" style="width:1500px"></canvas>
            </div>
        </div>
    </div>
    <div>
        <table class="table">
            <thead>
                <tr id="ydate_prod_cnt_headaer">
                </tr>
            </thead>
            <tbody>
                <tr id="ydate_prod_cnt_body">
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>