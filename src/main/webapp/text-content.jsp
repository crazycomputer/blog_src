<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	String path = request.getContextPath();
	String basePath = path + "/";
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<%=path%>/css/loading.css" />
<link rel="stylesheet" href="<%=path%>/css/ioc.css" />
<link rel="stylesheet" href="<%=path%>/css/blog-top-index.css" />
<link rel="stylesheet" href="<%=path%>/css/right.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/editormd.preview.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/editormd-2.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bottom-css.css">

	    <style type="text/css">
	    	*{margin:0; padding:0;}
	    	
	    	.main{
				width:94%;
				margin: 4% auto;
				overflow: hidden;
			}
			.main .content-all{
				float: left;
				width: 64%;
				height:100%;
				margin-left: 6%;
				padding: 1%;
				background: #fff;
				border-radius: 8px;
			}
			.alert{
				font-size:20px;
			}
	    </style>
		
		<link rel="stylesheet" type="text/css" href="css/blog-index-css.css"/>
		
		<style type="text/css">
			@media only screen and (max-width: 1070px){
					.main .content-all {
						float:none;
					    width: 87%;
					    padding: 2.3%;
					    margin: 0 auto 20px;
					    background:#fff;
					}
				}
		</style>
	</head>
	<body style="background: #f5f8f9;">
		<!-- 加载.... -->
		<jsp:include page="./blog_component/locaing.jsp"></jsp:include>
		
		<!-- 头部 -->
		<jsp:include page="./blog_component/blog-top.jsp"></jsp:include>
		
		<!-- 内容主体部分   S -->
		<div class="main">
			<div class="content-all editormd-preview-theme-dark" id="content">
				<c:if test="${empty requestScope.blogData.article}"><div class="alert">没有找到文章!</div></c:if>
				
				<c:if test="${not empty requestScope.blogData.article}">${requestScope.blogData.article.contentHTML}</c:if>
			</div>
			
			<!-- 右侧部分 -->
			<jsp:include page="./blog_component/blog-right.jsp" />			
		</div>
		<!-- 内容主体部分  E -->
		
		<jsp:include page="./blog_component/blog-bottom.jsp"></jsp:include>
	</body>
	
	<script type="text/javascript"  src="<%=path%>/js/jquery2.0.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/loading.js"></script>
	<script type="text/javascript">
		$(".markdown-body").attr("style","padding:0px");
	</script>
</html>