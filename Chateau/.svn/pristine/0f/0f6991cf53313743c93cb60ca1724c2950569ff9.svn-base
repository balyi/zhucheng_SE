<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 2017/11/28
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
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

    <link href="${ctx}/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
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
                        <li><a href="chateau">酒庄管理</a></li>
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
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="content-panel">
                            <section id="unseen">
                                <form name="chform" method="post">
                                <table class="table table-bordered table-striped table-condensed" >
                                    <input type="hidden" name="wineId" value="${wine.wineId}"/>
                                    <tr>
                                        <td>红酒名称</td>
                                        <td><input type="text" name="wineName" value="${wine.wineName}"/></td>
                                    </tr>
                                    <tr>
                                        <td>所属酒庄</td>
                                        <td>
                                            <select name="chateau.chateauId" >
                                                <option value="1"	<c:if test="${wine.chateau.chateauId==1}">selected="selected"</c:if>>-拉菲酒庄-</option>
                                                <option value="2"	<c:if test="${wine.chateau.chateauId==2}">selected="selected"</c:if>>-奔富酒庄-</option>
                                                <option value="3"	<c:if test="${wine.chateau.chateauId==3}">selected="selected"</c:if>>-罗曼尼·康帝酒庄-</option>
                                                <option value="4"	<c:if test="${wine.chateau.chateauId==4}">selected="selected"</c:if>>-木桐酒庄-</option>
                                                <option value="5"	<c:if test="${wine.chateau.chateauId==5}">selected="selected"</c:if>>-玛格酒庄-</option>
                                                <option value="6"	<c:if test="${wine.chateau.chateauId==6}">selected="selected"</c:if>>-靓茨柏酒庄-</option>
                                                <option value="7"	<c:if test="${wine.chateau.chateauId==7}">selected="selected"</c:if>>-柏鲁斯酒庄-</option>
                                                <option value="8"	<c:if test="${wine.chateau.chateauId==8}">selected="selected"</c:if>>-力士金酒庄-</option>
                                                <option value="9"	<c:if test="${wine.chateau.chateauId==9}">selected="selected"</c:if>>-张裕酒庄-</option>
                                                <option value="10"<c:if test="${wine.chateau.chateauId==10}">selected="selected"</c:if>>-碧尚女爵酒庄-</option>

                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>库存</td>
                                        <td><input type="text" name="pnum" value="${wine.pnum}"/></td>
                                    </tr>
                                    <tr>
                                        <td>售价</td>
                                        <td><input type="text" name="price" value="${wine.price}"/></td>
                                    </tr>
                                    <tr>
                                        <td>产地</td>
                                        <td><textarea name="area" style="width: 40%;height: 37px;">${wine.area}</textarea></td>
                                    </tr>
                                    <tr>
                                        <td>酒精度</td>
                                        <td><input type="text" name="alcohol" value="${wine.alcohol}"/></td>
                                    </tr>
                                    <tr>
                                        <td>产品类型</td>
                                        <td><input type="text" name="type" value="${wine.type}"/></td>
                                    </tr>
                                    <tr>
                                        <td>入库年份</td>
                                        <td><input type="text" name="time" value="${wine.year}"/></td>
                                    </tr>
                                    <tr>
                                        <td>产品描述</td>
                                        <td><textarea name="remark" style="width: 50%;height: 100px;">${wine.remark}</textarea></td>
                                    </tr>

                                    <a href="#" onclick="formSubmit('updateWine','_self');this.blur();">
                                        <button class="btn btn-theme03"  type="button">保存</button>
                                    </a>
                                    <a href="wine"><button class="btn btn-theme03" type="button">返回</button></a>
                                    </thead>
                                </table>
                                </form>
                            </section>
                        </div>
                    </div>
                </div>
            </section>
        </section>

    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="${ctx}/js/fullcalendar.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${ctx}/js/jquery.scrollTo.min.js"></script>
    <script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${ctx}/js/common-scripts.js"></script>
    <script src="${ctx}/js/calendar-conf-events.js"></script>
    <script src="${ctx}/js/common.js"></script><u></u>
</section>
</body>
</html>

