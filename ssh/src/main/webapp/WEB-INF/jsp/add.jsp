<%@page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head></head>
	<body>
		<c:import url="/WEB-INF/jsp/head.jsp"></c:import>
		<h2>添加产品</h2>
		<div>${message}</div>
		<form action="save.do" method="post">
			<div>
				<label>名称:</label>
				<input name="product.name" type="text"
					value="${product.name}"> 
				<span>${nameMessage}</span>
			</div>
			<div>
				<label>价格:</label>
				<input name="product.price" type="text"
					value="${product.price}">
				<span>${priceMessage}</span>
			</div>
			<input type="submit" value="保存">  
		</form>
	</body>
</html>


