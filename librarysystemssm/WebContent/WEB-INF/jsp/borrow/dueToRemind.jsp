<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书借阅信息查询</title>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/script/dueToRemind.js"></script>
</head>
<body id="layout" class="easyui-layout">
    <input type="hidden" id="toTime" value="${toTime }">
	<!-- 借阅信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px">
		<table id="dg" class="easyui-datagrid"></table>
	</div>
</body>
</html>