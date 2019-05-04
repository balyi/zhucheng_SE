<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>合同列表</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>合同列表</legend>
</fieldset>
<form class="layui-form" method="post"  action="">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <button class="layui-btn" onclick="formSubmit('to_contract','_self');this.blur();">查看详细信息</button>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="40">
                <col width="350">
                <col width="150">
                <col width="150">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <td><input type="checkbox" name="selid"  lay-skin="primary"
                           onclick="checkAll('contractId',this)"></td>
                <td>合同号</td>
                <td>货物名称</td>
                <td>合同起始日期</td>
                <td>合同终止日期</td>
                <td>总费用</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${contracts}" var="c" varStatus="status">
            	<tr>
                    <td><input type="checkbox" name="orderId"  lay-skin="primary"
                               value="${c.orderId}" /></td>
                    <td>${c.orderId}</td>
                    <td>${c.pname }</td>
					<td>${c.startDate}</td>
					<td>${c.endDate}</td>
                    <td>${c.price }</td>
            	</tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

