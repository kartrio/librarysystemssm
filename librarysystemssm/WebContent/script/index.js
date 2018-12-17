$(function(){
	var readerStatus = $('#readerStatus').val();
	if(readerStatus == 0){
		layer.msg("新注册的用户只能进行特定信息查看,如需借阅书籍,请联系管理员！", {
			time : 2000,
			icon : 5,
			shift : 6
		}, function() {
		});
	}
})

/**
 * 在选项卡面板上新增选项卡
 * @param tabPath 路径--页面即jsp的路径，或者是action的路径
 * @param tabTitle 选项卡名称
 */
function addTab(tabPath, tabTitle) {
    var tabId = tabPath.substring(tabPath.lastIndexOf('/')+1,tabPath.lastIndexOf('?'));
	if (!$('#tab').tabs('exists',tabTitle)) {
		$('#tab').tabs('add',{
			id : tabId,
			title : tabTitle,
			content : "<iframe src='"+tabPath+"' frameborder='no' border='0' style='width:100%;height:100%'></iframe>",
			closable : true
	    });
	}else{
		$('#tab').tabs('select', tabTitle);
	}
}
