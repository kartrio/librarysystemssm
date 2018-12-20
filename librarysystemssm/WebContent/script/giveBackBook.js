// 页面加载成功时执行
$(function() {
	var readerid = $('#readerid').val();
	$('#dg').datagrid({
		url : "findNeedBackInfo?ifback=0&readerid=" + readerid + "&status=1",
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
			field : 'bookname',
			title : '图书名称',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.bookInfo != null){
					return row.bookInfo.bookname;
				}else{
					return null;
				}
			}
		}, {
			field : 'borrowTime',
			title : '借阅时间',
			align : 'center',
			width : 100
		}, {
			field : 'backTime',
			title : '应还时间',
			align : 'center',
			width : 100
		}, {
			field : 'pubname',
			title : '出版社',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.bookInfo != null){
					return row.bookInfo.publishInfo.pubname;
				}else{
					return null;
				}
			}
		}, {
			field : 'bookcase',
			title : '书架',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.bookInfo != null){
					return row.bookInfo.bookcase.name;
				}else{
					return null;
				}
			}
		}] ],
		toolbar : [ {
			id : 'GiveBackBook',
			text : '归还图书',
			iconCls : 'icon-ok',
			handler : giveBackBook
		} ]
	});
})

// 查询按钮的事件
function query() {
	var json = {};
	json['bookname'] = $('#bookname').val();
	json['readerid'] = $('#readerid').val();
	json['ifback'] = 0;
	json['status'] = 1;
	$.ajax({
		type : 'POST',
		url : 'findNeedBackInfo',
		data : json,
		async : false,
		success : function(data) {
			$('#dg').datagrid('loadData', data);
		}
	});
}

//图书归还
function giveBackBook(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'giveBackBook',
		data : {
			'id' : row.id,
			'readerid' : $('#readerid').val(),
			'bookid' : row.bookInfo.id,
			'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
		    'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
		},
		success : function(result){
			layer.msg("归还成功,等待管理员核查!", {time : 2000,icon : 6,shift : 2}, function() {
				$('#dg').datagrid("loadData",result);				
			});
		},
		error : function(data){
			layer.msg("归还失败,联系管理员!", {time : 2000,icon : 5,shift : 6}, function() {});
		}
	});
}

// 重置按钮的事件
function flushForm() {
	$('#frmSearch').form('reset');
}