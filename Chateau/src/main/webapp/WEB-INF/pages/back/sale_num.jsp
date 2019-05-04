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

    <link href="${ctx}/css/table-responsive.css" rel="stylesheet">
  </head>

  <body>

  <section id="container" >
      <!--header start-->
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
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              	  <p class="centered">
                      <img src="${ctx}/img/ui-sam.jpg" class="img-circle" width="60">
                  </p>
              	  <h5 class="centered">${admin.name}</h5>
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
                  <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>订单管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="reserve">预购订单</a></li>
                          <li><a  href="order">订购订单</a></li>
                          <li class="active"><a  href="download">销售榜单</a></li>
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
              <!-- sidebar menu end-->
          </div>
      </aside>
      
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i>销售信息</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                              <tr>
                                  <th class="numeric">红酒id</th>
                                  <th class="numeric">订单id</th>
                                  <th class="numeric">销售量</th>
                              </tr>
                               <tr>
                                  <td>酒id</td>
                                  <td>订单id</td>
                                  <td>销售数量</td>
                              </tr>
                              </thead>
                          </table>
                        </section>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		</section>
      </section>
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${ctx}/js/jquery.scrollTo.min.js"></script>
    <script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${ctx}/js/common-scripts.js"></script>
    <script src="${ctx}/js/common.js"></script>
  </body>
</html>
