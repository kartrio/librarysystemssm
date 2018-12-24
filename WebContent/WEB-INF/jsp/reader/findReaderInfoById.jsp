<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/script/findReaderInfoById.js"></script>
</head>
<body>
	<div align="center" style="margin-top:2%">
	    <input type="hidden" id="userId" value="${loginUserId }">
	    <input type="hidden" id="role" value="${role }">
		<form id="frmReaderInfo" method="post">
		    <input type="hidden" name="id" value="${loginUserId }"> 
			<table>
			    <tr>
					<td>条形码:</td>
					<td><input id="barcode" class="easyui-textbox" name="barcode" 
					style="width:200px" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input id="name" class="easyui-textbox" name="name" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input id="sex" class="easyui-textbox" name="sex" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>生日:</td>
					<td><input id="birthday" class="easyui-textbox" name="birthday" 
					style="width:200px"/>(日期格式:2018-11-27)</td>
				</tr>
				<tr>
					<td>证件类型:</td>
					<td><input id="paperType" class="easyui-textbox" name="paperType" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>证件号:</td>
					<td><input id="paperNO" class="easyui-textbox" name="paperNO" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>电话号码:</td>
					<td><input id="tel" class="easyui-textbox" name="tel" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><input id="email" class="easyui-textbox" name="email" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>借书证号:</td>
					<td><input id="libraryCard" class="easyui-textbox" name="libraryCard" 
					style="width:200px" readonly="readonly"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="margin-top:20px;margin-left: 35%">
			<a class="easyui-linkbutton" style="width: 100px" onclick="doUpdate()">保存</a>
			<a class="easyui-linkbutton" style="width: 100px" onclick="applyLibraryCard()">申请借书证</a>
    </div>
</body>
</html>