// 页面加载成功时执行
$(function() {
	$('#readerDg').datagrid({
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
			title : '读者名',
			align : 'center',
			width : 100
		}, {
			field : 'typeid',
			title : '读者类别',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {// 解决多个对象嵌套无法直接作为列的情况
				return row.readerType.name;
			}
		}, {
			field : "birthday",
			title : '出生日期',
			align : 'center',
			width : 100
		}, {
			field : 'paperType',
			title : '注册证件',
			align : 'center',
			width : 100
		}, {
			field : 'tel',
			title : '联系电话',
			align : 'center',
			width : 100
		}, {
			field : 'email',
			title : '电子邮箱',
			align : 'center',
			width : 110
		},{
			field : 'createDate',
			title : '注册日期',
			align : 'center',
			width : 100
		},{
			field : 'status',
			title : '同意注册',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.status == 0){
					return "未同意";
				}else{
					return "同意";
				}
			}
		} ] ],
		toolbar : [ {
			id : 'AgreeRegister',
			text : '同意注册',
			iconCls : 'icon-remove',
			handler : agreeRegister
		},{
			id : 'ReaderInfoDelete',
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		},{
			id : 'ReaderInfoSelect',
			text : '新增管理员',
			iconCls : 'icon-ok',
			handler : addNewManager
		}]
	});
	
	var manager = $('#manager').val();
	if(manager == "true"){
		$('#AgreeRegister').hide();
		$('#ReaderInfoDelete').hide();
		$.ajax({
			type : 'POST',
			url : 'findReaderInfo?status=1',
			async : false,
			success : function(result){
				$('#readerDg').datagrid('loadData', result);
			}
		});
	}else{
		$('#ReaderInfoSelect').hide();
		$.ajax({
			type : 'POST',
			url : 'findReaderInfo',
			async : false,
			success : function(result){
				$('#readerDg').datagrid('loadData', result);
			}
		});
	}
})

// 查询按钮的事件
function query() {
	var json = {};
	json['name'] = $('#name').val();
	$.ajax({
		type : 'POST',
		url : 'findReaderInfo',
		data : json,
		async : false,
		success : function(data) {
			$('#readerDg').datagrid('loadData', data);
		}
	});
}

// 点击删除按钮触发
function del() {
	var row = $('#readerDg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.messager.confirm("操作提示", "确认删除该记录?", function(r) {
		if (r) {
			$.ajax({
				type : 'post',
				url : 'deleteReaderInfo',
				data : {
					'id' : row.id,
					'page' : $('#readerDg').datagrid('getPager').data("pagination").options.pageNumber,
					'rows' : $('#readerDg').datagrid('getPager').data("pagination").options.pageSize
				},
				success : function(result) {
					layer.msg("删除读者信息成功!", {
						time : 1000,
						icon : 6,
						shift : 2
					}, function() {
						$('#readerDg').datagrid('loadData', result);
					});
					
				},
				error : function(result){
					layer.msg("删除读者信息失败!", {
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

//新增管理员
function addNewManager(){
	var row = $('#readerDg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.messager.confirm("操作提示", "确认设置选中用户为管理员?", function(r) {
		if (r) {
			$.ajax({
				type : 'POST',
				url : 'addManager',
				data : {
					'name' : row.name,
					'PWD' : row.pwd,
					'page' : $('#page').val(),
					'rows' : $('#rows').val()
				},
				success : function(result){
					if(result.errorMsg == 1){
						layer.msg("管理员已存在,请重新选择!", {
							time : 2000,
							icon : 5,
							shift : 6
						}, function() {
						});
					}else{
						layer.msg("添加管理员成功!", {
							time : 1000,
							icon : 6,
							shift : 2
						}, function() {
							parent.$('#addManager').dialog('close');
							parent.$('#dg').datagrid('reload');
						});
					}
				},
				error : function(result){
					layer.msg("添加管理员失败!", {
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

//同意用户注册
function agreeRegister(){
	var row = $('#readerDg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'agreeRegister',
		data : {
			'id' : row.id,
			'page' : $('#readerDg').datagrid('getPager').data("pagination").options.pageNumber,
		    'rows' : $('#readerDg').datagrid('getPager').data("pagination").options.pageSize
		},
		success : function(result){
			layer.msg("确认成功!", {time : 2000,icon : 6,shift : 2}, function() {
				$('#readerDg').datagrid("loadData",result);				
			});
		},
		error : function(data){
			layer.msg("确认失败!", {time : 2000,icon : 5,shift : 6}, function() {});
		}
	});
}

// 重置按钮的事件
function flushForm() {
	$('#frmSearch').form('reset');
}