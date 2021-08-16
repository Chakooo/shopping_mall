<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="/assets/css/footer.css">
            <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="/assets/js/footer.js"></script>
        </head>

        <body>
            <footer>
                <div class="f_content">
                    <div class="container">
                        <a href="#"><img src="/assets/images/pc_img_1623290330.jpg"></a>
                    </div>
                </div>
                <div class="footer_menu">
                    <div class=menu_container>
                        <div class="footer_nav">
                            <a href="#">EE 마켓 소개</a>
                            <span>|</span>
                            <a href="#">채용정보</a>
                            <span>|</span>
                            <a href="#">이용약관</a>
                            <span>|</span>
                            <a href="#"><b>개인정보처리방침</b></a>
                            <span>|</span>
                            <a href="#">청소년보호정책</a>
                            <span>|</span>
                            <a href="#">전자금융거래약관</a>
                            <span>|</span>
                            <a href="#">제휴·광고</a>
                        </div>
                    </div>
                </div>
                <div class="info">
                    <div class="company_info">
                        <p><b>00000회사</b></p>
                        <p>서울특별시 강남구 0000로 000 (역삼동 00000) 업무집행자 : 000</p>
                        <p>사업자등록번호 : 000-00-0000 사업자정보확인</p>
                        <p>통신판매업신고 : 강남 10630호</p>
                    </div>
                    <div class="help_center">
                        <p><b>고객센터 ></b></p>
                        <p>경기도 0 0 시 0 0구 0 0로 223 (00동) 0 0빌딩 9층</p>
                        <p>Tel : <b>0000-0000</b> (평일 09:00 ~ 18:00) </p>
                        <p> VIP전용 Tel :<b>0000-000</b> (365일 09:00 ~ 18:00)</p>
                        <p>Fax : 02-000-0000 Mail : EEmarket@EEmarket.co.kr</p>
                    </div>
                </div>

                <div class="seller_login">
                    <c:if test="${member==null && seller==null}">
                        <a href="/seller/login">판매자 로그인</a>
                        <span>|</span>
                        <a href="/seller/join">판매자 회원가입</a>
                        <span>|</span>
                    </c:if>
                </div>
            </footer>
            
        </body>

        </html>