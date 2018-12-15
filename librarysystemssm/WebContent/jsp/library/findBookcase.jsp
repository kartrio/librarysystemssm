<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/jsp/library/findBookcase.js"></script>
</head>
<body class="easyui-layout">
	<!-- 书架信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px">
		<table id="dg" class="easyui-datagrid"></table>
	</div>
	
	<!-- 新增书架对话框 -->
	<div id="addBookcase" class="easyui-dialog" title="新增书架信息"
		style="width: 40%; height: 35%" align="center" closed="true">
		<h2>新增书架信息</h2>
		<form id="frmAddBookcase" method="post"
			style="margin-left: 30px; margin-top: 10px">
			<table>
				<tr>
					<td>书架名称:</td>
					<td><input class="easyui-textbox" name="name" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td style="padding-left:30px">
					<a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmAddBookcase','addBookcase')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 修改书架信息对话框 -->
	<div id="editBookcase" class="easyui-dialog" title="修改书架信息"
		style="width: 40%; height: 35%" align="center" closed="true">
		<h2>修改书架信息</h2>
		<form id="frmEditBookcase" method="post"
			style="margin-left: 30px; margin-top: 10px">
			<input type="hidden" name="id">
			<table>
				<tr>
					<td>图书类别:</td>
					<td><input class="easyui-textbox" name="name" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td style="padding-left:30px">
					<a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmEditBookcase','editBookcase')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>