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
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="left_menu">
            <a href="/" id = "main_logo">CORONA INFO</a>
            <ul class = "menu">
                <li>
                    <a href="#">Overview <span>전체 통계</span></a>
                </li>
                <li>
                    <a href="/regional">Regional <span>지역별 통계</span></a>
                </li>
                <li>
                    <a href="#">Vaccine <span>백신접종현황</span></a>
                </li>
                <li>
                    <a href="#">Social Distance <span>사회적거리두기</span></a>
                </li>
                <li>
                    <a href="#">Prediction Info <span>코로나예측정보</span></a>
                </li>
            </ul>
        </div>
        <div class="dashboard_area">
            <div class="dashboard_content">
                <div class="content_left">
                    <p class="con_title">검사자 수</p>
                    <p class="con_number" id="accExamCnt">0</p>
                    <p class="con_title">확진자 수</p>
                    <p class="con_number" id="decideCnt">0</p>
                </div>
                <div class="content_right">
                    <canvas id="regional_status" style="width:100%; height:100%"></canvas>
                </div>
            </div>
            <div class="dashboard_content">
                <div class="content_left">
                    <canvas id = "confirmed_chart" style="width:100%; height:100%"></canvas>
                </div>
                <div class="content_right">
                    <canvas id="vaccine_chart" style = "width:100%; height:100%"></canvas>
                </div>
            </div>
            <div class="dashboard_content">
                <div class="content_left live_confirm_area">
                    <div class="live_confirm_item">
                        <span class = "time">16분 전</span>
                        <span class="region">경남 고성군</span>
                        <span class="num">2</span>명 추가확진
                    </div>
                    <div class="live_confirm_item">
                        <span class = "time">16분 전</span>
                        <span class="region">경남 고성군</span>
                        <span class="num">2</span>명 추가확진
                    </div>  <div class="live_confirm_item">
                        <span class = "time">16분 전</span>
                        <span class="region">경남 고성군</span>
                        <span class="num">2</span>명 추가확진
                    </div>  <div class="live_confirm_item">
                        <span class = "time">16분 전</span>
                        <span class="region">경남 고성군</span>
                        <span class="num">2</span>명 추가확진
                    </div>  <div class="live_confirm_item">
                        <span class = "time">16분 전</span>
                        <span class="region">경남 고성군</span>
                        <span class="num">2</span>명 추가확진
                    </div>  <div class="live_confirm_item">
                        <span class = "time">16분 전</span>
                        <span class="region">경남 고성군</span>
                        <span class="num">2</span>명 추가확진
                    </div>
                </div>
                <div class="content_right">
                    <table class="region_confirm_tbl">
                        <thead>
                            <tr>
                                <td>지역</td>
                                <td>누적확진자</td>
                                <td>신규확진자</td>
                            </tr>
                        </thead>
                    </table>
                    <div class="region_pager_area">
                        <button id ="region_prev">&lt;</button>
                        <span class="current">1</span> / <span class="total">6</span>
                        <button id = "region_next">&gt;</button>
                    </div>
                </div>
            </div>
            <div class="dashboard_content">
                <div class="content_left"><canvas id="gen_chart" style="width:100%; height:100%;"></canvas></div>
                <div class="content_right"><canvas id="age_chart" style="width:100%; height:100%;"></canvas></div>
            </div>
        </div>
    </div>
</body>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>    
</html>