package com.chinamobile.servlet;

import com.chinamobile.dao.XUserDao;
import com.chinamobile.pojo.XUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryBalanceServlet")
public class QueryBalanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");


        XUserDao dao = new XUserDao();

        if(action == null || "".equals(action)){
            response.sendRedirect("querybalance.jsp");
        }else if("list".equals(action)){
            String mobilesNum = request.getParameter("mobilesNum");
            String cusNumber = request.getParameter("cusNumber");
            String cusType = request.getParameter("cusType");

            List<XUser> xsuers = dao.findByParam(mobilesNum,cusNumber,cusType);
            request.setAttribute("xusers",xsuers);
            request.getRequestDispatcher("querybalance.jsp").forward(request,response);

        }else if("findById".equals(action)){
            String suserId = request.getParameter("userId");
            suserId = (suserId==null || "".equals(suserId))?"0":suserId;
            Integer userId = Integer.parseInt(suserId);
            XUser xUser = dao.findById(userId);
            if(xUser != null){
                request.setAttribute("xuser",xUser);
                request.getRequestDispatcher("recharge.jsp").forward(request,response);
            }else{
                out.println("查询无此ID");
                response.setHeader("refresh","2;url=QueryBalanceServlet");
            }

        }else if("modify".equals(action)){

           String suserId = request.getParameter("userId");
            suserId = (suserId==null || "".equals(suserId))?"0":suserId;
            Integer userId = Integer.parseInt(suserId);

            String smobilesNum = request.getParameter("mobilesNum");
            smobilesNum = (smobilesNum==null || "".equals(smobilesNum))?"0":smobilesNum;

            String sbalance = request.getParameter("balance");
            sbalance = (sbalance==null || "".equals(sbalance))?"0":sbalance;
            Double balance = Double.parseDouble(sbalance);

            int count = dao.modifyByNum(smobilesNum,balance);
            if(count > 0){
                //XUser xUser2 = dao.findById(userId);
                List<XUser> xusers = dao.findByParam(smobilesNum,null,null);
                request.setAttribute("xusers",xusers);
                request.getRequestDispatcher("querybalance.jsp").forward(request,response);
                //response.sendRedirect("QueryBalanceServlet");
            }else{
                out.println("充值失败");
                response.setHeader("refresh","2;url=QueryBalanceServlet");
            }

        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
