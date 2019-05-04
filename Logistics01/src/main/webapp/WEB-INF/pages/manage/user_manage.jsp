<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户管理</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>用户列表</legend>
</fieldset>
<form name="icform" method="post">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <button class="layui-btn" onclick="formSubmit('user_permit','_self');this.blur();">启用</button>
                        <button class="layui-btn" onclick="formSubmit('user_forbit','_self');this.blur();">禁用</button>
                        <button class="layui-btn" onclick="formSubmit('to_user_role','_self');this.blur();">角色</button>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="40">
                <col width="100">
                <col width="100">
                <col width="250">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <td><input type="checkbox" name="selid"  lay-skin="primary"
                           onclick="checkAll('userId',this)"></td>
                <td>序号</td>
                <td>用户名</td>
                <td>用户创建时间</td>
                <td>用户状态</td>
                <td>负责人</td>
                <td>手机号</td>
                <td>电子邮箱</td>
            </tr>
            </thead>
            <tbody>

                <c:forEach items="${users}" var="u" varStatus="status">
                    <tr>
                    <td><input type="checkbox" name="userId"  lay-skin="primary"
                               value="${u.userId}" /></td>
                    <td>${status.index+1}</td>
                    <td>${u.username}</td>
                    <td>${u.createTime}</td>
                    <td>
						<c:if test="${u.userState==1}"><font color="blue">启用</font></c:if>
						<c:if test="${u.userState==0}"><font color="red">禁用</font></c:if>
					</td>
                    <td>${u.userInfo.name}</td>
                    <td>${u.userInfo.tel}</td>
                    <td>${u.userInfo.email}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

