<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/editormd-2.min.css">
</head>
<body>
<form action="./spring?method=insert" method="post">
    <div class="editormd" id="test-editormd">
      <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
      <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 name=test-editormd-html-code-->
	  <textarea id="text" name="text" style="display:none"></textarea>
    </div>
    <input type="submit" value="提交">
</form>

</body>

<script type="text/javascript" src="./js/jquery2.0.min.js"></script>
<script type="text/javascript" src="./js/editormd.min.js"></script>
<script type="text/javascript">
	
  $(function() {
      editormd("test-editormd", {
          width   : "90%",
          height  : 640,
          syncScrolling : "single",
          //你的lib目录的路径，我这边用JSP做测试的
          path    : "./lib/",
          //让构造出来的HTML代码直接在第二个隐藏的textarea域中，用与post提交。
          saveHTMLToTextarea : false,
          previewTheme: "dark"
      });
      
	$(document).keyup(function(e){
		var str = $(".editormd-preview-theme-dark").html();
		$("#text").html(str);
	});
      
  });

</script>
</html>
