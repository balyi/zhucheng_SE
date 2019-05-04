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
    <link href="${ctx}/css/bootstrap2.css" rel="stylesheet">
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
              <!-- sidebar menu start-->
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
                          <li  class="active"><a  href="wine">红酒管理</a></li>
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

      <form name="wwform" method="post">
      <section id="main-content">
          <section class="wrapper">
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed" >
                              <thead>
                              <tr>
							      <td>红酒名称</td>
								  <td><input type="text" name="wineName" /></td>
						      </tr>
						      <tr>
							      <td>所属酒庄</td>
								  <td>
                                      <select name="chateau.chateauId">
                                          <option>-请选择酒庄-</option>
                                          <c:forEach items="${chateaus}" var="c">
                                              <option value="${c.chateauId}">${c.chateauName}</option>
                                          </c:forEach>
                                      </select>
                                  </td>
						      </tr>
						      <tr>
							      <td>库存</td>
								  <td><input type="text" name="pnum" /></td>
						      </tr>
						      <tr>
							      <td>售价</td>
								  <td><input type="text" name="price" /></td>
						      </tr>
                              <tr>
                                  <td>产地</td>
                                  <td><input type="text" name="area" /></td>
                              </tr>
						      <tr>
							      <td>酒精度</td>
								  <td><input type="text" name="alcohol" /></td>
						      </tr>
						      <tr>
							      <td>产品类型</td>
								  <td><input type="text" name="type" /></td>
						      </tr>
						      <tr>
							      <td>入库年份</td>
								  <td><input type="text" name="time" /></td>
						      </tr>
                              <tr>
                                  <td>产品描述</td>
                                  <td><input type="text" name="remark" /></td>
                              </tr>
                              <a href="#" onclick="formSubmit('save','_self');this.blur();">
                                  <button class="btn btn-theme03"  type="button"  >保存</button>
                              </a>
                              <a href="#" onclick="window.history.back();"><button class="btn btn-theme03" type="button">返回</button></a>
                              </thead>
                          </table>
                        </section>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		</section>
      </section><!-- /MAIN CONTENT -->
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
        <script src="${ctx}/js/common.js"></script>
      </section>
  </body>
</html>
