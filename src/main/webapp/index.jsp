<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>boy Hu | ^_^</title>

	<link rel="stylesheet" href="css/loading.css" />
		<style type="text/css">

			
			*{margin:0;padding: 0;}
			#container{
					
					font-size: 0.9rem;
					height: 100vh;
					background: url(img/muntime-img2.jpg) no-repeat;
					background-size: cover;
			}
			#container .mytitle{
				margin-top: 3%;
				text-align: center;
				font-size: 1.2rem;
				color:white;
			}
			.info{
				position: absolute;
				top:0px; left:0px; bottom: 0px; right: 0px;
				width:40%;
				margin: auto;
				height:40%;
			}
			.info .portralt{
				width:100px;
				height:100px;
				border-radius: 50%;
				background: url(img/logo.jpg) no-repeat;
				background-size: cover;
				margin: 0 auto;
			}
			.info .desc{
				text-align: center;
				margin-top: 3%;
				font-size: 0.7rem;
				color:#fff;
			}
			.info .info-but{
				overflow: hidden;
				width:392px;
				text-align: center;
				margin: 5% auto;
			}
			.info .info-but .but-a{
					width: 140px;
					text-align: center;
					border: 1px solid #00a3ee;
					background: #00a3ee;
					padding: 1%;
					border-radius: 5%;
					font-size: 0.6rem;
					text-decoration: none;
					color: white;
			}
			.info .info-but .github{
					float: left;
					margin-left: 5%;
			}
			.info .info-but .blog{
					float: right;
					margin-right: 5%;
			}
		</style>
<link rel="stylesheet" type="text/css" href="css/model.css" />
  </head>
  <body>
			<jsp:include page="./blog_component/locaing.jsp"></jsp:include>
			<div id="container">
				<main class="info">
					<div class="portralt"></div>
					<!-- 作者 -->
					<h1 class="mytitle">author</h1>
					<!-- 每一描述   -->
					<div class="desc">desc</div>
					<!--  -->
					<div class="info-but">
						<a href="https://github.com/BoyMi" class="github but-a">Github</a>
						<a href="./article/article-list" class="blog but-a">我的博客</a>
					</div>
					
				</main>
			</div>
  </body>
    <script src="js/jquery2.0.min.js"></script>
    
    <script type="text/javascript" src="js/loading.js"></script>
</html>