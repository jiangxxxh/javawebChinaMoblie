<%--
  Created by IntelliJ IDEA.
  User: 29566
  Date: 2018/1/23
  Time: 20:35
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
                    </TR></TBODY></TABLE></TD></TR>
        <TR>
            <TD height="12" colSpan=2 align=right bgColor=#d4dced>


                <img src="images/spacer.gif" width="1" height="1">
                <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    </TR></TBODY></TABLE>

            </TD></TR>
        <TR>
            <TD colSpan=2><IMG height=2 src="images\blank.gif" width=1></TD></TR></TBODY></TABLE>
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
                                                           src="images/blank.gif" width=1 border=0></TD></TR>
                    <TR>
                        <TD width=11 bgColor=#2650a6><IMG height=1
                                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
                        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                                class=nav
                                href="LogServlet?action=logout">退出</A></TD>
                    </TR>
                    <TR>
                        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                                           src="images/blank.gif" width=1 border=0></TD></TR>

                    <TR align=middle>
                        <TD colSpan=2 height=160>&nbsp;</TD></TR>
                    <TR>
                        <TD colSpan=2><IMG height=1 src="images/blank.gif"
                                           width=1></TD></TR></TBODY></TABLE></TD>
            <TD width=2 rowSpan=3><IMG height=1 src="images\blank(1).gif" width=2></TD>
            <TD width="2">
                <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                        <TD height=25>&nbsp;您现在的位置：选号</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD></TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>

                <c:if test="${empty pager}">
                    <c:redirect url="ResourceServlet"/>
                </c:if>
                <table border="1" width="98%" height="89"  style="margin-left:5px;margin-top:5px">
                    <tr>
                        <td width="25%" align="center" height="20">序号</td>
                        <td width="25%" align="center" height="20"><a href="ResourceServlet?page=${page}&rows=${rows}&sort=${sort}&order=${(order=='asc')?'desc':'asc'}&mobilesType=${mobilesType}">手机号码</a></td>
                        <td width="25%" align="center" height="20">
                            <select id="myselect" onchange="on_change()" style="background-color:#f1f3f9">
                                <option value="" ${mobilesType==null?'selected':''}>号码类型</option>
                                <option value="UIM" ${mobilesType=='UIM'?'selected':''}>UIM</option>
                                <option value="SIM" ${mobilesType=='SIM'?'selected':''}>SIM</option>
                                <%--<option value="SIM" ${requestScope.param=='SIM'?'selected':''}>SIM</option>--%>
                            </select>
                        </td>
                        <td width="25%" align="center" height="20">是否可用</td>
                        <!--<td width="20%" align="center" height="16">修改</td>-->
                    </tr>
                    <c:forEach var="xm" items="${requestScope.pager.rows}" varStatus="rows">
                        <tr>
                            <td width="25%" align="center" height="20">${rows.index+1}</td>
                            <td width="25%" align="center" height="20">${xm.mobilesNum}</td>
                            <td width="25%" align="center" height="20">${xm.mobilesType}</td>
                            <td width="25%" align="center" height="20">${xm.isAvailable=="1"?"可用":"不可用"}</td>
                            <!--<td width="20%" align="center" height="16">修改</td>-->
                        </tr>
                    </c:forEach>
                    <tr style="text-align: center">

                        <td colspan="4"><small>
                            <form style="margin: auto">
                            每页显示<select id="myrows" onchange="on_change2()">
                            <option value="10" ${rows=='10'?'selected':''}>10</option>
                            <option value="20" ${rows=='20'?'selected':''}>20</option>
                            <option value="30" ${rows=='30'?'selected':''}>30</option>
                        </select>条&nbsp;&nbsp;
                            第${page}/${pageSize}页&nbsp;&nbsp;
                            <a href="ResourceServlet?page=1&rows=${rows}&sort=${sort}&order=${order}">首页</a>&nbsp;
                            <a href="ResourceServlet?page=${(page-1)<1?1:page-1}&rows=${rows}&sort=${sort}&order=${order}">上一页</a>&nbsp;
                            <a href="ResourceServlet?page=${(page+1)>pageSize?pageSize:page+1}&rows=${rows}&sort=${sort}&order=${order}">下一页</a>&nbsp;
                            <a href="ResourceServlet?page=${pageSize}&rows=${rows}&sort=${sort}&order=${order}">尾页</a>&nbsp;&nbsp;
                            跳转到<input type="number" id="mypage" min="1" max="${pageSize}" onkeypress="on_keypress(event)">页
                            &nbsp;&nbsp;
                            总记录:${pager.total}条
                            </form>
                        </small>
                        </td>
                    </tr>


                </table>

            </TD>
        </TR>
        </TBODY></TABLE>
    <BR></CENTER>
<script>
    function on_change() {
        var myselect= document.getElementById("myselect").value;
        location.href = "ResourceServlet?page=${page}&rows=${rows}&sort=${sort}&order=${order}&mobilesType="+myselect;
        /*location.href = "ResourceServlet?insertType=findByParam&param="+myselect;*/
    }
    function on_change2() {
        var rows= document.getElementById("myrows").value;
        location.href = "ResourceServlet?page=1&rows="+rows+"&sort=${sort}&order=${order}";
    }
    function on_keypress(event) {
        var page = document.getElementById("mypage").value;
        if(page>${pageSize}){
            page=${pageSize};
        }
        if(page<1){
            page=1;
        }
        if(event.keyCode == 13){
            location.href = "ResourceServlet?page="+page+"&rows=${rows}&sort=${sort}&order=${order}";
        }

    }
</script>


</BODY>



</html>