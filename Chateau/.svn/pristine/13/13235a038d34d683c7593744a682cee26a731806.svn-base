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
                        <li><a href="user">酒庄管理</a></li>
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

                                    <tr>
                                        <td>用户名</td>
                                        <td><input type="text" name="username" value="${user.username}"/></td>
                                    </tr>
                                    <tr>
                                        <td>密码</td>
                                        <td><input type="text" name="password" value="${user.password}"/></td>
                                    </tr>
                                    <tr>
                                        <td>昵称</td>
                                        <td><input type="text" name="name" value="${user.name}"/></td>
                                    </tr>
                                    <tr>
                                        <td>邮箱</td>
                                        <td><input type="text" name="email" value="${user.email}"/></td>
                                    </tr>
                                    <tr>
                                        <td>电话</td>
                                        <td><input type="text" name="telephone" value="${user.telephone}"/></td>
                                    </tr>
                                    <tr>
                                        <td>选择等级</td>
                                        <td>
                                            <select name="role">
                                                <option>-请选择等级-</option>
                                                <option value="customer" <c:if test="${user.role=='customer'}">selected="selected"</c:if>>-顾客-</option>
                                                <option value="boss" <c:if test="${user.role=='boss'}">selected="selected"</c:if>>-酒庄老板-</option>
                                                <option value="admin" <c:if test="${user.role=='admin'}">selected="selected"</c:if>>-管理员-</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <a href="#" onclick="formSubmit('toSaveUser','_self');this.blur();">
                                        <button class="btn btn-theme03"  type="button">保存</button>
                                    </a>
                                    <a href="customer"><button class="btn btn-theme03" type="button">返回</button></a>
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

