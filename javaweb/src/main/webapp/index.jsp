<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2018/1/11
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <TITLE>中国移动业务管理系统</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
    <style type="text/css">
        <!--
        body {
            background-color: #CCCCCC;
            margin-top: 10px;
        }
        -->
    </style>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="images/angrybird_1.png">
</HEAD>
<BODY LEFTMARGIN=0 MARGINWIDTH=0>
<!-- ImageReady Slices (index.psd) -->
<TABLE WIDTH=750 BORDER=0 align="center" CELLPADDING=0 CELLSPACING=0>
    <TR>
        <TD ROWSPAN=2>
            <IMG SRC="images/index_01.gif" WIDTH=444 HEIGHT=237 ALT=""></TD>
        <TD>
            <IMG SRC="images/index_02.gif" WIDTH=306 HEIGHT=99 ALT=""></TD>
    </TR>
    <TR>
        <TD>
            <IMG SRC="images/index_03.gif" WIDTH=306 HEIGHT=138 ALT=""></TD>
    </TR>
    <TR>
        <TD ROWSPAN=2>
            <IMG SRC="images/index_04.gif" WIDTH=444 HEIGHT=363 ALT=""></TD>
        <TD width="306" height="185" background="images/index_05.gif"><table width="250" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td><form action="LogServlet?action=login" method=post name=login>
                    <div align="center">
                        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td height="30"><div align="center"><strong>用户名：</strong>
                                    <INPUT name="opName" type="text" placeholder="用户名">
                                    <br>
                                </div></td>
                            </tr>
                            <tr>
                                <td height="30"><div align="center"><strong>密&nbsp;&nbsp;码：</strong>
                                    <INPUT name="opPwd" type="password" placeholder="密码">
                                </div></td>
                            </tr>

                            <tr>
                                <td height="30"><div align="center"><strong>验证码：</strong>
                                    <INPUT type="text" name="checkcode"/>
                                    <a href=""><img src="RandomCodeServlet" onclick="window.location.reload()" /></a>&nbsp;
                                </div></td>
                            </tr>


                                <td height="30">
                                    <div align="center">
                                        <INPUT class=f2 type=submit size=4 value=进入系统 name=Submit>
                                    </div></td>
                            </tr>
                        </table>
                    </div>
                </form></td>
            </tr>
        </table></TD>
    </TR>
    <TR>
        <TD>
            <IMG SRC="images/index_06.gif" WIDTH=306 HEIGHT=178 ALT=""></TD>
    </TR>
</TABLE>
<!-- End ImageReady Slices -->
</BODY>
</HTML>
