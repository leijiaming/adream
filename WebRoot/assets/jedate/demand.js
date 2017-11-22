function from(pp){
	$("#dataPagingStr").empty();
	var pagination=pp;//显示的页码
	var line_number=5;//每页需要显示的数据
	//var val=$(this).val();
	//alert("是不是查询的按钮"+val);
	var startTime=$("#hid_startTime").val();            
	var endTime=$("#hid_endTime").val();
	var status=$("#hid_status").val();
	var nu=true;
	if(pp==0||pp=="0"){
		startTime=$("#inpstart").val().trim();            
		endTime=$("#inpend").val().trim();
		status=$("#openStatus").val();
		if(startTime==""||endTime==""){
			nu=false;
			alert("请填写完整的日期段");
		}
    	$("#hid_startTime").val(startTime);
    	$("#hid_endTime").val(endTime);
    	$("#hid_status").val(status);
		pagination=1;
	}
	if(nu){
	$.ajax({
		type: "post",
        url:"ScanOpen/sotFind.do",
        data:{"startTime":startTime,"endTime":endTime,"status":status,"line_number":line_number,"pagination":pagination},
        dataType:"json",
        success:function(result){
        	//alert(result);
            if(result!=null){
            	$("#sotLoadData").empty();//清空
            	var data=result.data;
            	var NextPageData=result.msg;
            	var size=result.status;
            	if(result.data==""||NextPageData==""){
            		$("#numberAll").html("数据量：0&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>没有符合查询条件的数据!</font>");
            		$("#add").hide();
            		return;
            	}
            	var da=JSON.stringify(data);
            	if(pp==0||pp=="0"){
            	$.ajax({
            		type:"post",
                    url:"ScanOpen/sotLoad.do",
                    data:{da:da},
                    dataType:"json",
                    success:function(result){
                    $("#add").show();
                    document.getElementById("add").href="./ScanOpen/download.do?path="+result.data;
                    },
                    error: function() {
                    	alert("文件下载失败！");
                    },
                    });
            	}
            	//$("#ExcelBody").show();
            	for(var i=0;i<NextPageData.length;i++){
            	var id=NextPageData[i].id;
            	var	ticketcode=NextPageData[i].ticketcode;
            	var	status=NextPageData[i].status;
            	var	ordercode=NextPageData[i].ordercode;
            	var	createtime=NextPageData[i].createtime;
            	var	remark=NextPageData[i].remark;
            	var tr="<tr>";
				tr+="<td>"+ticketcode+"</td>";
				tr+="<td>"+status+"</td>";
				tr+="<td>"+ordercode+"</td>";
				tr+="<td>"+createtime+"</td>";
				tr+="<td>"+remark+"</td>";
				tr+="</tr>";
				var $tr=$(tr);
				$("#sotLoadData").append($tr);
            	}
            	$("#numberAll").html("数据量："+data.length+"<p>当前表格数据为：&nbsp;&nbsp;起止日期："+startTime+"&nbsp;&nbsp;至 &nbsp;&nbsp;"+endTime+"&nbsp;&nbsp;票号状态为:"+status+"&nbsp;&nbsp; 的查询结果！</p>");
            }
            var s ="<li><a title=\"总页数\">共"+size+"页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;";
			s+="<li id='prev_page'><a href=\"javascript:;\" onclick=\"first_page()\" id='home_page'>首页</a><a href=\"javascript:;\" onclick=\"on_page("+pagination+");\" id='previous_page_id'>上一页</a></li>";
			for ( var i = 1; i <= size; i++) {
				s+="<li ";
				if(i==pagination){
					s+="class=\"active\"";
				}
				s+="onclick=\"from("+i+")\"><a href=\"javascript:;\"><div id=\"page\">&nbsp;&nbsp;"+i+"</div></a></li>";
			}
			s+="<li id='next_page'><a id='next_page_id' href=\"javascript:;\" onclick=\"next_page("+pagination+","+size+")\">下一页</a><a href=\"javascript:;\" onclick=\"last_page("+size+")\" id='end_page'>末页</a></li>";
			
			$("#dataPagingStr").append(s);
			
			if(pagination==1){
				$("#prev_page").attr("class","prev disabled");
				$("#previous_page_id").removeAttr("onclick");
				$("#home_page").removeAttr("onclick");
			}//给上一页的按钮增加禁止样式
			if(pagination==size){
				$("#next_page").attr("class","next disabled");
				$("#next_page_id").removeAttr("onclick");
				$("#end_page").removeAttr("onclick");
				}//给下一页的按钮增加禁止样式
        },
            error: function() {
            	alert("查询失败！");
            },
	});
	}
}
//list集合分页显示
function current_page(page){
	from(page);
}
function on_page (pagination){//上一页
	var page=1;
	if(pagination>1){
		page=pagination-1;
	}
	from(page);
	
}
function next_page(pagination,size){//下一页
	var page=size;
	if(pagination<size){
		page=pagination+1;
	}
	from(page);
}
function first_page(){//首页
	from(1);
}
function last_page(size){//末页
	from(size);
}