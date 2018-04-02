package com.chinamobile.servlet;

import com.chinamobile.dao.XOperatorDao;
import com.chinamobile.md5.MD5;
import com.chinamobile.pojo.XOperator;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LogServlet")
public class LogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        String randomcode = (String) session.getAttribute("Rand");

        String action = request.getParameter("action");
        // 若验证用户名或密码 (应先验证随机码然后再查询数据库)
        // ${emp.ename} - ${emp.dept.dname}
        if ("login".equals(action)) {
            if (checkcode.equals(randomcode)) {

                String opName = request.getParameter("opName");
                System.out.println(request.getParameter("opPwd"));
                String opPwd = MD5.getMD5(request.getParameter("opPwd"));
                //String opPwd = MD5.getMD5("admin123");
                System.out.println(opName);
                System.out.println(opPwd);

                XOperatorDao dao = new XOperatorDao();

                XOperator xOperator = dao.findByParam(opName, opPwd);


                if (xOperator != null) {
                    session.setAttribute("xoperator", xOperator);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);

                } else {
                    out.println("账号或密码错误！");
                    response.setHeader("refresh", "2;url=index.jsp");
                }

            } else {
                out.println("验证码不匹配...");
                response.setHeader("refresh", "2;url=index.jsp");
            }

        } else if ("logout".equals(action)){
                session.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }


        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
