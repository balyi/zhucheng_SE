<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>模块管理</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>模块列表</legend>
</fieldset>
<form name="icform" method="post">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <button class="layui-btn" onclick="formSubmit('module_permit','_self');this.blur();">返回</button>
                        <button class="layui-btn" onclick="formSubmit('to_module_update','_self');this.blur();">修改</button>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="40">
                <col width="150">
                <col width="150">
                <col width="100">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <td><input type="checkbox" name="selid"  lay-skin="primary"
                           onclick="checkAll('moduleId',this)"></td>
                <td>序号</td>
                <td>模块ID</td>
                <td>模块名称</td>
                <td>模块说明</td>
            </tr>
            </thead>
            <tbody>

                <c:forEach items="${modules}" var="m" varStatus="status">
                    <tr>
                    <td><input type="checkbox" name="moduleId"  lay-skin="primary"
                               value="${m.moduleId}" /></td>
                    <td>${status.index+1}</td>
                    <td>${m.moduleId}</td>
                    <td>${m.name}</td>
                    <td>${m.remark}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

