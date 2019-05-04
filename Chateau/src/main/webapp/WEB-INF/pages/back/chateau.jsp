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
          	<h3><i class="fa fa-angle-right"></i>酒庄管理</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                          <h4>
                              <a href="#" onclick="formSubmit('toCreateChateau','_self');this.blur();"><i class="fa fa-angle-right"></i>添加酒庄</a>&nbsp;&nbsp;
                              <a href="#" onclick="formSubmit('toDeleteChateau','_self');this.blur();"><i class="fa fa-angle-right"></i>删除酒庄</a>&nbsp;&nbsp;
                              <a href="#" onclick="formSubmit('toUpdateChateau','_self');this.blur();"><i class="fa fa-angle-right"></i>更新酒庄</a>&nbsp;&nbsp;
                              <a href="#" onclick="formSubmit('toViewChateau','_self');this.blur();"><i class="fa fa-angle-right"></i>酒庄详情</a>&nbsp;&nbsp;
                          </h4>
                          <section id="unseen">
                          <form name="chform" method="post">
                            <table class="table table-bordered table-striped table-condensed" style="align-items: center;">
                              <thead>
                              <tr>
                                  <th class="numeric">
                                      <input type="checkbox" name="selid" onclick="checkAll('chateauId',this)">
                                  </th>
                                  <th class="numeric">序号</th>
                                  <th class="numeric">酒庄</th>
                                  <th class="numeric">酒庄地点</th>
                                  <th class="numeric">酒庄图片</th>
                                  <th class="numeric">酒庄主人</th>
                                  <th class="numeric">酒庄等级</th>
                                  <th class="numeric">年产量</th>
                                  <th class="numeric">年可预定量</th>
                                  <th class="numeric">面积</th>
                                  <th class="numeric">创建时间</th>
                              </tr>
                              <c:forEach items="${listChateau}" var="c" varStatus="status">
                               <tr align="center">
                                  <td><input type="checkbox" name="chateauId" value="${c.chateauId}"/></td>
                                  <td>${status.index+1}</td>
                                  <td><a href="toViewChateau?chateauId=${c.chateauId}">${c.chateauName}</a></td>
                                  <td>${c.address}</td>
                                  <td>
                                      <a href="toViewChateau?chateauId=${c.chateauId}"><img src="${c.imgurl}" height="150px;" width="320px;"/></a>
                                  </td>
                                  <td>${c.user.name}</td>
                                  <td>${c.level}</td>
                                  <td>${c.output}箱</td>
                                  <td>${c.reserveNum}箱</td>
                                  <td>${c.area}公顷</td>
                                  <td>${c.createTime}年</td>
                              </tr>
                              </c:forEach>
                              </thead>
                          </table>
                          </form>
                        </section>
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
