<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/script/findLibraryInfo.js"></script>
</head>
<body>
 	<!-- 该字段用于判断是否为读者登录 -->
    <input type="hidden" id="readerLogin" value="${reader }">
	<div align="center" style="margin-top: 2%">
		<form id="frmLibraryInfo" name="frmLibraryInfo" action="updateLibraryInfo" method="post">
			<input type="hidden" name="id">
			<table>
				<tr>
					<td>图书馆名称:</td>
					<td><input id="libraryname" class="easyui-textbox" name="libraryname"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>馆长:</td>
					<td><input id="curator" class="easyui-textbox" name="curator"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>联系电话:</td>
					<td><input id="tel" class="easyui-textbox" name="tel"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>联系地址:</td>
					<td><input id="address" class="easyui-textbox" name="address"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>联系邮箱:</td>
					<td><input id="email" class="easyui-textbox" name="email"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>图书馆网址:</td>
					<td><input id="url" class="easyui-textbox" name="url"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>建馆时间:</td>
					<td><input id="createDate" class="easyui-textbox" name="createDate"
						style="width: 200px" />(日期格式:2018-11-27)</td>
				</tr>
			</table>
			<div>
				<label>图书馆简介:</label> <input id="introduce" class="easyui-textbox" name="introduce"
					data-options="multiline:true" style="width: 380px; height: 100px" />
			</div>
			<div id="doUpdate" style="margin-top: 20px">
				<a class="easyui-linkbutton" style="width: 100px" onclick="doUpdate()">保存</a>
			</div>
		</form>
	</div>
</body>
</html>