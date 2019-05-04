<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>合同下载</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>合同下载</legend>
</fieldset>
<blockquote class="layui-elem-quote">
    以下是物流合同重的主要信息，确认无误后即可下载合同
</blockquote>
<form class="layui-form" method="post" action="">
<blockquote class="layui-elem-quote layui-quote-nm">
    <div class="layui-field-box">
        合同号：${contract.orderId }
        <hr class="layui-bg-cyan">

        合同起始日期：${contract.startDate }
        <hr class="layui-bg-red">

        合同终止日期：${contract.endDate}
        <hr class="layui-bg-orange">

        货物名称：${contract.pname }
        <hr class="layui-bg-green">

        发货地址：${contract.sadd }
        <hr class="layui-bg-cyan">

        收货地址：${contract.eadd }
        <hr class="layui-bg-red">
        
         总里程：${contract.distance }千米
        <hr class="layui-bg-cyan">

        押金：${contract.security }
        <hr class="layui-bg-orange">

        总费用：${contract.price }
        <hr class="layui-bg-green">
    </div>
</blockquote>
<button class="layui-btn" onclick="formSubmit('/contract_download.action','_self');" >合同下载</button>
</form>

<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>