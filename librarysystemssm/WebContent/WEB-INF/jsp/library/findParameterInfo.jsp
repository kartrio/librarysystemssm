<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/link.jsp" />
<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : 'POST',
			url : 'findParameterInfo',
			success : function(result) {
				if (result.success) {
					$('#frmParameterInfo').form('load', result.data);
				} else {
					layer.msg(result.data, {
						time : 2000,
						icon : 5,
						shift : 6
					}, function() {
					});
				}
			}
		});
	});
	
	//修改参数信息
	function doUpdate(){
		var cost = $('#cost').val();
		if (cost == "") {
			layer.msg("办证费为空!", {time : 1000,icon : 5,shift : 6}, function() {});
			return;
		}
		var validity = $('#validity').val();
		if (validity == "") {
			layer.msg("有效期限为空!", {time : 1000,icon : 5,shift : 6}, function() {});
			return;
		}
		$.ajax({
			type : 'POST',
			url : 'updateParameterInfo',
			data : $('#frmParameterInfo').serializeArray(),
			success : function(result){
				if(result.success){
					layer.msg("保存成功!", {
					time : 1000,
					icon : 6,
					shift : 2
				}, function() {
					$('#frmParameterInfo').form('load', result.data);
				});
			  }else{
					layer.msg("保存失败!", {time : 2000,icon : 5,shift : 6}, function() {});
				  }
			}
	  });
	}
</script>
</head>
<body>
	<div align="center" style="margin-top:2%">
		<form id="frmParameterInfo" action="updateParameterInfo" method="post">
		    <input type="hidden" name="id"> 
			<table>
				<tr>
					<td>办证费:</td>
					<td><input class="easyui-textbox" name="cost" style="width:200px"/>(元)</td>
				</tr>
				<tr>
					<td>有效期限:</td>
					<td><input class="easyui-textbox" name="validity" style="width:200px"/>(月)</td>
				</tr>
			</table>
			<div style="margin-top:20px">
			   <a class="easyui-linkbutton" style="width: 100px" onclick="doUpdate()">保存</a>
			</div>
		</form>

	</div>
</body>
</html>