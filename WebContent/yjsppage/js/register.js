function registercheck(){
	//获得所有输入框的对象
	var umobj=document.getElementById("employeename");
	var accobj=document.getElementById("accountname");
	var paobj=document.getElementById("password");
	var paconobj=document.getElementById("confirm");
	var phoneobj=document.getElementById("phone");
	var emailobj=document.getElementById("email");
	//var remarkobj=document.getElementById("remark");
	var formobj=document.getElementById("regform");
	//获得值
	var umva=umobj.value;
	var accva=accobj.value;
	var pava=paobj.value;
	var paconva=paconobj.value;
	var phoneva=phoneobj.value;
	var emailva=emailobj.value;
    var reg=new RegExp(/^(\w*)@(\w{2,3})(\.)(\w{2,3})$/);	

	//非空判断
	if(umva==null||umva==""){
		alert("用户名不能为空");
	}else if(accva==null||accva==""){
		alert("账号不能为空");
	}else if(pava==null||pava==""){
		alert("密码不能为空");
	}else if(paconva==null||paconva==""){
		alert("确认密码不能为空");
	}else if(phoneva==null||phoneva==""){
		alert("电话不能为空");
	}else if(emailva==null||emailva==""){
		alert("邮件不能为空");
	}else if(pava.length<6){
		alert("密码长度不合法！");
	}else if(pava!=paconva){
		alert("密码与确认密码必须相同!");
	}else if(!reg.test(emailva)){
		alert("邮箱格式不正确");
	}
    else{
		//提交表单
		formobj.submit();
	}
	
	
}