var globalCount = 0;
$(document).ready(function() {
	selectReport();
});
var returnAllCount = function() {
	if (globalCount == 1) {
		setTimeout(function() {
			$('#fakeloader').css('display', 'none');
		}, 500);
	}
}
// 实现点击类别传参数到后台
$("#toolbar .btn-group .btn").click(function() {
	selectReport();
});
// 初始化表格数据
// 初始化表格数据
var selectReport = function() {
	$('#allReport').bootstrapTable({
		method : 'post',
		url : "../../report/queryAll",
		dataType : "json",
		striped : false, // 使表格带有条纹
		pagination : true, // 在表格底部显示分页工具栏
		pageSize : 10,
		dataType : "json",
		striped : false, // 使表格带有条纹
		pagination : true, // 在表格底部显示分页工具栏
		pageSize : 10,
		pageNumber : 1,
		sortStable : true,
		sortable : true,
		pageList : [ 10, 20, 50 ],
		idField : "id", // 标识哪个字段为id主键
		showToggle : false, // 名片格式
		cardView : false, // 设置为True时显示名片（card）布局
		showColumns : true, // 显示隐藏列
		showRefresh : true, // 显示刷新按钮
		// singleSelect: true,//复选框只能选择一条记录
		search : true, // 是否显示搜索框
		searchOnEnterKey : true, // 设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
		// clickToSelect: true,//点击行即可选中单选/复选框
		queryParams : queryParams, // 参数
		// showFullscreen:true, //全屏按钮
		// queryParamsType: "limit", //查询参数组织方式
		sidePagination : "server", // 服务端处理分页
		silent : true, // 刷新事件必须设置
		searchTimeOut : 500, // 设置搜索超时时间
		toolbarAlign : 'left', // 工具栏对齐方式
		buttonsAlign : 'right', // 按钮对齐方式
		toolbar : '#toolbar', // 指定工作栏
		searchAlign : 'right',
		contentType : "application/x-www-form-urlencoded",
		formatLoadingMessage : function() {
			return "请稍等，正在加载中...";
		},
		formatNoMatches : function() { // 没有匹配的结果
			return "无符合条件的记录";
		},
		responseHandler : function(res) {
			
			return {
				"total" : res.data.records, // 总页数
				"rows" : res.data.rows, // 数据
			};
		},
		columns : [
			
			{
				title : '序号',
				align : 'center',
				valign : 'middle',
				width : '4%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + index1 + '</span>';
					return id;
				}
			},
			{
				title : '视频id',
				field : 'title',
				align : 'center',
				valign : 'middle',
				width : '22%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + row.dealVideoId + '</span>';
					return id;
				}
			},
		
			{
				title : '标题',
				field : 'status',
				align : 'center',
				width : '5%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + index + '">' + row.title + '</span>';
					return id;
				}
			},
			
			{
				title : '内容',
				field : 'id',
				align : 'center',
				width : '25%',
				formatter : function(value, row, index) {
					
					var index1 = index + 1;
					var id = '<span title="ID:' + index + '">' + row.content + '</span>';
					return id;
				}
			},
			
			{
				title : '发布者',
				field : 'keyword',
				align : 'center',
				width : '8%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + row.publisher + '</span>';
					return id;
				}
			},

			{
				title : '举报人',
				field : 'status',
				align : 'center',
				width : '10%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + index + '">' + row.userName + '</span>';
					return id;
				}
			},
			{
				title : '執行',
				field : 'id',
				align : 'center',
				width : '5%',
				formatter : function(value, row, index) {
					
                    if(row.status==2)
                    {
    					var a  = '<a  class=" btn-sm btn-primary"  onclick="operation(\'' + row.dealVideoId + '\',\'上架\')"><i class="fa fa-share-square-o" ></i>上架</a> ';
                        return a;
                    }
					// 下架
                    else if(row.status==1)
                    {
					var b  = '<a  class=" btn-sm btn-danger"  onclick="operation(\'' + row.dealVideoId + '\',\'下架\')"><i class="fa fa-share-square-o" ></i>下架</a> ';
				    return b;
                    }
				},
				
			}
			
			
		]
	});
	globalCount++;
	returnAllCount();
}
function operation(id,op)
{
	
	  var status=0;
      if(op=='下架')// 发送ajax请求下架程序
      {
    	 status=2;
      }
      else if(op=="上架")
      {
    	  status=1;
      }
      $.ajax({
    	    		 url:"../../report/undercarriage?id="+id+"&status="+status,
    	    		 method : 'post',
    	    		 dataType : "json",// 预期服务器返回的数据类型發
    	    		 success:function(res)
    	    		 {
    	    			 if(res.status==200)
    	    			 {
    	    				 alert("操作成功");
    	    				 $("#allReport").bootstrapTable('refresh');
    	    			 }
    	    		 },
    	    		 error : function(e) {
    	 				alert("异常！" + e);
    	 			}
    	    	 })
}
//传参数到后台
function queryParams(params) {
	return {
		pageSize : params.limit,
		page : (params.offset) / params.limit + 1,
		title : $(".form-control").val(),
		keyword : $(".form-control").val(),
		status : 1 // 1 表示正文
	}
}

// 格式化时间
function Format(datetime, fmt) {
	if (parseInt(datetime) == datetime) {
		if (datetime.length == 10) {
			datetime = parseInt(datetime) * 1000;
		} else if (datetime.length == 13) {
			datetime = parseInt(datetime);
		}
	}
	datetime = new Date(datetime);
	var o = {
		"M+" : datetime.getMonth() + 1, // 月份
		"d+" : datetime.getDate(), // 日
		"h+" : datetime.getHours(), // 小时
		"m+" : datetime.getMinutes(), // 分
		"s+" : datetime.getSeconds(), // 秒
		"q+" : Math.floor((datetime.getMonth() + 3) / 3), // 季度
		"S" : datetime.getMilliseconds() // 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}
