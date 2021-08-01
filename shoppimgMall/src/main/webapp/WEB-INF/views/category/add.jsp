<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/admin_header.jsp" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>카테고리추가</title>
            <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
            <link rel="stylesheet" href="/assets/css/admin_css/table_style.css">
            <script src="/assets/js/admin_js/category.js"></script>
            <script>
               
            </script>
        </head>
        <body>
           
                <h1>카테고리 추가</h1>
                <div class="cate_wrap">
                    <span>카테고리명</span>
                    <input type="text" name="" id="cate_name">
                    <button id="add">추가</button>
                </div>

                <div id="cate_list" class="list">
                    <table id="cate_table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>이름</td>
                                <td>제품수</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody id="cate_table_body">
                            <tr>                               
                            </tr>
                        </tbody>
                    </table>
                </div>
        </body>

        </html>