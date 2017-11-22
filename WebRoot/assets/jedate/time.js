var start = {
    dateCell: '#inpstart',
    format: 'YYYY-MM-DD hh:mm',
    minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
	festival:true,
    maxDate: '2099-06-16 23:59:59', //最大日期
   isTime: true,
    choosefun: function(datas){
         end.minDate = datas; //开始日选好后，重置结束日的最小日期
    }
};
var end = {
    dateCell: '#inpend',
    format: 'YYYY-MM-DD hh:mm',
    minDate: jeDate.now(0), //设定最小日期为当前日期
	festival:true,
    maxDate: '2099-06-16 23:59:59', //最大日期
    isTime: true,
    choosefun: function(datas){
         start.maxDate = datas; //将结束日的初始值设定为开始日的最大日期
    },
	okfun:function(val){alert(val)}
};
jeDate(start);
jeDate(end);

jeDate({
	dateCell:"#textymdhms",  
	format:"YYYY-MM-DD hh:mm:ss",
	//isinitVal:true,
	isTime:true, 
	festival: true, //显示节日
	minDate:"2015-09-19 00:00:00",
	maxDate:"2019-09-19 00:00:00"
})

jeDate({
	dateCell:"#texthms",  
	format:"hh:mm"
});

jeDate({
    dateCell: '#testym',
	isinitVal:true,
    format: 'YYYY/MM', // 分隔符可以任意定义，该例子表示只显示年月 
	minDate: '2015-06-01', //最小日期
    maxDate: '2017-06-01',  //最大日期
	choosefun:function(val){alert(val)}
});
jeDate({
    dateCell: '#testy',
	isinitVal:true,
    format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月 
    minDate: '2010-06-01', //最小日期
    maxDate: '2020-06-01' //最大日期
})
jeDate({
	dateCell:"input.datep",  
	format:"YYYY-MM-DD hh:mm:ss",
	minDate:"2015-09-19 00:00:00",
	isinitVal:true,
	isDisplay:true,
    displayCell:".discls",
	isTime:true, 
	festival: true, //显示节日	
})