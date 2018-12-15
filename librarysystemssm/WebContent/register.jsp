<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="${APP_PATH }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH }/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH }/css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" style="font-size: 32px;">读者注册</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">
		<form id="registerForm" class="form-signin" role="form">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-user"></i> 注册
			</h2>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="name" name="name"
					placeholder="账户名" autofocus> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="pwd" name="pwd"
					placeholder="密码" style="margin-top: 10px;"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback form-inline">
			    <label class="label label-info" style="font-size: 14px">性别:</label>
			    <div class="radio" style="margin-left: 30px">
				   <label>
				      <input type="radio" name="sex" value="男" checked> 男
				   </label>
				</div>
				<div class="radio" style="margin-left: 30px">
				   <label>
				      <input type="radio" name="sex" value="女"> 女
				   </label>
				</div>
			</div>
			<div class="form-group has-success has-feedback">
				<select id="readerTypeId" name="readerType.id" class="form-control">
					<c:if test="${not empty  readerTypeList}">
						<c:forEach items="${readerTypeList }" var="readerType">
							<option value="${readerType.id }">${readerType.name }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="form-group has-success has-feedback">
					<input type="text" class="form-control" id="birthday"
						name="birthday" placeholder="生日(格式:2018-12-14)"
						style="margin-top: 10px;">
		    </div>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="tel" name="tel"
					placeholder="电话" style="margin-top: 10px;">
			</div>
		    <div id="extraInfo" class="collapse">
			<div class="form-group has-success has-feedback">
				<select id="paperType" name="paperType" class="form-control">
					<option value="身份证">身份证</option>
					<option value="护照">护照</option>
				</select>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="paperNO" name="paperNO"
					placeholder="证件号" style="margin-top: 10px;">
			</div>
				<div class="form-group has-success has-feedback">
					<input type="text" class="form-control" id="email" name="email"
						placeholder="电子邮箱" style="margin-top: 10px;">
				</div>
				<div class="form-group has-success has-feedback">
					<input type="text" class="form-control" id="remark" name="remark"
						placeholder="备注" style="margin-top: 10px;">
				</div>
			</div>
			<div class="form-group has-success has-feedback form-inline">
				<input type="text" class="form-control" id="checkcode"
					name="checkcode" placeholder="验证码" style="width: 60%;" autofocus>
				<img id="checkImage" class="img-rounded"
					src="${APP_PATH }/checkcode" onclick="doRefresh()" />
			</div>
			<div class="form-inline">
				<a class="btn btn-lg btn-success" onclick="doRegister()"> 注册</a> <a
					id="showHiddenForm" class="btn btn-lg btn-success"
					onclick="showHiddenForm()">显示</a> <label>点击显示,显示可选内容</label>
			</div>
		</form>
	</div>
	<script src="${APP_PATH }/easyui1.6/jquery.min.js"></script>
	<script src="${APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
	<script>
		$(function() {
			//隐藏或显示折叠内容时修改按钮显示的文本信息
			$("#extraInfo").on("hide.bs.collapse", function() {
				$('#showHiddenForm').text("显示");
			});
			$("#extraInfo").on("show.bs.collapse", function() {
				$('#showHiddenForm').text("隐藏");
			});
		})

		//进行注册
		function doRegister(){
			var name = $('#name').val();
			if (name == "") {
				layer.msg("用户名为空!", {time : 1000,icon : 5,shift : 6}, function() {});
				return;
			}
			
			var pwd = $('#pwd').val();
			if (pwd == "") {
				layer.msg("密码为空!", {time : 1000,icon : 5,shift : 6}, function() {});
				return;
			}
			
			/* var paperNO = $('#paperNO').val();
			if (paperNO == "") {
				layer.msg("证件号为空!", {time : 1000,icon : 5,shift : 6}, function() {});
				return;
			} */
			
			var tel = $('#tel').val();
			if (tel == "") {
				layer.msg("联系电话为空!", {time : 1000,icon : 5,shift : 6}, function() {});
				return;
			}else{
				var isPhone = /^1[34578]\d{9}$/;//手机号码
				var isMob = /^0(([1,2]\d)|([3-9]\d{2}))\d{7,8}$/; //电话号码
			    if(!isPhone.test(tel)&&!isMob.test(tel)){
			    	layer.msg("联系电话格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
			    	return;
			    }
			}
			
			var birthday = $('#birthday').val();
			if(birthday != ""){
				var dateReg = /((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/;
				if(!dateReg.test(birthday)){
					layer.msg("日期格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
			    	return;
				}
			}else{
				layer.msg("出生日期为空!", {time : 1000,icon : 5,shift : 6}, function() {});
			}
			
			var email = $('#email').val();
			if(email != ""){
				var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
				if(!mailReg.test(email)){
					layer.msg("邮箱格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
			    	return;
				}
			}
			
			var checkcode = $('#checkcode').val();
			if (checkcode == "") {
				layer.msg("验证码为空!", {time : 1000,icon : 5,shift : 6}, function() {});
				return;
			}
			$.ajax({
				type : 'POST',
				url : 'doRegister',
				data : $('#registerForm').serializeArray(),
				success : function(result){
					if(result.success){
						layer.msg("注册成功,返回登录页面!", {time : 1000,icon : 6,shift : 2}, function() {
							window.location.href =  "loginPage";
						});
					}else{
						layer.msg(result.data, {time : 1000,icon : 5,shift : 6}, function() {});
					}
				}
			});
		}
		
		//进行可选填内容的折叠显示
		function showHiddenForm() {
			$('#extraInfo').collapse('toggle');
		}

		//刷新验证码
		function doRefresh() {
			//增加时间参数来保证每次点击时url的不同
			$('#checkImage').attr('src',
					'${APP_PATH }/checkcode?date=' + new Date());
		}
	</script>
</body>
</html>