<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div>
	<div style="position: relative;width: 100%;height: 100%;">
	    <h2 style="margin-left:40%;margin-top:3px;font-family: FZShuTi;font-size: 35px">图书馆管理系统</h2>
		<div style="position: absolute;width: 7%;right:0;bottom:10%;">
		    <a class="easyui-menubutton" data-options="menu:'#userMenu',iconCls:'icon-man'">${loginUserName }</a>
		</div>
		
		<div id="userMenu" style="width:150px;">
		   <div data-options="iconCls:'icon-man'">
		   <a onclick="addTab('userInfoPage?role=${role}','个人信息')">个人信息</a>
		   </div>
		   <div data-options="iconCls:'icon-lock'">
		       <a onclick="addTab('updatePwdPage','更改口令')">更改口令</a>
           </div>
		   <div data-options="iconCls:'icon-back'">
		       <a href="${APP_PATH }/logout" style="color: black">安全退出</a>
		   </div>
		</div>
	</div>
</div>
