<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome</title>
<link rel="stylesheet" href="${APP_PATH }/css/index.css" />
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/script/index.js"></script>
</head>
<body class="easyui-layout" style="cursor: pointer;">
	<div data-options="region:'north'"
		style="height: 10%; overflow: hidden; background: linear-gradient(to right, #6495ED, #8DEEEE);">
		<jsp:include page="/WEB-INF/jsp/top.jsp" />
	</div>

	<div data-options="region:'west',split:true" style="width: 10%">
		<div class="easyui-accordion" style="width: 100%; height: 100%">
			<c:if test="${role eq 'reader' }">
				<input type="hidden" id="readerStatus" value="${loginUserStatus }">
				<div title="系统信息" data-options="iconCls:'icon-set'" style="overflow: auto; padding: 10px;">
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('libraryInfoPage?reader=1','图书馆信息')">图书馆信息</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('bookcasePage?reader=1','书架信息')">书架信息</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('bookInfoPage?reader=1','图书信息')">图书信息</a>
					</div>
				</div>
				<c:if test="${loginUserStatus == 1 }">
					<div title="图书借还" data-options="iconCls:'icon-book'" style="padding: 10px;">
						<div align="center" style="margin-top: 10px; cursor: pointer;">
							<a onclick="addTab('borrowBookPage','图书借阅 ')">图书借阅 </a>
						</div>
						<div align="center" style="margin-top: 10px; cursor: pointer;">
							<a onclick="addTab('renewBookPage','图书续借')">图书续借</a>
						</div>
						<div align="center" style="margin-top: 10px; cursor: pointer;">
							<a onclick="addTab('giveBackPage','图书归还')">图书归还</a>
						</div>
					</div>
					<div title="借还信息查询" data-options="iconCls:'icon-tip'" style="padding: 10px;">
						<div align="center" style="margin-top: 10px; cursor: pointer;">
							<a onclick="addTab('findAllBorrowBookInfo','借阅信息查询')">借阅信息查询</a>
						</div>
						<div align="center" style="margin-top: 10px; cursor: pointer;">
							<a onclick="addTab('findAllGiveBackInfo','归还信息查询')">归还信息查询</a>
						</div>
					</div>
				</c:if>

			</c:if>

			<c:if test="${role eq 'manager' }">
				<div title="系统设置" data-options="iconCls:'icon-set'" style="overflow: auto; padding: 10px;">
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('libraryInfoPage?reader=0','图书馆信息')">图书馆信息</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('managerPage','管理员设置')">管理员设置</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('parameterInfoPage','参数设置')">参数设置</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('bookcasePage?reader=0','书架设置')">书架设置</a>
					</div>
				</div>
				<div title="读者管理" data-options="iconCls:'icon-man'" style="padding: 10px;">
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('readerTypePage','读者类型管理')">读者类型管理</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('readerInfoPage?manager=false','读者档案管理')">读者档案管理</a>
					</div>
				</div>
				<div title="图书管理" data-options="iconCls:'icon-book'" style="padding: 10px;">
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('bookTypePage','图书类型管理')">图书类型管理</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('bookInfoPage?reader=0','图书档案管理')">图书档案管理</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('publishInfoPage','出版社管理')">出版社管理</a>
					</div>
				</div>
				<div title="读者申请处理" data-options="iconCls:'icon-edit'" style="padding: 10px;">
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('delBorrowInfoPage','图书借阅处理 ')">图书借阅处理</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('delRenewBookPage','图书续借处理')">图书续借处理</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('delGiveBackInfoPage','图书归还处理')">图书归还处理</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('delApplyInfoPage','办证申请处理')">办证申请处理</a>
					</div>
				</div>
				<div title="系统查询" data-options="iconCls:'icon-new-tip'" style="padding: 10px;">
					<!-- <div align="center" style="margin-top:10px;cursor:pointer;">
			      <a href="#" onclick="add()">图书档案查询</a>
			    </div> -->
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('borrowInfoPage?source=0','图书借阅查询')">图书借阅查询</a>
					</div>
					<div align="center" style="margin-top: 10px; cursor: pointer;">
						<a onclick="addTab('borrowInfoPage?source=1','借阅到期提醒')">借阅到期提醒</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<div data-options="region:'south'" style="height: 5%">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</div>
	<div data-options="region:'center',split:true">
		<div id="tab" class="easyui-tabs" style="width: 100%; height: 100%">
		</div>
	</div>
</body>
</html>