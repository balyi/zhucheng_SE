<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>提交订单</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>提交订单</legend>
</fieldset>
<form name="icform" method="post">
<div class="layui-form-item">
        <label class="layui-form-label">订单号</label>
        <div class="layui-input-block">
            <input type="text" name="orderNo" lay-verify="required"  value="${date}" class="layui-input" readonly="readonly">
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
                <td>货号</td>
                <td>货物名称</td>
                <td>总重量</td>
                <td>总体积</td>
                <td>货物描述</td>
            </tr>
            </thead>
            <tbody>
            <c:set var="totalWeight" value="0"/>
            <c:set var="totalVolume" value="0"/>
                <c:forEach items="${products}" var="p" varStatus="status">
            <tr>
                    <td>${p.productNo}</td>
                    <td>${p.productName}</td>
                    <td>${p.number*p.weight}
                    <c:set var="totalWeight" value="${totalWeight+p.number*p.weight}" />
                    </td>
                    <td>${p.number*p.length*p.weight*p.height}
                    <c:set var="totalVolume" value="${totalVolume+(p.number*p.length*p.weight*p.height)}" />
                    </td>
                    <td>${p.productRemark}</td>
                    
                    
            </tr>
                </c:forEach>
                 <tr>
                    <td>合计</td>
                    <td></td>
                    <td> <input type="text" name="totalWeight"  value="${totalWeight}"  class="layui-input"  readonly="readonly"></td>
                    <td> <input type="text" name="totalVolume"  value="${totalVolume}"  class="layui-input"  readonly="readonly"></td>
                    <td></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">始发地：</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="sSheng"  placeholder="省/自治区/直辖市" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="sShi" placeholder="市/市辖区"  class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="sQu" placeholder="区/县级市"   class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 350px;">
                <input type="text" name="sJiedao"   placeholder="乡镇街道"  class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">目的地：</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="eSheng"  placeholder="省/自治区/直辖市" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="eShi" placeholder="市/市辖区"  class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="eQu" placeholder="区/县级市"   class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 350px;">
                <input type="text" name="eJiedao"   placeholder="乡镇街道"  class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" 
            lay-filter="demo1"
            onclick="formSubmit('add_order.action','_self');">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

