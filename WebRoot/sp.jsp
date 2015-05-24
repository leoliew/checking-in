<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>审批考勤申请</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<jsp:include page="top.jsp" />
		<br>
		<br>
		<hr>
		<br>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
			    <td>
					申请人
				</td>
				<td>
					日期
				</td>
				<td>
					打卡时间
				</td>
				<td>
					申请原由
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="%{#request.splist}">
				<tr>
				   <td>
						<s:property value="suserByUid.rname" />
			    	</td>
					<td>
						<s:property value="kd" />
					</td>
					<td style="color: red;">
						<s:if test="kt==null">
							<s:date name="kqdate" format="MM月dd日" />
						</s:if>
						<s:else>
							<s:property value="kt" />
						</s:else>
					</td>
					<td>
						<s:property value="exp01" />
					</td>
					<td>
						<select  id="kq<s:property value='kid'/>">
							<option value="1">
								同意
							</option>
							<option value="0">
								不同意
							</option>
						</select>
						<input type="button" value="审批" onclick="javascript:doSpkq(<s:property value='kid'/>)">
					</td>

				</tr>
			</s:iterator>
		</table>
	</body>
		<script type="text/javascript">
		  function doSpkq(kqid){
		     var kq = document.getElementById("kq"+kqid);
		     var value = kq.options[kq.selectedIndex].value;
		     window.location.href="spKaoqin.do?kqid="+kqid+"&adv="+value;
		  }
		
		</script>
</html>
