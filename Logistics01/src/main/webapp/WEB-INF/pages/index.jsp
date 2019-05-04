<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
   <title>主界面</title>
  <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
    <style>
        .cus01{font-family:微软雅黑;text-align:center;}
        .cus02{margin-top:35px;}
    </style>
    <script src="${ctx}/staticfile/js/vendor/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><p style="font-size:26px;font-family:Microsoft YaHei;text-align:center;">物流服务系统</p></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
        <shiro:hasPermission name="货物管理模块">
            <li class="layui-nav-item"><a href="to_add_product.action" target="main">添加货物</a></li>
        </shiro:hasPermission>
            <li class="layui-nav-item">
                <a href="javascript:;">资料管理</a>
                <dl class="layui-nav-child">
                <shiro:hasPermission name="用户权限模块">
                    <dd><a href="to_product_list.action?userId=${_CURRENT_USER.userId}" target="main">货物列表</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="用户权限模块">
                    <dd><a href="to_order_list.action?userId=${_CURRENT_USER.userId}" target="main">订单列表</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="用户权限模块">
                    <dd><a href="to_contract_list.action?userId=${_CURRENT_USER.userId}" target="main">合同列表</a></dd>
                </shiro:hasPermission>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">货运管理</a>
                <dl class="layui-nav-child">
                <shiro:hasPermission name="订单管理模块">
                    <dd><a href="to_order_manage.action" target="main">订单管理</a></dd>
                </shiro:hasPermission>
                <shiro:hasPermission name="货车管理模块">
                    <dd><a href="to_trucklist.action" target="main">货车管理</a></dd>
                </shiro:hasPermission>    
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">系统管理</a>
                <dl class="layui-nav-child">
                    <shiro:hasPermission name="用户管理模块">
                    <dd><a href="to_userlist.action" target="main">用户管理</a></dd>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="角色管理模块">
                    <dd><a href="to_rolelist.action" target="main">角色管理</a></dd>
                     </shiro:hasPermission>
                     <shiro:hasPermission name="模块管理模块">
                    <dd><a href="to_modulelist.action" target="main">模块管理</a></dd>
                    </shiro:hasPermission>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">	
			<c:if test="${!empty _CURRENT_USER.userInfo.company}">
			<strong>${_CURRENT_USER.userInfo.company}</strong>
			</c:if>
				<c:if test="${empty _CURRENT_USER.userInfo.company}">
			<strong>${_CURRENT_USER.username}</strong>
			</c:if>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="logout.action">退出登录</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户功能</a>
                    <dl class="layui-nav-child">
                    <shiro:hasPermission name="用户权限模块">
                    	<dd><a href="user_info.action?userId=${_CURRENT_USER.userId}" target="main">查看基本资料</a></dd>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="用户权限模块">
                        <dd><a href="to_update_user.action?userId=${_CURRENT_USER.userId}" target="main">基本资料修改</a></dd>
                    </shiro:hasPermission>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">资料下载</a>
                    <dl class="layui-nav-child">
                    <shiro:hasPermission name="资料管理模块">
                        <dd><a href="product_list_download.action" target="main">货物列表下载</a></dd>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="资料管理模块">
                        <dd><a href="order_list_download.action" target="main">订单列表下载</a></dd>
                    </shiro:hasPermission>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">关于我们</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <iframe src="introduction.action" name="main" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © logistics.com - 基于J2EE的物流服务系统设计
    </div>
</div>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
