<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>出版社信息</title>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/script/findPublishInfo.js"></script>
</head>
<body class="easyui-layout">
	<!-- 出版社信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px">
		<table id="dg" class="easyui-datagrid"></table>
	</div>
	<!-- 新增出版社对话框 -->
	<div id="addPublishInfo" class="easyui-dialog"
		style="width: 30%; height: 43%" title="新增出版社信息" closed="true">
		<h2 align="center">新增出版社信息</h2>
		<form id="frmAddPublishInfo" method="post"
			style="margin-left: 40px; margin-top: 10px">
			<table>
				<tr>
					<td>出版社代码:</td>
					<td><input class="easyui-textbox" name="isbn" /></td>
				</tr>
				<tr>
					<td>出版社名称:</td>
					<td><input class="easyui-textbox" name="pubname" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmAddPublishInfo','addPublishInfo')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- 修改出版社信息对话框 -->
	<div id="editPublishInfo" class="easyui-dialog" title="修改出版社信息"
		style="width: 30%; height: 43%" closed="true">
		<h2 align="center">修改出版社信息</h2>
		<form id="frmEditPublishInfo" method="post"
			style="margin-left: 40px; margin-top: 10px">
			<table>
				<tr>
					<td>出版社代码:</td>
					<td><input class="easyui-textbox" name="isbn"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>出版社名称:</td>
					<td><input class="easyui-textbox" name="pubname" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmEditPublishInfo','editPublishInfo')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>