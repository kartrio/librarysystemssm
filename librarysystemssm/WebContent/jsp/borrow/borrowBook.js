var opType; // 操作类型
// 页面加载成功时执行
$(function() {
	$('#dg').datagrid({
		url : "findBookInfo?del=0",
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
			field : 'barcode',
			title : '条形码',
			align : 'center',
			width : 100
		}, {
			field : 'bookname',
			title : '图书名称',
			align : 'center',
			width : 100
		}, {
			field : 'typename',
			title : '图书类型',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if (row.bookType != null) {
					return row.bookType.typename;
				} else {
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
				if (row.publishInfo != null) {
					return row.publishInfo.pubname;
				} else {
					return null;
				}
			}
		}, {
			field : 'price',
			title : '价格',
			align : 'center',
			width : 100
		}, {
			field : 'bookcase',
			title : '书架',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if (row.bookcase != null) {
					return row.bookcase.name;
				} else {
					return null;
				}
			}
		} ] ],
		toolbar : [ {
			id : 'BorrowBook',
			text : '图书借阅',
			iconCls : 'icon-ok',
			handler : borrowBook
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

//图书借阅
function borrowBook(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'borrowBook',
		data : {
			'readerid' : $('#readerid').val(),
			'bookid' : row.id,
			'days' : row.bookType.days
		},
		success : function(result){
			layer.msg("借阅成功,等待管理员审核!", {time : 2000,icon : 6,shift : 2}, function() {
				$('#dg').datagrid("load",result);				
			});
		},
		error : function(data){
			layer.msg("借阅失败,联系管理员!", {time : 2000,icon : 5,shift : 6}, function() {});
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