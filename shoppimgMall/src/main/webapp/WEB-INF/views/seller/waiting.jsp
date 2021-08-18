<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/login_header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/assets/js/seller_js/waiting.js"></script>
    <link rel="stylesheet" href="/assets/css/seller_css/waiting.css">
    <title>Document</title>
</head>
<body>
    <input type="text" name="" id="seller_seq" value= ${seller.si_seq} disabled hidden>
    <input type="text" name="" id="seller_id" value="${seller.si_id}" disabled hidden>
   
${imgUri}
    <div class="regi_div">
        <div class="img_form">
            <h1 class="regi_h1">사업자 등록 확인중</h1>
            <h3>사업자 등록증이 완료되었습니다.</h3>
            <h3>확인 후 정상 판매자 시스템을 이용할수 있습니다.</h3>
            <h3>경우에 따라 3~7일 정도 소요됩니다.</h3>
            
            <span id="img_preview">
                <img src="/image/${imgUri.sr_uri}/${seller.si_seq}" alt=""><br>
            </span>
            <form id="image_form">
               
                <input type="file" accept="image/gif,image/jpeg,image/png" name="file" value="제품이미지 선택" id="input-file">
                
                <button type="button" id="img_save">등록</button>
                
         
            </form>



            <button id="regist">사정자 등록증 교체하기</button> 
        </div>
    </div>
</body>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>
</html>