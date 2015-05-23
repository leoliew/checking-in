<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>个人考勤中心</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<s:set name="allCunt" value="0" />
		<s:set name="intimeCunt" value="0" />
		<s:set name="lateCuntNR" value="0" />
		<s:set name="lateCuntALW" value="0" />
		<s:set name="lateCuntUN" value="0" />
	</head>
	<body>
	    <SCRIPT src="js/calendar.js"></SCRIPT>
			
		<jsp:include page="top.jsp" />

		<s:if test="%{#request.mykq==null}">
			<jsp:forward page="kaoqin_show.action" />
		</s:if>
		<table>
			<tr>
				<td>
					<s:form action="kaoqin_bkq.action" theme="simple">
		  请选择时间：<s:textfield name="kqday" onclick="new Calendar().show(this);"
							size="10" maxlength="10" readonly="readonly" />
						<s:submit value="补考勤"></s:submit>
					</s:form>
				</td>
				<td>
					<s:form action="kaoqin_show" theme="simple">
			 查询指定月份：  <s:select list="#session.gmth" name="mth"></s:select>
						<s:submit value="查询"></s:submit>
					</s:form>
				</td>
			</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					日期
				</td>
				<td>
					打卡时间
				</td>
				<td>
					说明原由
				</td>
			</tr>
<s:property  value="#request.mykq.size"/>
			<s:iterator value="%{#request.mykq}"  >
				<s:set name="allCunt" value="#allCunt+1" />
				<tr>
					<td>
					<s:property value="kd" />
					</td>
					<td>		
						<s:if test="@com.util.DateUtil@formatDayInt(kt)>=9" >
			
					    </s:if>
						<s:else>
							<s:set name="intimeCunt" value="#intimeCunt+1"/>
					
					  </s:else>

						<s:if test="kt==null">
							<s:date name="kqdate" format="MM月dd日" />
						</s:if>
						<s:else>
							<s:property value="kt" />
						</s:else>
					</td>
					<td>
						<s:if test="@com.util.DateUtil@formatDayInt(kt)>=9">
							<s:if test="exp01==null">
								<s:url action="kaoqin_addE.action" id="addexp">
									<s:param name="kqid" value="kid"></s:param>
								</s:url>
								<s:a href="%{addexp}">添加
							     <s:set name="lateCuntNR" value="#lateCuntNR+1" />
								</s:a>
							</s:if>
							<s:else>
								<s:property value="exp01" />
								<s:if test="%{spCtnt==null}">
								       ,未被[<s:property value="suserBySpuid.rname" />]确认
								      <s:set name="lateCuntUN" value="#lateCuntUN+1" />
								</s:if>
								<s:else>
								        ,已经[<s:property value="suserBySpuid.rname" />]确认
								    <s:set name="lateCuntALW" value="#lateCuntALW+1" />
								</s:else>
							</s:else>
						</s:if>
						<s:else>

					  </s:else>
					</td>
				</tr>
			</s:iterator>
		</table>
		<br>

<s:actionerror/>

		<br>


		${requestScope.mth}月份考勤统计：
		<br>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="4">
					该月总打卡数：
					<s:property value="#allCunt" />
					(次)
				</td>
			</tr>
			<tr>
				<td>
					准点
				</td>
				<td colspan="3">
					迟到：
					<s:property value="%{#allCunt-#intimeCunt}" />
					(次)
				</td>
			</tr>
			<tr>
				<td rowspan="2" style="color: green;">
					<s:property value="#intimeCunt" />
					(次)
				</td>
				<td>
					无故
				</td>
				<td>
					因故
				</td>
				<td>
					未被确认
				</td>
			</tr>
			<tr>
				<td style="color: red;">
					<s:property value="#lateCuntNR" />
				</td>
				<td style="color: green;">
					<s:property value="#lateCuntALW" />
				</td>
				<td style="color: aqua;">
					<s:property value="#lateCuntUN" />
				</td>
			</tr>
		</table>
	</body>
</html>
