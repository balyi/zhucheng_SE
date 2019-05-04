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
    <form name="chform" method="post">
        <section id="main-content">
            <section class="wrapper">
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="content-panel">
                            <section id="unseen">
                                <table class="table table-bordered table-striped table-condensed">
                                    <thead>
                                    <input type="hidden" name="chateauId" value="${chateau.chateauId}"/>
                                    <tr>
                                        <td>酒庄名称</td>
                                        <td><input type="text" name="chateauName" value="${chateau.chateauName}"/></td>
                                    </tr>
                                    <tr>
                                        <td>酒庄地点</td>
                                        <td><input type="text" name="address" value="${chateau.address}"/></td>
                                    </tr>
                                    <tr>
                                        <td>酒庄主人</td>
                                        <td>
                                            <select name="user.userId">
                                                <option>~无主人~</option>
                                                <c:forEach items="${userList}" var="u">
                                                    <option value="${u.userId}" <c:if test="${chateau.user.userId==u.userId}">selected="selected"</c:if>>${u.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>酒庄创建时间</td>
                                        <td><input type="text" name="createTime" value="${chateau.createTime}"/></td>
                                    </tr>
                                    <tr>
                                        <td>选择等级</td>
                                        <td>
                                            <select name="level">
                                                <option>-请选择等级-</option>
                                                <option value="梅朵克一级" <c:if test="${chateau.level=='梅朵克一级'}">selected="selected"</c:if>>-梅朵克一级-</option>
                                                <option value="梅朵克二级" <c:if test="${chateau.level=='梅朵克二级'}">selected="selected"</c:if>>-梅朵克二级-</option>
                                                <option value="梅朵克三级" <c:if test="${chateau.level=='梅朵克三级'}">selected="selected"</c:if>>-梅朵克三级-</option>
                                                <option value="梅朵克四级" <c:if test="${chateau.level=='梅朵克四级'}">selected="selected"</c:if>>-梅朵克四级-</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>面积</td>
                                        <td><input type="text" name="area" value="${chateau.area}"/></td>
                                    </tr>
                                    <tr>
                                        <td>年产量</td>
                                        <td><input type="text" name="output" value="${chateau.output}"/></td>
                                    </tr>
                                    <tr>
                                        <td>年可预约量</td>
                                        <td><input type="text" name="reserveNum" value="${chateau.reserveNum}"/></td>
                                    </tr>
                                    <tr>
                                        <td>描述信息</td>
                                        <td><textarea name="remark" style="width:100%;height:100px">${chateau.remark}</textarea></td>
                                    </tr>

                                    <a href="#" onclick="formSubmit('updateChateau','_self');this.blur();">
                                        <button class="btn btn-theme03"  type="button">保存</button>
                                    </a>
                                    <a href="chateau"><button class="btn btn-theme03" type="button">返回</button></a>
                                    </thead>
                                </table>
                            </section>
                        </div>
                    </div>
                </div>
            </section>
        </section>
    </form>
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

