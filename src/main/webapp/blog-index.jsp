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
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/ioc.css" />
<link rel="stylesheet" href="css/loading.css" />
<link rel="stylesheet" href="css/blog-top-index.css" />
<link rel="stylesheet" type="text/css" href="css/editormd.preview.min.css">
<link rel="stylesheet" type="text/css" href="css/editormd-2.min.css">
		<style type="text/css">
			*{margin: 0; padding: 0;}
			/* main  S */

			.main{
				width:94%;
				margin: 4% auto;
				overflow: hidden;
				
			}
			/* 文章 部分  S */
			.main .content-all{
				float: left;
				width: 64%;
				height:100%;
				margin-left: 6%;
				padding: 1%;
			}
			.main .content-all .con{
				width:92%;
				overflow: hidden;
				background: #fff;
				margin:20px auto; 
				list-style: none;
				box-shadow: 2px 5px 5px #eee;
			}
			.main .con .con-box{
				width: 96%;
				margin:0 auto;
			}
			
			/* 文章 头部 */
			.main .con-box .con-head{
				width:100%;
				padding:1% 0px;
				text-align: center;
				border-bottom: 1px solid #ccc;
			}
			.main .con-box .con-head h3:hover{
				cursor: pointer;
			}
			.main .con-box .con-head div{
				font-size: 0.6rem;
			}
			.main .con-box .con-head div a{ 
				color:#9c9d9b;				
			}
			
			.main .con-head h3 a{
				font-size:1rem;
				text-decoration:none;
				color: #000;
			}
			.main .con-head h3 a:hover{
				color:#0366d6;
			}
			.main .con-head div a{
				text-decoration:none;
				color: #000;
			}
			
			.main .con-head div i{
				font-size: 0.6rem;
			}
			.main .con-box .con-desc{
				width:100%;
				padding:2% 0px;
				font-size: 0.8rem;
			}

			.main .con-box .con-footer{
				width:100%;
				padding:2% 0px;
				font-size: 0.7rem;
				
			}
			.main .con-footer{
				color:#9c9d9b;
			}
			.main .con-footer a{
				font-size: 0.6rem;
				color:#9c9d9b;
				text-decoration: none;
				margin-right: 1%;
				vertical-align: text-top;
			}
			.main .con-footer a:hover{
				color:#0366d6;
				text-decoration:underline;
			}
			.main .con-footer i{
				font-size: 0.7rem;
			}
			/* ------------------ */
			
			/*加载更多*/
			#click-article{
				font-size:0.8rem;
				padding:10px 0px;
				color:#fff;
				text-align:center;
				background-color:#66a3ff;
				cursor:pointer;
				transition:0.4s;
			}
			#click-article:hover{
				background-color:#3385ff;				
			}
			/* 文章 部分 E */
		</style>

		<link rel="stylesheet" type="text/css" href="css/right.css" />
		<link rel="stylesheet" type="text/css" href="css/blog-index-css.css"/>
</head>
<body style="background: #f5f8f9;">


		
		<jsp:include page="./blog_component/locaing.jsp"></jsp:include>
		<jsp:include page="./blog_component/blog-top.jsp"></jsp:include>
		
		<!-- 内容主体部分   S -->
		<div class="main">
			
			<!-- 文章   S -->
			<ul class="content-all">
				<c:if test="${not empty requestScope.blogData}">
					<c:forEach items="${requestScope.blogData.page.list}" var="article">
						<li class="con">
							<div class="con-box">
								<header class="con-head">
									<h3><a href="./article/article-show/${article.id}">${article.title}</a></h3>
									<div>
										<a href="#">作者:${article.author}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="#"><i class="iconfont">&#xe608;</i>:&nbsp;${article.parentType }</a>
									</div>
								</header>
								<div class="con-desc editormd-preview-theme-dark">
									${article.subtitleHTML}
								</div>
								<div class="con-footer">
									<i class="iconfont">&#xe637;</i>&nbsp;  <fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<i class="iconfont">&#xe62a;</i>
									<a href="#">${article.type}</a>
									<i class="iconfont">&#xe640;</i>
									<a>${article.browse}</a>
									<i class="iconfont">&#xe643;</i>
									<a>${article.like}</a>
								</div>
							</div>
						</li>
					</c:forEach>
					<li id="click-article" class="con">点击加载</li>
				</c:if>
				<li id="test" class="con" style="list-style:none;display:none;">
					<div class="con-box">
						<header class="con-head">
							
						</header>
						<div class="con-desc editormd-preview-theme-dark">
							
						</div>
						<div class="con-footer">
							
						</div>
					</div>
				</li>
			</ul>
			<!-- 文章 E -->
			

		
		
		<jsp:include page="./blog_component/blog-right.jsp" />
		</div>
		<!-- 主体内容   E -->

<jsp:include page="./blog_component/blog-bottom.jsp"></jsp:include>
</body>
    <script src="js/jquery2.0.min.js"></script>
	<script type="text/javascript" src="js/loading.js"></script>
	<script type="text/javascript">
	
	
	window.onload = function() {
		$(".markdown-body").attr("style","padding:0px");

		var pageNo = 2;
		
		$("#click-article").click(function(){
			
			$.get("./article/article-list-ajax?pageNo="+pageNo,function(data){
				createAricles(data);
				pageNo++;
				if(!data.isHasNext){
					$("#click-article").hide();
				}
			},"JSON");
		});
	}
	function createAricles(data) {
		var listArticle = data.list;
		
		var con_head = $("#test .con-head");
		var oMdBox = $("#test .con-desc");
		var footer = $("#test .con-footer");
		
		for(var i = 0 ;i<listArticle.length; i++) {
			con_head.empty();
			oMdBox.empty();
			footer.empty();
			
			
			/*
			
				<i class="iconfont">&#xe640;</i><a href="">${article.browse}</a><i class="iconfont">&#xe643;</i><a href="">${article.like}</a>
			
			*/
			var oH3 = $("<h3></h3>").html("<a href='./article/article-show/"+ listArticle[i].id +"'>"+ listArticle[i].title +"</a>");
			var oDiv_author = $("<div></div>").html("<a href='#'>作者:"+ listArticle[i].author +"</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#'><i class='iconfont'>&#xe608;</i>:&nbsp;"+ listArticle[i].parentType +"</a>");
			
			con_head.append(oH3).append(oDiv_author);
			
			oMdBox.html(listArticle[i].subtitleHTML);
			
			footer.html("<i class='iconfont'>&#xe637;</i>&nbsp;"+ formatDate(listArticle[i].createDate) +"&nbsp;&nbsp;&nbsp;&nbsp;<i class='iconfont'>&#xe62a;</i>&nbsp;<a href='#'>"+ listArticle[i].type +"</a>&nbsp;&nbsp;&nbsp;&nbsp;<i class='iconfont'>&#xe640;</i>&nbsp;<a>" + listArticle[i].browse + "</a>&nbsp;&nbsp;&nbsp;&nbsp;<i class='iconfont'>&#xe643;</i>&nbsp;<a>" + listArticle[i].like + "</a>");
			
			var cloneLi = $("#test").clone();
			
			cloneLi.removeAttr("id");
			cloneLi.removeAttr("style");
			
			$("#click-article").before(cloneLi);
		}
		$(".markdown-body").attr("style","padding:0px");
		
		
	}
	
	function formatDate(dateTime) {
		console.log(dateTime);		
		var date = new Date(parseInt(dateTime));
		//年
		var year = date.getFullYear() + "-";
		//月
		var month = parseInt(date.getMonth() + 1);
		month = formatNum(month , "-");
		//日
		var day = date.getDate();
		day = formatNum(parseInt(day)," ");
		//时
		var hours = date.getHours();
		hours = formatNum(parseInt(hours) , ":");
		//分
		var minutes = date.getMinutes();
		minutes = formatNum(parseInt(minutes), "");
		//秒
		//var seconds = date.getSeconds();
		//seconds = formatNum(parseInt(seconds) , "");
		
		return year+month+day+hours+minutes;
	}
	
	/*
		num: 需要在前面加 0 的数字
		flag: 链接符
	*/
	function formatNum(num , flag) {
		console.log(flag);
		if(num < 10){
			num = "0" + num + flag;
		}else{
			num = num + flag;
		}
		return num;
	}
	


	
	
	
		
	</script>
</html>