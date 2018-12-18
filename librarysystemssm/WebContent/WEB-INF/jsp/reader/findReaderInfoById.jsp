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
			url : 'findReaderInfoById',
			data : {
				'id' : $('#userId').val()
			},
			success : function(result){
				if(result.success){
					layer.msg("查询成功,载入表单!", {time : 1000,icon : 6,shift : 2}, function() {
						$('#frmReaderInfo').form('load', result.data);
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
    	
    	var sex = $("#sex").val;
    	if (sex == "") {
    		layer.msg("性别为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}
    	
    	var birthday = $('#birthday').val();
    	if (birthday == "") {
    		layer.msg("生日为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}else{
    		var dateReg = /((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/;
    		if(!dateReg.test(birthday)){
    			layer.msg("生日格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
    	    	return;
    		}
    	}
    	
    	var paperType = $("#paperType").val;
    	if (paperType == "") {
    		layer.msg("证件类型为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}
    	
    	var paperNo = $("#paperNo").val;
    	if (paperNo == "") {
    		layer.msg("证件号为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}
    	
    	var tel = $('#tel').val();
    	if (tel == "") {
    		layer.msg("电话号码为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}else{
    		var isPhone = /^1[34578]\d{9}$/;//手机号码
    		var isMob = /^0(([1,2]\d)|([3-9]\d{2}))\d{7,8}$/; //电话号码
    	    if(!isPhone.test(tel)&&!isMob.test(tel)){
    	    	layer.msg("电话号码格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
    	    	return;
    	    }
    	}
    	
    	var email = $('#email').val();
    	if (email == "") {
    		layer.msg("邮箱为空!", {time : 1000,icon : 5,shift : 6}, function() {});
    		return;
    	}else{
    		var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    		if(!mailReg.test(email)){
    			layer.msg("邮箱格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
    	    	return;
    		}
    	}
    	
		$.ajax({
			type : 'POST',
			url : 'updateReaderInfo',
			data : $('#frmReaderInfo').serializeArray(),
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
			</table>
			<div style="margin-top:20px">
			   <a class="easyui-linkbutton" style="width: 100px" onclick="doUpdate()">保存</a>
			</div>
		</form>

	</div>
</body>
</html>