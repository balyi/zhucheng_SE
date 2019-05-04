<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
    <title>企业用户注册</title>
   <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
    <script src="${ctx}/staticfile/js/jquery-1.6.2.js"></script>
	<script src="${ctx}/staticfile/js/regist.js"></script>
    <style>
        .cus01{font-family:微软雅黑;text-align:center;}
        .cus02{margin-top:25px;}
        .cus03{width: 150px;}
        .cus04{margin-top:10px;}
    </style>

</head>
<body bgcolor="#d2d2d2">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<div style="height:100px;line-height: 100px;">
    <p class="cus01" style="font-size:36px">企业用户注册</p>
</div>
<div class="layui-col-md6 layui-col-md-offset3" style="height:550px; background-color:#00AACC;border-radius:5px;">
    <div class="layui-col-md10 layui-col-md-offset1" style="height:530px; background-color:#2F4056;margin-top:10px;border-radius:5px;">
        <form class="layui-form" method="post"  action="">
					<span style="font-size:20px;text-align:center;color:#D0BFA9">
						<!-- 如果校验失败, 在此处获取提示消息提示用户 -->
						${msg }
					</span>
            <div class="layui-col-md11">
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">公司名称</p></label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.company" value="${user.userInfo.company}" placeholder="请输入公司名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">账号</p></label>
                    <div class="layui-input-block">
                        <input type="text" name="username" value="${user.username}" placeholder="请输入账号" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">密码</p></label>
                    <div class="layui-input-block">
                        <input type="password" name="password" value="${user.password}" placeholder="请输入密码" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">确认密码</p></label>
                    <div class="layui-input-block">
                        <input type="password" name="password2" value="${user.password2}" placeholder="请确认密码" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">负责人</p></label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.name" value="${user.userInfo.name}" placeholder="请输入负责人姓名" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">邮箱</p></label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.email" value="${user.userInfo.email}" placeholder="请输入邮箱" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item cus02">
                    <label class="layui-form-label"><p class="cus01" style="font-size:20px;color:#f2f2f2">手机</p></label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.tel" value="${user.userInfo.tel}" placeholder="请输入手机号" class="layui-input">
                    </div>
                </div>
                <div class="layui-col-md4 layui-col-md-offset5 cus04">
                        <button class="layui-btn btn cus03" 
                        lay-submit="" 
                        lay-filter="demo2"
                        onclick="formSubmit('${ctx}/regist.action','_self');" >
                            <p class="cus01" style="font-size:20px">注册</p>
                        </button>
                </div>
            </div>

        </form>
    </div>
</div>

</body>
</html>
