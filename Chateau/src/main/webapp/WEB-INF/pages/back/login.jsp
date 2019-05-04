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
	  <div id="login-page">
	  	<div class="container">
		      <form class="form-login" action="index">
		        <h2 class="form-login-heading">登录</h2>
		        <div class="login-wrap">
		            <input type="text" class="form-control" placeholder="用户名" name="username">
		            <br>
		            <input type="password" class="form-control" placeholder="密码" name="password">
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login#myModal">忘记密码?</a>
		                </span>
		            </label>
                    <div class="send-button w3layouts agileits">
                        <c:if test="${!empty errorInfo}">
                            ${errorInfo}
                        </c:if>
                    </div>
		                <button class="btn btn-theme btn-block" onclick="formSubmit('tologin','_self');this.blur();" type="submit"><i class="fa fa-lock"></i>登录</button>
		            </div>
		      </form>
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/common.js"></script>
    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="${ctx}/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("../img/login-bg.jpg", {speed: 500});
    </script>
  </body>
</html>
