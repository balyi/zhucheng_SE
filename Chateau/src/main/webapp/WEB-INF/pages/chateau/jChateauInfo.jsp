<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 2017/11/26
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>酒庄详情</title>
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
    <style>
        .gomall2{ width:100%; overflow:hidden; padding:6px 0 12px 0px;}
        .gomall2 a.buymall { display: block;width: 170px;line-height: 16px;background-color: #ac1630;padding: 5px 0px 6px 15px;font-size: 14px;color: #fff;text-decoration: none; font-family: "Microsoft Yahei"; border-top-right-radius: 15px; border-bottom-right-radius: 15px; }
        .gomall2 a.buymall:hover { background-color: #ac1630; }
        .gomall2 a.buymall i{ font-style:normal; font-size:12px; font-family:"宋体";}
        .gomall2.nopads{ padding-bottom:0px;}


        .sch-cont{ padding:15px 10px; border-bottom:1px dotted #ddd; width:678px; }
        .wine-lable{ float:left; width:100px; border:1px solid #e0e0e0; background-color:#f3f3f3; padding:3px; text-align:center}
        .schlist .sch-cont .wine-f .wine-enm{ color:#162878; font-size:16px;}
        .wine-cnm{ font-size:14px; padding-bottom:8px; padding-top:3px; height:25px; width:540px;}
        .sch-cont .wine-f .wine-cnm a{ display:block; float:left; font-size:14px;}

        .grape-js-list ul li{ float:left; padding:0px 15px 0 0; height:25px; line-height:25px;
            white-space:nowrap;}
    </style>
    <!-- //css -->
    <script src="${ctx}/js/jquery-1.11.1.min.js"> </script>
    <script src="${ctx}/js/bootstrap.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
            });
        });
    </script>
</head>
<body>
<%@include file="../home/title.jsp"%>
<div style="background-color: #9d9d9d;text-align: center;">
    <h1>
        <strong>
            拉菲古堡
        </strong><br>
        Chateau Lafite Rothschild
    </h1>
</div>

<div class="container">
    <img src="${chateau.imgurl}" width="1100px" height="500px">
    <div class="grid_3 grid_5" style="color: #1b1b1b;">

        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">酒庄简介</a></li>
                <li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile">酒庄资料</a></li>
                <li role="presentation"><a href="#profile2" role="tab" id="profile-tab2" data-toggle="tab" aria-controls="profile2">酒庄酒款</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
                    <p>${chateau.remark}</p>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
                    <p>
                    <div>
                        <div>
                            <span>酒庄拥有者：</span><span>${chateau.user.name}</span></div>
                        <div>
                            <span>所在产区：</span><span>${chateau.address}</span></div>
                        <div>
                            <span>酒庄等级：</span><span>${chateau.level}</span></div>
                        <div>
                            <span>年产量：</span><span>年均${chateau.output}箱（正牌）</span></div>
                        <div>
                            <span>年最大预约量：</span><span>${chateau.reserveNum}箱</span></div>
                        <div>
                            <span>红葡萄比例：</span><span>${chateau.proportion}</span></div>
                        <div>
                            <span>主要葡萄品种：</span><span>${chateau.mostlyType}</span></div>
                        <div>
                            <span>其他葡萄品种：</span><span>${chateau.otherType} </span></div>
                        <div>
                            <span>平均葡萄树树龄：</span><span>39年</span></div>
                        <div>
                            <span>土壤类型：</span><span>沙砾和白垩土</span></div>
                        <div>
                            <span>葡萄采摘方式：</span><span>手工采摘</span></div>
                        <div>
                            <span>葡萄园面积：</span><span>${chateau.area}公顷</span></div>
                    </div>
                    </p>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="profile2" aria-labelledby="profile-tab2">

                    <c:forEach items="${listWine}" var="w" varStatus="status">
                    <p>

                    <div class="sch-cont">
                        <table>

                            <tr>
                                <td>
                                    <div class="wine-lable">
                                        <img src="${w.imgurl}" width="100" height="100">
                                    </div>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                                <td>


                                    <div class="wine-f">
                                        <div class="wine-cnm">${w.wineName}</div>
                                        产区：

                                        <a href="javascript:void(0)" title="France">${w.area}</a>
                                        <br>
                                        葡萄酒类型：${w.type}
                                        <span style="padding-left: 30px;"></span><br/>
                                        酿酒葡萄：

                                        <a href="javascript:void(0)" title="Cabernet Sauvignon">
                                            ${w.chateau.mostlyType}&nbsp;${w.chateau.otherType}</a>


                                        <div class="gomall2 nopads"><a class="buymall" href="/wine/prod_info?wineId=${w.wineId}">去商城购买&nbsp;&nbsp;<i>&gt;</i></a> </div>
                                    </div>
                                    <div class="clearbox"></div></td>
                            </tr>
                        </table>
                    </div>
                    </p>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>

</div>


<br/>
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
