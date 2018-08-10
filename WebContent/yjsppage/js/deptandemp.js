//定义对象
var xmlHttp;
//定义函数存储当前页面上选择过后的员工的信息
var myempidarr=new Array();
var index=0;
//获得XMLHttpRequest对象
function  getXMLHttpRequest() {
	 try{
	   // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	    }catch (e){// Internet Explorer
	   try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	      }catch (e){
	     try{
	         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	         }catch (e){
	         alert("您的浏览器不支持AJAX！");
	         return false;
	         }
	      }
	    }
}

//清空所有的员工信息
function clearAllEmps() {
	//获得lsel对象
	var lselobj=document.getElementById("selEmployees");
	//获取所有的options
	var loptions=lselobj.getElementsByTagName("option");
	//循环
	for(var i=0;i<loptions.length;){
		//移除数据
		lselobj.removeChild(loptions[0]);
	}
	
}

//显示所有的员工信息
function showEmployees() {
	//获得ajax的对象
	getXMLHttpRequest();
	//根据请求状态执行的功能
    xmlHttp.onreadystatechange=function (){
    	//清空所有的员工
    	clearAllEmps();
    	//请求状态
    	if(xmlHttp.readyState==4){
    		   //拿到数据
    		   var mydata=xmlHttp.responseText;
    		   //截取数据
    		   var subdata=mydata.substring(1,mydata.length-1);
    		   if(subdata.length>1){
    			 //将数据转化成数据
    			 var emparrs=subdata.split(",");    			 
    		   //创建option节点
    		    addemptooption(emparrs);
    		   }
        }
    }
    	//获得部门id通过对象获取数据
    	var did=document.getElementById("selDepartments").value;
    	//请求操作 发送
    	xmlHttp.open("GET","AjaxEmpsServlet?deptid="+did,true);
    	xmlHttp.send(null);
}

//添加节点
function addemptooption(emparrs) {
	//获的对象
	var leftempsel=document.getElementById("selEmployees");
	//遍历数组
	for(var i=0;i<emparrs.length;i++){
		//获得每一条数据
		var myempdata=emparrs[i].split("=");
		//判断数据是否在数组中
		var flag=checkpemp(myempdata[0]);
		//判断
		if(flag){
		//创建节点
		var noption=document.createElement("option");
		//添加属性
		noption.setAttribute("value", myempdata[0]);
		//创建文本节点
		var ntxt=document.createTextNode(myempdata[1]);
		//添加子节点
		noption.appendChild(ntxt);
		leftempsel.appendChild(noption);
		}
	}
}

//使用数组监控不能重复
function  checkpemp(myempid) {
	var flag=true;
	//循环判断
	for(var i=0;i<myempidarr.length;i++){
		//判断
		if(myempidarr[i]==myempid){
			//移动过了
			flag=false;
			break;
		}	
	}
	return flag;
}

//点击移动的js方法
function myremove(){
	//获得两个对象
	var lsel=document.getElementById("selEmployees");
	var rsel=document.getElementById("selSelectedEmployees");
  //获取左边所有的option
	var loptions=lsel.getElementsByTagName("option");
	//循环遍历
	for(var i=0;i<loptions.length;i++){
		//判断选中
		if(loptions[i].selected){
			//将值添加到数组
			myempidarr[index]=loptions[i].value;
			index++;
			//移到右边
			rsel.appendChild(loptions[i]);
		}
	}
}
