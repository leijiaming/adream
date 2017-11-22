function userCheck(){
		if($("#user").val()==""){
		login_message.innerHTML = '<div class="alert alert-danger fade in m-b-15"><strong>用户名不能为空！！！</strong><span data-dismiss="alert" class="close">×</span></div>'; 
			//$("#user").focus();
			return false;
		}else{
			login_message.innerHTML = ""; 
			return true;
		}
	}
	function passwordCheck(){
		if($("#password").val()==""){
			//$("#password").focus();
			login_message.innerHTML = '<div class="alert alert-danger fade in m-b-15"><strong>密码不能为空！！！</strong><span data-dismiss="alert" class="close">×</span></div>';
			return false; 
		}else{
			login_message.innerHTML = ""; 
			return true;
		}
	}
	window.onload=function(){
	$("#loginCC").click(function(){
		var username=$("#user").val();
		var password=$("#password").val();
		if(userCheck()==true&&passwordCheck()==true){
			$("#loginCC").html("登陆中......");
		var s=document.getElementById("loginCC");//.innerHtml="新按钮"
		s.value="xinanniu";
		$.ajax({
        url:"login.do",
		type:"post", 
		async: false, 
        data:{"username":$("#user").val(),"password":$("#password").val()},
        dataType:"json",
        success:function(msg){
	        window.location="main.do";
	     },
         error: function(XMLHttpRequest, textStatus, errorThrown) {
         $("#loginCC").html("登陆");
 				login_message.innerHTML='<div class="alert alert-danger fade in m-b-15"><strong>登录失败！账号密码不匹配！！！</strong><span data-dismiss="alert" class="close">×</span></div>';
				/* alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);//error */
 		  },
});
		}else{
		login_message.innerHTML='<div class="alert alert-danger fade in m-b-15"><strong>账号密码不能为空！！！</strong><span data-dismiss="alert" class="close">×</span></div>';
		}
	});
	
	};