<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>基本资料修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/staticfile/layui/css/layui.css" media="all" />
    <script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>基本资料修改</legend>
</fieldset>


<blockquote class="layui-elem-quote layui-quote-nm">
<form class="layui-form" method="post"  action="">
        <div class="layui-field-box">
            <div class="layui-form-item">
                <label class="layui-form-label">用户ID：</label>
                <div class="layui-input-block">
                    <input type="text" name="userId"  value="${user.userId }"  class="layui-input"  readonly="readonly">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-input-block">
                    <input type="text" name="username" value="${user.username }" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">公司名称：</label>
                <div class="layui-input-block">
                    <input type="text" name="userInfo.company" value="${user.userInfo.company }" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">负责人：</label>
                <div class="layui-input-block">
                    <input type="text" name="userInfo.name" value="${user.userInfo.name }"  class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">身份证号：</label>
                <div class="layui-input-block">
                    <input type="text" name="userInfo.cardNo" value="${user.userInfo.cardNo }"  class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">手机号：</label>
                <div class="layui-input-block">
                    <input type="text" name="userInfo.tel" value="${user.userInfo.tel }" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">电子邮箱：</label>
                <div class="layui-input-block">
                    <input type="text" name="userInfo.email" value="${user.userInfo.email }" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">公司简介：</label>
                <div class="layui-input-block">
                    <textarea class="layui-textarea" name="userInfo.remark">${user.userInfo.remark } </textarea>
                </div>
            </div>

        </div>
    <button class="layui-btn" onclick="formSubmit('user_update.action','_self');" >保存</button>
    <br>
    </form>
</blockquote>
<script src="${ctx}/staticfile/layui/layui.all.js" charset="utf-8"></script>
</body>
</html>