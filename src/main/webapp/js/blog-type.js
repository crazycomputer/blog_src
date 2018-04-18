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
			scrollHeight();
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
			//计算body的高度为刘浏览器的总高度
			//$("body").eq(0).height($(document).height());
			var typeHead = document.getElementsByClassName("type_head")[0];
			var main =  document.getElementById("main-box");
			var top = typeHead.clientHeight;	
			main.style.top = top +"px";
			type_articleallWidth();
		}
		
		var arrH = [];
		
		function change() {
			
			var t = 0;
			arrH = [];
			for(var i=0; i< articles.length; i++){
				var j = i%count;
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
			
			var maxIndex = findMax(arrH);
			$(".main-box-articleList").eq(0).height(arrH[maxIndex]+40);
		}
		
		function findMin(arr) {
			var m = 0;
			for(var i = 0; i < arr.length; i++) {
				m = Math.min(arr[m] , arr[i]) == arr[m] ? m : i;
			}
			return m;
		}
		function findMax(arr) {
			var m = 0;
			for(var i = 0; i < arr.length; i++) {
				m = Math.max(arr[m] , arr[i]) == arr[m] ? m : i;
			}
			return m;
		}
		
		/* 监听浏览器滚动条高度 , S */
		function scrollHeight() {
			/*var flagDown = true;
			var flagUp = true;
			
			$(window).scroll(function(){
				var before = $(document).scrollTop(); 
				
				$(window).scroll(function(){
					var after = $(document).scrollTop();
					//判断添加下滑标记  true : 表示盒子处于上划隐藏状态 , 可以下滑   而  false: 表示盒子处于下滑状态 , 不能在执行if当中的代码
					if(before > after) {
						$(".type_head").slideDown(100);						
						before = after;
						console.log(before+ "--before" + "上");
					}
					
					if(before < after){  //浏览器滚轮 下划 , 盒子向上划 隐藏
						$(".type_head").slideUp(100);
						before = after;		
						console.log(before+ "--before" + "下");
					}
					//console.log(flagDown +"--(before > after): "+(before > after));
					//console.log(flagUp +"--(before < after): "+(before < after));
				});
				
			});*/
			
			
				   var upflag=1;
				   var  downflag= 1;
			    //scroll滑动,上滑和下滑只执行一次！
				scrollDirect(function (direction) {
				        if (direction == "down") {
				            if (downflag) {
				                $(".footer_wrap").slideUp(200);
				                downflag = 0;
				               upflag = 1;
				               $(".type_head").slideUp(100);
				               	
				            }
				        }
				        if (direction == "up") {
				            if (upflag) {
				                $(".footer_wrap").slideDown(200);
				                downflag = 1;
				                upflag = 0;
				                $(".type_head").slideDown(100);
				            }
				        }
				 });		
		}
		
		function scrollDirect(fn){
		    var beforeScrollTop = document.body.scrollTop;
		    fn = fn || function () {
		    };
		    window.addEventListener("scroll", function (event) {
		        event = event || window.event;

		        var afterScrollTop = document.body.scrollTop;
		        delta = afterScrollTop - beforeScrollTop;
		        beforeScrollTop = afterScrollTop;

		        var scrollTop = $(this).scrollTop();
		        var scrollHeight = $(document).height();
		        var windowHeight = $(this).height();
		        if (scrollTop + windowHeight > scrollHeight - 10) {  //滚动到底部执行事件
		            fn('up');
		            return;
		        }
		        if (afterScrollTop < 10 || afterScrollTop > $(document.body).height - 10) {
		            fn('up');
		        } else {
		            if (Math.abs(delta) < 10) {
		                return false;
		            }
		            fn(delta > 0 ? "down" : "up");
		        }
		    }, false);			
			
		}
		
		
		
		
		
		/* 监听浏览器滚动条高度 , E */
		
		function create() {
		}
		
	})();