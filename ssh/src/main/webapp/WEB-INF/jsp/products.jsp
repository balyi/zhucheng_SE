<%@page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head></head>
	<body>
		<c:import url="/WEB-INF/jsp/head.jsp"></c:import>
		<h2>全部产品</h2>
		<!-- 如果sesison 中有错误消息, 显示消息 -->
		<c:if test="${! empty sessionScope.message}">
			<div>${sessionScope.message}</div>
		</c:if>
		<table>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>价格</th>
				<th>功能</th>
			</tr>
			<c:forEach items="${products}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.price}</td>
					<c:url var="url" 
						value="/day04/delete.do?id=${p.id}"/>
					<td><a href="${url}">删除</a>
					<c:url var="url" 
						value="/day04/edit.do?id=${p.id}"/>
					<a href="${url}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>


