<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	//String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	//+ path;
	String basePath = path + "/" + "editor/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/editor/css/manager.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/editor/layui/css/layui.css">
</head>
<body>
	<div class="behind-main">
		<jsp:include page="./editor-component/editor-left.jsp"></jsp:include>
		<div class="behind-right">
			<div class="behind-right-header">
				<jsp:include page="./editor-component/header-author.jsp"></jsp:include>
			</div>
			<div class="behind-edit">
				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="100">
						<col width="100">
						<col width="60">
						<col width="60">
						<col width="60">
						<col width="60"> 
						<col width="100">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>标题</th>
							<th>作者</th>
							<th>创建时间</th>
							<th>分类</th>
							<th>浏览</th>
							<th>评论</th>
							<th>文章状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty requestScope.blogData.articlesList}">
							<c:forEach items="${requestScope.blogData.articlesList}" var="article">
								<tr>
									<td>${article.title}</td>
									<td>${article.author}</td>
									<td><fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
									<td>${article.parentType}</td>
									<td>${article.browse}</td>
									<td>0</td>
									<td>
										<c:if test="${article.articleType == 2}">
											<span style="color:#66a3ff;">已发布</span>
										</c:if>
										<c:if test="${article.articleType != 2}">
											<span style="color:red;">草稿</span>
										</c:if>
									</td>
									<td>
										<div class="layui-btn-group">
											<a href="<%=path%>/manager-article/show-form?_i=${article.id}&flag=modify" class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
												<i class="layui-icon">&#xe642;</i>
											</a>
											<button class="layui-btn layui-btn-primary layui-btn-sm" title="删除">
												<i class="layui-icon">&#xe640;</i>
											</button>
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<c:if test="${empty requestScope.blogData.articlesList}">还没有发表过文章</c:if>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=path%>/editor/layui/layui.js"></script>
<script type="text/javascript">
	//元素模块
	layui.use('element', function() {
		var element = layui.element;
	});
</script>
</html>