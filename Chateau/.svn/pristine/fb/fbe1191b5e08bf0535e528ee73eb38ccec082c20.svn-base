<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 2017/11/26
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>增加订单</title>
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
    <link href="${ctx}/css/order_add.css" rel='stylesheet' type='text/css' />
    <!-- //css -->
    <script src="${ctx}/js/jquery-1.11.1.min.js"> </script>
    <script src="${ctx}/js/common.js"> </script>
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
<div class="warp">
    <form name="form1" method="post">
        <h3>增加订单</h3>
        <div id="forminfo">
            <span class="lf">订单信息：</span> <label for="textarea"></label>
            <textarea name="remark" id="textarea" cols="45" rows="5"></textarea>
            <br> 收货地址：<input name="address" type="text">
            <br> 支付方式：<input name="" type="radio" value="" checked="checked">&nbsp;在线支付
        </div>
        <table width="1200" height="80" border="1" cellpadding="0" cellspacing="0" bordercolor="#d8d8d8">
            <tr>
                <th width="226">商品图片</th>
                <th width="200">商品名称</th>
                <th width="201">商品单价</th>
                <th width="189">购买方式</th>
                <th width="184">购买数量</th>
                <th width="200">小计</th>
            </tr>
            <c:set var="money" value="0"/>
            <c:forEach items="${cart}" var="entry">
            <tr>
                <td><img src="${entry.key.imgurl}" width="90" height="90" /></td>
                <td>${entry.key.wineName }</td>
                <td>${entry.key.price }</td>
                <td>
                    <c:if test="${entry.key.check=='false'}">购买</c:if>
                    <c:if test="${entry.key.check=='true'}">预定</c:if>
                </td>
                <td>${entry.value }件</td>
                <td>${entry.key.price*entry.value }元</td>
            </tr>
                <c:set var="money" value="${money+entry.key.price*entry.value}"/>
            </c:forEach>

        </table>

        <div class="Order_price">总价：${money}元</div>

        <div class="add_orderbox">
            ${error_msg}
            <input name="" type="submit" value="增加订单" class="add_order_but " onclick="formSubmit('add','_self');this.blur();">
        </div>
    </form>
</div>
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
<script type="text/javascript" src="${ctx}/js/easing.js"></script>
</body>
</html>
