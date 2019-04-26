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
	selectBgm();
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
	selectBgmType();
});


// 初始化表格数据
var selectBgm = function() {
	$('#allBgm').bootstrapTable({
		method : 'post',
		url : "../../bgm/selectBgmList",
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
				title : '背景音乐名称',
				field : 'title',
				align : 'center',
				valign : 'middle',
				width : '20%',
				cellStyle : formatTableUnit,
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + row.name + '</span>';
					return id;
				}
			},
		
			{
				title : '作者',
				field : 'keyword',
				align : 'center',
				width : '8%',
				cellStyle : formatTableUnit,
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + row.author + '</span>';
					return id;
				}
			},

			{
				title : '路径',
				field : 'status',
				align : 'center',
				width : '16%',
				formatter : function(value, row, index) {
					var index1 = index + 1;
					var id = '<span title="ID:' + row.id + '">' + row.path + '</span>';
					return id;
				}
			},
			{
				title : '播放',
				field : 'id',
				align : 'center',
				width : '16%',
				formatter : function(value, row, index) {
					
					var path=row.path;
					// 查看
					var a = '<audio src='+path+' controls  id='+row.id+'></audio> ';
					// 编辑
				    return a;
				}
			}
		]
	});
	globalCount++;
	returnAllCount();
}

var selectResourceById = function(id) {
	var params = {
		id : id
	};
	$.ajax({
		url : '../../bgm/selectResourceById',
		type : 'post',
		data : params,
		dataType : 'json',
		success : function(data) {
			if (data.status == 200) {
				var param=data.data;
			    $("#newTitle").val(param.author);
				$("#newContent").val(param.name);
				$("#newLink").val(param.id);
				var updateButton = ' <button class="btn btn-sm btn-primary pull-right m-t-n-xs" onclick="updateResource(' + param.id + ',\'' + param.name + '\',null)" type="button"><strong>提交</strong></button>'
				$("#update").html(updateButton);
				
			} else if (data.status == 0) {
				swal("查询失败", "不存在该类别信息", "error");
			}
		},
		error : function() {
			swal("查询错误", "请重新操作", "error");
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


// 获取行号
var getSelectRows = function(status) {
	var date = $("#allBgm").bootstrapTable('getSelections');
	var idArray = new Array();
	var title = '';
	var text = '';
	if (status == 1) {
		title = '确定要删除这' + date.length + '条信息吗';
		text = '删除后前台将无法显示，请谨慎操作！';
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
				operationBgm(idArray[i], 2, null, null); // 参数2表示 放入回收站
			}
		}
	});
};

// 背景音乐的操作
var operationBgm = function(idArray, status, isrecommend, isTop) {
	var param = '';
	var prarm = '';
	if (status != null) {
		if (status == 1) {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客<span class="text-success">发表</span>'
		} else if (status == -1) {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客放入<span class="text-navy">草稿箱</span>'
		} else if (status == 2) {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客放入<span class="text-danger">垃圾箱</span>'
		}
		param = {
			'id' : idArray,
			'status' : status,
			prarm : prarm,
		};
	}
	if (isrecommend != null) {
		if (isrecommend == 1) {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客置为<span class="text-success">推荐</span>'
		} else {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客<span class="text-navy">取消推荐</span>'
		}
		param = {
			'id' : idArray,
			'isrecommend' : isrecommend,
			prarm : prarm,
		};
	}
	if (isTop != null) {
		if (isTop == 1) {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客<span class="text-success">置顶</span>'
		} else {
			prarm = '将ID为<span class="text-info">' + idArray + '</span>的博客<span class="text-navy">取消置顶</span>'
		}
		param = {
			'id' : idArray,
			'istop' : isTop,
			prarm : prarm,
		};
	}
	$.ajax({
		url : '../../bgm/updateBgm',
		type : 'post',
		data : param,
		dataType : 'json',
		success : function(data) {
			// 查询成功
			if (data.status == 200) {
				$("#allBgm").bootstrapTable('refresh');
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


//如果字体太长 对字体进行控制
var formatTableUnit = function(value, row, index) {
	return {
		css : {
			"overflow" : 'hidden',
			"text-overflow" : 'ellipsis',
			"white-space" : 'nowrap'
		}
	};
};




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
