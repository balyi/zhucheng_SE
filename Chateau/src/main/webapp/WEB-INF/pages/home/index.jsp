<%--
  Created by IntelliJ IDEA.
  User: tedu
  Date: 2017/11/26
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
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
<!-- banner -->
<div class="banner">
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
                            <li><a href="/wine/list">美酒之廊</a></li>
                            <li><a href="/order/cart">购物车</a></li>
                            <li><a href="/account/account">我的账户</a></li>
                            <li><a href="/home/contact">联系我们</a></li>

                            <c:if test="${sessionScope.USER!=null }" var="flag">
                            <li>
                                <span style="font-size: small;font-family: '微软雅黑';color: white">
                                    欢迎${sessionScope.USER.username}&nbsp;&nbsp;|&nbsp;&nbsp;

                                    <a href="/login/logout">
                                        注销
                                    </a>
                                </span>
                            </li>
                            </c:if>
                            <c:if test="${!flag }">
                            <li>
                                <span style="font-size: small;font-family: '微软雅黑';color: white">
                                    <a href="tologin">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="toregist">注册</a>
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
    <!-- banner-grids -->
    <div class="banner-grids">
        <!-- container -->
        <div class="container">
            <div class="banner-top-grids">
                <div class="top-grids">
                    <div class="col-md-6 banner-grid">
                        <div class="banner-left-grid blue">
                            <div class="banner-left-icon">
                                <div class="services-icon">
                                    <span class="glyphicon glyphicon-glass" aria-hidden="true"></span>
                                </div>
                            </div>
                            <div class="banner-grid-info">
                                <h3>Consectetur</h3>
                                <p>品味生活的红，恰是红酒，在唇齿间留恋，于心中醉眠。
                                </p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="col-md-6 banner-grid">
                        <div class="banner-left-grid green">
                            <div class="banner-left-icon">
                                <div class="services-icon">
                                    <span class="glyphicon glyphicon-glass glyphicon-cog" aria-hidden="true"></span>
                                </div>
                            </div>
                            <div class="banner-grid-info">
                                <h3>Faucibus</h3>
                                <p>拈一杯红酒，滑过红唇，浪漫依然，人因酒而醉，醇香不散。
                                </p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //container -->
    </div>
    <!-- //banner-grids -->
</div>
<!-- banner -->
<!-- welcome -->
<div class="welcome">
    <!-- container -->
    <div class="container">
        <div class="welcome-info">
            <h2>Welcome</h2>
            <h5>品味杯中风情，曼妙醇香，未饮而醉，风情何止万种.</h5>
            <p>　人生就是一场比较远比较长的旅行，你会东奔西走遇到许多不一样的人，了解他们不一样的人生。在酒精的感染下你也可以在这样的人生中迷失了自己是梦还是现实。</p>
        </div>
    </div>
    <!-- //container -->
</div>
<!-- welcome -->
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
<!-- work -->
<div class="work">
    <!-- container -->
    <div class="container">
        <div class="work-info">
            <h3>Popular Wines</h3>
        </div>
        <div class="work-grids">
            <div class="work-grids-top">
                <div class="col-md-4 work-grid-left">
                    <h5>路易十三干红葡萄酒</h5>
                    <p>Chateau Lafite Rothschild,LOUIS XIII, Pauillac, France</p>
                    <a href="/wine/list">more</a>
                </div>
                <div class="col-md-4 work-grid-middle">
                    <img src="${ctx}/img/6.jpg" alt="">
                </div>
                <div class="col-md-4 work-grid-left">
                    <h5>西拉干红葡萄酒</h5>
                    <p>Penfolds Bin 389 Cabernet - Shiraz, Australia</p>
                    <a href="/wine/list">more</a>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="work-grids-top">
                <div class="col-md-4 work-grid-middle">
                    <img src="${ctx}/img/5.jpg" alt="">
                </div>
                <div class="col-md-4 work-grid-left">
                    <h5>木桐酒庄干红葡萄酒</h5>
                    <p>Chateau Mouton Rothschild, Pauillac, France</p>
                    <a href="/wine/list">more</a>
                </div>
                <div class="col-md-4 work-grid-middle">
                    <img src="${ctx}/img/7.jpg" alt="">
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="work-grids-top">
                <div class="col-md-4 work-grid-left">
                    <h5>银翼干白葡萄酒</h5>
                    <p>Aile d'Argent Blanc du Chateau Mouton Rothschild, Bordeaux, France</p>
                    <a href="/wine/list">more</a>
                </div>
                <div class="col-md-4 work-grid-middle">
                    <img src="${ctx}/img/6.jpg" alt="">
                </div>
                <div class="col-md-4 work-grid-left">
                    <h5>怡和堡干红葡萄酒</h5>
                    <p>Chateau  Latour,  Pauillac,  DEWELLBON  ,  France</p>
                    <a href="/wine/list">more</a>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
    <!-- //container -->
</div>
<!-- //work -->
<!-- news -->
<div class="news">
    <!-- container -->
    <div class="container">
        <div class="news-info">
            <h3>News & Events</h3>
        </div>
        <div class="news-grids">
            <div class="col-md-6 news-grid">
                <img src="${ctx}/img/8.jpg" alt="" />
                <div class="news-grid-info">
                    <a href="#">平古斯酒庄庄主彼得·西塞克收购雪梨酒Camborio品牌</a>
                    <p class="date">19th Jun | 10:00 - 12:00</p>
                    <p class="text">为了酿造西班牙最杰出的白葡萄酒，平古斯酒庄庄主彼得·西塞克近日收购了著名的雪梨酒Camborio品牌。
                        在收购了这个雪莉酒品牌后，彼得·西塞克将会致力于酿造西班牙最杰出最顶级的白葡萄酒。</p>
                </div>
            </div>
            <div class="col-md-6 news-grid">
                <img src="${ctx}/img/9.jpg" alt="" />
                <div class="news-grid-info">
                    <a href="#">黑皮诺葡萄酒：2017年度新西兰航空葡萄酒大奖赛的主角</a>
                    <p class="date">24th Nov. | 09:00 - 11:32</p>
                    <p class="text">在今年举办的新西兰航空葡萄酒大奖赛中，共有1300款葡萄酒进行了盲品评选，最终出现了80款获得金奖的葡萄酒。
                        其中，黑皮诺葡萄酒再次成为了新西兰航空葡萄酒大奖赛的主角，共有20款黑皮诺葡萄酒获得了金奖。
                    </p>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <!-- //container -->
</div>
<!-- //news -->
<%@include file="footer.jsp"%>
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