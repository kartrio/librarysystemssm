<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<link rel="stylesheet" href="${APP_PATH }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH }/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH }/css/login.css">
<link rel="stylesheet" href="${APP_PATH }/css/index.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" style="font-size: 32px;">系统登录</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container" >
		<form id="loginForm" class="form-signin" role="form">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-user"></i> 登录
			</h2>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="acct" name="name"
					placeholder="请输入登录账户" autofocus> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="password" class="form-control" id="pwd" name="password"
					placeholder="请输入登录密码" style="margin-top: 10px;"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<select id="role" name="role" class="form-control">
					<option value="reader">读者</option>
					<option value="manager">管理员</option>
				</select>
			</div>
			<div class="form-group has-success has-feedback form-inline">
				<input type="text" class="form-control" id="checkcode"
					name="checkcode" placeholder="验证码" style="width: 60%;" autofocus>
				<img id="checkImage" class="img-rounded" src="${APP_PATH }/checkcode" onclick="doRefresh()"/>
			</div>
			<div class="checkbox">
				<label> </label> <label style="float: right"> <a href="registerPage">我要注册</a>
				</label>
			</div>
			<a class="btn btn-lg btn-success btn-block" onclick="dologin()">
				登录</a>
		</form>
	</div>
	<script src="${APP_PATH }/easyui1.6/jquery.min.js"></script>
	<script src="${APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/layer/layer.js"></script>
	<script>
	    //登录
		function dologin() {
			var type = $(":selected").val();
			var acct = $('#acct').val();
			if (acct == "") {
				layer.msg("用户名为空!", {
					time : 1000,
					icon : 5,
					shift : 6
				}, function() {
				});
				return;
			}

			var pwd = $('#pwd').val();
			if (pwd == "") {
				layer.msg("密码为空!", {
					time : 1000,
					icon : 5,
					shift : 6
				}, function() {
				});
				return;
			}

			var checkcode = $('#checkcode').val();
			if (checkcode == "") {
				layer.msg("验证码为空!", {
					time : 1000,
					icon : 5,
					shift : 6
				}, function() {
				});
				return;
			}
			var role = $('#role').val();

			var loadingIndex = null;
			$.ajax({
				type : 'POST',
				url : '${APP_PATH}/login',
				data : {
					'name' : acct,
					'password' : pwd,
					'role' : role,
					'checkcode' : checkcode
				},
				beforeSend : function() {
					loadingIndex = layer.msg('加载中', {
						icon : 16
					});
				},
				success : function(result) {
					layer.close(loadingIndex);
					if (result.success) {
						layer.msg("登录成功!", {
							time : 1000,
							icon : 6,
							shift : 2
						}, function() {
							window.location.href =  "goMainPage";
						});
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
		}
	    
	   //刷新验证码
	   function doRefresh(){
		   //增加时间参数来保证每次点击时url的不同
		   $('#checkImage').attr('src','${APP_PATH }/checkcode?date=' + new Date());
	   }
	</script>
</body>
</html>