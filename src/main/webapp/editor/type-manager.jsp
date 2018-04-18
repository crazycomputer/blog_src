<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	String path = request.getContextPath();
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
<style type="text/css">
	.behind-edit{
		
	}
	
	.behind-edit .parent{
		margin:40px 20px 0px;
	}
	.behind-edit .child{
		margin:40px 20px 0px;
	}	
	
	
	.behind-edit .layui-btn{
		padding-left:10px;
		padding-right:0px;
	}
	.behind-edit .layui-btn .layui-icon{
		margin-left:10px;
		transition: 0.4s;
	}
	
	.behind-edit .layui-btn .layui-icon:hover{
		background:red;
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
					<ul>
						<li class="parent">
							<div class="layui-btn-container">
								<c:forEach items="${requestScope.parentTypes}" var="type">
								  <button class="layui-btn boybtn" name="${type.name}">${type.name}<i class="layui-icon boyicon">&#x1006;</i></button>							
								</c:forEach>
							</div>
						</li>
						<li class="child">
							<div class="layui-btn-container child-box">
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript" src="<%=path%>/editor/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>/editor/js/jquery2.0.min.js"></script>

<script type="text/javascript">
//元素模块
layui.use('element', function(){
	  var element = layui.element;
});

	$(".layui-btn-container .boyicon").click(function(){
		
		if(confirm("确定要删除吗?")) {
			//$(this).parent().remove();
			
		}
		return false;
	});
	
	$(".layui-btn-container .boybtn").click(function() {
		var params = {parentName:this.name};
		var box = $(".child .child-box");
		var childObj = null;
		$.get("<%=path%>/manager-article/childs-ParentName",
				params , function(data){
			//每次请求前都先将其清空
			box.empty();
			
			for(var i =0; i<data.length; i++){
				childObj = $("<button class='layui-btn boybtn layui-btn-sm layui-btn-normal'>"+ data[i].name +" <i class='layui-icon boyicon'>&#x1006;</i></button>")
				box.append(childObj);
			}			
		});
	});

</script>
</html>