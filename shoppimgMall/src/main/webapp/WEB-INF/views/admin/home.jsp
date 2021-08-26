<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="/WEB-INF/views/includes/admin_header.jsp" %>
            <% String strReferer=request.getHeader("referer"); if(strReferer==null){ %>
                <script>
                    alert("정상적인 경로 이용하세요")
                    document.location.href = "/";
                </script>
                <% return; } %>
                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">


                        <title>Document</title>
                    </head>

                    <body>
                        afsdafsd
                    </body>

                    </html>