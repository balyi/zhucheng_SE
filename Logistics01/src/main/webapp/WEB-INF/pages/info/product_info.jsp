<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>货物列表</title>
<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>货物列表</legend>
</fieldset>
<form class="layui-form" method="post"  action="">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <button class="layui-btn" onclick="formSubmit('delete_product','_self');this.blur();">删除</button>
                        <button class="layui-btn" onclick="formSubmit('to_order','_self');this.blur();">添加至订单</button>
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
                <col width="30">
                <col width="100">
                <col width="100">
                 <col width="150">
                 <col width="100">
            </colgroup>
            <thead>
            <tr>
                <td><input type="checkbox" 
                				name="selid"  
                				lay-skin="primary"
                 				onclick="checkAll('productId',this)"></td>
                <td>序号</td>
                <td>货号</td>
                <td>货物名称</td>
                <td>货物状态</td>
                <td>货物数量</td>
                <td>货物长宽高</td>
                <td>毛重</td>
                <td>货物描述</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="p" varStatus="status">
            <tr>
                    <td><input type="checkbox" 
                    				name="productId"  
                    				lay-skin="primary"
                               value="${p.productId}" /></td>
                    <td>${status.index+1}</td>
                    <td><a href="toview?productId=${p.productId}">${p.productNo}</a></td>
                    <td>${p.productName}</td>
                    <td>
                    	<c:if test="${p.productState==0}"><font color="blue">未添加</font></c:if>
						<c:if test="${p.productState==1}"><font color="green">已添加</font></c:if>
                    </td>
                    <td>${p.number}</td>
                    <td>${p.length}/${p.width}/${p.height}</td>
                    <td>${p.weight}</td>
                    <td>${p.productRemark}</td>
                          </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</form>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>

