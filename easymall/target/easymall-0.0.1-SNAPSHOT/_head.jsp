<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<link rel="stylesheet" href="${app}/css/head.css"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

<div id="common_head">
	<div id="line1">
		<div id="content">
		<%-- <%Object unObj =session.getAttribute("username"); 
		if(unObj!=null){
		 %>
		 欢迎<%=(String)unObj %>&nbsp;&nbsp;|<a href="<%=request.getContextPath()%>/servlet/LogoutServlet">注销</a>
		 <%}else{ %>
			<a href="${app}/login.jsp">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="${app}/regist.jsp">注册</a>
		<%} %> --%>
	<c:if test="${sessionScope.loginUser!=null }" var="flag">
	 欢迎${sessionScope.loginUser.username }&nbsp;&nbsp;|<a href="<%=request.getContextPath()%>/servlet/LogoutServlet">注销</a>
	</c:if>
	<c:if test="${!flag }">
		<a href="${app}/login.jsp">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${app}/regist.jsp">注册</a>
	</c:if>
		</div>
	</div>
	<div id="line2">
		<img id="logo" src="${app}/img/head/logo.jpg"/>
		<input type="text" name=""/>
		<input type="button" value="搜 索"/>
		<span id="goto">
			<a id="goto_order" href="${app}/OrderListServlet">我的订单</a>
			<a id="goto_cart" href="${app}/cart.jsp">我的购物车</a>
		</span>
		<img id="erwm" src="${app}/img/head/qr.jpg"/>
	</div>
	<div id="line3">
		<div id="content">
			<ul>
				<li><a href="index.jsp">首页</a></li>
				<li><a href="${app}/ProdListServlet">全部商品</a></li>
				<li><a href="#">手机数码</a></li>
				<li><a href="#">电脑平板</a></li>
				<li><a href="#">家用电器</a></li>
				<li><a href="#">汽车用品</a></li>
				<li><a href="#">食品饮料</a></li>
				<li><a href="#">图书杂志</a></li>
				<li><a href="#">服装服饰</a></li>
				<li><a href="#">理财产品</a></li>
			</ul>
		</div>
	</div>
</div>