<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 2017/11/26
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>世界名庄</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Red wine Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link href="${ctx}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- //bootstrap-css -->
    <!-- css -->
    <link href="${ctx}/css/style2.css" rel='stylesheet' type='text/css' />
    <style>
        body{
            background-image: linear-gradient(to right,#262630,#fff);
        }
    </style>
    <!-- //css -->
    <script src="${ctx}/js/jquery-1.11.1.min.js"> </script>
    <script src="${ctx}/js/bootstrap.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
            });
        });
    </script>
</head>
<body>
<%@include file="../home/title.jsp"%>
<!-- typography -->
<%--<div class="typography">--%>
<div class="space"></div>
<br><br>
    <!-- container-wrap -->
    <div class="container">
        <div class="typography-info">
            <h2 class="type" style="font-family: '隶书';color: #403B83;">世界名庄</h2>
        </div>
        <div class="grid_3 grid_4">
            <div class="bs-example">
                <table class="table" style="font-family: '微软雅黑';color: #2e2f2f;">
                    <%-- <tbody>--%>
                    <c:forEach items="${listChateaus}" var="c" varStatus="status">
                        <tr>
                            <td><a href="toInfo?chateauId=${c.chateauId}"><img src="${c.imgurl}" width="800px" height="300px"></a></td>
                            <td class="type-info">
                                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                                    ${c.chateauName}<br/>
                                拥有者:${c.user.name}<br/>
                                酒庄等级:${c.level}<br/>
                                所在地:${c.address}<br/>
                                面积:${c.area}公顷<br/>
                            </td>
                        </tr>
                    </c:forEach>

                    <%--  </tbody>--%>
                </table>
            </div>
        </div>
    </div>
<%--</div>--%>
<%@include file="../home/footer.jsp"%>
<script type="text/javascript">
    $(document).ready(function() {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- content-Get-in-touch -->
<script type="text/javascript" src="${ctx}/js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
</body>
</html>
