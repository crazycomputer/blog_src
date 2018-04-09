<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/loading.css" />
<link rel="stylesheet" href="css/ioc.css" />
<link rel="stylesheet" href="css/blog-top-index.css" />
<link rel="stylesheet" href="css/right.css" />
<link rel="stylesheet" type="text/css" href="css/editormd.preview.min.css">
<link rel="stylesheet" type="text/css" href="css/editormd-2.min.css">
	    
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
			}
			.alert{
				font-size:20px;
			}
	    </style>
		
		<link rel="stylesheet" type="text/css" href="css/blog-index-css.css"/>
		
		<style type="text/css">
			@media only screen and (max-width: 1070px){
					.main .content-all {
					    width: 87%;
					    padding: 4%;
					    margin: 0 auto;
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
	
	<script src="js/jquery2.0.min.js"></script>
	<script type="text/javascript" src="js/loading.js"></script>
</html>