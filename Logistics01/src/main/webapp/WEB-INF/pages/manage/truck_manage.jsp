<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>货车管理</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>货车列表</legend>
</fieldset>
<form name="icform" method="post">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <button class="layui-btn" onclick="formSubmit('truck_permit','_self');this.blur();">启用</button>
                        <button class="layui-btn" onclick="formSubmit('truck_forbit','_self');this.blur();">禁用</button>
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
                           onclick="checkAll('truckId',this)"></td>
                <td>序号</td>
                <td>货车号</td>
                <td>货车状态</td>
                <td>货车载重</td>
                <td>货车地址</td>
            </tr>
            </thead>
            <tbody>

                <c:forEach items="${trucks}" var="t" varStatus="status">
                    <tr>
                    <td><input type="checkbox" name="truckId"  lay-skin="primary"
                               value="${t.truckId}" /></td>
                    <td>${status.index+1}</td>
                    <td>${t.truckNo}</td>
                    <td>
						<c:if test="${t.truckState==0}"><font color="grey">已启用</font></c:if>
						<c:if test="${t.truckState==1}"><font color="blue">正在运输</font></c:if>
						<c:if test="${t.truckState==2}"><font color="orange">已停用</font></c:if>
					</td>
                    <td>${t.loadWeight}</td>
                    <td>${t.truckAdd}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

