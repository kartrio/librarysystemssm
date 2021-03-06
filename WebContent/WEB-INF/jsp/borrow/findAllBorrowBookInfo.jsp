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
		}, {
			field : 'status',
			title : '借阅状态',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				if(row.status == 0){
					return "新建";
				}else if(row.status == 1){
					return "已处理";
				}else if(row.status == 2){
					return "归还";
				}else if(row.status == 3){
					return "续借";
				}else if(row.status == 4){
					return "拒绝借阅";
				}else{
					return "拒绝续借";
				} 
			}
		}] ]
	});
})
</script>
</head>
<body class="easyui-layout">
    <!-- 获取读者的id -->
    <input type="hidden" id="readerid" value="${loginUserId }">
	<!-- 查询 -->
	<!-- <div data-options="region:'north',border:true" style="height: 13%">
		<form id="frmSearch" style="margin-top: 20px; margin-left: 20px;">
			图书条形码:&nbsp;<input id="barcode" name="barcode" class="easyui-textbox" />&nbsp
			书名:&nbsp;<input id="bookname" name="bookname" class="easyui-textbox" />&nbsp
			<a class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
			<a class="easyui-linkbutton" iconCls="icon-reload"
				onclick="flushForm()">重置</a>
		</form>
	</div> -->
	
	<!-- 图书信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px;">

		<table id="dg" class="easyui-datagrid"></table>
	</div>
</body>
</html>