/**
 * 分类page 的瀑布流加载js代码
 */
	(function(){
		var articles = $(".type_articleall");
		//获取列的宽度
		var articlesW = articles.width() + 20;
		//当前浏览器的高度
		var berowseHeight = $(document).height();
		//当前浏览器的宽度
		//var browseWidth = $(window).width();
		var browseWidth = $(".main-box-articleList").width();
		//每一行需要显示的列数
		var count = parseInt(browseWidth / articlesW);
		
		var center = (browseWidth - (count * articlesW)  + 50) / 2;
		
		function type_articleallWidth(){
			console.log(browseWidth);
			if(browseWidth < 650) {
				$(".type_articleall").css({"width":"90%",
											"margin":"20px auto 0px",
											"background":"#fff"});
			}else{
				$(".type_articleall").css({"width":"313px",
					"background":"#fff"});
				
			}
		}
		
		window.onresize = function(){
			
			browseWidth = $(".main-box-articleList").width();
			count = parseInt(browseWidth / articlesW);
			center = (browseWidth - (count * articlesW) + 50) / 2;
			autoHeight();
			if(count <= 1){
				articles.css("position","initial");
			}
			if(count > 1){
				articles.css("position","absolute");
				change();
			}
			berowseHeight = $(document).height();
		}
		
		window.onload = function() {
			$(".markdown-body").attr("style","padding:0px");
			autoHeight();
			
			if(count <= 1){
				articles.css("position","initial");
				return;
			}
			if(count > 1){
				articles.css("position","absolute");
			}
			change();
			
		}
		

		//设置 class = type_head 的top 值 
		function autoHeight(){
			//设置 .main-box-articleList的高度和 浏览器窗口一样大
			//$(".main-box-articleList").height(berowseHeight);
			//alert(berowseHeight);
			//------------
			var typeHead = document.getElementsByClassName("type_head")[0];
			var main =  document.getElementById("main-box");
			var top = typeHead.clientHeight;	
			main.style.top = top +"px";
			type_articleallWidth();
		}
		
		
		function change() {
			var t = 0;
			var arrH = [];
			for(var i=0; i< articles.length; i++){
				var j = i%count;
				console.log(count);
				console.log(j);
				
				console.log("------------");
				if(arrH.length == count) {
					var min = findMin(arrH); //找到arrH当中最小的
					articles[i].style.left = center + min * articlesW + "px";
					articles[i].style.top = arrH[min]+10 + "px";
					arrH[min] += articles[i].offsetHeight + 10;
				
				}else{
					arrH[j] = articles[i].offsetHeight;
					articles[i].style.left = center + (articlesW * j) + "px";
					articles[i].style.top = 0;
				}
				
			}
		}
		
		function findMin(arr) {
			var m = 0;
			for(var i = 0; i < arr.length; i++) {
				m = Math.min(arr[m] , arr[i]) == arr[m] ? m : i;
			}
			return m;
		}
		
		function create() {
		}
		
	})();