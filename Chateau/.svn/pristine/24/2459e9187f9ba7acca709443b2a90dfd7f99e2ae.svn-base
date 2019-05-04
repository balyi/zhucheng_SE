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
            <h3><i class="fa fa-angle-right"></i>红酒管理</h3>
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="content-panel">
                        <form name="chform" method="post">
                            <h4>
                                <a href="#" onclick="formSubmit('addWine','_self');this.blur();"><i class="fa fa-angle-right"></i>添加红酒</a>&nbsp;&nbsp;
                                <a href="#" onclick="formSubmit('delete','_self');this.blur();"><i class="fa fa-angle-right"></i>删除红酒</a>&nbsp;&nbsp;
                                <a href="#" onclick="formSubmit('view','_self');this.blur();"><i class="fa fa-angle-right"></i>查看信息</a>&nbsp;&nbsp;
                                <a href="#" onclick="formSubmit('toupdateWine','_self');this.blur();"><i class="fa fa-angle-right"></i>修改信息</a>
                            </h4>
                            <section id="unseen">

                                <table class="table table-bordered table-striped table-condensed" style="text-align: center">
                                    <thead>
                                    <tr>
                                        <td class="numeric"><input type="checkbox" name="wineId" onclick="checkAll('wineId',this)"></td>
                                        <td class="numeric">序号</td>
                                        <td class="numeric">名称</td>
                                        <td class="numeric">酒庄</td>
                                        <td class="numeric">库存</td>
                                        <td class="numeric">售价</td>
                                        <td class="numeric">产地</td>
                                        <td class="numeric">酒精度</td>
                                        <td class="numeric">产品类型</td>
                                        <td class="numeric">入库时间</td>
                                    </tr>
                                    <c:forEach items="${wines}" var="w" varStatus="status">
                                        <tr align="center">
                                            <td><input type="checkbox" name="wineId" value="${w.wineId}"/></td>
                                            <td>${status.index+1}</td>
                                            <td><a href="view?wineId=${w.wineId}">${w.wineName}</a></td>
                                            <td>${w.chateau.chateauName}</td>
                                            <td>${w.pnum}</td>
                                            <td>${w.price}</td>
                                            <td>${w.area}</td>
                                            <td>${w.alcohol}</td>
                                            <td>${w.type}</td>
                                            <td>${w.time}</td>
                                        </tr>
                                    </c:forEach>
                                    </thead>
                                </table>
                            </section>
                        </form>
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
