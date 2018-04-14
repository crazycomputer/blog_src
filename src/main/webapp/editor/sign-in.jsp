<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "editor/";
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="./layui/css/layui.css">
<style type="text/css">
*{margin:0; padding:0; }
			body{
				font: 16px Helvetica Neue,Helvetica,PingFang SC,\5FAE\8F6F\96C5\9ED1,Tahoma,Arial,sans-serif;
				position:relative;
				background:url("./images/web_login_bg.jpg") no-repeat ;
				background-size: cover;
			}
			#login{
				position:absolute;
				top: 0;  bottom: 0;  left: 0; right:0; 
				margin:auto;
				width: 430px; height: 345px;
				background: rgba(255,255,255,0.5);
				border-radius:5px;
			}
			#login::before{
				content:" ";
				display:block;
				width:260px; height:68px;
				margin:10px auto;
			}
			#login-form{
				width:350px;
				margin:0 auto;
			}
			#login .form-in {
				padding:8px;
				width:260px; height:20px;
				background:rgba(255,255,255,0);
				font-size: 16px;
				border:none;
				border-bottom: 1px solid #949494;
				outline:none;
				margin-bottom:5px;
			}
			#login #submit{
				width:346px; height:40px;
				font-size:18px;
				border:none;
				background:#00a3ee;
				color:white;
				margin:25px 0px 5px 0px;
				outline: none;
				cursor:pointer;
			}
			#login .sign-up{
				float:right;
				margin-right:42px;
			}
			#login .sign-up a{
				text-decoration:none;
				color:#616161;
			}
			#login .sign-up a:hover{
				color:#00a3ee;
			}
</style>
</head>
<% 
	Object obj = request.getSession().getAttribute("now-author");
	if(obj != null) {  //若已经登录  , 重定向到后台页面
		response.sendRedirect(path+"/author/author-data");
	}
	
%>
	<body style="width: 100%; height: 100vh;">
		<div id="login">
			<form id="login-form" method="post" action="javascript:void(0)" onsubmit="return verify()">
				<table class="tab-form" >
					<tr>
						<td style="text-align:right;">用户名：</td>
						<td><input class="form-in"  placeholder="输入用户账号"  type="text" name="account" ></td>
					</tr>
					<tr>
						<td style="text-align:right;">密码：</td>
						<td><input class="form-in" placeholder="输入用户密码" type="password" name="hash" ></td>
					</tr>
				</table>
				<input type="submit" id="submit"  value="登 录" />
			</form>
			<div class="sign-up">
				<a href="">立刻注册</a> <!-- 添加注释 -->
			</div>
		</div>
	</body>
	<script type="text/javascript" src="./layui/layui.js"></script>
	<script type="text/javascript" src="./js/jquery2.0.min.js"></script>
	<script type="text/javascript">
		var layer = null;
		
		//弹出窗
		layui.use('layer', function(){
			 layer = layui.layer;
		});
		
		function verify() {
			var oIns = document.getElementsByTagName("input");
			var userName = oIns[0].value , pass = oIns[1].value;
			if(userName == "" || pass == "") {
				//layer.msg('图片不符合要求');
				layer.msg('账号密码不能为空...^_^');
				return false;
			}
			send(userName , pass);
			return false;
		}
		
		function send(userName , pass) {
			$.post("<%=path%>author/laici-go" ,{account:userName,hash:pass} , function(resultStr){
				console.log(resultStr);
				layer.msg(resultStr);
				
				if(resultStr == "登录成功"){
					setTimeout(function(){
						window.location = "<%=path%>author/author-data";
					} , 1000);
				}
				
			});
		}
		
		
	</script>
</html>