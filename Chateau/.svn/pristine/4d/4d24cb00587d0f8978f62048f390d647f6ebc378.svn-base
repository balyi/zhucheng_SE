<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

	<title>注册</title>

	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="${ctx}/css/regists.css" type="text/css" media="all">
	<script src="${ctx}/js/jquery-1.7.1.min.js"></script>
	<script src="${ctx}/js/common.js"></script>
	<script src="${ctx}/js/regist.js"></script>

</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>注册</h1>

<div class="container w3layouts agileits">
	<form onsubmit="return checkForm()" action="regist" method="POST">


					<input type="text"
						   name="username"

						   <c:if test="${msg==null}">placeholder="用户名"</c:if>
						   <c:if test="${msg!=null}">placeholder="${msg}"</c:if>

						   onblur="checkNull('username', '请填写用户名')"
						   value=""/>
					<span></span>

					<input type="text"
						   name="name"
						   placeholder="昵称"
						   onblur="checkNull('name', '请填写昵称')"
						   value="${param.name }"/><span></span>

					<input type="password"
						   name="password"
						   placeholder="密码"
						   onblur="checkNull('password', '密码不能为空')"
						   value="${param.password }"/><span></span>

					<input type="password"
						   name="password2"
						   placeholder="确认密码"
						   onblur="checkPassword('password', '两次密码不一致')"
						   value="${param.password2 }"/><span></span>

					<input type="text"
						   name="email"
						   placeholder="邮箱"
						   onblur="checkEmail('email', '邮箱格式不正确')"
						   value="${param.email }"/><span></span>

					<input type="text"
						   name="telephone"
						   placeholder="手机号码"
						   onblur="checkNull('telephone', '请填写手机号')"
						   value="${param.telephone }"/><span></span>





<br/><br/>


		<ul class="tick w3layouts agileits">
			<li>
				<input type="radio" id="brand1" name="role" value="customer" checked />
				<label for="brand1"><span></span>顾客注册</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="brand2" name="role" value="boss"/>
				<label for="brand2"><span></span>酒庄管理注册</label>
			</li>
		</ul>
		<div class="send-button w3layouts agileits">
			<%--<input type="button" value="免费注册" onclick="formSubmit('regist','_self');this.blur();">--%>
			<input type="submit" value="免费注册">
		</div>

	</form>

	<div class="clear"></div>
</div>

<div class="clear"></div>

</div>

<div class="footer w3layouts agileits">
	<p>Copyright &copy; 2017 无锡达内1708A 版权所有 保留一切权利 巨蟹座B-6F </p>
</div>

</body>
<!-- //Body -->

</html>