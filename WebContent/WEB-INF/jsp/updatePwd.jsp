<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript">
	//修改参数信息
	function doUpdate(){
		var initalPwd = $('#initalPwd').val();
		if (initalPwd == "") {
			layer.msg("初始密码为空!", {time : 1000,icon : 5,shift : 6}, function() {});
			return;
		}
		var newPwd = $('#newPwd').val();
		if (newPwd == "") {
			layer.msg("新密码为空!", {time : 1000,icon : 5,shift : 6}, function() {});
			return;
		}
		var checkPwd = $('#checkPwd').val();
		if (checkPwd == "") {
			layer.msg("确认新密码为空!", {time : 1000,icon : 5,shift : 6}, function() {});
			return;
		}
		
		if(newPwd != checkPwd){
			layer.msg("新密码与确认新密码不同!", {time : 1000,icon : 5,shift : 6}, function() {});
			return;
		}
		
		$.ajax({
			type : 'POST',
			url : 'updatePwd',
			data : {
				'id' : $('#userId').val(),
				'role' : $('#role').val(),
				'initalPwd' : initalPwd,
				'newPwd' : newPwd
			},
			success : function(result){
				if(result.success){
					layer.msg("修改成功,请重新登录!", {time : 1000,icon : 6,shift : 2}, function() {
						parent.window.location.href='loginPage';
					});
			  }else{
					layer.msg(result.data, {time : 2000,icon : 5,shift : 6}, function() {});
				  }
			}
	  });
	}
</script>
</head>
<body>
	<div align="center" style="margin-top:2%">
	    <input type="hidden" id="userId" value="${loginUserId }">
	    <input type="hidden" id="role" value="${role }">
		<form id="frmUpdatePassword" method="post">
		    <input type="hidden" name="id"> 
			<table>
				<tr>
					<td>初始密码:</td>
					<td><input id="initalPwd" type="password" class="easyui-textbox" name="initalPwd" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input id="newPwd" type="password" class="easyui-textbox" name="newPwd" 
					style="width:200px"/></td>
				</tr>
				<tr>
					<td>确认新密码:</td>
					<td><input id="checkPwd" type="password" class="easyui-textbox" name="checkPwd" 
					style="width:200px"/></td>
				</tr>
			</table>
			<div style="margin-top:20px">
			   <a class="easyui-linkbutton" style="width: 100px" onclick="doUpdate()">保存</a>
			</div>
		</form>

	</div>
</body>
</html>