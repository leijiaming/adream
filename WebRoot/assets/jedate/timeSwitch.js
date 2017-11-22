//时间格式转换
var formatDateTime = function (date) {  
	        var y = date.getFullYear();  
	        var m = date.getMonth() + 1;  
	        m = m < 10 ? ('0' + m) : m;  
	        var d = date.getDate();  
	        d = d < 10 ? ('0' + d) : d;  
	        var h = date.getHours();  
	        var minute = date.getMinutes();
	        var s=date.getSeconds();
	        minute = minute < 10 ? ('0' + minute) : minute;
	        s=s < 10 ? ('0' + s) : s;
	        return y + '-' + m + '-' + d+' '+h+':'+minute+":"+s;  
	    };
var formatDate = function (date) {  
	        var y = date.getFullYear();  
	        var m = date.getMonth() + 1;  
	        m = m < 10 ? ('0' + m) : m;  
	        var d = date.getDate();  
	        d = d < 10 ? ('0' + d) : d;  
	        return y + '-' + m + '-' + d;  
	    }; 
