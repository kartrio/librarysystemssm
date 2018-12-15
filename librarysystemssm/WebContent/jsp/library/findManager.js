// 页面加载成功时执行
$(function() {
	$('#dg').datagrid({
		url : "findManager",
		fit : true,
		loadMsg : 'loading',
		singleSelect : true,
		scrollbarSize : 0,
		pagination : true,
		rownumbers : true,
		fitColumns : true,
		pageSize : 8,
		pageList : [ 8, 10, 20 ],
		columns : [ [ {
			field : 'id',
			title : '管理员编号',
			align : 'center',
			width : 100
		}, {
			field : 'name',
			title : '管理员姓名',
			align : 'center',
			width : 100
		}] ],
		toolbar : [ {
			id : 'ManagerAdd',
			text : '增加',
			iconCls : 'icon-add',
			handler : add
		} ]
	});
	var addSuccess = $('#addSuccess').val();
	if(addSuccess == "true"){
		$('#addManager').dialog('close');
		$('#dg').datagrid('reload');
	}
})

// 查询按钮的事件
function query() {
	var adminName = $('#adminName').val();
	$.ajax({
		type : 'POST',
		url : 'findBookInfo',
		data : {
			'name' : adminName
		},
		async : false,
		success : function(data) {
			$('#dg').datagrid('loadData', data);
		}
	});
}

// 点击新增按钮触发
function add() {
	var page = $('#dg').datagrid('getPager').data("pagination").options.pageNumber;
	var rows = $('#dg').datagrid('getPager').data("pagination").options.pageSize;
	var linkUrl = 'readerInfoPage?manager=true&page=' + page + '&rows=' + rows;
	$('#linkToReader').attr('src', linkUrl);
	$('#addManager').dialog('open');
}

// 新增对话框上的提交按钮事件
function submit() {
	var json = {};
	var t = $('#frmAddManager').serializeArray();;

	$.each(t, function() {
		if (this.value != "" || this.value != null) // 去除控制
			json[this.name] = $.trim(this.value);
	});
	json['page']=$('#dg').datagrid('getPager').data("pagination").options.pageNumber;
	json['rows']=$('#dg').datagrid('getPager').data("pagination").options.pageSize;
	//alert(JSON.stringify(json));
	$.ajax({
		type : 'post',
		url : 'addManager',
		data : json,
		dataType : 'json',
		async : false,
		success : function(data) {
			layer.msg("提交成功,已保存!", {
				time : 1000,
				icon : 6,
				shift : 2
			}, function() {
				$('#frmAddManager').form('reset');
				$('#addManager').dialog('close');
				$('#dg').datagrid('loadData', data);
			});
		},error : function(data){
			layer.msg("提交失败!", {
				time : 2000,
				icon : 5,
				shift : 6
			}, function() {
			});
		}
	});
}

// 新增对话框上的取消按钮事件
function closeDialog(formId, dialogId) {
	$('#' + formId).form('reset');
	$('#' + dialogId).dialog('close');
}

// 重置按钮的事件
function flushForm() {
	$('#frmSearch').form('reset');
}