<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书类别</title>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/script/findBookType.js"></script>
</head>
<body class="easyui-layout">
	<!-- 查询 -->
	<div data-options="region:'north',border:true" style="height: 13%">
		<form id="frmSearch" style="margin-top: 20px; margin-left: 20px;">
			图书类别:&nbsp;<input id="typename" name="typename"
				class="easyui-textbox" />&nbsp 可借阅天数:&nbsp;<input id="days"
				name="days" class="easyui-textbox" />&nbsp <a
				class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
			<a class="easyui-linkbutton" iconCls="icon-reload"
				onclick="flushForm()">重置</a>
		</form>
	</div>
	<!-- 图书类别信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px">
		<table id="dg" class="easyui-datagrid"></table>
	</div>

	<!-- 新增图书类别对话框 -->
	<div id="addBookType" class="easyui-dialog" title="新增图书类别信息"
		style="width: 40%; height: 45%" align="center" closed="true">
		<h2>新增图书类别信息</h2>
		<form id="frmAddBookType" method="post"
			style="margin-left: 30px; margin-top: 10px">
			<table>
				<tr>
					<td>图书类别:</td>
					<td><input class="easyui-textbox" name="typename" /></td>
				</tr>
				<tr>
					<td>可借阅天数:</td>
					<td><input class="easyui-textbox" name="days" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td style="padding-left:30px">
					<a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmAddBookType','addBookType')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- 修改图书类别对话框 -->
	<div id="editBookType" class="easyui-dialog" title="修改图书类别信息"
		style="width: 40%; height: 45%" align="center" closed="true">
		<h2>修改图书类别信息</h2>
		<form id="frmEditBookType" method="post"
			style="margin-left: 30px; margin-top: 10px">
			<input type="hidden" name="id">
			<table>
				<tr>
					<td>图书类别:</td>
					<td><input class="easyui-textbox" name="typename" /></td>
				</tr>
				<tr>
					<td>可借阅天数:</td>
					<td><input class="easyui-textbox" name="days" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td style="padding-left:30px">
					<a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmEditBookType','editBookType')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>