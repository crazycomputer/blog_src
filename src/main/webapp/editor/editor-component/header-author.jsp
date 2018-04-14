<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>欢迎:${sessionScope["now-author"].nickname}</h3>
<a href="<%=request.getContextPath()%>/author/exit" class="layui-btn layui-btn-danger  layui-btn-sm">退出登录</a>
<a href="<%=request.getContextPath()%>/article/article-list" target="_blink" class="layui-btn  layui-btn-sm">查看文章</a>