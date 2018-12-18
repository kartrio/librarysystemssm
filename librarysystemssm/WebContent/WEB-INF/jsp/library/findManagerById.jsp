<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript">
    $(function(){
    	$.ajax({
    		type : 'POST',
			url : 'getManagerById',
			data : {
				'id' : $('#userId').val()
			},
			success : function(result){
				if(result.success){
					layer.msg("查询成功,载入表单!", {time : 1000,icon : 6,shift : 2}, function() {
						$('#frmManager').form('load', result.data);
					});
			    }else{
					layer.msg("查询失败!", {time : 2000,icon : 5,shift : 6}, function() {});
				}
			}
    	});
    })
    
	//修改读者信息
	function doUpdate(){
    	
    	var name = $("#name").val;
    	if (name == "") {
    		layer.msg("姓名为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}
    	
		$.ajax({
			type : 'POST',
			url : 'updateManager',
			data : $('#frmManager').serializeArray(),
			success : function(result){
				if(result.success){
					layer.msg("修改成功!", {time : 1000,icon : 6,shift : 2}, function() {
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
		<form id="frmManager" method="post">
		    <input type="hidden" name="id" value="${loginUserId }"> 
			<table>
				<tr>
					<td>姓名:</td>
					<td><input id="name" class="easyui-textbox" name="name" 
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