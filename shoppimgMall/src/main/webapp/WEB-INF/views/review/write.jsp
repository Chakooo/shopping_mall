<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="/assets/js/review.js"></script>
            <link rel="stylesheet" href="/assets/css/review.css">
            <title>Document</title>
        </head>

        <body>
            ${product}

            <input type="text" name="" id="product" value="${product.pi_seq}" disabled hidden>
            <input type="text" name="" id="member" value="${member.mi_seq}" disabled hidden>
            <div class="main_wrap">
                <div class="review_container">
                    <h2>상품 리뷰 작성</h2>
                    <p>이 상품에 대해서 얼마나 만족하시나요 ? </p>
                    <div class="review_rate">
                        <div class="review_rate_input">
                            <img src="/assets/images/free-icon-house-things-988364.png"
                                alt=""><span>${product.pi_name}</span>
                            <br>
                            <input type="radio" id="rate1" name="rate" value="1">
                            <label for="rate1">1</label>
                            <input type="radio" id="rate2" name="rate" value="2">
                            <label for="rate2">2</label>
                            <input type="radio" id="rate3" name="rate" value="3">
                            <label for="rate3">3</label>
                            <input type="radio" id="rate4" name="rate" value="4">
                            <label for="rate4">4</label>
                            <input type="radio" id="rate5" name="rate" value="5">
                            <label for="rate5">5</label>
                        </div>
                    </div>
                    <div class="review_detail">
                        <img src="/image/${product.pi_img_uri}" alt="">
                        <br>
                        <p>상세리뷰</p>
                        <textarea id="review_detail_content" placeholder="상품에 대한 고객님의 솔직한 리뷰를 남겨주세요."></textarea>
                    </div>
                    <div class="review_btn">
                        <button id="cancel">작성취소</button>
                        <button id="save">등록하기</button>
                    </div>
                </div>
            </div>
            <%@include file="/WEB-INF/views/includes/footer.jsp" %>
        </body>

        </html>