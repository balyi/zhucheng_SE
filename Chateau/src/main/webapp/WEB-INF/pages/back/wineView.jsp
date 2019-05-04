<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>私人酒庄后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/css/bootstrap2.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/css/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="${ctx}/css/style4.css" rel="stylesheet">
    <link href="${ctx}/css/style-responsive.css" rel="stylesheet">
</head>

<body>

<section id="container" >
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="tologout">注销</a></li>
            </ul>
        </div>
    </header>
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered">
                        <img src="${ctx}/img/ui-sam.jpg" class="img-circle" width="60">
                    </a>
                </p>
                <h5 class="centered">${admin.name}</h5>
                <li class="sub-menu">
                    <a class="active" href="javascript:;" >
                        <i class="fa fa-cogs"></i>
                        <span>信息管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="customer">用户管理</a></li>
                        <li><a  href="chateau">酒庄管理</a></li>
                        <li class="active"><a  href="wine">红酒管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-th"></i>
                        <span>订单管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="reserve">预购订单</a></li>
                        <li><a  href="order">订购订单</a></li>
                        <li><a  href="download">销售榜单</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-book"></i>
                        <span>安全管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="lock_screen">锁屏</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </aside>

    <section id="main-content">
        <section class="wrapper">

            <div class="row mt">
                <div class="col-lg-12">
                    <div class="content-panel">
                        <table class="table table-bordered table-striped table-condensed" ">

                            <td><input name="wineId" value="${wine.wineId}" type="hidden"/></td>
                            <tr>
                                <td width="400px;">红酒名称</td>
                                <td>${wine.wineName}</td>
                            </tr>
                            <tr>
                                <td>所属酒庄</td>
                                <td>
                                    <c:if test="${wine.chateau.chateauId==1}">拉菲酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==2}">奔富酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==3}">罗曼尼·康帝酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==4}">木桐酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==5}">玛格酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==6}">靓茨柏酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==7}">柏鲁斯酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==8}">力士金酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==9}">张裕酒庄</c:if>
                                    <c:if test="${wine.chateau.chateauId==10}">碧尚女爵酒庄</c:if>
                                </td>
                            </tr>
                            <tr>
                                <td>库存</td>
                                <td>${wine.pnum}</td>
                            </tr>
                            <tr>
                                <td>售价</td>
                                <td>${wine.price}</td>
                            </tr>
                            <tr>
                                <td>产地</td>
                                <td>${wine.area}</td>
                            </tr>
                            <tr>
                                <td>酒精度</td>
                                <td>${wine.alcohol}</td>
                            </tr>
                            <tr>
                                <td>产品类型</td>
                                <td>${wine.type}</td>
                            </tr>
                            <tr>
                                <td>入库年份</td>
                                <td>${wine.year}</td>
                            </tr>
                            <tr>
                                <td>产品描述</td>
                                <td>${wine.remark}</td>
                            </tr>
                            <a href="#" onclick="window.history.back();"><button class="btn btn-theme03" type="button">返回</button></a>

                        </table>
                    </div><!-- /content-panel -->
                </div><!-- /col-lg-4 -->
            </div><!-- /row -->
        </section>
    </section><!-- /MAIN CONTENT -->
</section>
<!-- js placed at the end of the document so the pages load faster -->
<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/fullcalendar.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${ctx}/js/common.js"></script>

<!--common script for all pages-->
<script src="${ctx}/js/common-scripts.js"></script>

<!--script for this page-->
<script src="${ctx}/js/calendar-conf-events.js"></script>

</body>
</html>
