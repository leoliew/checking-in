<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>查询部门考勤</title>

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
		<jsp:include page="top.jsp" />
		<s:if test="%{#session.gns==null}">
			<jsp:forward page="showGp.do" />
		</s:if>
		<br>
		<table>
			<tr>
				<td>
					<s:form action="showGp" theme="simple">
			 查询指定月份：
			 <SELECT name="smth">
							<c:forEach items="${sessionScope.gmth}" var="gm">
								<option value="${gm}"
									<c:if test="${sessionScope.smth eq gm}">selected="selected" </c:if>>
									${gm}
								</option>
							</c:forEach>
						</SELECT>
						<s:submit value="更改" theme="simple"></s:submit>
					</s:form>
				</td>
				<td>
					<s:form action="showGp" theme="simple">
			 查询指定的组：		
			 <SELECT name="gns">
							<c:forEach items="${sessionScope.gns}" var="gn">
								<option value="${gn}"
									<c:if test="${sessionScope.selectgn eq gn}">selected="selected" </c:if>>
									${gn}
								</option>
							</c:forEach>
						</SELECT>
						<s:submit value="更改"></s:submit>
					</s:form>
				</td>
			</tr>
		</table>


		<hr>
		<s:iterator value="%{#session.usrinG}">
			<s:url action="showGp.do" id="shUrl">
				<s:param name="shUid" value="uid" />
			</s:url>
			<s:if test="#session.shUid==uid">
				<span style="color: red;"> 【 
			</s:if>
			<s:a href="%{shUrl}">
				<s:property value="rname" />
			</s:a>
			<s:if test="#session.shUid==uid">
			       】 </span>
			</s:if>
			&nbsp;&nbsp;
			</s:iterator>
		<s:if test="%{#request.mykq==null}">
		           --->请指定。
		</s:if>
		<s:else>
			<hr>
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

				<s:iterator value="%{#request.mykq}">
					<s:set name="allCunt" value="#allCunt+1" />
					<tr>
						<td>
							<s:property value="kd" />
						</td>
						<td
							<s:if test="@com.nsit.tool.DateUtil@formatDayInt(kt)>=9" >
				 	       style="color: red;"  
					    </s:if>
							<s:else>
							<s:set name="intimeCunt" value="#intimeCunt+1"/>
					       style="color: green;"  
					  </s:else>>

							<s:if test="kt==null">
								<s:date name="kqdate" format="MM月dd日" />
							</s:if>
							<s:else>
								<s:property value="kt" />
							</s:else>
						</td>
						<td>
							<s:if test="@com.nsit.tool.DateUtil@formatDayInt(kt)>=9">
								<s:if test="exp01==null">
									-
							        <s:set name="lateCuntNR" value="#lateCuntNR+1" />

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
					      -
					  </s:else>
						</td>
					</tr>
				</s:iterator>
			</table>
			<br>
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
		</s:else>
	</body>
</html>
