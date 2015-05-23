<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>填写异常考勤原由</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<jsp:include page="top.jsp"/>
		<br>
		<s:form action="add">
	        <input type="hidden" name="kqid" value="${requestScope.kq.kid}"/>
			<table border="1" cellpadding="1" cellspacing="1">
				<tr>
					<td>
						上班日期
					</td>
					<td>
						${requestScope.kq.kd}
						
					</td>
				</tr>
				<tr>
					<td>
						打卡时间
					</td>
					<td>			
			${requestScope.kq.kqdate}
					</td>
				</tr>
				<tr>
					<td colspan="2">
				   <%--  	<s:select  list="#application.mgrs" name="mu" label="证明人"></s:select> --%>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:textarea name="exp" cols="28" rows="4" label="原由说明"></s:textarea>
					</td>
					<s:submit value="提交申请"></s:submit>
				</tr>
			</table>
		</s:form>
	</body>
</html>
