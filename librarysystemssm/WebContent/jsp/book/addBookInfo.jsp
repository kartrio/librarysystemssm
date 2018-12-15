<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增书籍信息</title>
<jsp:include page="/link.jsp" />
<script type="text/javascript" src="jsp/findBookInfo.js"></script>
</head>
<body>
	<div>
		<h2 align="center">新增书籍</h2>
		<form id="frmAddBook" method="post" style="margin-left: 20px; margin-top: 10px">
			<input type="hidden" name="operator" value="${loginUser }">
			<table>
				<tr>
					<td>条形码:</td>
					<td><input class="easyui-textbox" name="barcode" /></td>
					<td>图书名称:</td>
					<td><input class="easyui-textbox" name="bookname" /></td>
				</tr>
				<tr>
					<td>图书类型:</td>
					<td>
					   <input class="easyui-combobox" name="bookType.id" 
					   data-options="valueField: 'id',textField: 'typename',url: 'getBookType',
					   panelHeight:'auto',value:1">
					</td>
					<td>作者:</td>
					<td><input class="easyui-textbox" name="author" /></td>
				</tr>
				<tr>
					<td>出版社:</td>
					<td>
					<input class="easyui-combobox" name="publishInfo.isbn" 
					   data-options="valueField: 'isbn',textField: 'pubname',url: 'getPublishInfo',
					   panelHeight:'auto',value:'7-302'">
					</td>
					<td>价格:</td>
					<td><input class="easyui-numberbox" data-options="precision:2"
						name="price" /></td>
				</tr>
				<tr>
					<td>书架:</td>
					<td>
					   <input class="easyui-combobox" name="bookcase.id" 
					   data-options="valueField: 'id',textField: 'name',url: 'getBookcase',
					   panelHeight:'auto',value:1">
					</td>
					<td>页数:</td>
					<td><input class="easyui-numberbox" name="page" /></td>
				</tr>
				<tr>
					<td></td>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="submit()">提交</a></td>
					<td></td>
					<td><a class="easyui-linkbutton" style="width: 100px"
						onclick="closeDialog('frmAddBook','addBookInfo')">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>