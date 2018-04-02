<%--
  Created by IntelliJ IDEA.
  User: 29566
  Date: 2018/1/23
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>中国移动业务管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="images/angrybird_1.png">

</head>

<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<c:if test="${empty xoperator}">
    <c:redirect url="index.jsp"/>
</c:if>
<CENTER>
    <TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
        <TBODY>
        <TR>
            <TD width=173><A href="welcome.jsp"><IMG
                    height=74 src="images/logo.gif" width=173 border=0></A></TD>
            <TD vAlign=top align=right>
                <TABLE width="100%" border=0 cellPadding=0 cellSpacing=0>
                    <TBODY>
                    <TR bgColor=#2650a6>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                    </TR>
                    <TR bgColor=#FFFFFF>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                    </TR>
                    <TR>
                        <TD><img src="images/pic01.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic04.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic03.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic02.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic05.gif" width="115" height="55"></TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
        </TR>
        <TR>
            <TD height="12" colSpan=2 align=right bgColor=#d4dced>


                <img src="images/spacer.gif" width="1" height="1">
                <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    </TR>
                    </TBODY>
                </TABLE>

            </TD>
        </TR>
        <TR>
            <TD colSpan=2><IMG height=2 src="images\blank(1).gif" width=1></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
        <TBODY>
        <TR vAlign=top>
            <TD width=173 bgColor=#c9d3e9 rowSpan=2>
                <TABLE cellSpacing=0 cellPadding=0 width=173 border=0>
                    <TBODY>
<c:if test="${sessionScope.xoperator.opMark=='Y'}">
                    <TR>
                        <TD width=11 height="29" bgColor=#2650a6><IMG height=1
                                                                      src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="newOperator.jsp">新增操作员</A></TD>
                    </TR>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="modifyOperator.jsp">修改操作员</A></TD>
                    </TR>
                    <!--TR>
                      <TD bgColor=#ffffff colSpan=2><IMG height=1
                        src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                      <TD width=11 bgColor=#2650a6><IMG height=1
                        src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                      <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                        class=nav
                        href="modifyOperator.htm">修改操作员</A></TD>
                    </TR-->

                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="中国移动通信.files/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav href="resource.jsp">资源管理</A></TD>
                    </TR>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="charge.jsp">配置业务费用</A></TD>
                    </TR>
</c:if>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="newCustomer.jsp">开户</A></TD>
                    </TR>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="querybalance.jsp">余额查询</A></TD>
                    </TR>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="recharge.jsp">用户充值</A></TD>
                    </TR>

                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD>
                    </TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img
                                src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav href="showmobiles.jsp">选号</A></TD>
                    </TR>


                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD>
                    </TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img
                                src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="LogServlet?action=logout">退出</A></TD>
                    </TR>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD>
                    </TR>

                    <TR align=middle>
                        <TD colSpan=2 height=160>&nbsp;</TD>
                    </TR>
                    <TR>
                        <TD colSpan=2><IMG height=1 src="images/blank.gif"
                                           width=1></TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
            <TD width=2 rowSpan=3><IMG height=1 src="images\blank(1).gif" width=2></TD>
            <TD width="2">
                <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                        <TD height=25>&nbsp;您现在的位置：用户充值</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD>
                    </TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
        </TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>

              <%--  <c:if test="${xuser==null}">
                    <c:redirect url="QueryBalanceServlet"/>
                </c:if>
                <c:if test="${xuser!=null}">--%>
                    <form method="POST" action="QueryBalanceServlet" style="margin-top:5px">
                        <input type="hidden" name="action" value="modify">
                       <input type="hidden" name="userId" value="${xuser.userId}">
                        <p>   </p>  <p>   </p>
                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号：&nbsp;<input type="text" name="mobilesNum" value="${xuser.mobilesNum}"></label>
                        <p>   </p>
                        <label>&nbsp;&nbsp;&nbsp;&nbsp;充值金额：&nbsp;<input type="text" name="balance"></label>
                        <br>
                        <br>
                        <p style="margin-left: 120px"><button type="submit">确认</button></p>

                    </form>
               <%-- </c:if>--%>


                    </TD>
                    </TR>
                    </TBODY>
                </TABLE>
                <BR>
</CENTER>
</BODY>


</html>
