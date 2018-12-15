var opType; // 操作类型
// 页面加载成功时执行
$(function() {
	$('#dg').datagrid({
		url : "findReaderType",
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
			checkbox : true,
			width : 100
		}, {
			field : 'name',
			title : '读者类别',
			align : 'center',
			width : 100
		}, {
			field : 'number',
			title : '可借阅数量',
			align : 'center',
			width : 100
		}] ],
		toolbar : [ {
			id : 'ReaderTypeAdd',
			text : '增加',
			iconCls : 'icon-add',
			handler : add
		}, '-', {
			id : 'ReaderTypeUpdate',
			text : '编辑',
			iconCls : 'icon-edit',
			handler : edit
		}, '-', {
			id : 'ReaderTypeDelete',
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		} ]
	});

})

// 查询按钮的事件
function query() {
	var json = {};
	json['name'] = $('#name').val();
	json['number'] = $('#number').val();
	$.ajax({
		type : 'POST',
		url : 'findReaderType',
		data : json,
		async : false,
		success : function(data) {
			$('#dg').datagrid('loadData', data);
		}
	});
}

// 点击新增按钮触发
function add() {
	opType = "add";
	$('#addReaderType').dialog('open');
}

// 点击编辑按钮触发
function edit() {
	opType = "edit";
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	var json = {};
	for ( var d in row) {
		json[d] = row[d];
	}
	// alert(JSON.stringify(json));
	$('#frmEditReaderType').form('load', json);
	$('#editReaderType').dialog('open');
}

// 新增对话框上的提交按钮事件
function submit() {
	var json = {};
	var myUrl;
	var t;
	if (opType == "add") {
		myUrl = 'addReaderType';
		t = $('#frmAddReaderType').serializeArray(); // 通过序列化表单来创建数组
	} else if (opType == "edit") {
		myUrl = 'editReaderType';
		t = $('#frmEditReaderType').serializeArray(); // 通过序列化表单来创建数组
	}

	$.each(t, function() {
		if (this.value != "" || this.value != null) // 去除控制
			json[this.name] = $.trim(this.value);
	});
	json['page']=$('#dg').datagrid('getPager').data("pagination").options.pageNumber;
	json['rows']=$('#dg').datagrid('getPager').data("pagination").options.pageSize;
	// alert(JSON.stringify(json));
	$.ajax({
		type : 'post',
		url : myUrl,
		data : json,
		dataType : 'json',
		async : false,
		success : function(data) {
			layer.msg("提交成功,已保存!", {
				time : 1000,
				icon : 6,
				shift : 2
			}, function() {
				$('#frmAddReaderType').form('reset');
				$('#addReaderType').dialog('close');
				$('#frmEditReaderType').form('reset');
				$('#editReaderType').dialog('close');
				$('#dg').datagrid('loadData', data);
			});
			
		},
		error : function(data){
			layer.msg("提交失败!", {
				time : 2000,
				icon : 5,
				shift : 6
			}, function() {
			});
		}
	});
}

// 点击删除按钮触发
function del() {
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.messager.confirm("操作提示", "确认删除该记录?", function(r) {
		if (r) {
			$.ajax({
				type : 'post',
				url : 'deleteReaderType',
				data : {
					'id' : row.id,
					'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
					'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
				},
				dataType : 'json',
				success : function(data) {
					layer.msg("删除读者类别信息成功!", {
						time : 1000,
						icon : 6,
						shift : 2
					}, function() {
						$('#dg').datagrid('loadData', data);
					});
				},
				error : function(data){
					layer.msg("删除读者类别信息失败!", {
						time : 2000,
						icon : 5,
						shift : 6
					}, function() {
					});
				}
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