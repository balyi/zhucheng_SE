<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>基本资料</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>用户基本资料</legend>
</fieldset>


<blockquote class="layui-elem-quote layui-quote-nm">
    <fieldset class="layui-elem-field">
        <legend>用户信息</legend>
        <div class="layui-field-box">
            用户ID：${user.userId }
            <hr class="layui-bg-cyan">

            用户创建时间：${user.createTime }
            <hr class="layui-bg-red">

            用户名：${user.username }
            <hr class="layui-bg-orange">

            用户状态：<c:if test="${user.userState==1}">
										<a href="stop?userId=${user.userId}"><font color="green">启用</font></a>
									</c:if> <c:if test="${user.userState==0}">
										<a href="start?userId=${user.userId}"><font color="red">停用</font></a>
									</c:if></td>
            <hr class="layui-bg-green">
        </div>
    </fieldset>
    <br>
    <fieldset class="layui-elem-field">
        <legend>扩展信息</legend>
        <div class="layui-field-box">

            公司名称：${user.userInfo.company }
            <hr class="layui-bg-blue">

            负责人：${user.userInfo.name }
            <hr class="layui-bg-red">

            身份证号码：${user.userInfo.cardNo }
            <hr class="layui-bg-orange">

            手机号：${user.userInfo.tel }
            <hr class="layui-bg-green">

            电子邮箱：${user.userInfo.email }
            <hr class="layui-bg-cyan">

            公司简介：${user.userInfo.remark }
            <hr class="layui-bg-black">

        </div>
    </fieldset>
    <br>
</blockquote>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>