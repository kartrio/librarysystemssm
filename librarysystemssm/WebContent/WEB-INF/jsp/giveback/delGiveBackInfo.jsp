<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript">
$(function() {
	$('#dg').datagrid({
		url : "findGiveBackInfo?status=2",
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
			field : 'backTime',
			title : '归还时间',
			align : 'center',
			width : 100
		}, {
			field : 'operator',
			title : '处理人',
			align : 'center',
			width : 100
		}] ],
		toolbar : [ {
			id : 'ConfirmGiveBack',
			text : '确认归还',
			iconCls : 'icon-ok',
			handler : confirmGiveBack
		},{
			id : 'RefuseGiveBack',
			text : '拒绝归还申请',
			iconCls : 'icon-undo',
			handler : refuseGiveBack
		} ]
	});
})

//同意归还
function confirmGiveBack(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
        type : 'POST',
        url : 'confirmGiveBack',
        data : {
        	'id' : row.id,
        	'operator' : $('#operator').val(),
        	'bookid' : row.bookInfo.id,
			'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
		    'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
        },
        success : function(data){
        	layer.msg("处理成功!", {time : 1000,icon : 6,shift : 2}, function() {
        		$('#dg').datagrid('loadData', data);
        	});
        },
		error : function(data){
			layer.msg("处理失败!", {time : 2000,icon : 5,shift : 6}, function() {});
		}
	});
}

//拒绝归还申请
function refuseGiveBack(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
        url : 'refuseGiveBack',
        data : {
        	'id' : row.id,
			'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
		    'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
        },
        success : function(data){
        	layer.msg("拒绝归还申请成功!", {time : 1000,icon : 6,shift : 2}, function() {
        		$('#dg').datagrid('loadData', data);
        	});
        },
		error : function(data){
			layer.msg("拒绝归还申请失败!", {time : 2000,icon : 5,shift : 6}, function() {});
		}
	});
}
</script>
</head>
<body class="easyui-layout">
    <input type="hidden" id="operator" value="${loginUserName }">
	<!-- 未处理借阅信息信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px;">

		<table id="dg" class="easyui-datagrid"></table>
	</div>
</body>
</html>