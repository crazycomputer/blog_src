<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="behind-left">
	<div class="behind-left-logo">
					
	</div>
	<ul class="beind-menu layui-nav layui-nav-tree " lay-filter="test">
	  <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/author/author-data"><i class="iocfont">&#xe608;</i>活动数据</a></li>
	  <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/manager-article/show-form?flag=insert" target="_blank"><i class="iocfont">&#xe659;</i>文章发布</a></li>

	  <li class="layui-nav-item">
	    <a><i class="iocfont">&#xe7c0;</i>管理</a>
	    <dl class="layui-nav-child">
	      <dd><a href="<%=request.getContextPath()%>/manager-article/article-tab" target="_blank">文章管理</a></dd>
	      <c:if test="${sessionScope['now-author'].level == 2}">
	      	<dd><a href="<%=request.getContextPath()%>/manager-article/type-tab">分类管理</a></dd>
	      </c:if>
	      <!--  <dd><a href="<%=request.getContextPath()%>/manager-article/draft">草稿管理</a></dd>-->
	    </dl>
	  </li>
	  <li class="layui-nav-item">
	    <a>解决方案</a>
	    <dl class="layui-nav-child">
	      <dd><a href="">移动模块</a></dd>
	      <dd><a href="">后台模版</a></dd>
	      <dd><a href="">电商平台</a></dd>
	    </dl>
	  </li>
	  <li class="layui-nav-item"><a href="#"><i class="iocfont">&#xe659;</i>网站设置</a></li>
	</ul>
</div>