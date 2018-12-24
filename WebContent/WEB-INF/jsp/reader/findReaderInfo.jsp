<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>读者信息</title>
	<jsp:include page="/WEB-INF/jsp/link.jsp" />
	<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
	<script type="text/javascript" src="${APP_PATH }/script/findReaderInfo.js"></script>
</head>
<body class="easyui-layout">
   <!-- 该字段用于确定是否是管理员设置页面的请求 -->
   <input type="hidden" id="manager" name="manager" value="${manager }">
   <!-- 传递分页信息 -->
   <input type="hidden" id="page" name="page" value="${page }">
   <input type="hidden" id="rows" name="rows" value="${rows }">
   <!-- 查询 -->
   <div data-options="region:'north',border:true" style="height:13%">
	   <form id="frmSearch" style="margin-top:20px;margin-left:20px;">
		   读者姓名:&nbsp;<input id="name" name="name" class="easyui-textbox" style="width: 150px" />&nbsp
	     <a class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查询</a>&nbsp
	     <a class="easyui-linkbutton" iconCls="icon-reload" onclick="flushForm()">重置</a>
	   </form>
   </div>
   <!-- 读者信息列表 -->
   <div data-options="region:'center',border:false" style="overflow: hidden;margin-top:5px">
    
     <table id="readerDg" class="easyui-datagrid" ></table>
   </div>
</body>
</html>