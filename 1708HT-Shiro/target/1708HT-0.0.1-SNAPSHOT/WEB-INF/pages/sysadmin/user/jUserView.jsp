<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="back"><a href="#" onclick="window.history.back();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    新增部门
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr><td><input name="userId" value="${user.userId } " type="hidden" ></td></tr>
	<tr>
	
		<td>用户名：</td>
		<td>${user.username }</td>
		<td>密码：</td>
		<td>${user.password }</td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td>${user.userInfo.name }</td>
		<td>身份证号：</td>
		<td>${user.userInfo.cardNo }</td>
	</tr>
	<tr>
		<td>性别：</td>
		<td>${user.userInfo.gender }</td>
		<td>工资：</td>
		<td>${user.userInfo.salary }</td>
	</tr>
	 	<tr>
		<td>入职日期：</td>
		
		<td><fmt:formatDate value="${user.userInfo.joinDate }" pattern="yyyy-MM-dd"/></td>
		<td>生日：</td>
		<td><fmt:formatDate value="${user.userInfo.birthday }" pattern="yyyy-MM-dd"/></td>
	</tr>
	</tr>
	 	<tr>
		<td>岗位描述：</td>
		<td>${user.userInfo.station }</td>
		<td>用户级别：</td>
		<td>	
		<c:if test="${user.userInfo.userLevel==4 }">普通员工</c:if>
		<c:if test="${user.userInfo.userLevel==3 }">部门经理</c:if>
		<c:if test="${user.userInfo.userLevel==2 }">副总</c:if>
		<c:if test="${user.userInfo.userLevel==1 }">总经理</c:if>
		<c:if test="${user.userInfo.userLevel==0 }">超级管理员</c:if>
		</td>
	</tr>
	
	<tr>
		<td>所属部门：</td>
		<td>
		 ${user.dept.deptName }
		</td>
		<td>直属领导：</td>
		<td>
		${user.userInfo.manager.name }
		</td>
	</tr>
	<tr>
		<td>员工状态：</td>
	
		<td>	
		<c:if test="${user.state==1 }">启用</c:if>
		<c:if test="${user.state==0 }">停用</c:if>
		</td>
		
	</tr>
	
	<tr>
		<td>备注信息：</td>
		<td colspan="3">
		${user.userInfo.remark }
 		</td>
	</tr>
	
	

</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

