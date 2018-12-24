<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>书籍信息</title>
	<jsp:include page="/WEB-INF/jsp/link.jsp" />
	<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
	<script type="text/javascript" src="${APP_PATH }/script/findBookInfo.js"></script>
</head>
<body class="easyui-layout">
 	<!-- 该字段用于判断是否为读者登录 -->
    <input type="hidden" id="readerLogin" value="${reader }">
   <!-- 查询 -->
   <div data-options="region:'north',border:true" style="height:13%">
	   <form id="frmSearch" style="margin-top:20px;margin-left:20px;">
		   书名:&nbsp;<input id="bookname" name="bookname" class="easyui-textbox"/>&nbsp
	             作者:&nbsp;<input id="author" name="author" class="easyui-textbox"/>&nbsp
	     <a class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
	     <a class="easyui-linkbutton" iconCls="icon-reload" onclick="flushForm()">重置</a>
	   </form>
   </div>
   <!-- 书籍信息列表 -->
   <div data-options="region:'center',border:false" style="overflow: hidden;margin-top:5px">
     <table id="dg" class="easyui-datagrid" ></table>
   </div>
   <!-- 新增书籍对话框 -->
   <div id="addBookInfo" class="easyui-dialog" style="width:45%;height:60%" closed="true">
   </div>
   
   <!-- 修改书籍信息对话框 -->
   <div id="editBookInfo" class="easyui-dialog" title="修改书籍信息" style="width:45%;height:60%" closed="true">
      <h2 align="center">修改书籍信息</h2>
		<form id="frmEditBook" method="post"
			style="margin-left: 20px; margin-top: 10px">
			<input type="hidden" name="id">
			<input type="hidden" name="operator">
			<table>
				<tr>
					<td>条形码:</td>
					<td><input class="easyui-textbox" name="barcode" readonly="readonly" /></td>
					<td>图书名称:</td>
					<td><input class="easyui-textbox" name="bookname" /></td>
				</tr>
				<tr>
					<td>图书类型:</td>
					<td>
						<input id="bookType" class="easyui-combobox" name="bookType.id" 
						   data-options="valueField: 'id',textField: 'typename',url: 'getBookType',
						   panelHeight:'auto'">
					</td>
					<td>作者:</td>
					<td><input class="easyui-textbox" name="author" /></td>
				</tr>
				<tr>
					<td>出版社:</td>
					<td>
					   <input id="publishInfo" class="easyui-combobox" name="publishInfo.isbn" 
					   data-options="valueField: 'isbn',textField: 'pubname',url: 'getPublishInfo',
					   panelHeight:'auto'">
					</td>
					<td>价格:</td>
					<td><input class="easyui-numberbox" data-options="precision:2"
						name="price" /></td>
				</tr>
				<tr>
					<td>书架:</td>
					<td>
					  <input id="bookcase" class="easyui-combobox" name="bookcase.id" 
					   data-options="valueField: 'id',textField: 'name',url: 'getBookcase',
					   panelHeight:'auto'">
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
						onclick="closeDialog('frmEditBook','editBookInfo')">取消</a></td>
				</tr>
			</table>
		</form>
   </div>
</body>
</html>