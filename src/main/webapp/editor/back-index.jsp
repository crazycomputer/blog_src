<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String path = request.getContextPath();
	String basePath = path + "/editor/";
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页  |	后台管理 </title>
<link rel="stylesheet" type="text/css" href="./css/manager.css">
<link rel="stylesheet" type="text/css" href="./layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/ioc.css">
<style type="text/css">
	.behind-edit{
		
	
	}
	.behind-edit .article-box{	
		border-radius: 12px;
    	padding: 10px;
    	color:#fff;
	}
	
	.behind-edit .myioc{
		font-size:42px;		
	} 
	.behind-edit .article-box{
		font-size:20px;
	}
	
	

	.behind-edit .article-data-box{
		width:400px;
		margin:30px auto 0px;
	}
	
	.behind-edit .article-count{
		width:400px;
		height:100px; 
		margin-bottom:40px;
		background-color:#29b6f6;
	}
	.behind-edit .article-message{
		width:400px;
		height:100px;
		background-color:#7e57c2;
	}
	

</style>
</head>
<body>
		<div class="behind-main">
			<jsp:include page="./editor-component/editor-left.jsp"></jsp:include>
			<div class="behind-right">
				<div class="behind-right-header">
					<jsp:include page="./editor-component/header-author.jsp"></jsp:include>
				</div>
				<div class="behind-edit">
					<div class="article-data-box">
						<div class="article-count article-box">
							<i class="iconfont myioc ioc1">&#xe659;</i>
							<div>发表了<span>0</span>篇文章</div>
						</div>
						<div class="article-message article-box">
							<i class="iconfont myioc ioc2">&#xe6fe;</i>
							<div>收到留言<span>0</span>条</div>			
						</div>					
					</div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript" src="./layui/layui.js"></script>
<script type="text/javascript">
//元素模块
layui.use('element', function(){
	  var element = layui.element;
});
</script>
</html>