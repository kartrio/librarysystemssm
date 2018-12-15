<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/jsp/library/findManager.js"></script>
</head>
<body class="easyui-layout">
    
    <!-- 查询 -->
    <div data-options="region:'north',border:true" style="height:13%">
	   <form id="frmSearch" style="margin-top:20px;margin-left:20px;">
		   管理员姓名:&nbsp;<input id="adminName" name="name" class="easyui-textbox"/>&nbsp
	     <a class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
	     <a class="easyui-linkbutton" iconCls="icon-reload" onclick="flushForm()">重置</a>
	   </form>
    </div>
    
	<!-- 管理员信息列表 -->
	<div data-options="region:'center',border:false"
		style="overflow: hidden; margin-top: 5px">
		<table id="dg" class="easyui-datagrid"></table>
	</div>
	
	<!-- 新增管理员信息对话框 -->
	<div id="addManager" class="easyui-dialog" title="新增管理员信息"
		style="width: 80%; height: 90%" align="center" closed="true">
		<div class="easyui-layout" style="width: 100%; height: 100%">
		   <iframe id="linkToReader" frameborder='no' border='0' style="width:100%;height:100%"></iframe>
		</div>
	</div>
	
</body>
</html>