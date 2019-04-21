var globalCount = 0;
$("#fakeloader").fakeLoader({
	timeToHide : 10000, // Time in milliseconds for fakeLoader disappear
	zIndex : 999, // Default zIndex
	spinner : "spinner6", // Options: 'spinner1', 'spinner2', 'spinner3',
							// 'spinner4', 'spinner5', 'spinner6', 'spinner7'
	bgColor : "#fff", // Hex, RGB or RGBA colors
});
setTimeout(function() {
	$('body').css('opacity', '1');
	$('body').attr("class", "gray-bg") // 添加样式
}, 100);

$(document).ready(function() {
	selectAllBusiness();
});

var returnAllCount = function() {
	if (globalCount == 1) {
		setTimeout(function() {
			$('#fakeloader').css('display', 'none');
		}, 500);
	}
}
$("#toolbar .type").click(function() {
	var statu;
	var isrecommend;
	var istop;
	if ($(this).val() < 3)
		statu = $(this).val();
	if ($(this).val() == 3)
		isrecommend = 1;
	if ($(this).val() == 4)
		istop = 1;
	var params = $('#allBlog').bootstrapTable('getOptions')
	params.queryParams = function(params) {
		return {
			pageSize : params.limit,
			page : (params.offset) / params.limit + 1,
			title : $(".form-control").val(),
			keyword : $(".form-control").val(),
			status : statu,
			isrecommend : isrecommend,
			istop : istop,
		}
	}
	$('#allBlog').bootstrapTable('refresh', params)
});


 
// 获取行号
 var getSelectRows = function(status) {
 	var date = $("#allBlog").bootstrapTable('getSelections');
 	var idArray = new Array();
 	var title = '';
 	var text = '';
 	if (status == 1) {
 		title = '确定要删除这' + date.length + '条信息吗';
 		text = '删除后前台将无法显示，请谨慎操作！';
 	} else if (status == 2) {
 		title = '确定要将这' + date.length + '条博客置顶吗';
 		text = '置顶后,将显示在前台置顶栏目';
 	} 
 	swal({
 		title : title,
 		text : text,
 		type : "warning",
 		showCancelButton : true,
 		confirmButtonColor : "#DD6B55",
 		confirmButtonText : "确定",
 		closeOnConfirm : false
 	}, function() {
 		if (status == 1) {
 			for (var i = 0; i < date.length; i++) {
 				idArray[i] = date[i].id;
 				operationVideo(idArray[i], 2, null, null); // 参数2表示 放入回收站
 			}
 		} else if (status == 2) {
 			for (var i = 0; i < date.length; i++) {
 				idArray[i] = date[i].id;
 				operationVideo(idArray[i], null, null, 1); // 设置为置顶
 			}
 		} 
 	});
 };
// 传参数类别ID
var sendType = function(type_id) {
	var params = $('#allBlog').bootstrapTable('getOptions')
	params.queryParams = function(params) {
		return {
			pageSize : params.limit,
			page : (params.offset) / params.limit + 1,
			title : $(".form-control").val(),
			keyword : $(".form-control").val(),
			'type.id' : type_id,
		}
	}
	$('#allBlog').bootstrapTable('refresh', params)
}

// 初始化表格数据
var selectAllBusiness = function() {
	$('#allBlog').bootstrapTable({
		method : 'post',
		url : "../../business/queryAll",
		dataType : "json",
		striped : false, // 使表格带有条纹
		pagination : true, // 在表格底部显示分页工具栏
		pageSize : 10,
		pageNumber : 1,
		sortStable : true,
		sortable : true,
		pageList : [ 10, 20, 50 ,100],
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
		// singleSelect : true,
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
				"rows" : res.data.rows // 数据
			};
		},
		columns : [
			{
				checkbox : true,
				width : '3%',
				align : 'center',
				valign : 'middle',
			},
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
				title : '类别',
				field : 'video_category',
				align : 'center',
				width : '4%',
				formatter : function(value, row, index) {
					if (row.videoCategory == "define") {
						return '<span>美拍类</span>';
					} else if (row.videoCategory == "food") {
						return '<span>美食类</span>';
					}
					else if (row.videoCategory == "beauty") {
						return '<span>美食类</span>';
					}
			}
			}
			,{
				title : '封面',
				field : 'video_category',
				align : 'center',
				width : '4%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<img src="' + row.coverPath+ '" style="width:'+(row.videoWidth/10)+'px;height:'+(row.videoHeight/10)+'px;"/>';
					return id;
				}
			},
			{
				title : '内容',
				field : 'content',
				align : 'center',
				width : '10%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + row.videoDesc + '</span>';
					return id;
				}
			
			},
			{
				title : '状态',
				field : 'video_status',
				align : 'center',
				width : '4%',
				formatter : function(value, row, index) {
					if (row.status == 1) {
						return '<span>发布中</span>';
					} else if (row.status == 2) {
						return '<span>禁播</span>';
					}
				}
			
			},{
				title : '入驻时间',
				field : 'create_time',
				align : 'center',
				width : '8%',
				formatter : function(value, row, index) {
					return Format(row.createTime, "yyyy-MM-dd hh:mm:ss");
				}
			},
			{
				title : '操作',
				field : 'id',
				align : 'center',
				width : '8%',
				formatter : function(value, row, index) {
					
					// 查看
					var a = '<a  class=" btn-sm btn-primary" href='+row.videoPath+'  data-target="#myModal" ">查看</a> ';
					// 删除
					var b  = '<a  class=" btn-sm btn-danger"  onclick="operation(\'' + row.id + '\',\'删除\')"><i class="fa fa-share-square-o" ></i>删除</a> ';
					// 从回收站还原
			    return a+b;
			}
			}
		]
	});
	globalCount++;
	returnAllCount();
};

var operation = function(id, op) {
	var title = "";
	var text = "";
	if (op == "还原") {
		title = '确定要移出回收站吗';
		text = '移出后,将显示在前台页面';
	} else if (op == "删除") {
		title = '确定要删除吗';
		text = '删除后，将不再显示在前台页面';
	} 
	swal({
		title : title,
		text : text,
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "确定",
		closeOnConfirm : false
	}, function() {
		if (op == "还原") {
			operationVideo(id, 1, null, null)
		} else if (op == "删除") {
			operationVideo(id, 2, null, null)
		} 
	});
};
// 传参数到后台
function queryParams(params) {
	return {
		pageSize : params.limit,
		page : (params.offset) / params.limit + 1,
		title : $(".form-control").val(),
		keyword : $(".form-control").val(),
		status : 1 // 1 表示正文
	}
}


var formatTableUnit = function(value, row, index) {
	return {
		css : {
			"overflow" : 'hidden',
			"text-overflow" : 'ellipsis',
			"white-space" : 'nowrap'
		}
	};
};




// 视频的操作
var operationVideo = function(idArray, status, isrecommend, isTop) {
	var param = '';
	param = {
			'id' : idArray,
			'status' : status,
		};
	$.ajax({
		url : '../../video/updateVideo',
		type : 'post',
		data : param,
		dataType : 'json',
		success : function(data) {
			if (data.status == 200) {
				$("#allBlog").bootstrapTable('refresh');
				swal("更新成功", "", "success");
			} else {
				swal("更新失败", "请重新操作", "error");
			}
		},
		error : function() {
			swal("更新错误", "请重新操作", "error");
		}
	});
}

// 格式化时间工具类
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

