<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div>
	<div style="position: relative;width: 100%;height: 100%;">
	    <h2 style="margin-left:5%;margin-top:3px;font-family: FZShuTi;font-size: 35px">图书馆管理系统</h2>
		<div style="position: absolute;width: 17%;right:0;bottom:10%;">
		    <span style="color: #8B864E;">
			    您好,<%=session.getAttribute("loginUserName").toString()%> |
			 <a style="color:#8B864E" onclick="addTab('updatePassword','更改口令')">更改口令</a> |
			 <a href="${APP_PATH }/logout" style="color:#8B864E">安全退出</a>		    
		    </span>
		</div>
	</div>
</div>
