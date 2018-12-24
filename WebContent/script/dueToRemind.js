var opType; // 操作类型
// 页面加载成功时执行
$(function() {
	$('#dg').datagrid({
		url : 'findBorrowInfo?toTime=' + $('#toTime').val() + "&ifback=0",
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
			title : '图书条形码',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.bookInfo != null){
					return row.bookInfo.barcode;
				}else{
					return null;
				}
			}
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
			field : 'readerBarcode',
			title : '读者条形码',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.readerInfo != null){
					return row.readerInfo.barcode;
				}else{
					return null;
				}
			}
		}, {
			field : 'name',
			title : '读者名称',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.readerInfo != null){
					return row.readerInfo.name;
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
		}] ],
		toolbar : [ {
			id : 'remindGiveback',
			text : '提醒归还',
			iconCls : 'icon-ok',
			handler : remindGiveback
		} ]
	});

})

//提醒归还书籍
function remindGiveback(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'remindGiveBack',
		data : {
			'readerName' : row.readerInfo.name,
			'email' : row.readerInfo.email,
			'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
		    'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
		},
		success : function(result){
			layer.msg("提醒成功!", {time : 2000,icon : 6,shift : 2}, function() {
				$('#dg').datagrid("loadData",result);				
			});
		},
		error : function(result){
			layer.msg("提醒失败!", {time : 2000,icon : 5,shift : 6}, function() {});
		}
	});
}
