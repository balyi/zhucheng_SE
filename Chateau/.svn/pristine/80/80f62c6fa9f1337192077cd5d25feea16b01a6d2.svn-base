<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 2017/11/26
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>预定</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Red wine Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link href="${ctx}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- //bootstrap-css -->
    <!-- css -->
    <link href="${ctx}/css/style2.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="${ctx}/css/owl.carousel.css">
    <link rel="stylesheet" href="${ctx}/css/bootstrap1.min.css">
    <link rel="stylesheet" href="${ctx}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/css/style1.css">
    <link rel="stylesheet" href="${ctx}/css/ionicons.min.css">
    <link rel="stylesheet" href="${ctx}/css/animate.css">
    <link rel="stylesheet" href="${ctx}/css/responsive.css">
    <link rel="stylesheet" href="${ctx}/css/prodInfo.css">

    <!-- //css -->
    <!-- Js -->
    <script src="${ctx}/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="${ctx}/js/vendor/jquery-1.10.2.min.js"></script>
    <script>window.jQuery || document.write('<script src="${ctx}/js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
    <script src="${ctx}/js/bootstrap1.min.js"></script>
    <script src="${ctx}/js/owl.carousel.min.js"></script>
    <script src="${ctx}/js/min/waypoints.min.js"></script>
    <script src="${ctx}/js/jquery.counterup.js"></script>
    <script src="${ctx}/js/plugins.js"></script>
    <script src="${ctx}/js/main.js"></script>
    <!--<script src="${ctx}/js/jquery-1.11.1.min.js"> </script>-->
    <script src="${ctx}/js/bootstrap.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
            });
        });


        $(function () {
            // 为"-"绑定点击事件
            $("#delNum").click(function(){

                // 获取购买数量对应的输入框对象
                var $buyNumInput = $(this).next();
                // 计算修改后的购买数量
                var newBuyNum = $buyNumInput.val()-1;
                //将修改后的结果影响session
                if(newBuyNum<=0){
                    $buyNumInput.val(1);
                }else{
                    $buyNumInput.val(newBuyNum);
                    $("#hid").val(newBuyNum);
                }
            });

            // 为"+"绑定点击事件
            $("#addNum").click(function(){

                // 获取购买数量对应的输入框对象
                var $bni = $(this).prev();

                // 计算修改后的购买数量
                var newBuyNum = parseInt($bni.val()) + 1;
                //将修改后的结果影响session
                $bni.val(newBuyNum);
                $("#hid").val(newBuyNum);
            });


            // 为输入框绑定失去焦点事件
            $(".buyNumInp").blur(function(){

                // 获取修改后的数量
                var newNum = $(this).val();

                if(oldNum != newNum){
                    if((/^[1-9][0-9]*$/.test(newNum))){//
                        $("#hid").val(newNum);
                    }else{
                        alert("请输入大于0的整数");
                        // 获取旧的购买数量
                        var oldNum = $("#hid").val();
                        $(this).val(oldNum);
                    }
                }
            });

            $("#types").click(function(){
                if($('input[name="chk"]').prop("checked"))
                {
                    $("#types").val("true");
                }
            })
            $(".add_cart_but").click(function () {
                var buyNum=$("#num").val();
                var types=$("#types").val();
                var year=$("#year").val();
                location.href="/order/toadd?wineId=${wine.wineId}&buyNum="+buyNum+"&check="+types+"&year="+year;
            })
        })
    </script>
</head>
<body>
<%@include file="../home/title.jsp"%>
<!--list_info-->
<div class="contact">
    <div id="warp">
        <div id="left">
            <div id="left_top">
                <img src="${wine.imgurl}"/>
            </div>
            <div id="left_bottom">
                <img id="lf_img" src="/img/portfolio/lf.jpg"/>
                <img id="mid_img" src="${wine.imgurl}" width="60px" height="60px"/>
                <img id="rt_img" src="/img/portfolio/rt.jpg"/>
            </div>
        </div>
        <div id="right">
            <div id="right_top">
                <span id="prod_name">
                    ${wine.wineName}<br/>

                </span>
            </div>
            <div id="right_middle">
				<span id="right_middle_span">
						产区： ${wine.area} <br/>
						浓度： ${wine.alcohol}<br/>
                        年份：${wine.year}<br>
						购买数量：
	            <a href="javascript:void(0)" id="delNum" onclick="">-</a>
	            <input class="buyNumInp" id="num" name="" type="text" value="1" onblur="">
		        <a href="javascript:void(0)" id="addNum" onclick="">+</a><br/>
                <input type="hidden" id="hid" value="1">
                    <input id="types" name="chk" type="checkbox" value="false"> &nbsp;私人订制，请选择年限：
                    <select id="year">
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                        <option value="2022">2022</option>
                        <option value="2023">2023</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                        <option value="2027">2027</option>
                        <option value="2028">2028</option>
                    </select>年

				</span>
            </div>
            <div id="right_bottom">


                    <input class="add_cart_but" type="button" />

            </div>
        </div>
    </div>
</div>
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
