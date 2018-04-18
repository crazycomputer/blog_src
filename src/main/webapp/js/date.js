	/*
		实现一个与指定日期之间动态差的时间(天,时,分,秒)
		
		使用说明: 引入该js文件,然后调用其中run(id名,日期)即可
		日期格式 : 年/月/日 00:00:00

	*/

	 function Xm(sVal) {this.oVal = document.getElementById(sVal);}
		
		
			Xm.prototype.html = function(valHTML) {
				this.oVal.innerHTML = valHTML;
				//return obj;
			}
			
			Xm.prototype.setTime = function (fromDate ,toDate ) {
			
				var time =Math.abs( toDate.getTime() - new Date(fromDate).getTime() );
				
				//将取得的差值转换为小时 h = time/1000/60/60
				var h = time/1000/60/60;
				//parseInt(h/24) --天数
				var day = parseInt(h/24);
				
				//获取到当前未取整的小时数
				hour = h%24;
				//parseInt(hours)--小时
				var hours = parseInt(hour);
				if(hours < 10){
					hours = "0"+hours;
				}
				
				//取出 h 的小数部分乘以60,就是带小数的分钟,
				var minutes = parseInt((hour - hours)*60);
				if(minutes < 10) {
					minutes = "0" + minutes;
				}
				//没取整的减去取整的,求出小数
				var seconds = (((hour - hours)*60) - minutes)*60;
				//alert(day+"天"+hours+"时"+minutes+"分"+parseInt(seconds)+"秒");
				var intsrconds = parseInt(seconds);
				if(intsrconds < 10) {
					intsrconds = "0" + intsrconds;
				}
				//结果*60
				var result = day+"天"+hours+"时"+minutes+"分"+intsrconds+"秒";
				return result;
			}
		

	function run(str,date) {
		var xm= new Xm(str);
		function tima() {
			xm.html(xm.setTime(date,toDate = new Date()));
		}
		setInterval(tima,1000);
	}
	
	
	
