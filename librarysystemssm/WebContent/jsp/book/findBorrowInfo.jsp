<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书借阅信息查询</title>
<jsp:include page="/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/jsp/book/findBorrowInfo.js"></script>
</head>
<body id="layout" class="easyui-layout">
    <!-- 该字段用于判断请求的来源 -->
    <input type="hidden" id="source" value="${source }"> 
	<!-- 查询 -->
	<div id="divSearch" data-options="region:'north',border:true" style="height: 13%">
		<form id="frmSearch" style="margin-top: 20px; margin-left: 20px;">
			图书条形码:&nbsp;<input id="barcode" name="barcode" class="easyui-textbox" />&nbsp 
		         借阅时间:&nbsp;从:&nbsp;<input id="fromTime" name="fromTime" class="easyui-textbox" />&nbsp
		          到&nbsp;<input id="toTime" name="toTime" class="easyui-textbox" />(日期格式:2018-11-27)&nbsp
		    &nbsp <a class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
			<a class="easyui-linkbutton" iconCls="icon-reload"
				onclick="flushForm()">重置</a>
		</form>
	</div>
	<!-- 借阅信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px">
		<table id="dg" class="easyui-datagrid"></table>
	</div>
</body>
</html>