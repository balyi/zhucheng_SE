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
                </p>
                <h5 class="centered">${admin.name}</h5>
                <li class="sub-menu">
                    <a class="active" href="javascript:;" >
                        <i class="fa fa-cogs"></i>
                        <span>信息管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="customer">用户管理</a></li>
                        <li class="active"><a  href="chateau">酒庄管理</a></li>
                        <li><a  href="wine">红酒管理</a></li>
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
            <h3>
                <a href="chateau"><i class="fa fa-angle-right">酒庄管理</i></a>
                <i class="fa fa-angle-right">${chateau.chateauName}</i>
            </h3>
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="content-panel">
                        <table style="font-size: 20px">
                            <tr>
                                <td>酒庄拥有者：</td><td>${chateau.user.name}</td></tr>
                            <tr>
                                <td>所在产区：</td><td>${chateau.address}</td></tr>
                            <tr>
                                <td>酒庄等级：</td><td>${chateau.level}</td></tr>
                            <tr>
                                <td>年产量：</td><td>年均${chateau.output}箱（正牌）</td></tr>
                            <tr>
                                <td>年最大预约量：</td><td>${chateau.reserveNum}箱</td></tr>
                            <tr>
                                <td>红葡萄比例：</td><td>${chateau.proportion}</td></tr>
                            <tr>
                                <td>主要葡萄品种：</td><td>${chateau.mostlyType}</td></tr>
                            <tr>
                                <td>其他葡萄品种：</td><td>${chateau.otherType} </td></tr>
                            <tr>
                                <td>平均葡萄树树龄：</td><td>39年</td></tr>
                            <tr>
                                <td>土壤类型：</td><td>沙砾和白垩土</td></tr>
                            <tr>
                                <td>葡萄采摘方式：</td><td>手工采摘</td></tr>
                            <tr>
                                <td>葡萄园面积：</td><td>${chateau.area}公顷</td></tr>
                            <tr><td >酒庄简介：<td></tr>
                            <tr><td colspan="2">${chateau.remark}<td></tr>
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
