<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>添加货物</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>物流货物添加</legend>
</fieldset>
<blockquote class="layui-elem-quote layui-text">
    请注意：不同类型的货物请分别添加至货物列表中，以便计算重量、体积、以及价格，统一安排运输
</blockquote>
<form class="layui-form"  method="post"  action="">
<input name="userId"  value="${_CURRENT_USER.userId}" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">货号</label>
        <div class="layui-input-block">
            <input type="text" name="productNo" lay-verify="required"  value="${date}" class="layui-input" readonly="readonly">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">货物名称</label>
        <div class="layui-input-block">
            <input type="text" name="productName" lay-verify="required" placeholder="请输入货物名称"  class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">货物长(cm)</label>
            <div class="layui-input-inline">
                <input type="text" name="length" lay-verify="required|number"  class="layui-input">
            </div>

        </div>
        <div class="layui-inline">
            <label class="layui-form-label">货物宽(cm)</label>
            <div class="layui-input-inline">
                <input type="text" name="width" lay-verify="required|number" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">货物高(cm)</label>
            <div class="layui-input-inline">
                <input type="tel" name="height" lay-verify="required|number"  class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">毛重(kg)</label>
            <div class="layui-input-inline">
                <input type="text" name="weight" lay-verify="required|number" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">单位</label>
            <div class="layui-input-inline">
                <input type="text" name="unit" lay-verify="required"  class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <input type="tel" name="number" lay-verify="required|number"  class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">货物描述</label>
        <div class="layui-input-block">
            <textarea name="productRemark" placeholder="请输入货物描述" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" onclick="formSubmit('add_product.action','_self');"  lay-submit="" lay-filter="demo1">添加到货物列表</button>
            <button class="layui-btn layui-btn-normal" onclick="formSubmit('to_product_list.action','_self');">前往货物列表</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>

</body>
</html>