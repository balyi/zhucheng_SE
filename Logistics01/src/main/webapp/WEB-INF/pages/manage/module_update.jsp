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
                        <button class="layui-btn" onclick="formSubmit('module_update','_self');this.blur();">保存并返回</button>
                    </ul>
                </div>
            </div>
        </div>
    </div>
     <div class="layui-field-box">
            <div class="layui-form-item">
                <label class="layui-form-label">模块ID：</label>
                <div class="layui-input-block">
                    <input type="text" name="moduleId"  value="${module.moduleId}"  class="layui-input"  readonly="readonly">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">模块名称：</label>
                <div class="layui-input-block">
                    <input type="text" name="name" value="${module.name}" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">模块说明：</label>
                <div class="layui-input-block">
                    <input type="text" name="remark" value="${module.remark}" class="layui-input">
                </div>
            </div>
        </div>

</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>
