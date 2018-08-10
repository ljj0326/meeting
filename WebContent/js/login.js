//登陆操作的方法
function mylogin() {
	//获得input框中的数据
	var umobj=document.getElementById("input_um");
	var upobj=document.getElementById("input_up");
	var fomobj=document.getElementById("myform");//form对象
	//获得输入框中输入的数据
	var umval=umobj.value;
	var upval=upobj.value;
	//判断
	if(umval==null||umval==""){
		alert("账号不能为空！");
	}else if(upval==null||upval==""){
		alert("密码不能为空！");
	}else{
		//使用form对象调用其提交的方法提交表单
		fomobj.submit();
	}
	
}