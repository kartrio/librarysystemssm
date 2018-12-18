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
					layer.msg("修改成功,请重新登录!", {time : 1000,icon : 6,shift : 2}, function() {
						parent.window.location.href = "loginPage";
					});
			    }else{
					layer.msg(result.data, {time : 2000,icon : 5,shift : 6}, function() {});
				}
			}
	  });
	}
    
    //办理借书证
    function applyLibraryCard(){
    	var libraryCard = $('#libraryCard').val();
    	if(libraryCard != ''){
    		layer.msg("您已办理过借书证!", {time : 2000,icon : 5,shift : 6}, function() {});
    		return;
    	}
    	$.ajax({
    		type : 'POST',
    		url : 'applyLibraryCard',
    		data : {
    			'readerId' : $('#userId').val()
    		},
    	    success : function(result){
    	    	if(result.success){
					layer.msg("申请成功,请等待管理员审核!", {time : 1000,icon : 6,shift : 2}, function() {
					});
			    }else{
					layer.msg(result.data, {time : 2000,icon : 5,shift : 6}, function() {});
				}
    	    }
    	});
    }