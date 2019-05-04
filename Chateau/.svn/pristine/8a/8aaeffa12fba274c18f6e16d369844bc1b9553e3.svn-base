<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>私人酒庄后台管理</title>
 
    <link href="${ctx}/css/bootstrap2.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${ctx}/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/css/style5.css">
    
    <!-- Custom styles for this template -->
    <link href="${ctx}/css/style4.css" rel="stylesheet">
    <link href="${ctx}/css/style-responsive.css" rel="stylesheet">

    <script src="${ctx}/js/Chart.js"></script>
  </head>

  <body margin="0">

  <section id="container" >
      <header class="header black-bg">
          <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <div class="nav notify-row" id="top_menu">
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="tologout">注销</a></li>
            	</ul>
            </div>
        </header>
        
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              	  <p class="centered">
	              	  <img src="${ctx}/img/ui-sam.jpg" class="img-circle" width="60"></p>
              	  <h5 class="centered">${admin.name}</h5>
                  <shiro:hasPermission name="admin">
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>信息管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="customer">用户管理</a></li>
                          <li><a  href="chateau">酒庄管理</a></li>
                          <li><a  href="wine">红酒管理</a></li>
                      </ul>
                  </li>
                  </shiro:hasPermission>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>订单管理</span>
                      </a>
                      <ul class="sub">
                          <shiro:hasPermission name="admin">
                          <li><a  href="reserve">预购订单</a></li>
                          <li><a  href="order">订购订单</a></li>
                          </shiro:hasPermission>
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
      <div id="wel">欢迎登录酒庄后台管理系统...</div>
    
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${ctx}/js/jquery.scrollTo.min.js"></script>
    <script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery.sparkline.js"></script>

    
    <!--common script for all pages-->
    <script src="${ctx}/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="${ctx}/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="${ctx}/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="${ctx}/js/sparkline-chart.js"></script>
	<script src="${ctx}/js/zabuto_calendar.js"></script>
	<script src="${ctx}/js/common.js"></script>
      </section>
  <style type="text/css">

      /* css样式 */
      #wel{
          margin: 0;
          font-family: "微软雅黑";
          text-align: center;
          padding: 180px 0px;
          font-size: 45px;
          color: #686868;
          text-shadow: 5px 5px 5px #444444;
      }
  </style>
  <div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;">
      <img src="${ctx}/img/background2.jpg" width="100%" height="100%"/>
  </div>
  </body>
</html>
