<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>文章  | 分类</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/editormd.preview.min.css">
<link rel="stylesheet" type="text/css" href="css/editormd-2.min.css">
<link rel="stylesheet" href="css/ioc.css" />
<link rel="stylesheet" type="text/css" href="./editor/layui/css/layui.css">
<style type="text/css">
			/* 类型头部: S */
			.type_head{
				position: fixed;
				width: 100%;
				top: 0px;
				z-index: 20;
				background: #fff;
				overflow: hidden;
				box-shadow: 5px 2px 5px #ccc;
			}
			.type_head .level-1{
				width:90%;
				margin:20px auto;
				
			}
			.type_head .level-2{
				width:90%;
				margin:0px auto 20px;
				padding:5px;	
				
			}
			.level{
				position: relative;
			}
			.level a::before{
			    position: absolute;
			    content: "";
			    top: 0; left: 0;
			    width: 0; height: 0;
			    border-width: 12px 12px 12px 0;
			    border-color: #fff transparent;
			    border-style: solid;
			}
			.level a{
				position: relative;
			    display: inline-block;
			    max-width: 100%;
			    height: 24px;
			    margin: 0 10px 5px 0;
			    line-height: 24px;
			    padding: 0 8px 0 18px;
			    border-radius: 0 4px 4px 0;
			    background: #eee;
			    font-size: 14px;
			    color: #333;
			    overflow: hidden;
			    text-overflow: ellipsis;
			    text-decoration: none;
			    white-space: nowrap;				
			}
			.level a::after{
			    position: absolute;
			    content: "";
			    width: 4px;
			    height: 4px;
			    top: 10px;
			    left: 8px;
			    border-radius: 100%;
			    background: #fff;
			}
			.level a:hover{
				transition: 0.5s;
				background-color:#333;
				color:#fff;
			}			
			/* 类型头部: E */			
			/* 文章  S */
			#main-box{
				position: absolute;
				top:260px;
				left: 0;
				width:100%;
				background:#f4f4f4;
			}
			#main-box .main-box-articleList{
				width:90%;
				height:auto;
				min-height: 600px;
				margin:20px auto 10px;
			}
			.type_articleall{
		 		width:313px;
				margin-top: 20px;
				transition: 0.5s;
			}
			.type_articleall:hover{
				margin-top:16px;
				box-shadow:2px 8px 10px #ccc;
			}
			
			.type_articleall img{
				width:313px;
				display: block;
			}
			
			.type_article{
				width:293px;
				padding:10px;
				background:#fff;
			}
			.type_article .type_article_title{
				text-align: center;
				margin-bottom: 10px;
				font-size: 1.2rem;
			}
			.type_article .type_article_title a{
			    font-size: 1rem;
			    text-decoration: none;
			    color: #000;
			}
			.type_article .type_article_title a:hover{
				color:#0366d6;
			}
			.type_article div{
				color:#888;
				font-size: 1rem;
			}
			.type_article div:before{
				float: left;
				content: "";
				width:20px;
				height:6px;
			}
			
			
			.type_bottom{
				padding:10px;
				background: #fbfbfb;
				border-top:1px solid #eee;
				overflow: hidden;
			}
			.type_bottom .tag{
				float: left;
			}
			.type_bottom .tag a{
				font-size:1rem;
				text-decoration: none;
				color:#333;
			}
			.type_bottom .tag a:hover{
				color:royalblue;
			}
			.type_bottom .time{
				float: right;
			}
			/* 文章  E */
			
			@media only screen and (max-width: 450px){
			    html {font-size: 16px;}	
			    .type_articleall img{
					width:100%;
			   }
			.level {
				margin: 8px auto;
			}
			.level a::before{
			   border-width: 9px 8px 12px 0;
			}
			.level a{
			    height: 20px;
			    line-height: 20px;
			    font-size: 12px;
			}
			.level a::after{
			    top: 9px;
			}
			   
			}
			@media only screen and (min-width: 640px){
				 html {font-size: 18px;}
			}
			@media only screen and (max-width: 750px){
			   .type_articleall img{
					margin:0 auto;	
			   }
				.type_article{
					width:90%;
					padding:10px;
					background: #fff;
				}
			}			
		</style>
	</head>
	<body style="background:#f4f4f4;">
		<header class="type_head">
			<!--  一级分类 -->
			<nav class="level-1 level">
					<a>一級</a>
				<c:forEach items="${requestScope.blogData.parentTypesList}" var="parentType">
					<a href="./article/article-type/1/${parentType.name}">${parentType.name}</a>
				</c:forEach>
			</nav>
			
			<nav class="level-2 level">
				<a href="">二級</a>
				<c:forEach items="${requestScope.blogData.childTypesList}" var="childType">
					<a href="./article/article-type/2/${childType.name}">${childType.name}</a>
				</c:forEach>
			</nav>
			
		</header>
		<div id="main-box">
			<section class="main-box-articleList">
				<c:forEach items="${requestScope.blogData.articlesList}" var="article">
					<div class="type_articleall layui-anim layui-anim-fadein">
						<c:if test="${not empty article.bgPath}">
							<img alt="" src="./poto/type_mg/${article.bgPath}">
						</c:if>
						<div class="type_article">
							<h3 class="type_article_title"><a href="./article/article-show/${article.id}">${article.title}</a></h3>
							<div class="editormd-preview-theme-dark">
								${article.subtitleHTML}
							</div>
						</div>
						<footer class="type_bottom">
								<div class="tag">
									Tags:
									<a href="#">${article.type}</a>
								</div>
								<div class="time"><fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd HH:mm"/> </div>
						</footer>
					</div>
				</c:forEach>
			</section>
		</div>
		
	<script type="text/javascript" src="js/jquery2.0.min.js"></script>	
	<script type="text/javascript" src="js/blog-type.js"></script>
	
	<script type="text/javascript">
		
	</script>
</html>