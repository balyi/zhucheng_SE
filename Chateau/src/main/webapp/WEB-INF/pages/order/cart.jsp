<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>我的购物车</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Red wine Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- bootstrap-css -->
	<link href="${ctx}/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- //bootstrap-css -->
	<!-- css -->
	<link href="${ctx}/css/style2.css" rel='stylesheet' type='text/css' />
	<link href="${ctx}/css/cart.css" rel="stylesheet" type="text/css">
	<!-- //css -->
	<script src="${ctx}/js/jquery-1.11.1.min.js"> </script>
	<script src="${ctx}/js/common.js"> </script>
	<script src="${ctx}/js/bootstrap.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});

		$(function(){
			$("#del").click(function(){
				if(confirm("您确定删除吗?")){
					// 如何获取商品
					var id = $(this).parent().parent().find("input[type=text]").attr("id");
					var check = $(this).parent().parent().find("input[id=check]").val();
					location.href="/order/todelete?wineId="+id+"&check="+check;
				}
			});

			// 为"-"绑定点击事件
			$(".delNum").click(function(){
				// 获取购买的数量对应的输入框对象
				var $buyNumInput = $(this).next();
				// 获取商品id
				var id = $buyNumInput.attr("id");
				// 计算修改后的购买数量
				var newBuyNum = $buyNumInput.val()-1;
				// 将修改后的结果返回输入框中
				$buyNumInput.val(newBuyNum);
				// 将修改后的结果影响到session
				var check = $(this).prev().val();
				if(newBuyNum<=0){
					location.href="/order/todelete?wineId="+id+ "&check="+check;
				} else {
					location.href="/order/toedit?wineId="+id+"&buyNum="+newBuyNum+"&check="+check;
				}
			});

			// 为"+"绑定点击事件
			$(".addNum").click(function(){
				// 获取购买的数量对应的输入框对象
				var $buyNumInput = $(this).prev();
				// 获取商品id
				var id = $buyNumInput.attr("id");
				var check = $(this).prev().prev().prev().val();
				// 计算修改后的购买数量
				var newBuyNum = parseInt($buyNumInput.val())+1;
				// 将修改后的结果返回输入框中
				$buyNumInput.val(newBuyNum);
				// 将修改后的结果影响到session
				location.href="/order/toedit?wineId="+id+"&buyNum="+newBuyNum + "&check="+check;
			});

			// 为输入框绑定失去焦点事件
			$(".buyNumInp").blur(function(){
				// 获取商品的id
				var id = $(this).attr("id");
				// 获取旧的购买数量
				var oldNum = $("#hid_"+id).val();
				var check = $(this).prev().prev().attr("value");
				// 获取修改后的数量
				var newNum = $(this).val();
				if(oldNum != newNum){
					if(newNum == 0){
						location.href = "/order/todelete?wineId="+id+ "&check="+check;
					} else if(/^[1-9][0-9]*$/.test(newNum)) {
						location.href = "/order/toedit?wineId="+id+"&buyNum="+newNum+"&check="+check;
					} else {
						alert("请输入有效数字");
						$(this).val(oldNum);
					}
				}
			});

		});

	</script>
</head>
<body>
<%@include file="../home/title.jsp"%>

<div id="wrap">
	<!-- 标题信息 -->
	<form action="post" >
		<table>
			<tr>
				<ul id="title">
					<li>
						<input class="allC" name="wineId" type="checkbox" onclick="checkAll('wineId',this)"/>
						<span id="title_checkall_text">全选</span>
					</li>
					<li class="li_prod">商品</li>
					<li>类型</li>
					<li>单价（元）</li>
					<li>数量</li>
					<li>小计（元）</li>
					<li>操作</li>
				</ul>
			</tr>
			<!-- 购物信息 -->
			<c:set var="money" value=""/>
			<c:forEach items="${cart}" var="entry">
			<tr>
				<ul class="prods">

					<li>
						<input type="checkbox" class="check" name="wineId"  value="${entry.key.wineId}"/>
					</li>
					<li class="li_prod">
						<img src="${entry.key.imgurl}" width="40" height="40" class="prodimg"/>
						<span class="prodname">${entry.key.wineName}</span>
					</li>
					<li>
						<span>

							<c:if test="${entry.key.check=='false'}">购买</c:if>
							<c:if test="${entry.key.check=='true'}">预订</c:if>
						</span>
					</li>
					<li class="li_price">${entry.key.price}</li>
					<li>
						<input type="hidden" id="check" value="${entry.key.check}"/>
						<a href="javascript:void(0)" class="delNum">-</a>
						<input id="${entry.key.wineId}" class="buyNumInp" type="text" value="${entry.value}">
						<a href="javascript:void(0)" class="addNum">+</a>
						<input type="hidden" id="hid_${entry.key.wineId}" value="${entry.value}">
					</li>
					<li class="sum_price">${entry.key.price*entry.value}</li>
					<c:set var="money" value="${entry.key.price*entry.value+money}" />
					<li><a id="del" class="delProd">删除</a></li>

				</ul>
			<tr>
				</c:forEach>
				<!-- 总计条 -->
				<div id="total">
					<div id="total_1">
						<input type="checkbox" class="allC" name="wineId" onclick="checkAll('wineId',this)"/>
						<span>全选</span>
						<a id="del_a" onclick="formSubmit('todelete','_self');this.blur();">删除选中的商品</a>
						<div id="div_sum">
							<span id="span_1">总价：</span>
							<span>￥</span>
							<span id="span_2" class="total_sum_price">${money}</span>
						</div>
					</div>
					<div id="total_2">
						<a id="goto_order" onclick="formSubmit('toAdd','_self');this.blur();">去结算</a>
					</div>
				</div>
		</table>
	</form>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="../home/footer.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		/*
		 var defaults = {
		 containerID: 'toTop', // fading element id
		 containerHoverID: 'toTopHover', // fading element hover id
		 scrollSpeed: 1200,
		 easingType: 'linear'
		 };
		 */

		$().UItoTop({ easingType: 'easeOutQuart' });

	});
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- content-Get-in-touch -->
<script type="text/javascript" src="${ctx}/js/move-top.js"></script>
<script type="text/javascript" src="${ctx}/js/easing.js"></script>
</body>
</html>