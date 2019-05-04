<%--
  Created by IntelliJ IDEA.
  User: tedu
  Date: 2017/11/26
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>OnePager - One Page Responsive Portfolio Template</title>

        <meta name="viewport" content="width=device-width,initial-scale=1">

        <link rel="stylesheet" href="${ctx}/css/style3.css" media="screen" />
        <link rel="stylesheet" href="${ctx}/css/media-queries.css" />
        <link rel="stylesheet" href="${ctx}/css/flexslider.css" type="text/css" media="screen" />
        <link href="${ctx}/css/prettyPhoto.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="${ctx}/css/tipsy.css" rel="stylesheet" type="text/css" media="screen" />

        <script type="text/javascript" src="${ctx}/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/jquery.flexslider-min.js"></script>
        <script src="${ctx}/js/jquery.prettyPhoto.js" type="text/javascript"></script>
        <script src="${ctx}/js/jquery.tipsy.js" type="text/javascript"></script>
        <script src="${ctx}/js/jquery.knob.js" type="text/javascript"></script>
        <script type="text/javascript" src="${ctx}/js/jquery.isotope.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/waypoints.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/setup.js"></script>
    </head>
<body>
<div id="wrap">
    <!-- wrapper -->
    <div id="sidebar">
        <!-- the  sidebar -->
        <!-- logo -->
        <a href="/home/index" id="logo"> <img src="${ctx}/img/logo.png" alt="" /></a>
        <!-- navigation menu -->
        <ul id="navigation">
            <li><a href="#home" class="active">首页</a></li>
            <li><a href="#portfolio">我的展示</a></li>
            <li><a href="#skills">我的订单</a></li>
            <li><a href="#contact">问题反馈</a></li>
        </ul>
    </div>
    <div id="container">
        <!-- page container -->
        <div class="page" id="home">
            <!-- page home -->
            <div class="page_content">
                <div class="gf-slider">
                    <!-- slider -->
                    <ul class="slides">
                        <li> <img src="${ctx}/img/01.jpg" alt="" />
                            <p class="flex-caption"> 拉菲酒庄</p>
                        </li>
                        <li> <img src="${ctx}/img/02.jpg" alt="" />
                            <p class="flex-caption"> 碧尚女爵酒庄</p>
                        </li>
                        <li> <img src="${ctx}/img/03.jpg" alt="" />
                            <p class="flex-caption"> 奔富酒庄</p>
                        </li>
                        <li> <img src="${ctx}/img/04.jpg" alt="" />
                            <p class="flex-caption"> 罗曼尼·康帝酒庄</p>
                        </li>
                        <li> <img src="${ctx}/img/05.jpg" alt="" />
                            <p class="flex-caption"> 木桐酒庄</p>
                        </li>
                    </ul>
                </div>

                <div class="clear"> </div>
            </div>
        </div>
        <div class="page" id="portfolio">
            <!-- page portfolio -->
            <h3 class="page_title"> 我的展示</h3>
            <div class="page_content">
                <p>读一本骚书,就是和许多高尚的人谈话</p>
                <ul id="works_filter">
                    <li><a href="#" data-filter="*" class="selected">全部</a></li>
                    <li><a href="#" data-filter=".css">红酒</a></li>
                    <li><a href="#" data-filter=".html_php">酒庄</a></li>
                    <li><a href="#" data-filter=".js">葡萄园</a></li>
                </ul>
                <div class="clear"> </div>
                <div id="works">
                    <!-- works -->
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/01.jpg"> <img class="work js" src="${ctx}/img/photos/01.jpg" alt="" /></a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/02.jpg"> <img class="work css" src="${ctx}/img/photos/02.jpg" alt="" /></a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/06.jpg"> <img class="work html_php" src="${ctx}/img/photos/06.jpg" alt="" /> </a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/08.jpg"> <img class="work html_php" src="${ctx}/img/photos/08.jpg" alt="" /> </a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/03.jpg"> <img class="work css" src="${ctx}/img/photos/03.jpg" alt="" /> </a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/04.jpg"> <img class="work js" src="${ctx}/img/photos/04.jpg" alt="" /> </a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/09.jpg"> <img class="work html_php" src="${ctx}/img/photos/09.jpg" alt="" /> </a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/07.jpg"> <img class="work js" src="${ctx}/img/photos/07.jpg" alt="" /> </a>
                    <a rel="prettyPhoto[gallery]" href="${ctx}/img/photos/05.jpg"> <img class="work css" src="${ctx}/img/photos/05.jpg" alt="" /> </a>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="page" id="skills">
            <!-- page skills -->
            <h3 class="page_title"> 我的订单</h3>
            <div class="page_content">
                <table style="width: 100%;font-size: medium">
                    <tr>
                        <td>创建日期</td>
                        <td>购买金额</td>
                        <td width="180">收货地址</td>
                        <td width="240">备注</td>
                    </tr>
                    <c:forEach items="${OrdersL}" var="o">
                        <tr>
                            <td><fmt:formatDate value="${o.createTime}" pattern="yyyy-MM-dd"/> </td>
                            <td>${o.money}</td>
                            <td width="180">${o.address}</td>
                            <td width="240">${o.remark}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="page" id="contact">
            <!-- page contact -->
            <h3 class="page_title"> 问题反馈</h3>
            <div class="page_content">
                <fieldset id="contact_form">
                    <div id="msgs"> </div>
                    <form id="cform" name="cform" method="post" action="">
                        <input type="text" id="name" name="name" value="全名*" onFocus="if(this.value == '全名*') this.value = ''"
                               onblur="if(this.value == '') this.value = '全名*'" />
                        <input type="text" id="email" name="email" value="邮箱地址*" onFocus="if(this.value == '邮箱地址*') this.value = ''"
                               onblur="if(this.value == '') this.value = '邮箱地址*'" />
                        <input type="text" id="subject" name="subject" value="主题*" onFocus="if(this.value == '主题*') this.value = ''"
                               onblur="if(this.value == '') this.value = '主题*'" />
            <textarea id="msg" name="message" onFocus="if(this.value == '你的问题*') this.value = ''"
                      onblur="if(this.value == '') this.value = '你的问题*'">你的问题*</textarea>
                        <button id="submit" class="button">发送</button>
                    </form>
                </fieldset>
                <div class="clear"> </div>
                <ul class="social_icons">
                    <li><a href="#" id="fb" original-title="Join My Fan Club"> <img src="${ctx}/img/facebook.png" alt="Facebook" /></a></li>
                    <li><a href="#" id="tw" original-title="Follow Me on Twitter"> <img src="${ctx}/img/twitter.png" alt="Twitter" /></a></li>
                    <li><a href="#" id="ld" original-title="Find me on LinkedIn"> <img src="${ctx}/img/linkedin.png" alt="LinkedIn" /></a></li>
                </ul>
            </div>
        </div>
        <div class="footer">
            <p> &copy; 2017 . Some Rights Reserved.</p>
        </div>
    </div>
</div>
<a class="gotop" href="#top">Top</a>
</body>
</html>
</head>
<body>

</body>
</html>
