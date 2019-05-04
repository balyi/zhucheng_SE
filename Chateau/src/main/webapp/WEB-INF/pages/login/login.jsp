<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

	<title>登录</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

 <link rel="stylesheet" href="${ctx}/css/login.css" type="text/css" media="all">
	<script src="${ctx}/js/jquery-1.7.1.min.js"></script>
	<script src="${ctx}/js/common.js"></script>

	<script type="text/javascript">
		$(function(){
			//获取用户名对应的输入框
			$ipt=$("input[name=username]")[0];
			//转码
			var unval=decodeURI($ipt.val());
			//修改输入框的值
			$ipt.val(unval);
		});
		$(function(){
			//获取用户名对应的输入框
			$ipt=$("input[name=password]")[0];
			//转码
			var unval2=decodeURI($ipt.val());
			//修改输入框的值
			$ipt.val(unval2);
		});
	</script>
</head>



<body>

<h1>登录</h1>

<div class="container w3layouts agileits">

	<div class="login w3layouts agileits">


		<form action="#" method="post">
			<!-- **************************************************************************************************************-->
			<!--用户名-->
			<input type="text" Name="username" placeholder="用户名"
				   id="username" value="${cookie.remname.value}">

			<!--密码-->

			<input type="password" Name="password" placeholder="密码"
				   id="password" value="${cookie.rempwd.value}">

			<ul class="tick w3layouts agileits">
				<li>
					<!-- **************************************************************************************************************-->
					<input type="checkbox" id="brand1" name="remname" value="true"
					${empty cookie.remname? "":"checked='checked'" }>
					<label for="brand1"><span></span>记住用户名</label>
					&nbsp;&nbsp;&nbsp;
					<input type="checkbox" id="brand2"  name="rempwd" value="true"
					${empty cookie.rempwd? "":"checked='checked'" }>
					<label for="brand2"><span></span>记住密码</label>

				</li>
			</ul>

			<div class="send-button w3layouts agileits">
				<c:if test="${!empty errorInfo}">
					${errorInfo}
				</c:if>
			</div>
			<div class="send-button w3layouts agileits">

				<!-- **************************************************************************************************************-->
				<input type="button" value="登 录" onclick="formSubmit('login','_self');this.blur();">
			</div>
		</form>


		<div class="clear"></div>


		<div class="send-button w3layouts agileits">
			<a href="toregist">没有账号? 立即注册</a>
		</div>
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