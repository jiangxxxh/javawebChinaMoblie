package com.chinamobile.servlet;

import com.chinamobile.dao.XOperatorDao;
import com.chinamobile.md5.MD5;
import com.chinamobile.pojo.XOperator;
import com.mysql.cj.x.protobuf.MysqlxExpr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OperatorServlet")
public class OperatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String action=request.getParameter("action");
        action=(action==null || "".equals(action))?"list":action;
        XOperatorDao dao=new XOperatorDao();
        if ("list".equals(action)){
            List<XOperator> xos=dao.find();
            request.setAttribute("xos",xos);
            request.getRequestDispatcher("modifyOperator.jsp").forward(request,response);
        }else if ("add".equals(action)){
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String password= MD5.getMD5(request.getParameter("password"));
            String stats=request.getParameter("state");
            String password1=MD5.getMD5(request.getParameter("password1"));
           if (password.equals(password1)){
               int i=0;
               XOperator x=new XOperator(id,name,password,stats);
               i=dao.add(x);
               if(i>0){
                   // 增加成功
                   response.sendRedirect("OperatorServlet");
               }else{
                   out.println("增加失败");
                   response.setHeader("refresh", "3;url=newOperator.jsp");
               }
           }else {
               out.println("两次密码不正确");
               response.setHeader("refresh", "3;url=newOperator.jsp");
           }
        }else if ("modify".equals(action)){
            String id1=request.getParameter("id1");
            String name1=request.getParameter("name1");
            String password1=MD5.getMD5(request.getParameter("password"));
            String stats1=request.getParameter("state1");
            XOperator x=new XOperator(id1,name1,password1,stats1);
            System.out.println("modify x="+x);
            int i=0;
            i=dao.modify(x);
            if (i>0){
                // 修改成功
                response.sendRedirect("OperatorServlet");
            }else {
                out.println("修改失败");
                response.setHeader("refresh", "3;url=modifyOperator.jsp");
            }

        }else if ("remove".equals(action)){
            String id=request.getParameter("id");
            int i=0;
            i=dao.remove(id);
            if (i>0){
                // 删除成功
                response.sendRedirect("OperatorServlet");
            }else {
                out.println("删除失败");
                response.setHeader("refresh", "3;modifyOperator.jsp");
            }

        }else if ("selectid".equals(action)){
            String id=request.getParameter("opId");
            XOperator xo=dao.findById(id);
            request.setAttribute("xo",xo);
            request.getRequestDispatcher("modOperator.jsp").forward(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
