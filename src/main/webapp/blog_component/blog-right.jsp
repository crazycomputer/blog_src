<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 右侧功能  S -->
<div class="right-model">
	
	<!-- 搜索    S  -->
	<div class="search box-sdown">
		<input type="text" name="search-val" id="input-search" placeholder="搜索" />
		<div class="search-but"><i class="iconfont sear-ico">&#xe6ac;</i></div>
	</div>
	<!-- 搜索    E  -->			
	
	<!-- 近期文章    S  -->
	<div class="recent box-sdown">
		<h5 class="recent-title title">热门文章</h5>
		<ul class="recent-ul">		
			<c:forEach items="${requestScope.blogData.articleBrowse}" var="articleB">
				<li><a href="./article/article-show/${articleB.id}">${articleB.title}</a></li>			
			</c:forEach>
		</ul>
	</div>
	<!-- 近期文章    E  -->
	
	
	<!-- 音乐    S  -->
	<div class="music box-sdown">
		<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width="100%" height="100%" src="http://music.163.com/outchain/player?type=0&id=2146709262&auto=0&height=430"></iframe>
	</div>
	<!-- 音乐    E  -->
	
	<!-- 标签    S  -->
	<div class="my-labels box-sdown">
		<h5 class="my-labels-title title">标签</h5>
		<div class="lab">
				<c:forEach items="${requestScope.blogData.childTypesList}" var="childType">
					<a href="./article/article-type/2/${childType.name}">${childType.name}</a>
				</c:forEach>
		</div>
	</div>
	<!-- 标签    E  -->
</div>
<!-- 右侧功能  E -->