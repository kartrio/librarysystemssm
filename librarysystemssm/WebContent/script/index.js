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
