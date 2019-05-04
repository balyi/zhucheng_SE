<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>locked</title>

    <link href="${ctx}/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${ctx}/css/style4.css" rel="stylesheet">
    <link href="${ctx}/css/style-responsive.css" rel="stylesheet">

    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/common.js"></script>

    <script type="text/javascript" src="${ctx}/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("../img/login-bg.jpg", {speed: 500});
    </script>
    <script type="text/javascript" src="${ctx}/js/jquery.backstretch.min.js"></script>
    <script>
        function getTime()
        {
            var today=new Date();
            var h=today.getHours();
            var m=today.getMinutes();
            var s=today.getSeconds();
            // add a zero in front of numbers<10
            m=checkTime(m);
            s=checkTime(s);
            document.getElementById('showtime').innerHTML=h+":"+m+":"+s;
            t=setTimeout(function(){getTime()},500);
        }

        function checkTime(i) {
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        }
        $(function(){
            $("#lock").click(function(){
                var pwd = $("input[name=password]").val().trim();
                if(pwd==""||pwd!="${admin.password}"){
                    alert("密码错误");
                    $("input[name=password]").val("");
                }
                if(pwd=="${admin.password}"){
                    window.history.go(-1);
                }
            });
        });
    </script>
</head>


<body onload="getTime()">
<div class="container">
    <div id="showtime"></div>
    <form method="post">
    <div class="col-lg-4 col-lg-offset-4">
        <div class="lock-screen">
            <h2><a data-toggle="modal" href="#myModal"><i class="fa fa-lock"></i></a></h2>
            <p>解锁</p>
            <!-- Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">欢迎回来</h4>
                        </div>
                        <div class="modal-body">
                            <p class="centered"><img class="img-circle" width="80" src="${ctx}/img/ui-sam.jpg"></p>
                            <input type="password" name="password" placeholder="密码" autocomplete="off" class="form-control placeholder-no-fix">
                        </div>
                        <c:if test="${!empty errorInfo}">
                            ${errorInfo}
                        </c:if>
                        <div class="modal-footer centered">
                            <button data-dismiss="modal" class="btn btn-theme04" type="button">取消</button>
                            <button id="lock" data-dismiss="modal" class="btn btn-theme03" type="button">解锁</button>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--  -->
    </div><!-- /col-lg-4 -->
    </form>
</div><!-- /container -->

<script>
    $.backstretch("../img/login-bg.jpg", {speed: 500});
</script>
</body>
</html>
