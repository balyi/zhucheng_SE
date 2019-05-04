function checkForm(){
	var res1=checkNull("username", "用户名不能为空");
	var res2=checkNull("name", "昵称不能为空");
	var res3=checkNull("password", "密码不能为空");
	var res4=checkNull("password2", "确认密码不能为空");
	var res5=checkNull("email", "邮箱不能为空");
	var res6=checkPassword("password", "两次密码不一致");
	var res7=checkEmail("email", "邮箱格式不正确");
	var res8=checkNull("telephone", "电话不能为空");
	return res1 && res2 && res3 && res4 && res5 && res6 && res7&&res8;
}

function checkEmail(name,msg){
	var email=$("input[name='"+name+"']").val().trim();
	var regExp=/^\w+@\w+(\.[a-z]+)+$/;
	setMsg(name,"");
	checkNull("email", "邮箱不能为空");
	if(email!=""&& !regExp.test(email)){
		setMsg(name,msg);
		return false;
	}
	return true;
}

function checkPassword(name,msg){
	var psw1=$("input[name='"+name+"']").val().trim();
	var psw2=$("input[name='"+name+"2']").val().trim();
//	setMsg(name,"");
	checkNull("password2", "确认密码不能为空");
	if(psw1!=""&&psw2!=""&&psw1!=psw2){
		setMsg(name+"2",msg);
		return false;
	}
	return true;
}

function checkNull(name,msg){
	var value=$("input[name='"+name+"']").val().trim();
	setMsg(name,"");
	if(value==""){
		setMsg(name,msg);
		return false;
	}
	return true;
}

function setMsg(name,msg){
	var $oInp=$("input[name="+name+"]");
	var $oSpan=$oInp.nextAll("span");
	$oSpan.html(msg);
	$oSpan.css({color:"#FFF"});
}