<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>简介</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>功能简介</legend>
</fieldset>
	<blockquote class="layui-elem-quote layui-quote-nm">
		主要功能：提供企业用户对系统的使用权，包括注册、登录、个人信息查看和修改、货物添加和修改、提交订单、查看和下载合同的功能
		<hr class="layui-bg-orange">
  		计价标准：1.核算货物重量体积比值（带包装），大于等于300千克/立方米，按0.5元/（千克·1000千米）计算，小于300千克/立方米，按0.15元/（立方米·1000千米）计算
  		<hr class="layui-bg-orange">
	</blockquote>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

