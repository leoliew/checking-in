<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<style type="text/css">
<!--
body {
	font-family: arial, sans-serif;
	background-color: #fff;
	margin-top: 2;
}
.c {
	width: 4;
	height: 4;
}
a:link {
	color: #00c;
}
a:visited {
	color: #551a8b;
}
a:active {
	color: #f00;
}
.form-noindent {
	background-color: #fff;
	border: 1px solid #c3d9ff;
}
-->
</style>
<style type="text/css">
<!--
.gaia.le.lbl {
	font-family: Arial, Helvetica, sans-serif;
	font-size: smaller;
}
.gaia.le.fpwd {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 70%;
}
.gaia.le.chusr {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 70%;
}
.gaia.le.val {
	font-family: Arial, Helvetica, sans-serif;
	font-size: smaller;
}
.gaia.le.button {
	font-family: Arial, Helvetica, sans-serif;
	font-size: smaller;
}
.gaia.le.rem {
	font-family: Arial, Helvetica, sans-serif;
	font-size: smaller;
}
.gaia.captchahtml.desc {
	font-family: arial, sans-serif;
	font-size: smaller;
}
.gaia.captchahtml.cmt {
	font-family: arial, sans-serif;
	font-size: smaller;
	font-style: italic;
}
-->
</style>
    <title>OA登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<style type="text/css">
<!--
body {
	font-family: arial, sans-serif;
	margin: 0;
	padding: 13px 15px 15px;
}
.body {
	margin: 0;
}
div.errorbox-good {
}
div.errorbox-bad {
}
div.errormsg {
	color: red;
	font-size: smaller;
	font-family: arial, sans-serif;
}
font.errormsg {
	color: red;
	font-size: smaller;
	font-family: arial, sans-serif;
}
div.topbar {
	font-size:smaller;
	margin-right: -5px;
	text-align:right;
	white-space:nowrap;
}
div.header {
	margin-bottom: 9px;
	position:relative;
 zoom: 1  text-align: center;
	height: 80px;
}
div.header img.logo {
	border: 0;
	float:left;
}
div.header div.headercontent {
	float:right;
	margin-top:17px;
}
div.header:after {
	content:".";
	display:block;
	height:0;
	clear:both;
	visibility:hidden;
}
div.pagetitle {
	font-weight:bold;
}
.footer {
	color: #666;
	font-size: smaller;
	margin-top: 0px;
	text-align: center;
}
table#signupform {
	left: -5px;
	top: -7px;
	position:relative;
}
table#signupform td {
	padding: 7px 5px;
}
table#signupform td table td {
	padding: 1px;
}
hr {
	border: 0;
	background-color:#DDDDDD;
	height: 1px;
	width: 100%;
	text-align: left;
	margin: 5px;
}
-->
</style>
</head>
<body dir="ltr" >
<div id="main">
  <div class=header> <a href='https://www.google.com/accounts/'> </a> </div>
  <div id=maincontent>
    <table border="0" width="100%" cellpadding=0 cellspacing=0>
      <tr>
        <td style="padding-left: 10px;" valign="top" align="center"><div id="rhs">
            <div id="rhs_login_signup_box">
              <style type="text/css">
<!--
  div.errormsg { color: red; font-size: smaller; font-family:arial,sans-serif; }
  font.errormsg { color: red; font-size: smaller; font-family:arial,sans-serif; }  
-->
</style>
              <style type="text/css">
<!--
.gaia.le.lbl { font-family: Arial, Helvetica, sans-serif; font-size: smaller; }
.gaia.le.fpwd { font-family: Arial, Helvetica, sans-serif; font-size: 70%; }
.gaia.le.chusr { font-family: Arial, Helvetica, sans-serif; font-size: 70%; }
.gaia.le.val { font-family: Arial, Helvetica, sans-serif; font-size: smaller; }
.gaia.le.button { font-family: Arial, Helvetica, sans-serif; font-size: smaller; }
.gaia.le.rem { font-family: Arial, Helvetica, sans-serif; font-size: smaller; }

.gaia.captchahtml.desc { font-family: arial, sans-serif; font-size: smaller; } 
.gaia.captchahtml.cmt { font-family: arial, sans-serif; font-size: smaller; font-style: italic; }
  
-->
</style>

     <s:if test="%{#session.usr!=null}">
        <jsp:forward page="show.do"/>
     </s:if>
<font color="red">
<s:actionerror/>
</font>
                <s:form action="/user_login.action">

                <div id="gaia_loginbox">
                  <table class="form-noindent" cellspacing="3" cellpadding="5" width="300" border="0">
                    <tr>
                      <td valign="top" style="text-align:center" nowrap="nowrap"
        bgcolor="#e8eefa"><div class="loginBox">
                          <table id="gaia_table" align="center" border="0" cellpadding="1" cellspacing="0">
                            <tr>
                              <td colspan="2" align="center"><font size="-1">员工考勤系统</font>
                                <table>
                                  <tr>
                                    <td valign="top"></td>
                                    <td valign="middle"></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td colspan="2" align="center"></td>
                            </tr>
                            <tr id="email-row">
                              <td nowrap="nowrap"></td>
                              <td>  <s:textfield name="user.uname" label="用户名"/>
</td>
                            </tr>
                            <tr>
                              <td></td>
                              <td align="left"></td>
                            </tr>
                            <tr id="password-row" class="enabled">
                              <td align="right" nowrap="nowrap"></td>
                              <td>            <s:password name="user.pwd" label="密码"/>
</td>
                            </tr>
                            <tr>
                              <td></td>
                              <td align="left"></td>
                            </tr>
                            <tr id="rememberme-row" class="enabled">
                              
                            </tr>
                            <tr>
                              <td></td>
                              <td align="left">            <s:submit label="提交" value="登录"></s:submit>
</td>
                            </tr>

                          </table>
                        </div></td>
                    </tr>
                  </table>
                </div>
		</s:form>
            </div>
            <br/>
          </div></td>
      </tr>
    </table>
  </div>
  <div class="footer"> &copy;2010 广州东方标准软件实训部 </div>
</div>
</body>
</html>
