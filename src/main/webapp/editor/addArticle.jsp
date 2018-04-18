<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%
	String path = request.getContextPath();
	String basePath = path+"/editor/";
	%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加文章 | 后台管理</title>
<link rel="stylesheet" type="text/css" href="./layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="./css/manager.css">
<link rel="stylesheet" type="text/css" href="./css/editormd-2.min.css">
	<style type="text/css">

		.behind-main .behind-edit .page-title{
			margin-left:20px;
			font-size:20px;
			margin-bottom:20px;
			font-weight: bold;
		}
		.layui-form{
			width:90%;
		}
		.layui-form .editormd{
			 margin-left: 107px;
			 z-index: 1;
			 
		}
		.layui-form .editormd li{
			list-style: square;
		}
		.layui-form .upload-box{
		    display: inline-block;
		    height: 38px;
		    line-height: 38px;
		    padding: 0 11px;
		    background-color: #009688;
		    color: #fff;
		    text-align: center;
		    font-size: 14px;
		    border: none;
		    border-radius: 2px;
		    cursor: pointer;
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
					<h3 class="page-title">发布文章</h3>
					
					<form:form enctype="multipart/form-data" action="../manager-article/update-commit-article" method="post" class="layui-form" modelAttribute="article">
						  <input id="addarcle-id" type="hidden" name="id" value="${param._i}">
						  <input id="addarcle-author" type="hidden" name="author" value="${sessionScope['now-author'].nickname}">
						  <form:hidden path="bgPath"/>
						  <div class="layui-form-item">
						    <label class="layui-form-label">文本标题</label>
						    <div class="layui-input-block">
						      <form:input path="title" placeholder="请输入标题" autocomplete="off" class="layui-input" id="addartle-title" />
							 <!-- <div class="layui-form-mid layui-word-aux">文章标题</div> -->   
						    </div>
						  </div>
						 
						  <div class="layui-form-item">
						    <label class="layui-form-label">选择分类</label>
						    <div class="layui-input-block">
						      <form:select path="parentType" items="${requestScope.blogData.parentTypesList}" 
						      	itemLabel="name" itemValue="name" id="addartle-parentType" ></form:select>
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">选择标签</label>
						    <div class="layui-input-block">
						    <form:select path="type" items="${requestScope.blogData.childTypesList}" 
						      	itemLabel="name" itemValue="name" id="addartle-childType" ></form:select>
						    </div>
						  </div>
						  
						  <div class="layui-form-item layui-form-text">
						    <label class="layui-form-label">文章描述</label>
						    <div class="layui-input-block">
						      <form:textarea path="subtitleHTML" cssClass="layui-textarea" id="addartle-subtitle" />
						    </div>
						  </div>			  
						  
					      <div class="editormd" id="test-editormd">
						      <form:textarea class="editormd-markdown-textarea" path="contentMd" id="addartle-contentmd" ></form:textarea>
						      <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 name=test-editormd-html-code-->
							  <textarea id="addartle-contenthtml" name="contentHTML" style="display:none" ></textarea>
						   </div>
						  <div class="layui-form-item">
						    <div class="layui-input-block">
						      <div style="margin-bottom:20px">
							      <label>
							      	<input class="layui-article-file" type="file" name="pototitle" style="display:none;" />
							      	<div class="upload-box" id="upload-article-bg"><i class="layui-icon">&#xe67c;</i>上传图片</div>
							      </label>
							      <span class="layui-article-fileName"></span>
						      	  <div class="layui-form-mid layui-word-aux">文件大小最大2M & 仅支持图片</div>
						      </div>
						      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
						    </div>
						  </div>
					</form:form>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript" src="./js/jquery2.0.min.js"></script>
<script type="text/javascript" src="./js/editormd.min.js"></script>
<script type="text/javascript" src="./layui/layui.js"></script>
<script>

$(function() {
    
	//元素模块
	layui.use('element', function(){
		  var element = layui.element;
	});
	
	//表单模块
	layui.use("form",function(){
			var form = layui.form;
	});
	
	
	editormd("test-editormd", {
        width   : "90%",
        height  : 640,
        syncScrolling : "single",
        //lib目录的路径
        path    : "./lib/",
        //让构造出来的HTML代码直接在第二个隐藏的textarea域中，用与post提交。
       // saveHTMLToTextarea : false,
        previewTheme: "dark"
    });
    
	$(document).keyup(function(e){
		var str = $(".editormd-preview").html();
		$("#addartle-contenthtml").val(str);
	});
	
	$(".layui-article-file").change(function(e){
		var file = e.target.files[0];
		if(/^image\/\w{1,5}$/.test(file.type)){
			$(".layui-article-fileName").html(e.target.value);
			layer.msg('图片ok啦!');
		}else{
			e.target.value = null;
			layer.msg('图片不符合要求');
		
		}
	});
	
	if("${param.flag}" == "insert"){
		setTimeout(insertArticle , 10000);
	}
	setInterval(autoSave , 20000);
});

var article = {
		title:""
		,parentType:""
		,type:""
		,subtitleHTML:""	
		,contentHTML:""
		,contentMd:""
		,author:""
};
var mydata = {index:0};

var layer = null ;

function alertStyle() {
	
	//弹出窗
	layui.use('layer', function(){
		 layer = layui.layer;
	});
}

/*
 *获取必要的数据 , 通过ajax 传递到后台 
 */
function initData() {
	article.title = $("#addartle-title").val();
	article.parentType = $("#addartle-parentType").val();
	article.type = $("#addartle-childType").val();
	article.subtitleHTML = $("#addartle-subtitle").val();
	article.contentHTML = $("#addartle-contenthtml").val();
	article.contentMd = $("#addartle-contentmd").val();
	article.author = $("#addarcle-author").val();
}

/* 第一次插入记录 , 返回文章id 为后面的文章 */
function insertArticle() {
	//初始化数据
	initData();
	//发送ajax请求
	$.post("<%=path%>/manager-article/add-article" , article , function(data){
		$("#addarcle-id").val(data);
	});
}
//flag不能为null  需要有id 参数当中
function autoSave() {
	//初始化数据
	initData();
	var id = $("#addarcle-id").val(); //获取id
	mydata.index++;
	//保存成功返回 大于零的数 , 若为零或小于零则是没有保存未成功
	$.post("<%=path%>/manager-article/autoSave?_i=" + id + "&flag=updata" , article , function(data){
		if(data > 0) {
			layer.msg("30秒自动保存次数:"+mydata.index,{
				offset: 'r',
				offset: 'b'
			});			
		}else{
			layer.msg("保存失败",{
				offset: 'r',
				offset: 'b'
			});	
		}
	});
}




</script>
</html>