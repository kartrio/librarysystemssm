var opType; // 操作类型
// 页面加载成功时执行
$(function() {
	$('#dg').datagrid({
		url : 'findBorrowInfo',
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
		}, {
			field : 'ifback',
			title : '是否归还',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.ifback == 1){
					return "已归还";
				}else{
					return "未归还";
				}
			}
		}] ]
	});

	//判断是否是借阅到期提醒的请求,如果是加载未归还的图书借阅信息
    var source = $('#source').val();
    if(source != 0){
    	$('#layout').layout("remove","north");
    	$.ajax({
    		type : 'POST',
    		url : 'findBorrowInfo',
    		data : {
    			ifback : 0
    		},
    		success : function(result){
    			$('#dg').datagrid('loadData',result);
    		}
    	});
    }
})

// 查询按钮的事件
function query() {
	var json = {};
	var fromTime = $('#fromTime').val();
	var toTime = $('#toTime').val();
	if(fromTime != "" && toTime != ""){
		var dateReg = /((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/;
		if(!dateReg.test(fromTime)){
			layer.msg("开始日期格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
	    	return;
		}
		if(!dateReg.test(toTime)){
			layer.msg("结束日期格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
	    	return;
		}
	}
	json['barcode'] = $('#barcode').val();
	json['fromTime'] = fromTime;
	json['toTime'] = toTime;
	$.ajax({
		type : 'POST',
		url : 'findBorrowInfo',
		data : json,
		async : false,
		success : function(data) {
			$('#dg').datagrid('loadData', data);
		}
	});
}

// 重置按钮的事件
function flushForm() {
	$('#frmSearch').form('reset');
}