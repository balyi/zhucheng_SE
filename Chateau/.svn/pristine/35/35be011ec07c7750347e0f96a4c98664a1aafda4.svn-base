<%--
  Created by IntelliJ IDEA.
  User: tedu
  Date: 2017/11/26
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- banner -->
<div class="banner banner-bg">
    <!-- header -->
    <div class="header">
        <!-- container -->
        <div class="container">
            <div class="logo">
                <a href="/home/index" id="logo"> <img src="${ctx}/img/logo.png" alt="" /></a>
            </div>
            <div class="top-nav">
                <nav class="navbar navbar-default">
                    <div class="container">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">Menu
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="/chateau/list">世界名庄</a></li>
                            <li><a href="/wine/list" >美酒之廊</a></li>
                            <li><a href="/order/cart" >购物车</a></li>
                            <li><a href="/account/account">我的账户</a></li>
                            <li><a href="/home/contact" >联系我们</a></li>
                            <c:if test="${sessionScope.USER!=null }" var="flag">
                                <li>
                                <span style="font-size: small;font-family: '微软雅黑';color: white">
                                    欢迎${sessionScope.USER.username}&nbsp;&nbsp;|&nbsp;&nbsp;

                                    <a href="${ctx}/login/logout">
                                        注销
                                    </a>
                                </span>
                                </li>
                            </c:if>
                            <c:if test="${!flag }">
                                <li>
                                <span style="font-size: small;font-family: '微软雅黑';color: white">
                                    <a href="${ctx}/login/tologin">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="${ctx}/login/toregist">注册</a>
                                </span>
                                </li>
                            </c:if>
                        </ul>
                        <div class="clearfix"> </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- //container -->
    </div>
    <!-- //header -->
</div>
<!-- banner -->
</body>
</html>
