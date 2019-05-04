<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
	<head>
    <title>系统登录</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
    <style>
        .cus01{font-family:微软雅黑;text-align:center;}
        .cus02{margin-top:35px;}
        .cus03{width: 150px;}
        .cus04{width: 350px;}
    </style>
	</head>
	<body bgcolor="#d2d2d2">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<div style="height:100px;line-height: 100px;">
    <p class="cus01" style="font-size:36px">物流服务系统登录</p>
</div>
<div class="layui-col-md6 layui-col-md-offset3" style="height:300px; background-color:#00AACC;border-radius:5px;">
    <div class="layui-col-md10 layui-col-md-offset1" style="height:280px; background-color:#2F4056;margin-top:10px;border-radius:5px;">
        <form class="layui-form" method="post" action="">
            <div class="layui-col-md11">
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">账号</p></label>
                    <div class="layui-input-block">
                        <input type="text" name="username" lay-verify="required" autocomplete="off" placeholder="请输入账号" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">密码</p></label>
                    <div class="layui-input-block">
                        <input type="password" name="password" lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
                    </div>
                </div>
                <div class="msgtip">
                <c:if test="${!empty errorInfo}">
                    <p class="cus01" style="font-size:20px;color:#f2f2f2">${errorInfo}</p>
				</c:if>
                </div>
                <div class="layui-col-md10 layui-col-md-offset3 cus02">
                    <div class="layui-col-md6">
                        <button class="layui-btn btn cus03" 
                        lay-submit="" 
                        lay-filter="demo2" 
                        onclick="formSubmit('${ctx}/login.action','_self');">
                            <p class="cus01" style="font-size:20px">登录</p>
                        </button>
                    </div>
                    <div class="layui-col-md6">
                        <button class="layui-btn btn cus03" 
                        onclick="formSubmit('${ctx}/toregist.action','');" 
                        lay-filter="demo2">
                            <p class="cus01" style="font-size:20px">注册</p>
                        </button>
                    </div>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

	</body>
</html>





