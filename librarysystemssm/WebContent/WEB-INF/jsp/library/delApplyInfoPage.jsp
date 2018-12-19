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
		url : "findApplyInfo?del=0",
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
			field : 'del',
			title : '处理结果',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.del == 0){
					return "新建";
				}else if(del == 1){
					return "同意";
				}else{
					return "不同意";
				}
			}
		}] ],
		toolbar : [ {
			id : 'AgreeApply',
			text : '同意办证申请',
			iconCls : 'icon-ok',
			handler : agreeApply
		},{
			id : 'DisAgreeApply',
			text : '拒绝办证申请',
			iconCls : 'icon-undo',
			handler : disagreeApply
		} ]
	});
})

//同意办证
function agreeApply(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'agreeApply',
		data : {
			'id' : row.id,
			'readerid' : row.readerInfo.id,
			'operator' : $('#operator').val(),
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

//拒绝办证申请
function disagreeApply(){
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert("系统提示", "请先选择一条记录", "info");
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'disagreeApply',
		data : {
			'id' : row.id,
			'operator' : $('#operator').val(),
			'page' : $('#dg').datagrid('getPager').data("pagination").options.pageNumber,
			'rows' : $('#dg').datagrid('getPager').data("pagination").options.pageSize
		},
        success : function(data){
        	layer.msg("拒绝办证申请成功!", {time : 1000,icon : 6,shift : 2}, function() {
        		$('#dg').datagrid('loadData', data);
        	});
        },
		error : function(data){
			layer.msg("拒绝办证申请失败!", {time : 2000,icon : 5,shift : 6}, function() {});
		}
	});
}
</script>
</head>
<body class="easyui-layout">
    <input type="hidden" id="operator" value="${loginUserName }">
	<!-- 办证申请信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px;">

		<table id="dg" class="easyui-datagrid"></table>
	</div>
</body>
</html>