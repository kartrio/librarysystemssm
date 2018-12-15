$(function() {
	$.ajax({
		type : 'POST',
		url : 'findLibraryInfo',
		success : function(result) {
			if (result.success) {
				$('#frmLibraryInfo').form('load', result.data);
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

//修改图书馆信息
function doUpdate(){
	var libraryname = $('#libraryname').val();
	if (libraryname == "") {
		layer.msg("图书馆名称为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}
	var curator = $('#curator').val();
	if (curator == "") {
		layer.msg("馆长名为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}
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
	var address = $('#address').val();
	if (address == "") {
		layer.msg("联系地址为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}
	var email = $('#email').val();
	if (email == "") {
		layer.msg("联系邮箱为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}else{
		var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
		if(!mailReg.test(email)){
			layer.msg("邮箱格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
	    	return;
		}
	}
	var url = $('#url').val();
	if (url == "") {
		layer.msg("图书馆网址为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}
	var createDate = $('#createDate').val();
	if (createDate == "") {
		layer.msg("建馆时间为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}else{
		var dateReg = /((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/;
		if(!dateReg.test(createDate)){
			layer.msg("日期格式错误!", {time : 1000,icon : 5,shift : 6}, function() {});
	    	return;
		}
	}
	var introduce = $('#introduce').val();
	if (introduce == "") {
		layer.msg("图书馆简介为空!", {time : 1000,icon : 5,shift : 6}, function() {});
		return;
	}
	$.ajax({
			type : 'POST',
			url : 'updateLibraryInfo',
			data : $('#frmLibraryInfo').serializeArray(),
			success : function(result){
				if(result.success){
					layer.msg("保存成功!", {
					time : 1000,
					icon : 6,
					shift : 2
				}, function() {
					$('#frmLibraryInfo').form('load', result.data);
				});
				}else{
					layer.msg("保存失败!", {
					time : 2000,
					icon : 5,
					shift : 6
				}, function() {
				});
				}
			}
	});
}