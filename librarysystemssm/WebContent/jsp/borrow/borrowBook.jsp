<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/jsp/borrow/borrowBook.js"></script>
</head>
<body class="easyui-layout">
    <!-- 获取读者的id -->
    <input type="hidden" id="readerid" value="${loginUserId }">
	<!-- 查询 -->
	<div data-options="region:'north',border:true" style="height: 13%">
		<form id="frmSearch" style="margin-top: 20px; margin-left: 20px;">
			图书条形码:&nbsp;<input id="barcode" name="barcode" class="easyui-textbox" />&nbsp
			书名:&nbsp;<input id="bookname" name="bookname" class="easyui-textbox" />&nbsp
			<a class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
			<a class="easyui-linkbutton" iconCls="icon-reload"
				onclick="flushForm()">重置</a>
		</form>
	</div>
	
	<!-- 图书信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px;">

		<table id="dg" class="easyui-datagrid"></table>
	</div>
</body>
</html>