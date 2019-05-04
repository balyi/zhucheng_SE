<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>订单列表</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>订单列表</legend>
</fieldset>
<form class="layui-form" method="post"  action="">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <button class="layui-btn" onclick="formSubmit('to_pay','_self');">前往支付</button>
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
                           onclick="checkAll('orderId',this)"></td>
                <td>订单号</td>
                <td>状态</td>
                <td>支付状态</td>
                <td>总重</td>
                <td>总体积</td>
                <td>发货地址</td>
                <td>收货地址</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${orders}" var="o" varStatus="status">
            <tr>
                    <td><input type="checkbox" name="orderId"  lay-skin="primary"
                               value="${o.orderId}" /></td>
                    <td>${o.orderNo}</td>
                    <td>
						<c:if test="${o.orderState==0}"><font color="grey">未分配货车</font></c:if>
						<c:if test="${o.orderState==1}"><font color="blue">已分配货车</font></c:if>
						<c:if test="${o.orderState==2}"><font color="orange">已发货</font></c:if>
						<c:if test="${o.orderState==3}"><font color="green">已到达</font></c:if>
						<c:if test="${o.orderState==4}"><font color="red">订单禁用/异常</font></c:if>
					</td>
					<td>
						<c:if test="${o.payState==0}"><font color="red">未支付</font></c:if>
						<c:if test="${o.payState==1}"><font color="blue">已支付</font></c:if>
					</td>
                    <td>${o.totalWeight}</td>
                    <td>${o.totalVolume}</td>
                    <td>${o.startAdd}</td>
                    <td>${o.endAdd}</td>
            </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

