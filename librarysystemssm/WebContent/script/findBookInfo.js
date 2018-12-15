var opType; // 操作类型
// 页面加载成功时执行
$(function() {
	$('#dg').datagrid({
		url : "findBookInfo",
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
		},{
			field : 'barcode',
			title : '条形码',
			align : 'center',
			width : 100
		}, {
			field : 'bookname',
			title : '图书名称',
			align : 'center',
			width : 100
		},{
			field : 'typename',
			title : '图书类型',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.bookType != null){
					return row.bookType.typename;
				}else{
					return null;
				}
			}
		}, {
			field : 'author',
			title : '作者',
			align : 'center',
			width : 100
		}, {
			field : "isbn",
			title : '出版社',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {// 解决多个对象嵌套无法直接作为列的情况
				if(row.publishInfo != null){
					return row.publishInfo.pubname;
				}else{
					return null;
				}
			}
		}, {
			field : 'price',
			title : '价格',
			align : 'center',
			width : 100
		},{
			field : 'bookcase',
			title : '书架',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.bookcase != null){
					return row.bookcase.name;
				}else{
					return null;
				}
			}
		}] ],
		toolbar : [ {
			id : 'BookInfoAdd',
			text : '增加',
			iconCls : 'icon-add',
			handler : add
		}, '-', {
			id : 'BookInfoUpdate',
			text : '编辑',
			iconCls : 'icon-edit',
			handler : edit
		}, '-', {
			id : 'BookInfoDelete',
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		} ]
	});
})

// 查询按钮的事件
function query() {
	var json = {};
	json['bookname'] = $('#bookname').val();
	json['author'] = $('#author').val();
	$.ajax({
		type : 'POST',
		url : 'findBookInfo',
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
	$('#addBookInfo').dialog({
		title : "新增书籍",
		cache : false,
		href : 'jsp/book/addBookInfo.jsp',
		modal : true
	});
	$('#addBookInfo').dialog('open');
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
	$('#bookType').combobox('setValue',row.bookType.id);
	$('#publishInfo').combobox('setValue',row.publishInfo.isbn);
	$('#bookcase').combobox('setValue',row.bookcase.id);
	//alert(JSON.stringify(json));
	$('#frmEditBook').form('load', json);
	$('#editBookInfo').dialog('open');
}

// 新增对话框上的提交按钮事件
function submit() {
	var json = {};
	var myUrl;
	var t;
	if (opType == "add") {
		myUrl = 'addBookInfo';
		t = $('#frmAddBook').serializeArray(); // 通过序列化表单来创建数组
	} else if (opType == "edit") {
		myUrl = 'editBookInfo';
		t = $('#frmEditBook').serializeArray(); // 通过序列化表单来创建数组
	}

	$.each(t, function() {
		if (this.value != "" || this.value != null) // 去除控制
			json[this.name] = $.trim(this.value);
	});
	json['page']=$('#dg').datagrid('getPager').data("pagination").options.pageNumber;
	json['rows']=$('#dg').datagrid('getPager').data("pagination").options.pageSize;
	//alert(JSON.stringify(json));
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
				$('#frmAddBook').form('reset');
				$('#addBookInfo').dialog('close');
				$('#frmEditBook').form('reset');
				$('#editBookInfo').dialog('close');
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
				url : 'deleteBookInfo',
				data : {
					'id' : row.id,
					'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
					'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
				},
				success : function(result) {
					layer.msg("删除书籍信息成功!", {
						time : 1000,
						icon : 6,
						shift : 2
					}, function() {
						$('#dg').datagrid('loadData', result);
					});
					
				},
				error : function(result){
					layer.msg("删除书籍信息失败!", {
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