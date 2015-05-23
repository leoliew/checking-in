<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
		<s:if test="%{#session.user==null}">
			<jsp:forward page="index.jsp" />
		</s:if>
		${sessionScope.user.position}
		欢迎<s:if test="%{#session.user.position!='主任' or #session.user.aid!=2 or #session.user.aid!=3 or #session.user.aid!=4}">
						[${sessionScope.selectgn}]
		     </s:if>
		${sessionScope.user.rname}${msg} &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="user_logout.action">退出</a> &nbsp;&nbsp;&nbsp;&nbsp;
		
		<a href="ok.jsp">个人考勤首页</a> &nbsp;&nbsp;&nbsp;&nbsp;
		
        <s:if test="%{#session.user.position=='主任' or #session.user.aid==2 or #session.user.aid==3 or #session.user.aid==4}">
				<a href="showGp.jsp">查看部门考勤</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
		
		<s:if test="%{#session.user.position=='主任' or #session.user.position=='秘书长助理'  or #session.user.aid==2 or #session.user.aid==4}">
				<a href="spkqsh.do">审批考勤申请</a>
		</s:if>
		<h2 style="font-size:1.25em; margin-bottom:1em; background:#e5ecf9; border-top:1px solid #36c; padding:2px 4px; clear:both;"><script type="text/javascript">
 <!--
	document.write(document.title);
 //-->
 </script></h2>

 <style type="text/css">
body {
	font-family:Arial, Sans-Serif;
}
#boundary {
	background:#f8f8f8;
	padding:2em;
	width:40em;
}
h1 {
	font-family:"Trebuchet MS", Sans-serif;
	text-transform:uppercase;
	color:#696;
	font-size:120%;
}
table {
	width:30em;
}
table caption {
	font-size:120%;
	text-transform:uppercase;
	text-align:left;
	padding:.5em 1em;
}
table th {
	text-align:left;
}
table, table th, table th {
	border:none;
	border-collapse:collapse;
}
table thead th {
	width:10em;
	border-style:solid;
	border-width:1px;
	border-color:#cff #69c #69c #cff;
	background:#9cf;
	padding:2px 10px;
}
table tfoot th, table tfoot td {
	border-style:solid;
	border-width:1px;
	border-color:#9cf #369 #369 #9cf;
	background:#69c;
	padding:2px 10px;
}
table tbody {
	background:#ddd;
}
table tbody td {
	padding:5px 10px;
	border:1px solid #999;
}
table tbody th {
	padding:2px 10px;
	border:1px solid #999;
	border-left:none;
}
table tbody tr.odd {
	background:#ccc;
}
table tfoot td img {
	border:none;
	vertical-align:bottom;
	padding-left:10px;
	float:right;
}
</style>

		