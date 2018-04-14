<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	//String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			//+ path;
	 String basePath = path+"/"+"editor/";
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/editor/css/manager.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/editor/layui/css/layui.css">
</head>
<body>
		<div class="behind-main">
			<jsp:include page="./editor-component/editor-left.jsp"></jsp:include>
			<div class="behind-right">
				<div class="behind-right-header">
					<jsp:include page="./editor-component/header-author.jsp"></jsp:include>
				</div>
				<div class="behind-edit">
					分类管理
				</div>
			</div>
		</div>
</body>
<script type="text/javascript" src="<%=path%>/editor/layui/layui.js"></script>
<script type="text/javascript">
//元素模块
layui.use('element', function(){
	  var element = layui.element;
});
</script>
</html>